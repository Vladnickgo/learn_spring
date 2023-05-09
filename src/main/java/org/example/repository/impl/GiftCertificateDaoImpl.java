package org.example.repository.impl;

import org.example.repository.CrudDao;
import org.example.repository.entity.GiftCertificate;
import org.example.repository.mapper.GiftCertificateRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository
public class GiftCertificateDaoImpl implements CrudDao<GiftCertificate, Integer> {
    private static final String FIND_ALL = "SELECT * FROM gift_certificate";
    private static final String FIND_BY_ID = "SELECT * FROM gift_certificate WHERE id=?";
    private static final String SAVE = "INSERT INTO gift_certificate(name, price, description, duration, create_date, last_update_date) " +
            "VALUES (?, ?, ?, ?, ?, ?);";

    private static final String FIND_BY_TAG_NAME = "SELECT * " +
            "FROM gift_certificate " +
            "         left join gift_certificate_tag gct on gift_certificate.id = gct.gift_certificate_id " +
            "         left join tag t on t.id = gct.tag_id " +
            "WHERE t.name = ? " +
            "ORDER BY create_date " +
            "LIMIT ? OFFSET ?;";


    private static final String UPDATE = "UPDATE gift_certificate " +
            "SET name=?, price=?, description=?, duration=?, create_date=?, last_update_date=? " +
            "WHERE id=? ";
    private static final String FIND_BY_NAME = "SELECT * FROM gift_certificate WHERE name LIKE CONCAT('%',?,'%'); ";
    private static final String FIND_BY_DESCRIPTION = "SELECT * FROM gift_certificate WHERE description " +
            "LIKE CONCAT('%',?,'%'); ";
    private static final String FIND_BY_DESCRIPTION_PAGE_AND_ITEMS = "SELECT * FROM gift_certificate WHERE description " +
            "LIKE CONCAT('%',?,'%') LIMIT ? OFFSET ?; ";
    private static final String FIND_BY_NAME_PAGE_AND_ITEMS = "SELECT * FROM gift_certificate WHERE name " +
            "LIKE CONCAT('%',?,'%') LIMIT ? OFFSET ?; ";
    private static final String DELETE_BY_ID = "DELETE FROM gift_certificate WHERE id=?; ";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GiftCertificateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(GiftCertificate entity) {

        jdbcTemplate.update(SAVE, ps -> mapForInsertStatement(entity, ps));
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
    public void update(Integer id, GiftCertificate entity) {
        jdbcTemplate.update(UPDATE, ps -> {
            mapForInsertStatement(entity, ps);
            ps.setInt(7, id);
        });
    }

    private static void mapForInsertStatement(GiftCertificate entity, PreparedStatement ps) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setInt(2, entity.getPrice());
        ps.setString(3, entity.getDescription());
        ps.setInt(4, entity.getDuration());
        ps.setDate(5, Date.valueOf(entity.getCreateDate()));
        ps.setDate(6, Date.valueOf(entity.getLastUpdateDate()));
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }

    public List<GiftCertificate> findByTagName(String tagName, Integer pageNumber, Integer offSet) {
        return getGiftCertificates(tagName, pageNumber, offSet, FIND_BY_TAG_NAME);
    }

    public List<GiftCertificate> findByName(String name) {
        return getGiftCertificates(name, FIND_BY_NAME);
    }

    public List<GiftCertificate> findByDescription(String description) {
        return getGiftCertificates(description, FIND_BY_DESCRIPTION);
    }

    private List<GiftCertificate> getGiftCertificates(String parameter, String query) {
        return jdbcTemplate.query(query, ps -> ps.setString(1, parameter), (rs, rowNum) -> GiftCertificate.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .price(rs.getInt("price"))
                .description(rs.getString("description"))
                .duration(rs.getInt("duration"))
                .createDate(rs.getDate("create_date").toLocalDate())
                .lastUpdateDate(rs.getDate("last_update_date").toLocalDate())
                .build()
        );
    }

    private List<GiftCertificate> getGiftCertificates(String parameter, Integer numberOfItems, Integer offSet, String findByPageAndItems) {
        return jdbcTemplate.query(findByPageAndItems, ps -> {
                    ps.setString(1, parameter);
                    ps.setInt(2, numberOfItems);
                    ps.setInt(3, offSet);
                }, (rs, rowNum) -> GiftCertificate.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .price(rs.getInt("price"))
                        .description(rs.getString("description"))
                        .duration(rs.getInt("duration"))
                        .createDate(rs.getDate("create_date").toLocalDate())
                        .lastUpdateDate(rs.getDate("last_update_date").toLocalDate())
                        .build()
        );
    }

    public List<GiftCertificate> paginatedFindByNameSortedByNameAndDate(String name, Integer numberOfItems, Integer offSet, String sortedByName, String sortedByDate) {
        String query = "SELECT * FROM gift_certificate WHERE name LIKE CONCAT('%',?,'%') ORDER BY name " + sortedByName +
                ", create_date " + sortedByDate + " LIMIT ? OFFSET ? ; ";
        return getGiftCertificates(name, numberOfItems, offSet, query);
    }

    public List<GiftCertificate> paginatedFindByDescriptionSortedByNameAndDate(String description, Integer numberOfItems, Integer offSet, String sortedByName, String sortedByDate) {
        String query = "SELECT * FROM gift_certificate WHERE description LIKE CONCAT('%',?,'%') ORDER BY name " +
                sortedByName + ", create_date " + sortedByDate + " LIMIT ? OFFSET ? ; ";
        return getGiftCertificates(description, numberOfItems, offSet, query);
    }

}
