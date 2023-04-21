package com.unbreakableheart.stackoverflowclone.question.controller;

import com.unbreakableheart.stackoverflowclone.answer.dto.AnswerDto;
import com.unbreakableheart.stackoverflowclone.answer.mapper.AnswerMapper;
import com.unbreakableheart.stackoverflowclone.answer.service.AnswerService;
import com.unbreakableheart.stackoverflowclone.common.response.MultiResponse;
import com.unbreakableheart.stackoverflowclone.common.response.SingleResponse;
import com.unbreakableheart.stackoverflowclone.common.utils.UriCreator;
import com.unbreakableheart.stackoverflowclone.question.dto.QuestionDto;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.question.mapper.QuestionMapper;
import com.unbreakableheart.stackoverflowclone.question.service.QuestionService;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/questions")
@Validated
@Slf4j
@RequiredArgsConstructor
public class QuestionController {

    private final static String ORDER_DEFAULT_URL = "/questions";
    private final QuestionService questionService;
    private final QuestionMapper mapper;
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    @PostMapping
    public ResponseEntity<Object> postQuestion(@AuthenticationPrincipal User user,
                                                @Valid @RequestBody QuestionDto.Post requestBody) {

        Question question = questionService.createQuestion(mapper.questionPostToQuestion(requestBody), user);
        URI location = UriCreator.createURI(question.getId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity<SingleResponse<QuestionDto.Response>> patchQuestion(@AuthenticationPrincipal User user,
                                        @PathVariable("question-id") @Positive Long questionId,
                                        @Valid @RequestBody QuestionDto.Patch requestBody) {
        requestBody.addQuestionId(questionId);
        Question question = questionService.updateQuestion(mapper.questionPatchToQuestion(requestBody), user);

        return ResponseEntity.ok(new SingleResponse<>(mapper.questionToQuestionDtoResponse(question)));
    }

    @GetMapping("/{question-id}")
    public ResponseEntity<SingleResponse<QuestionDto.SingleResponse>> getQuestion(@AuthenticationPrincipal User user,
                                      @PathVariable("question-id") @Positive Long questionId) {
        Question question = questionService.findQuestion(questionId, user);

        return ResponseEntity.ok(new SingleResponse<>(mapper.questionToQuestionResponse(question)));
    }

    @GetMapping
    public ResponseEntity<MultiResponse<QuestionDto.Response>> getQuestions(@AuthenticationPrincipal User user,
                                       @RequestParam @Valid @Positive int page,
                                       @RequestParam @Valid @Positive int size) {
        Page<Question> questionPage = questionService.findQuestions(page - 1, size, user);
        List<Question> questions = questionPage.getContent();

        return ResponseEntity.ok(new MultiResponse<>(questionPage, mapper.questionsToQuestionDtoResponses(questions)));
    }

    @DeleteMapping("{question-id}")
    public ResponseEntity<Object> deleteQuestion(@AuthenticationPrincipal User user,
                                         @PathVariable("question-id") @Positive Long questionId) {
        questionService.deleteQuestion(questionId, user);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{question-id}/answers")
    public ResponseEntity postAnswer(@AuthenticationPrincipal User user,
                                     @PathVariable("question-id") long questionId,
                                     @RequestBody AnswerDto.Post answerPostDto) {
        answerPostDto.addQuestionId(questionId);
        answerService.createAnswer(answerMapper.answerPostDtoToAnswer(answerPostDto), user);
//        Answer answer = answerMapper.answerPostDtoToAnswer(answerPostDto);
//        answer.setQuestionId(questionId);
//        answerService.createAnswer(answer);

//        URI uri = UriComponentsBuilder.newInstance().build(DEFAULT_ANSWER_URI);
        URI uri = UriCreator.createURI(questionId);
        return ResponseEntity.created(uri).build();
    }
}
