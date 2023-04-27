package com.unbreakableheart.stackoverflowclone.common.security.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.unbreakableheart.stackoverflowclone.common.security.jwt.JwtTokenProvider;
import com.unbreakableheart.stackoverflowclone.user.dto.LoginDto;
import com.unbreakableheart.stackoverflowclone.user.dto.UserDto;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.entity.UserPrincipal;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenizer;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenizer) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenizer = jwtTokenizer;
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        ObjectMapper objectMapper = new ObjectMapper();
        LoginDto loginDto = objectMapper.readValue(request.getInputStream(), LoginDto.class);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws ServletException, IOException {
        UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();
        User user = userPrincipal.getUser();

        String accessToken = jwtTokenizer.generateAccessToken(user.getEmail(), user.getRoles());
        String refreshToken = jwtTokenizer.generateRefreshToken();

        response.setHeader("Authorization", "Bearer " + accessToken);
        response.setHeader("Refresh", refreshToken);

        Gson gson = new Gson();
        UserDto.Response userResponse = userToUserDtoResponse(user);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.CREATED.value());
        response.getWriter().write(gson.toJson(userResponse, UserDto.Response.class));

        this.getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
    }

    private UserDto.Response userToUserDtoResponse(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = user.getId();
        String email = user.getEmail();
        String username = user.getUsername();
        LocalDateTime createdAt = user.getCreatedAt();
        LocalDateTime updatedAt = user.getUpdatedAt();

        return new UserDto.Response( id, email, username, createdAt, updatedAt );
    }
}