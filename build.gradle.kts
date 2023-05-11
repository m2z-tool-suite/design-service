plugins {
    java
    application
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.google.cloud.tools.jib") version "3.3.1"
    id("pl.allegro.tech.build.axion-release") version "1.14.0"
    id("jacoco")
    id("org.sonarqube") version "3.5.0.2730"
}

group = "com.m2z.tools"
version = scmVersion.version
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4")
    implementation(project(":m2z-security"))
    compileOnly("org.projectlombok:lombok")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    runtimeOnly("com.mysql:mysql-connector-j")

    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

// Basic Config
val mainClassPath = "com.m2z.tools.designservice.DesignServiceApplication"
application {
    mainClass.set(mainClassPath)
}

tasks.bootRun {
    systemProperties.put(
        "spring.profiles.active",
        if (project.hasProperty("springProfiles")) project.property("springProfiles") else ""
    )
}

extensions.findByName("buildScan")?.withGroovyBuilder {
    setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
    setProperty("termsOfServiceAgree", "yes")
}

// Utility method
fun gitBranch(): String {
    var branch: String
    val proc = ProcessBuilder("git", "rev-parse", "--abbrev-ref", "HEAD").start()
    proc.inputStream.bufferedReader().use { branch = it.readLine() }
    proc.waitFor()
    return branch
}

// Containerization (Fixed to local directly to docker-deamon)
jib {
    from {
        image = "eclipse-temurin:17-jre"
    }
    container {
        ports = listOf("8080")
        format = com.google.cloud.tools.jib.api.buildplan.ImageFormat.OCI
        containerizingMode = "packaged"
        mainClass = mainClassPath
    }
}

tasks.named("jibDockerBuild") {
    doFirst {
        jib {
            to {
                image = "design-service"
                credHelper.helper = "osxkeychain"
                tags = setOf("latest", gitBranch() + " " + version.toString())
            }
        }
    }
}

// Containerization (Fixed to remote directly to container registry)
tasks.named("jib") {
    doFirst {
        jib {
            to {
                if (project.hasProperty("remoteRegistry") && project.hasProperty("remoteImage")) {
                    val remoteRegistry = project.properties["remoteRegistry"]
                    val remoteImage = project.properties["remoteImage"]
                    image = "$remoteRegistry/$remoteImage"
                } else if (System.getProperty("AWS_ECR_IMAGE_ID") != null && System.getProperty("AWS_ECR_URL") != null) {
                    val remoteRegistry = System.getProperty("AWS_ECR_URL")
                    val remoteImage = System.getProperty("AWS_ECR_IMAGE_ID")
                    image = "$remoteRegistry/$remoteImage"
                } else {
                    throw GradleException("Both 'registry url' & 'registry image' are required")
                }
                if (!project.hasProperty("cd")) {
                    credHelper.helper = "ecr-login"
                }
                tags = setOf("latest"/*, version.toString()*/)
            }
        }
    }
}

// Tests
testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
            dependencies {
                // Note that this is equivalent to adding dependencies to testImplementation in the top-level dependencies block
            }
        }
        val integrationTest by registering(JvmTestSuite::class) {
            dependencies {
                implementation(project)
                implementation("org.springframework.boot:spring-boot-starter-test")
            }
            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}
tasks.named("check") {
    dependsOn(testing.suites.named("integrationTest"))
}

// Jacoco
tasks.jacocoTestReport {
    val integrationTest = testing.suites.named("integrationTest")
    executionData(tasks.test, integrationTest)
    reports {
        xml.required.set(true)
    }
    dependsOn(tasks.test, integrationTest)
}

// SonarQube
sonar {
    properties {
        sourceSets.add(sourceSets["integrationTest"])
        sourceSets.add(sourceSets["test"])
        property("sonar.branch.name", gitBranch())
        property("sonar.host.url", project.properties.get("SONAR_HOST_URL")!!)
        property("sonar.organization", project.properties.get("SONAR_ORGANIZATION")!!)
        property("sonar.projectKey", project.properties.get("SONAR_PROJECTKEY")!!)
        property("sonar.login", project.properties.get("SONAR_LOGIN")!!)
    }
}