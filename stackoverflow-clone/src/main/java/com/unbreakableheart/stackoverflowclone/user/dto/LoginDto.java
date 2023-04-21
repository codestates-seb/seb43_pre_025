package com.unbreakableheart.stackoverflowclone.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginDto {

    private String email;
    private String password;
}
