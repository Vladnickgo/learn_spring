package org.example.service;

import org.example.exception.NotFoundException;
import org.example.repository.impl.GiftCertificateDaoImpl;
import org.example.service.dto.GiftCertificateDto;
import org.example.service.mapper.GiftCertificateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {
    private final GiftCertificateDaoImpl giftCertificateDao;
    private final GiftCertificateMapper giftCertificateMapper;

    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDaoImpl giftCertificateDao, GiftCertificateMapper giftCertificateMapper) {
        this.giftCertificateDao = giftCertificateDao;
        this.giftCertificateMapper = giftCertificateMapper;
    }

    @Override
    public List<GiftCertificateDto> findAll() {
        return giftCertificateDao.findAll().stream()
                .map(giftCertificateMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GiftCertificateDto findById(Integer id) {
        if (giftCertificateDao.findById(id).isPresent()) {
            return giftCertificateMapper.mapEntityToDto(giftCertificateDao.findById(id).get());
        } else {
            throw new NotFoundException("GiftCertificate resource not found (id = " + id + ")");
        }
    }

    @Override
    public GiftCertificateDto insert(GiftCertificateDto giftCertificateDto) {
        return null;
    }

    @Override
    public GiftCertificateDto update(Integer id, GiftCertificateDto giftCertificateDto) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
