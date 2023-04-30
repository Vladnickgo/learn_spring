package org.example.service.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper<ENTITY, DTO> {
    DTO mapEntityToDto(ENTITY entity);

    ENTITY mapDtoToEntity(DTO dto);
}
