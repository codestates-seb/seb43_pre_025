package com.unbreakableheart.stackoverflowclone.answer.controller;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import com.unbreakableheart.stackoverflowclone.answer.entity.Answer;
import com.unbreakableheart.stackoverflowclone.answer.mapper.AnswerMapper;
import com.unbreakableheart.stackoverflowclone.answer.service.AnswerService;
import com.unbreakableheart.stackoverflowclone.common.response.MultiResponse;
import com.unbreakableheart.stackoverflowclone.common.response.SingleResponse;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity<SingleResponse<AnswerDto.Response>> patchAnswer(@AuthenticationPrincipal User user,
                                      @PathVariable("answer-id") long answerId,
                                      @RequestBody AnswerDto.Patch answerPatchDto) {
        answerPatchDto.setAnswerId(answerId);
        Answer answer = answerService.updateAnswer(answerMapper.answerPatchDtoToAnswer(answerPatchDto), user);
        AnswerDto.Response response = answerMapper.answerToAnswerDtoResponse(answer);
        return ResponseEntity.ok(new SingleResponse<>(response));
    }

    @GetMapping
    public ResponseEntity<MultiResponse<AnswerDto.Response>> getAnswers(@AuthenticationPrincipal User user,
                                     @RequestParam @Positive int page,
                                     @RequestParam @Positive int size) {
        Page<Answer> answerPage = answerService.findAnswers(page - 1, size, user);
        List<AnswerDto.Response> response = answerMapper.answersToAnswerDtoResponses(answerPage.getContent());
        return ResponseEntity.ok(new MultiResponse<>(answerPage, response));
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity<Object> deleteAnswer(@AuthenticationPrincipal User user,
                                       @PathVariable("answer-id") long answerId) {
        answerService.deleteAnswer(answerId, user);
        return ResponseEntity.noContent().build();
    }
}
