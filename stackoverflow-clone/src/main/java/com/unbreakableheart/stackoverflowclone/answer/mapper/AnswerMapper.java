package com.unbreakableheart.stackoverflowclone.answer.mapper;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "questionId", target = "question.id")
    Answer answerPostDtoToAnswer(AnswerDto.Post answerPostDto);
    @Mapping(source = "questionId", target = "question.id")
    Answer answerPatchDtoToAnswer(AnswerDto.Patch answerPostDto);
    List<AnswerDto.Response> answersToAnswerDtoResponses(List<Answer> answers);
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "question.id", target = "questionId")
    AnswerDto.Response answerToAnswerDtoResponse(Answer answer);
}
