package com.m2z.tools.designservice.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class SecurityUtil {

    private static final String PROJECT_PREFIX = "PROJECT_";
    private static final String READ_SUFFIX = "_READ";
    private static final String WRITE_SUFFIX = "_WRITE";

    public static final String READ = "READ";
    public static final String WRITE = "WRITE";

    public static HashMap<String, String> getProjects() {
        Collection<? extends GrantedAuthority> grantedAuthorities =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        List<String> authorities =
                grantedAuthorities.stream().map(GrantedAuthority::getAuthority).toList();
        List<String> projects =
                authorities.stream()
                        .filter((a) -> a.startsWith(PROJECT_PREFIX))
                        .map((a) -> a.substring(PROJECT_PREFIX.length()))
                        .toList();
        HashMap<String, String> map = new HashMap<>();
        for (String project : projects) {
            if (project.endsWith(READ_SUFFIX)) {
                map.put(project.substring(0, project.length() - READ_SUFFIX.length()), READ);
            } else if (project.endsWith(WRITE_SUFFIX)) {
                map.put(project.substring(0, project.length() - WRITE_SUFFIX.length()), WRITE);
            }
        }
        return map;
    }
}
