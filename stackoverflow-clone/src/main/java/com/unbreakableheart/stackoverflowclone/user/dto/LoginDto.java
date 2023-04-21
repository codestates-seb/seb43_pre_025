package com.unbreakableheart.stackoverflowclone.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class LoginDto {

    @Email
    private String email;
    @NotBlank
    private String password;
}
