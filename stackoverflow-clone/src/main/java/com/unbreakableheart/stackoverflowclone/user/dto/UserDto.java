package com.unbreakableheart.stackoverflowclone.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


public class UserDto {

    @Getter
    @AllArgsConstructor
    public static class Post {

        @Email
        String email;
        @NotBlank
        String password;
        @NotBlank
        String username;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {

        Long id;
        String password;
        @NotBlank
        String username;

        public void addId(Long id) {
            this.id = id;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {

        Long id;
        String email;
        String password;
        String username;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;
    }
}
