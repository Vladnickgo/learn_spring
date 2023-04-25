package org.example.service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GiftCertificateDto {
    private final Integer id;
    private final String name;
    private final String description;
    private final Integer price;
    private final Integer duration;
    private final LocalDate createDate;
    private final LocalDate lastUpdateDate;
}
