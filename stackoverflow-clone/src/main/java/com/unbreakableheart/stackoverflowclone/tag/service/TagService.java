package com.unbreakableheart.stackoverflowclone.tag.service;

import com.unbreakableheart.stackoverflowclone.tag.entity.Tag;
import com.unbreakableheart.stackoverflowclone.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TagService {


    private final TagRepository tagRepository;


    @Transactional
    public Tag createTag(Tag tag) {
        if(tagExist(tag.getName())){
            return tagRepository.findByName(tag.getName()).get();
        }
        else {
            return tagRepository.save(new Tag(tag.getName(), tag.getQuestion()));
        }
    }

    @Transactional
    public List<Tag> createTags(List<Tag> tags) {
        return tags.stream().map(tag -> createTag(tag)).collect(Collectors.toList());
    }

    private boolean tagExist(String name) {
        Optional<Tag> optionalTag = tagRepository.findByName(name);
        if (optionalTag.isEmpty()) {
            return false;
        }
        return true;
    }
}
