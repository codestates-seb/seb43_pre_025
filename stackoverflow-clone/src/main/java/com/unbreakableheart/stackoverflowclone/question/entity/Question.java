package com.unbreakableheart.stackoverflowclone.question.entity;

import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import com.unbreakableheart.stackoverflowclone.common.entity.BaseEntity;
import com.unbreakableheart.stackoverflowclone.tag.entity.QuestionTag;
import com.unbreakableheart.stackoverflowclone.tag.entity.Tag;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Question extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private int views;

    @Setter
    private QuestionStatus questionStatus;

//    외래키

    @Setter
    @OneToMany(mappedBy = "question")
    private List<QuestionTag> questionTags = new ArrayList<>();
    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private List<Answer> answers = new ArrayList<>();

//    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
//    private List<Comment> comments = new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
//    private List<Vote> votes = new ArrayList<>();




//    연관관계 설정 메서드
    public void setUser(User user) {
        this.user = user;
    }

//    public void addComment(Comment comment) {
//        comments.add(comment);
//        comment.setQuestion(this);
//    }

    public void addAnswer(Answer answer) {
        if(!answers.contains(answer)){
           answers.add(answer);
        }
    }

//    public void addVote(Vote vote) {
//        votes.add(vote);
//        vote.setQuestion(this);
//    }
//
//    public void addTag(Tag tag) {
//        tags.add(tag);
//        tag.setQuestion(this);
//    }

//    public void setTag(List<Tag> tags) {
//        this.tags = tags;
//    }

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
    public void updateQuestion(String title, String content, List<QuestionTag> questionTags) {
        this.title = title;
        this.content = content;
        this.questionTags = questionTags;
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
