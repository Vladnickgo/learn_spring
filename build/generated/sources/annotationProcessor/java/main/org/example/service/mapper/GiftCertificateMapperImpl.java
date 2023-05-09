package org.example.service.mapper;

import javax.annotation.processing.Generated;
import org.example.repository.entity.GiftCertificate;
import org.example.service.dto.GiftCertificateDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T19:53:46+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class GiftCertificateMapperImpl implements GiftCertificateMapper {

    @Override
    public GiftCertificate mapDtoToEntity(GiftCertificateDto giftCertificateDto) {
        if ( giftCertificateDto == null ) {
            return null;
        }

        GiftCertificate.GiftCertificateBuilder giftCertificate = GiftCertificate.builder();

        giftCertificate.id( giftCertificateDto.getId() );
        giftCertificate.name( giftCertificateDto.getName() );
        giftCertificate.description( giftCertificateDto.getDescription() );
        giftCertificate.price( giftCertificateDto.getPrice() );
        giftCertificate.duration( giftCertificateDto.getDuration() );
        giftCertificate.createDate( giftCertificateDto.getCreateDate() );
        giftCertificate.lastUpdateDate( giftCertificateDto.getLastUpdateDate() );

        return giftCertificate.build();
    }

    @Override
    public GiftCertificateDto mapEntityToDto(GiftCertificate giftCertificate) {
        if ( giftCertificate == null ) {
            return null;
        }

        GiftCertificateDto.GiftCertificateDtoBuilder giftCertificateDto = GiftCertificateDto.builder();

        giftCertificateDto.id( giftCertificate.getId() );
        giftCertificateDto.name( giftCertificate.getName() );
        giftCertificateDto.description( giftCertificate.getDescription() );
        giftCertificateDto.price( giftCertificate.getPrice() );
        giftCertificateDto.duration( giftCertificate.getDuration() );
        giftCertificateDto.createDate( giftCertificate.getCreateDate() );
        giftCertificateDto.lastUpdateDate( giftCertificate.getLastUpdateDate() );

        return giftCertificateDto.build();
    }
}
