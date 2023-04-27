package com.unbreakableheart.stackoverflowclone.question.dto;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class QuestionDto {

    @Getter
    @AllArgsConstructor
    public static class Post {

        private Long userId;
        private String title;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {

        private Long userId;
        private Long questionId;
        private String title;
        private String content;
//      private List<QuestionTagDto.Patch> questionTags;

        public void addQuestionId(Long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {

        private Long userId;
        private Long questionId;
        private String title;
        private String content;

//        private List<Comment> comments;
//
//        private List<Answer> answers;
//
//        private List<Vote> votes;
//        private List<QuestionTagDto.Response> questionTags;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class SingleResponse{

        private Long userId;
        private Long questionId;
        private String title;
        private String content;
        private List<AnswerDto.Response> answerResponses;
    }
}

