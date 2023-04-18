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

    private final UserService userService;

    private final TagRepository tagRepository;


    @Transactional
    public Question createQuestion(Question question) {
        verifyPostQuestion(question);

        //Logic
        //1. USER
        User foundUser = userService.findUser(question.getUser().getUserId());
        question.setUser(foundUser);
        //2. Tag





        Question savedQuestion = questionRepository.save(question);


        //Return
        return savedQuestion;
    }



    @Transactional
    public Question updateQuestion(Question question, Long questionId) {
        verifyPatchQuestion(question, questionId);

        //Logic
        Question foundQuestion = questionRepository.findById(questionId).get();
        foundQuestion.updateQuestion(question.getTitle(), question.getContent());

        //Tag변경 로직 필요함


        //Return
        return foundQuestion;
    }

    public Question findQuestion(Long questionId) {
        //Exception
        //1. Question Exist
        verifyGetQuestion(questionId);

        //Logic
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question question = optionalQuestion.orElseThrow(() -> ());

        //Return
        return question;
    }

    private void verifyGetQuestion(Long questionId) {

    }


    private void verifyPostQuestion(Question question) {
        //Exception
        //1.Member Exist.
        //2.Member is not Admin

    }

    private void verifyPatchQuestion(Question question, Long questionId) {

        //Exception
        //1. Member Exist
        //2. Member is the writer
        //3. Question Exist
        //3. Question Not Answered
        //4. Question Not Deleted

    }
}
