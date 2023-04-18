package com.unbreakableheart.stackoverflowclone.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class TagDto {

    @AllArgsConstructor
    @Getter
    public static class Post{
        @NotBlank
        private String name;

    }

    @AllArgsConstructor
    @Getter
    public static class Patch{

        private Long tagId;
        @NotBlank
        private String name;

    }

    @AllArgsConstructor
    @Getter
    public static class Response {

        private Long tagId;

        private String name;
    }

}
