package com.unbreakableheart.stackoverflowclone.answer.mapper;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    default Answer answerPostDtoToAnswer(AnswerDto.Post answerPostDto) {
        if (answerPostDto == null) {
            return null;
        }
        Answer answer = new Answer();
        User user = new User();
        Question question = new Question();

        user.setId(answerPostDto.getUserId());
        question.addQuestionId(answerPostDto.getQuestionId());
        answer.addUser(user);
        answer.addQuestion(question);
        answer.setContent(answerPostDto.getContent());
        return answer;
    }

    default Answer answerPatchDtoToAnswer(AnswerDto.Patch answerPatchDto) {
        Answer answer = new Answer();
        Question question = new Question();

        question.setId(answerPatchDto.getQuestionId());
        answer.setAnswerId(answerPatchDto.getAnswerId());
        answer.setQuestion(question);
        answer.setContent(answerPatchDto.getContent());
        return answer;
    }

    List<AnswerDto.Response> answersToAnswerDtoResponses(List<Answer> answers);

    AnswerDto.Response answerToAnswerDtoResponse(Answer answer);
}
