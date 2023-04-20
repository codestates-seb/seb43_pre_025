package com.unbreakableheart.stackoverflowclone.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

public class QuestionTagDto {

    @Getter
    public static class Post{

        private String name;

        public Post() {
        }

        public Post(String name) {
            this.name = name;
        }
    }

    @Getter
    @NoArgsConstructor
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
