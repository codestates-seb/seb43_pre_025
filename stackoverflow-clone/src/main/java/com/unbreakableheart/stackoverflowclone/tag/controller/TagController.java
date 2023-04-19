package com.unbreakableheart.stackoverflowclone.tag.controller;


import com.unbreakableheart.stackoverflowclone.common.response.MultiResponse;
import com.unbreakableheart.stackoverflowclone.question.entity.Question;
import com.unbreakableheart.stackoverflowclone.tag.entity.Tag;
import com.unbreakableheart.stackoverflowclone.tag.mapper.TagMapper;
import com.unbreakableheart.stackoverflowclone.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/tags")
@Validated
@RequiredArgsConstructor
public class TagController {

    private final static String ORDER_DEFAULT_URL = "/tags";

    private final TagService tagService;
    private final TagMapper mapper;

    @GetMapping("/")
    public ResponseEntity getTags(
            @RequestParam @Valid @Positive int page, @RequestParam @Valid @Positive int size
    ) {
        Page<Tag> tagPage = tagService.findTags(page - 1, size);
        List<Tag> tags = tagPage.getContent();

        return new ResponseEntity(new MultiResponse<>(tagPage, mapper.tagsToTagDtoResponses(tags)), HttpStatus.OK);
    }
}
