package com.unbreakableheart.stackoverflowclone.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class QuestionDto {


    @Getter
    @AllArgsConstructor
    public static class Post {

        private String title;

        private String content;

    }
    @Getter
    @AllArgsConstructor
    public static class Patch {

        private Long questionId;
        private String title;

        private String content;

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
    }
}

