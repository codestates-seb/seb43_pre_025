package com.unbreakableheart.stackoverflowclone.common.security.oauth.handler;

import com.unbreakableheart.stackoverflowclone.common.security.jwt.JwtTokenProvider;
import com.unbreakableheart.stackoverflowclone.common.security.oauth.CustomOAuth2User;
import com.unbreakableheart.stackoverflowclone.user.entity.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("OAuth login 성공");
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        loginSuccess(response, oAuth2User);
    }

    private void loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException {
        String accessToken = jwtTokenProvider.generateAccessToken(oAuth2User.getEmail(), oAuth2User.getRole());
        String refreshToken = jwtTokenProvider.generateRefreshToken();
        response.setHeader("Authorization", "Bearer " + accessToken);
        response.setHeader("Refresh", refreshToken);
        log.info("accessToken : {}", accessToken);
        log.info("refreshToken : {}", refreshToken);

        jwtTokenProvider.sendAccessAndRefreshToken(response, accessToken, refreshToken);
    }
}
