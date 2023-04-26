package org.example.repository.mapper;

import org.example.repository.entity.GiftCertificate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiftCertificateRowMapper implements RowMapper<GiftCertificate> {
    @Override
    public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return GiftCertificate.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .price(rs.getInt("price"))
                .description(rs.getString("description"))
                .duration(rs.getInt("duration"))
                .createDate(rs.getDate("create_date").toLocalDate())
                .lastUpdateDate(rs.getDate("last_update_date").toLocalDate())
                .build();
    }
}
