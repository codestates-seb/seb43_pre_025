package com.unbreakableheart.stackoverflowclone.tag.controller;


import com.unbreakableheart.stackoverflowclone.tag.mapper.TagMapper;
import com.unbreakableheart.stackoverflowclone.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
@Validated
@RequiredArgsConstructor
public class TagController {

    private final static String ORDER_DEFAULT_URL = "/tags";

    private final TagService tagService;
    private final TagMapper mapper;
}
