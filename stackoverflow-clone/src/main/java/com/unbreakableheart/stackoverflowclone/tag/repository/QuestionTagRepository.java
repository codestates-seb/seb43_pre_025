package com.unbreakableheart.stackoverflowclone.tag.repository;

import com.unbreakableheart.stackoverflowclone.tag.entity.QuestionTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTagRepository extends JpaRepository<QuestionTag, Long> {
}
