package com.unbreakableheart.stackoverflowclone.answer.mapper;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerDto.Post answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerDto.Patch answerPostDto);
    List<AnswerDto.Response> answersToAnswerDtoResponses(List<Answer> answers);
    AnswerDto.Response answerToAnswerDtoResponse(Answer answer);
}
