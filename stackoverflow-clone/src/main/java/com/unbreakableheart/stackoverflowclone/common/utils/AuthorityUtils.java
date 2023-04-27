package com.unbreakableheart.stackoverflowclone.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorityUtils {

    @Value("${mail.address.admin}")
    private String adminEmail;
    private final List<String> ADMIN_ROLES = List.of("ADMIN_ROLES", "USER_ROLES");
    private final List<String> USER_ROLES = List.of("USER_ROLES");

    public List<String> createRoles(String email) {
        if (email.equals(adminEmail)) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }
}
