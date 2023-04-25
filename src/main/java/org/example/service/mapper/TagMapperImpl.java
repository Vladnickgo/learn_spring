package org.example.service.mapper;

import org.example.repository.entity.Tag;
import org.example.service.dto.TagDto;
import org.springframework.stereotype.Component;

@Component
public class TagMapperImpl implements EntityMapper<Tag,TagDto> {
    @Override
    public TagDto mapEntityToDto(Tag tag) {
        if(tag==null){return null;}
        return TagDto.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }

    @Override
    public Tag mapDtoToEntity(TagDto tagDto) {
        if(tagDto==null){return null;}
        return Tag.builder()
                .id(tagDto.getId())
                .name(tagDto.getName())
                .build();
    }
}
