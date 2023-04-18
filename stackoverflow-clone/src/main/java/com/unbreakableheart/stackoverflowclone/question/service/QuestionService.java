package com.unbreakableheart.stackoverflowclone.question.service;

import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;


    @Transactional
    public Question createQuestion(Question question) {
        //Exception
        //1.Member Exist.
        //2.Member is not Admin

        //Logic
        question.setQuestionStatus(Question.QuestionStatus.QUESTION_REGISTERED);
        Question savedQuestion = questionRepository.save(question);

        //Tag?? Service 불러서 저장해야하나?


        //Return
        return savedQuestion;
    }


    @Transactional
    public Question updateQuestion(Question question) {
        //Exception
        //1. Member Exist
        //2. Member is the writer
        //3. Question Exist
        //3. Question Not Answered
        //4. Question Not Deleted


        //Logic
        Question foundQuestion = questionRepository.findById(question.getId()).get();
        foundQuestion.setTitle(question.getTitle());
        foundQuestion.setContent(question.getContent());

        //Tag?? Service 불러서 변경해야하나?


        //Return
        return foundQuestion;
    }
}
