package com.unbreakableheart.stackoverflowclone.tag.service;

import com.unbreakableheart.stackoverflowclone.tag.entity.QuestionTag;
import com.unbreakableheart.stackoverflowclone.tag.entity.Tag;
import com.unbreakableheart.stackoverflowclone.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Long createTagByName(String tagName) {
        if(tagExist(tagName)){
            //존재한다면 id를 바로 리턴함
            return tagRepository.findByName(tagName).get().getId();
        }
        else {
            //존재하지 않는다면 새로 등록한 후 등록한걸 반환함
            return tagRepository.save(new Tag(tagName)).getId();
        }
    }

    @Transactional(readOnly = true)
    public String findTagNameById(Long id) {
        return tagRepository.findById(id).get().getName();
    }
    private boolean tagExist(String name) {
        Optional<Tag> optionalTag = tagRepository.findByName(name);
        if (optionalTag.isPresent()) {
            return true;
        }
        return false;
    }

    public Tag findTagAlways(Long tagId) {
        return tagRepository.findById(tagId).get();
    }


    public Page<Tag> findTags(int page, int size) {
        PageRequest pageImpl = PageRequest.of(page, size);
        Page<Tag> pageTags = tagRepository.findAll(pageImpl);

        return pageTags;
    }



//    @Transactional
//    public List<Long> createTagByNames(List<Tag> tags) {
//        return tags.stream().map(tag -> createTagByName(tag.getName())).collect(Collectors.toList());
//    }
}
