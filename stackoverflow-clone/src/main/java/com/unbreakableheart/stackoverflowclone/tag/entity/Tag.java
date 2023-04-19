package com.unbreakableheart.stackoverflowclone.tag.entity;

import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_ID")
    private Long id;

    private String name;

    public Tag(String name) {
        this.name = name;
    }

    //    @OneToMany(mappedBy ="tag")
//    @JoinColumn(name = "MEMBER_ID")
//    @Setter
//    private List<QuestionTag> questionTags = new ArrayList<>();


//    public Tag(String name, Question question) {
//        this.name = name;
//        this.question = question;
//    }
}

