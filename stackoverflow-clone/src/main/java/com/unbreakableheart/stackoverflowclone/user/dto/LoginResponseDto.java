package com.unbreakableheart.stackoverflowclone.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
@AllArgsConstructor
public class LoginResponseDto {

    private String grantType;
    private String accessToken;
    private String refreshToken;
}
