package com.unbreakableheart.stackoverflowclone.tag.entity;

import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class QuestionTag {

    @Id
    @GeneratedValue
    @Column(name = "QUESTION_TAG_ID")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    public QuestionTag(String name) {
        this.name = name;
    }

    public void setQuestion(Question question) {
        this.question = question;
        if (!this.question.getQuestionTags().contains(this)) {
            this.question.getQuestionTags().add(this);
        }
    }

    public void setTag(Tag tag) {
        this.tag = tag;
        //QuestionTag -> Tag 단방향 관계
//        if (!this.tag.getQuestionTags().contains(this)) {
//            this.tag.getQuestionTags().add(this);
//        }
    }
}
