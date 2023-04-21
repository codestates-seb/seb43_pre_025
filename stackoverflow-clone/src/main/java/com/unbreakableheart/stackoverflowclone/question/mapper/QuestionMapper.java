package com.unbreakableheart.stackoverflowclone.question.mapper;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import com.unbreakableheart.stackoverflowclone.question.dto.QuestionDto;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.tag.dto.QuestionTagDto;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    default Question questionPostToQuestion(QuestionDto.Post requestBody) {
        //외래키 엔티티 생성
        User user = new User();
        user.setId(requestBody.getUserId());

        //기본 질문 등록
        Question question = Question.makeQuestion(requestBody.getTitle(), requestBody.getContent());

//        List<QuestionTag> questionTags = requestBody.getQuestionTags().stream().map(name -> {
//             return new QuestionTag(name.getName());
//        }).collect(Collectors.toList());
        //질문에 유저 등록
        //질문에 태그 등록

        question.setUser(user);
//        question.setQuestionTags(questionTags);

        return question;
    }



    default Question questionPatchToQuestion(QuestionDto.Patch requestBody) {
        User user = new User();
        user.setId(requestBody.getUserId());

        Question question = Question.makeQuestion(requestBody.getTitle(), requestBody.getContent());
        question.setUser(user);

        return question;
    }



    default QuestionDto.SingleResponse questionToQuestionResponse(Question question) {
        List<QuestionTagDto.Response> questionTagResponse = question.getQuestionTags()
                .stream()
                .map(questionTag ->
                        new QuestionTagDto.Response(
                                questionTag.getId(),
                                questionTag.getName()
                        )).collect(Collectors.toList());

        List<AnswerDto.Response> answerResponses = question.getAnswers().stream().map(answer ->
                new AnswerDto.Response(
                        answer.getAnswerId(),
                        answer.getContent(),
                        answer.getUser().getId(),
                        answer.getQuestion().getId(),
                        answer.getIsAccepted()
                )).collect(Collectors.toList());

        return new QuestionDto.SingleResponse(
                question.getUser().getId(),
                question.getId(),
                question.getTitle(),
                question.getContent(),
                answerResponses
//                question.getComments(),
//                question.getAnswers(),
//                question.getVotes(),
//                questionTagResponse()
        );
    }

    List<QuestionDto.Response> questionsToQuestionDtoResponses(List<Question> questions);

    @Mapping(source = "question.id", target = "questionId")
    @Mapping(source = "user.id", target = "userId")
    QuestionDto.Response questionToQuestionDtoResponse(Question question);
}
