package org.example.service;

import org.example.service.dto.GiftCertificateDto;

import java.util.List;

public interface GiftCertificateService {
    List<GiftCertificateDto> findAll();

    GiftCertificateDto findById(Integer id);

    void insert(GiftCertificateDto giftCertificateDto);

    GiftCertificateDto update(Integer id, GiftCertificateDto giftCertificateDto);

    void deleteById(Integer id);

    List<GiftCertificateDto> findByTagName(String tagName, String pageNumber, String items);

    List<GiftCertificateDto> findByName(String name);

    List<GiftCertificateDto> findByDescription(String description);

    List<GiftCertificateDto> paginatedFindByNameSortedByNameAndDate(String name, int page, int items, String sortedByName, String sortedByDate);

    List<GiftCertificateDto> paginatedFindByDescriptionSortedByNameAndDate(String description, int page, int items, String sortedByName, String sortedByDate);
}
