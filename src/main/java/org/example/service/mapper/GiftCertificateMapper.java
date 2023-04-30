package org.example.service.mapper;

import org.example.repository.entity.GiftCertificate;
import org.example.service.dto.GiftCertificateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GiftCertificateMapper {
    GiftCertificateMapper INSTANCE = Mappers.getMapper(GiftCertificateMapper.class);

    GiftCertificate mapDtoToEntity(GiftCertificateDto giftCertificateDto);

    GiftCertificateDto mapEntityToDto(GiftCertificate giftCertificate);
}
