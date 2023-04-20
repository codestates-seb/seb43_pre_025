package com.unbreakableheart.stackoverflowclone.tag.service;

import com.unbreakableheart.stackoverflowclone.tag.entity.QuestionTag;
import com.unbreakableheart.stackoverflowclone.tag.entity.Tag;
import com.unbreakableheart.stackoverflowclone.tag.repository.QuestionTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionTagService {

    private final QuestionTagRepository questionTagRepository;


    public QuestionTag saveQuestionTag(QuestionTag questionTag) {
        QuestionTag save = questionTagRepository.save(questionTag);
        return save;
    }

    public void deleteQuestionTag(Long id) {
        questionTagRepository.deleteById(id);
    }

}
