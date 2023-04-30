package org.example.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GiftCertificateDto {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer duration;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdateDate;
}
