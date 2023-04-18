package com.unbreakableheart.stackoverflowclone.tag.entity;

import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    @Setter
    private Question question;


    public Tag(String name, Question question) {
        this.name = name;
        this.question = question;
    }
}
