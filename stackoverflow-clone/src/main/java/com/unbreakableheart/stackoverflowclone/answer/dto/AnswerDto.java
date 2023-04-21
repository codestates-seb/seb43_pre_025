package com.unbreakableheart.stackoverflowclone.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class AnswerDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {

        private Long userId;
        private Long questionId;
        private String content;

        public void addQuestionId(Long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {

        private Long userId;
        private Long questionId;
        private Long answerId;
        private String content;

        public void setContent(String content) {
            this.content = content;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {

        private Long answerId;
        private Long userId;
        private Long questionId;
        private String content;
        private Boolean isAccepted;
    }
}
