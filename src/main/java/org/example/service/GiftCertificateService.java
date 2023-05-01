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

    List<GiftCertificateDto> paginatedFindByDescription(String description, String page, String items);

    List<GiftCertificateDto> paginatedFindByNameSortedByNameAndDate(String name, String page, String items, String sortedByName, String sortedByDate);

    List<GiftCertificateDto> paginatedFindByNameSortedByDate(String name, String page, String items, String sortedByDate);

    List<GiftCertificateDto> paginatedFindByNameSortedByName(String name, String page, String items, String sortedByName);

    List<GiftCertificateDto> paginatedFindByName(String name, String page, String items);

    List<GiftCertificateDto> paginatedFindByDescriptionSortedByNameAndDate(String description, String page, String items, String sortedByName, String sortedByDate);

    List<GiftCertificateDto> paginatedFindByDescriptionSortedByDate(String description, String page, String items, String sortedByDate);

    List<GiftCertificateDto> paginatedFindByDescriptionSortedByName(String description, String page, String items, String sortedByName);
}
