package com.unbreakableheart.stackoverflowclone.tag.mapper;

import com.unbreakableheart.stackoverflowclone.tag.dto.TagDto;
import com.unbreakableheart.stackoverflowclone.tag.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {
    List<TagDto.Response> tagsToTagDtoResponses(List<Tag> tags);
}
