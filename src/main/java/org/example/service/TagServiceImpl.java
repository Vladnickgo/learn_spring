package org.example.service;

import org.example.exception.NotFoundException;
import org.example.repository.entity.Tag;
import org.example.repository.impl.TagDaoImpl;
import org.example.service.dto.TagDto;
import org.example.service.mapper.TagMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {
    private final TagMapperImpl tagMapper;
    private final TagDaoImpl tagDao;

    @Autowired
    public TagServiceImpl(TagMapperImpl tagMapper, TagDaoImpl tagDao) {
        this.tagMapper = tagMapper;
        this.tagDao = tagDao;
    }


    @Override
    public List<TagDto> findAll() {
        return tagDao.findAll().stream()
                .map(tagMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TagDto findById(Integer id) {
        if (tagDao.findById(id).isPresent()) {
            return tagMapper.mapEntityToDto(tagDao.findById(id).get());
        } else {
            throw new NotFoundException("Not found");
        }
    }

    @Override
    public void insert(TagDto tagDto) {
        Tag tag = tagMapper.mapDtoToEntity(tagDto);
        tagDao.save(tag);
    }

    @Override
    public void deleteById(Integer id) {
        tagDao.deleteById(id);
    }
}
