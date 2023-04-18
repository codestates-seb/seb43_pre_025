package com.unbreakableheart.stackoverflowclone.question.mapper;

import com.unbreakableheart.stackoverflowclone.question.dto.QuestionDto;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    default Question questionPostToQuestion(QuestionDto.Post requestBody){

        //외래키 엔티티 생성
        User user = new User();
        user.setUserId(requestBody.getUserId());

        //기본 질문 등록
        Question question = Question.makeQuestion(requestBody.getTitle(), requestBody.getContent());

        //질문에 유저 등록
        //질문에 태그 등록(여기 소관이 아닐지도)
        question.setUser(user);

        return question;
    };

    default Question questionPatchToQuestion(QuestionDto.Patch requestBody){

        User user = new User();
        user.setUserId(requestBody.getUserId());

        Question question = Question.makeQuestion(requestBody.getTitle(), requestBody.getContent());
        question.setUser(user);
    };

    default QuestionDto.Response questionToQuestionResponse(Question question){

        return new QuestionDto.Response(
                question.getTitle(),
                question.getContent(),
                question.getUser().getUserId(),
                question.getComments(),
                question.getAnswers(),
                question.getVotes(),
                question.getTags()
        );
    };


}
