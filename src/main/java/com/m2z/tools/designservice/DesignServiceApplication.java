package com.m2z.tools.designservice;

import com.m2z.tools.security.model.CorsConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({CorsConfigProperties.class})
@ComponentScan(basePackages = "com.m2z.tools.security")
public class DesignServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignServiceApplication.class, args);
    }
}
