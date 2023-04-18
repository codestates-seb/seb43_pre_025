package com.unbreakableheart.stackoverflowclone.question.service;

import com.unbreakableheart.stackoverflowclone.common.exception.CustomException;
import com.unbreakableheart.stackoverflowclone.common.exception.ExceptionCode;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.question.repository.QuestionRepository;
import com.unbreakableheart.stackoverflowclone.tag.repository.TagRepository;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final UserService userService;

    private final TagRepository tagRepository;


    public Question createQuestion(Question question) {
        verifyPostQuestion(question);

        //Logic
        User foundUser = userService.findUser(question.getUser().getId());
        question.setUser(foundUser);
        //Tag 로직 필요함//

        /////////////////

        Question savedQuestion = questionRepository.save(question);


        return savedQuestion;
    }



    public Question updateQuestion(Question question, Long questionId) {
        verifyPatchQuestion(question, questionId);

        //Logic
        Question foundQuestion = questionRepository.findById(questionId).get();
        foundQuestion.updateQuestion(question.getTitle(), question.getContent());

        //Tag변경 로직 필요함//

        ////////////////////

        return foundQuestion;
    }

    public Question findQuestion(Long questionId) {
        verifyGetQuestion(questionId);

        //Logic
        Question question = questionRepository.findById(questionId).get();
        question.viewIncrease();

        //Return
        return question;
    }

    public Page<Question> findQuestions(int page, int size) {

        PageRequest pageImpl = PageRequest.of(page, size);
        Page<Question> pageQuestions = questionRepository.findAll(pageImpl);

        //삭제된 질문 조회 불가능하도록, 조회수 1증가 하도록 구현 필요//

        //////////////////////////////////////////////////////

        return pageQuestions;
    }

    public void deleteQuestion(Long questionId) {
        verifyGetQuestion(questionId);

        Question question = questionRepository.findById(questionId).get();
        question.setQuestionStatus(Question.QuestionStatus.QUESTION_DELETED);
    }



    private void verifyGetQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question question = optionalQuestion.orElseThrow(() -> new CustomException(ExceptionCode.QUESTION_NOT_FOUND));
        isDeleted(question.getQuestionStatus());
    }


    private void verifyPostQuestion(Question question) {
        //Exception
        //1.Member Exist.
        userService.findUser(question.getUser().getId());

    }

    private void verifyPatchQuestion(Question question, Long questionId) {
        //Exception
        //1. Member Exist
        //2. Member is the writer
        //3. Question Exist
        //4. Question Not Deleted
        userService.findUser(question.getUser().getId());
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question foundQuestion = optionalQuestion.orElseThrow(() -> new CustomException(ExceptionCode.QUESTION_NOT_FOUND));
        isDeleted(foundQuestion.getQuestionStatus());

    }

    private static void isDeleted(Question.QuestionStatus questionStatus) {
        if (questionStatus.equals(Question.QuestionStatus.QUESTION_DELETED)) {
            throw new CustomException(ExceptionCode.QUESTION_NOT_FOUND);
        }
    }



}
