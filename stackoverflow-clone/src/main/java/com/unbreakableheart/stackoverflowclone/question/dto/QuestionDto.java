package com.unbreakableheart.stackoverflowclone.question.dto;

import com.unbreakableheart.stackoverflowclone.tag.dto.QuestionTagDto;
import com.unbreakableheart.stackoverflowclone.tag.entity.QuestionTag;
import com.unbreakableheart.stackoverflowclone.tag.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

public class QuestionDto {


    @Getter
    @AllArgsConstructor
    public static class Post {

        private Long userId;

        private String title;

        private String content;

        private List<QuestionTagDto.Post> questionTags;

    }
    @Getter
    @AllArgsConstructor
    public static class Patch {

        private Long userId;

        private Long questionId;

        private String title;

        private String content;

        private List<QuestionTagDto.Patch> questionTags;

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor

    public static class Response {

        private String title;

        private String Content;

        private Long userId;

        private List<Comment> comments;

        private List<Answer> answers;

        private List<Vote> votes;

        private List<QuestionTagDto.Response> questionTags;
    }
}

