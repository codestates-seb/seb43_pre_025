package com.unbreakableheart.stackoverflowclone.common.utils;

import com.unbreakableheart.stackoverflowclone.user.entity.Role;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorityUtils {

    @Value("${mail.address.admin}")
    private String adminEmail;
    private final List<String> ADMIN_ROLES = List.of(Role.USER.getRole(), Role.ADMIN.getRole());
    private final List<String> USER_ROLES = List.of(Role.USER.getRole());

    public List<String> createRoles(String email) {
        if (email.equals(adminEmail)) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }

    public static List<SimpleGrantedAuthority> getAuthorities(List<String> roles) {
        return roles
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
