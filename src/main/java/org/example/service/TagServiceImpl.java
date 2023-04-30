package org.example.service;

import org.example.exception.NotFoundException;
import org.example.repository.entity.Tag;
import org.example.repository.impl.TagDaoImpl;
import org.example.service.dto.TagDto;
import org.example.service.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {
    private final TagDaoImpl tagDao;

    @Autowired
    public TagServiceImpl(TagDaoImpl tagDao) {
        this.tagDao = tagDao;
    }


    @Override
    public List<TagDto> findAll() {
        return tagDao.findAll().stream()
                .map(TagMapper.INSTANCE::entityToDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public TagDto findById(Integer id) {
        if (tagDao.findById(id).isPresent()) {
            Tag tag = tagDao.findById(id).get();
            return TagMapper.INSTANCE.entityToDtoMapper(tag);
        } else {
            throw new NotFoundException("Tag resource not found (id = " + id + ")");
        }
    }

    @Override
    public void insert(TagDto tagDto) {
        Tag tag = TagMapper.INSTANCE.dtoToEntityMapper(tagDto);
        tagDao.save(tag);
    }

    @Override
    public void deleteById(Integer id) {
        tagDao.deleteById(id);
    }
}
