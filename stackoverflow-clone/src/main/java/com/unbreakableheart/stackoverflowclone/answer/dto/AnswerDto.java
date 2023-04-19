package com.unbreakableheart.stackoverflowclone.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class AnswerDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        private String content;
        private Long userId;
        private Long questionId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        private Long answerId;
        private Long questionId;
        private String content;

        public void setContent(String content) {
            this.content = content;
        }
    }
    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String content;
        private Long userId;
        private Long questionId;
        private Boolean isAccepted;
    }
}
