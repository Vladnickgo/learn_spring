package org.example.service.mapper;

import javax.annotation.processing.Generated;
import org.example.repository.entity.Tag;
import org.example.service.dto.TagDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T19:53:47+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag dtoToEntityMapper(TagDto tagDto) {
        if ( tagDto == null ) {
            return null;
        }

        Tag.TagBuilder tag = Tag.builder();

        tag.id( tagDto.getId() );
        tag.name( tagDto.getName() );

        return tag.build();
    }

    @Override
    public TagDto entityToDtoMapper(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDto.TagDtoBuilder tagDto = TagDto.builder();

        tagDto.id( tag.getId() );
        tagDto.name( tag.getName() );

        return tagDto.build();
    }
}
