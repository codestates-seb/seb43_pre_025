package com.unbreakableheart.stackoverflowclone.user.service;

import com.unbreakableheart.stackoverflowclone.common.exception.CustomException;
import com.unbreakableheart.stackoverflowclone.common.exception.ExceptionCode;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.entity.UserPrincipal;
import com.unbreakableheart.stackoverflowclone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Slf4j
@Component
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("[loadUserByUsername] username : {}", username);
        User user = userRepository.findByEmail(username).orElseThrow(() ->
                new CustomException(ExceptionCode.MEMBER_NOT_FOUND));

        return UserPrincipal.of(user);
    }
}
