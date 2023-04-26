package com.unbreakableheart.stackoverflowclone.question.repository;

import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Optional<Question> findByTitle(String title);
    Page<Question> findAllByQuestionStatusNot(Pageable pageable, Question.QuestionStatus questionStatus);
}
