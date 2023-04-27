package com.unbreakableheart.stackoverflowclone.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Positive;

public class QuestionTagDto {

    @Getter
    @AllArgsConstructor
    public static class Post{

        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{

        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {

        @Positive
        private Long tagId;

        private String name;
    }

}
