package com.unbreakableheart.stackoverflowclone.question.repository;

import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Optional<Question> findByTitle(String title);

}
