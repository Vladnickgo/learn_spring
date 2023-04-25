package org.example.service.mapper;

import org.example.repository.entity.GiftCertificate;
import org.example.service.dto.GiftCertificateDto;

public class GiftCertificateMapper implements EntityMapper<GiftCertificate, GiftCertificateDto> {
    @Override
    public GiftCertificateDto mapEntityToDto(GiftCertificate giftCertificate) {
        if (giftCertificate == null) {
            return null;
        }
        return GiftCertificateDto.builder()
                .id(giftCertificate.getId())
                .name(giftCertificate.getName())
                .price(giftCertificate.getPrice())
                .description(giftCertificate.getDescription())
                .duration(giftCertificate.getDuration())
                .createDate(giftCertificate.getCreateDate())
                .lastUpdateDate(giftCertificate.getLastUpdateDate())
                .build();
    }

    @Override
    public GiftCertificate mapDtoToEntity(GiftCertificateDto giftCertificateDto) {
        if (giftCertificateDto == null) {
            return null;
        }
        return GiftCertificate.builder()
                .id(giftCertificateDto.getId())
                .name(giftCertificateDto.getName())
                .price(giftCertificateDto.getPrice())
                .description(giftCertificateDto.getDescription())
                .duration(giftCertificateDto.getDuration())
                .createDate(giftCertificateDto.getCreateDate())
                .lastUpdateDate(giftCertificateDto.getLastUpdateDate())
                .build();
    }
}
