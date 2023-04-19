package com.unbreakableheart.stackoverflowclone.answer.service;

import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import com.unbreakableheart.stackoverflowclone.answer.repository.AnswerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
//    private final QuestionService questionService;
//
//    private final UserService userService;


    public AnswerService(AnswerRepository answerRepository, QuestionService questionService, UserService userService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.userService = userService;
    }

    public Answer createAnswer(Answer answer) {
        userService.findUser(answer.getUser().getUserId());

        Question question =
                questionService.findQuestion(answer.getQuestion().getQuetionId(), answer.getUser().getUserId);

        answer.setQuestion(question);

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {

        return answerRepository.save(answer);
    }

    public Answer findAnswer(long answerId) {

        return findAnswer(answerId);
    }

    public Page<Answer> findAnswers(int page, int size) {
        return answerRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteAnswer(long answerId) {
        answerRepository.delete(findAnswer(answerId));
    }

}
