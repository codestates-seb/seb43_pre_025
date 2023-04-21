package com.unbreakableheart.stackoverflowclone.user.service;

import com.unbreakableheart.stackoverflowclone.common.security.jwt.JwtTokenProvider;
import com.unbreakableheart.stackoverflowclone.user.dto.LoginDto;
import com.unbreakableheart.stackoverflowclone.user.dto.LoginResponseDto;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public LoginResponseDto login(LoginDto loginDto) {
        User user = userService.findVerifyUser(loginDto.getEmail());
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UsernameNotFoundException("이메일 또는 비밀번호를 확인해주세요");
        }

        return new LoginResponseDto("Bearer",
                jwtTokenProvider.generateAccessToken(user.getEmail(), user.getRoles()),
                jwtTokenProvider.generateRefreshToken());
    }
}
