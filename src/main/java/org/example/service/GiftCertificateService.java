package org.example.service;

import org.example.service.dto.GiftCertificateDto;

import java.util.List;

public interface GiftCertificateService {
    List<GiftCertificateDto> findAll();

    GiftCertificateDto findById(Integer id);

    GiftCertificateDto insert(GiftCertificateDto giftCertificateDto);

    GiftCertificateDto update(Integer id, GiftCertificateDto giftCertificateDto);
    void deleteById(Integer id);
}
