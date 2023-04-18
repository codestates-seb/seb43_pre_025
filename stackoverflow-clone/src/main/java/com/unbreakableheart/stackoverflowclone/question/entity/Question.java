package com.unbreakableheart.stackoverflowclone.question.entity;

import com.unbreakableheart.stackoverflowclone.common.entity.BaseEntity;
import com.unbreakableheart.stackoverflowclone.tag.entity.Tag;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Question extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private int views;

    @Setter
    private QuestionStatus questionStatus;

//    외래키

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private List<Answer> answers;

    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private List<Vote> votes;

    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private List<Tag> tags;


//    연관관계 설정 메서드
    public void setUser(User user) {
        this.user = user;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setQuestion(this);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }

    public void addVote(Vote vote) {
        votes.add(vote);
        vote.setQuestion(this);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.setQuestion(this);
    }

    public void setTag(List<Tag> tags) {
        this.tags = tags;
    }

    private Question(String title, String content, int views, QuestionStatus questionStatus) {
        this.title = title;
        this.content = content;
        this.views = views;
        this.questionStatus = questionStatus;
    }

    public static Question makeQuestion(String title, String content) {
        Question madequestion = new Question(title, content, 0 , QuestionStatus.QUESTION_REGISTERED);
        return madequestion;
    }

    public void updateQuestion(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void viewIncrease() {
        this.views += 1;
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
