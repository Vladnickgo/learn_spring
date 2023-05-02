package org.example.service;

import org.example.exception.NotFoundException;
import org.example.repository.entity.GiftCertificate;
import org.example.repository.impl.GiftCertificateDaoImpl;
import org.example.service.dto.GiftCertificateDto;
import org.example.service.mapper.GiftCertificateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {
    private final GiftCertificateDaoImpl giftCertificateDao;

    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDaoImpl giftCertificateDao) {
        this.giftCertificateDao = giftCertificateDao;
    }

    @Override
    public List<GiftCertificateDto> findAll() {
        return giftCertificateDao.findAll().stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GiftCertificateDto findById(Integer id) {
        if (giftCertificateDao.findById(id).isPresent()) {
            GiftCertificate giftCertificate = giftCertificateDao.findById(id).get();
            return GiftCertificateMapper.INSTANCE.mapEntityToDto(giftCertificate);
        } else {
            throw new NotFoundException("GiftCertificate resource not found (id = " + id + ")");
        }
    }

    @Override
    public void insert(GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = GiftCertificateMapper.INSTANCE.mapDtoToEntity(giftCertificateDto);
        giftCertificateDao.save(giftCertificate);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public GiftCertificateDto update(Integer id, GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = GiftCertificateMapper.INSTANCE.mapDtoToEntity(giftCertificateDto);
        giftCertificateDao.update(id, giftCertificate);
        return findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        giftCertificateDao.deleteById(id);
    }

    @Override
    public List<GiftCertificateDto> findByTagName(String tagName, String stringPageNumber, String stringItems) {
        int items = Integer.parseInt(stringItems);
        int pageNumber = Integer.parseInt(stringPageNumber);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.findByTagName(tagName, offSet, items).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> findByName(String name) {
        return giftCertificateDao.findByName(name).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> findByDescription(String description) {
        return giftCertificateDao.findByDescription(description).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> paginatedFindByDescription(String description, String stringPage, String stringItems) {
        int pageNumber = Integer.parseInt(stringPage);
        int items = Integer.parseInt(stringItems);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.paginatedFindByDescription(description, items, offSet).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> paginatedFindByNameSortedByNameAndDate(String name, String stringPage, String stringItems, String sortedByName, String sortedByDate) {
        int pageNumber = Integer.parseInt(stringPage);
        int items = Integer.parseInt(stringItems);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.paginatedFindByNameSortedByNameAndDate(name, items, offSet, sortedByName, sortedByDate).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<GiftCertificateDto> paginatedFindByNameSortedByDate(String name, String stringPage, String stringItems, String sortedByDate) {
        int pageNumber = Integer.parseInt(stringPage);
        int items = Integer.parseInt(stringItems);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.paginatedFindByNameSortedByDate(name, items, offSet, sortedByDate).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> paginatedFindByNameSortedByName(String name, String stringPage, String stringItems, String sortedByName) {
        int pageNumber = Integer.parseInt(stringPage);
        int items = Integer.parseInt(stringItems);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.paginatedFindByNameSortedByName(name, items, offSet, sortedByName).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> paginatedFindByName(String name,
                                                        String stringPage,
                                                        String stringItems) {
        int pageNumber = Integer.parseInt(stringPage);
        int items = Integer.parseInt(stringItems);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.paginatedFindByName(name, items, offSet).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> paginatedFindByDescriptionSortedByNameAndDate(String description, String stringPage, String stringItems, String sortedByName, String sortedByDate) {
        int pageNumber = Integer.parseInt(stringPage);
        int items = Integer.parseInt(stringItems);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.paginatedFindByDescriptionSortedByNameAndDate(description, items, offSet, sortedByName, sortedByDate).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> paginatedFindByDescriptionSortedByDate(String description, String stringPage, String stringItems, String sortedByDate) {
        int pageNumber = Integer.parseInt(stringPage);
        int items = Integer.parseInt(stringItems);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.paginatedFindByDescriptionSortedByDate(description, items, offSet, sortedByDate).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> paginatedFindByDescriptionSortedByName(String description, String stringPage, String stringItems, String sortedByName) {
        int pageNumber = Integer.parseInt(stringPage);
        int items = Integer.parseInt(stringItems);
        Integer offSet = items * (pageNumber - 1);
        return giftCertificateDao.paginatedFindByDescriptionSortedByName(description, items, offSet, sortedByName).stream()
                .map(GiftCertificateMapper.INSTANCE::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
