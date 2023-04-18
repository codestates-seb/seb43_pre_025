package com.unbreakableheart.stackoverflowclone.question.controller;

import com.unbreakableheart.stackoverflowclone.common.response.SingleResponse;
import com.unbreakableheart.stackoverflowclone.common.utils.UriCreator;
import com.unbreakableheart.stackoverflowclone.question.dto.QuestionDto;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.question.mapper.QuestionMapper;
import com.unbreakableheart.stackoverflowclone.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/questions")
@Validated
@Slf4j
@RequiredArgsConstructor
public class QuestionController {

    private final static String ORDER_DEFAULT_URL = "/questions";

    private final QuestionService questionService;
    private final QuestionMapper mapper;


    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post requestBody) {

        Question question = questionService.createQuestion(mapper.questionPostToQuestion(requestBody));
        URI location = UriCreator.createURI(question.getId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{question-id}/title")
    public ResponseEntity patchQuestion(
            @PathVariable("question-id") @Positive Long questionId,
            @Valid @RequestBody QuestionDto.Patch requestBody
    ) {
        requestBody.setQuestionId(questionId);
        Question question = questionService.updateQuestion(mapper.questionPatchToQuestion(requestBody),questionId);

        return new ResponseEntity<>(new SingleResponse<>(mapper.questionToQuestionResponse(question)), HttpStatus.OK);
    }

    @GetMapping("/{question-id}/title")
    public ResponseEntity getQuestion(
            @PathVariable("question-id") @Positive Long questionId
    ) {
        Question question = questionService.findQuestion(questionId);

        return new ResponseEntity<>(new SingleResponse<>(mapper.questionToQuestionResponse(question)), HttpStatus.OK);
    }

}
