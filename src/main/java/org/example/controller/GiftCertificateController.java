package org.example.controller;

import org.example.service.GiftCertificateServiceImpl;
import org.example.service.dto.GiftCertificateDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class GiftCertificateController {
    private final GiftCertificateServiceImpl giftCertificateService;

    public GiftCertificateController(GiftCertificateServiceImpl giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    @GetMapping("/")
    public List<GiftCertificateDto> findAll() {
        return giftCertificateService.findAll();
    }

    @GetMapping("/{id}")
    public GiftCertificateDto findById(@PathVariable Integer id) {
        return giftCertificateService.findById(id);
    }
}
