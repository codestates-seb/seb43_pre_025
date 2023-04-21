package com.unbreakableheart.stackoverflowclone.answer.mapper;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "questionId", target = "question.id")
    Answer answerPostDtoToAnswer(AnswerDto.Post answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerDto.Patch answerPostDto);
    List<AnswerDto.Response> answersToAnswerDtoResponses(List<Answer> answers);
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "question.id", target = "questionId")
    AnswerDto.Response answerToAnswerDtoResponse(Answer answer);
}
