package org.example.service.mapper;

import org.example.repository.entity.Tag;
import org.example.service.dto.TagDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    Tag dtoToEntityMapper(TagDto tagDto);

    TagDto entityToDtoMapper(Tag tag);
}
