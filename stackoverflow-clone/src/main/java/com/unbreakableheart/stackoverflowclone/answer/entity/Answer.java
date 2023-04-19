package com.unbreakableheart.stackoverflowclone.answer.entity;

import com.unbreakableheart.stackoverflowclone.common.entity.BaseEntity;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @NotBlank
    @Column(name = "TEXT", nullable = false)
    private String content;

    @Column(name = "IS_ACCEPTED", nullable = false)
    private Boolean isAccepted;

    // FK
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public void addQuestion(Question question){
        if(this.question == null){
            this.question = question;
            question.addAnswer(this);
        }
    }

    public Answer() {}

    public Answer(String content, User user, Question question) {
        this.content = content;
        this.isAccepted = false;
        this.user = user;
        this.question = question;
    }

    @Getter
    public enum AnswerStatus {
        ANSWER_REGISTERED("답변 등록"),
        ANSWER_CORRECTED("답변 수정"),
        ANSWER_DELETED("답변 삭제");

        @Getter
        public String status;

        AnswerStatus(String status) {
            this.status = status;
        }
    }
}
