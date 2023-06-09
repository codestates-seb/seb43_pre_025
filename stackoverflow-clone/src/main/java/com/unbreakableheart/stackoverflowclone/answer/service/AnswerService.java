package com.unbreakableheart.stackoverflowclone.answer.service;

import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import com.unbreakableheart.stackoverflowclone.answer.repository.AnswerRepository;
import com.unbreakableheart.stackoverflowclone.common.exception.CustomException;
import com.unbreakableheart.stackoverflowclone.common.exception.ExceptionCode;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.question.service.QuestionService;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final UserService userService;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService, UserService userService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.userService = userService;
    }

    public Answer createAnswer(Answer answer, User user) {
        userService.findUserByEmail(user.getEmail());

        Question question =
                questionService.findQuestion(answer.getQuestion().getId(), user);

        answer.addQuestion(question);
        answer.addUser(user);

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer, User user) {
        userService.findUserByEmail(user.getEmail());
        Answer findAnswer = findVerifyAnswer(answer.getAnswerId());
        User authentication = userService.findUserByEmail(user.getEmail());
        userService.isMatchUser(findAnswer.getUser(), authentication);
        Optional.ofNullable(answer.getContent())
                .ifPresent(findAnswer::setContent);
        return answerRepository.save(findAnswer);
    }

    public Answer findAnswer(long answerId, User user) {
        userService.findUserByEmail(user.getEmail());
        return answerRepository.findById(answerId).orElseThrow(() ->
                new CustomException(ExceptionCode.ANSWER_NOT_FOUND));
    }

    public Page<Answer> findAnswers(int page, int size, User user) {
        userService.findUserByEmail(user.getEmail());
        return answerRepository.findAll(PageRequest.of(page, size));
    }

    private Answer findVerifyAnswer(Long answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() ->
                        new CustomException(ExceptionCode.ANSWER_NOT_FOUND));
    }

    public void deleteAnswer(long answerId, User user) {
        Answer answer = findAnswer(answerId, user);
        User authentication = userService.findUserByEmail(user.getEmail());
        userService.isMatchUser(answer.getUser(), authentication);
        answerRepository.delete(answer);
    }
}
