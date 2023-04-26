package org.example.repository.impl;

import org.example.repository.CrudDao;
import org.example.repository.entity.Tag;
import org.example.repository.mapper.TagRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TagDaoImpl implements CrudDao<Tag, Integer> {
    private static final String FIND_ALL_QUERY = "SELECT * FROM tag";
    private static final String FIND_BY_ID = "SELECT * FROM tag WHERE id = ?";
    private static final String SAVE = "INSERT INTO tag(name) VALUES (?)";
    private static final String DELETE_BY_ID = "DELETE FROM tag WHERE id=?;";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TagDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Tag entity) {
        jdbcTemplate.update(SAVE, entity.getName());
    }

    @Override
    public Optional<Tag> findById(Integer id) {
        try {
            Tag tag = jdbcTemplate.queryForObject(FIND_BY_ID, new Object[]{id}, new TagRowMapper());
            return Optional.ofNullable(tag);
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }

    }

    @Override
    public List<Tag> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, (rs, rowNum) -> Tag.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build());
    }

    @Override
    public void update(Tag entity) {

    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }


}
