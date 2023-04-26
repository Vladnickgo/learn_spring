package org.example.repository.impl;

import org.example.repository.CrudDao;
import org.example.repository.entity.GiftCertificate;
import org.example.repository.mapper.GiftCertificateRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class GiftCertificateDaoImpl implements CrudDao<GiftCertificate, Integer> {
    private static final String FIND_ALL = "SELECT * FROM gift_certificate";
    private static final String FIND_BY_ID = "SELECT * FROM gift_certificate WHERE id=?";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GiftCertificateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(GiftCertificate entity) {

    }

    @Override
    public Optional<GiftCertificate> findById(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, new Object[]{id}, new GiftCertificateRowMapper()));
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    @Override
    public List<GiftCertificate> findAll() {
        return jdbcTemplate.query(FIND_ALL, (rs, rowNum) -> GiftCertificate.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .price(rs.getInt("price"))
                .description(rs.getString("description"))
                .duration(rs.getInt("duration"))
                .createDate(rs.getDate("create_date").toLocalDate())
                .lastUpdateDate(rs.getDate("last_update_date").toLocalDate())
                .build());
    }

    @Override
    public void update(GiftCertificate entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
