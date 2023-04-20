package com.unbreakableheart.stackoverflowclone.answer.service;

import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import com.unbreakableheart.stackoverflowclone.answer.repository.AnswerRepository;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.question.service.QuestionService;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final UserService userService;


    public AnswerService(AnswerRepository answerRepository, QuestionService questionService, UserService userService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.userService = userService;
    }

    public Answer createAnswer(Answer answer) {
        answer.setUser(userService.findUser(answer.getUser().getId()));

        Question question =
                questionService.findQuestion(answer.getQuestion().getId());

        answer.addQuestion(question);

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        Question question = questionService.findQuestion(answer.getQuestion().getId());
        answer.setQuestion(question);

//        Answer findAnswer = findAnswer(answer.getAnswerId());
//        Optional.ofNullable(answer.getContent()).ifPresent(content -> findAnswer.setContent(content));

        Optional<Answer> tempAnswer = answerRepository.findById(answer.getAnswerId());
        if (tempAnswer.isPresent()) {
            Answer tempAnswer2 = tempAnswer.get();
            tempAnswer2.setContent(answer.getContent());
            return answerRepository.save(tempAnswer2);
        } else {
            throw new IllegalArgumentException("Answer ID를 찾을 수 없습니다.: " + answer.getAnswerId());
        }
    }
//        return answerRepository.save(findAnswer);



    public Answer findAnswer(long answerId) {

        Optional <Answer> answer = answerRepository.findById(answerId);
        return answer.get();
    }

    public Page<Answer> findAnswers(int page, int size) {
        return answerRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteAnswer(long answerId) {
        answerRepository.delete(findAnswer(answerId));
    }

}
