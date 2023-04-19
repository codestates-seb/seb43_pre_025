package com.unbreakableheart.stackoverflowclone.answer.controller;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import com.unbreakableheart.stackoverflowclone.answer.mapper.AnswerMapper;
import com.unbreakableheart.stackoverflowclone.answer.service.AnswerService;
import com.unbreakableheart.stackoverflowclone.common.response.MultiResponse;
import com.unbreakableheart.stackoverflowclone.common.utils.UriCreator;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/questions/{question-id}")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PostMapping("/{question-id}/answers")
    public ResponseEntity postAnswer(@PathVariable("question-id") long questionId,
                                     @RequestBody AnswerDto.Post answerPostDto) {

        answerService.createAnswer(answerMapper.answerPostDtoToAnswer(answerPostDto));
//        Answer answer = answerMapper.answerPostDtoToAnswer(answerPostDto);
//        answer.setQuestionId(questionId);
//        answerService.createAnswer(answer);\

//        URI uri = UriComponentsBuilder.newInstance().build(DEFAULT_ANSWER_URI);
        URI uri = UriCreator.createURI(questionId);
        return ResponseEntity.created(uri).build();


    }

    @PatchMapping("/answer/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") long answerId,
                                      @RequestBody AnswerDto.Patch answerPatchDto) {

        answerPatchDto.setAnswerId(answerId);
        Answer answer = answerService.updateAnswer(answerMapper.answerPatchDtoToAnswer(answerPatchDto));
        AnswerDto.Response response = answerMapper.answerToAnswerDtoResponse(answer);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity getAnswers(@RequestParam @Positive int page,
                                     @RequestParam @Positive int size) {
        Page<Answer> answerPage = answerService.findAnswers(page - 1, size);
        List<AnswerDto.Response> response = answerMapper.answersToAnswerDtoResponses(answerPage.getContent());
        return ResponseEntity.ok(new MultiResponse<>(answerPage, response));
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") long answerId) {
        answerService.deleteAnswer(answerId);
        return ResponseEntity.noContent().build();
    }
}
