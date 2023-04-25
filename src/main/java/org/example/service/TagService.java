package org.example.service;

import org.example.service.dto.TagDto;

import java.util.List;

public interface TagService {
    List<TagDto> findAll();

    TagDto findById(Integer id);

    void insert(TagDto tagDto);

    void deleteById(Integer id);
}