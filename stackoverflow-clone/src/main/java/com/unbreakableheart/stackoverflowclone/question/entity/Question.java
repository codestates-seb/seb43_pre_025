package com.unbreakableheart.stackoverflowclone.question.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private int views;

    private QuestionStatus questionStatus;

//    외래키

    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "question")
    private List<Comment> comments;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @OneToMany(mappedBy = "question")
    private List<Vote> votes;

    @OneToMany(mappedBy = "question")
    private List<Tag> tags;


//    연관관계 설정 메서드
    public void setMember(Member member) {
        this.member = member;
    }

    public void setComment(Comment comment) {
        comments.add(comment);
        comment.setQuestion(this);
    }

    public void setAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }

    public void setVote(Vote vote) {
        votes.add(vote);
        vote.setQuestion(this);
    }

    public void setTag(Tag tag) {
        tags.add(tag);
        tag.setQuestion(this);
    }

    public enum QuestionStatus{
        QUESTION_REGISTERED("질문 등록"),
        QUESTION_ANSWERED("답변 완료"),
        QUESTION_DELETED("질문 삭제");

        @Getter
        public String status;

    QuestionStatus(String status) {
        this.status = status;
    }
}


}
