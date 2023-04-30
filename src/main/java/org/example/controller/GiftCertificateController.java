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

    @GetMapping("/{tagName}/page/{pageNumber}/items/{items}")
    public List<GiftCertificateDto> findByTagName(@PathVariable String tagName, @PathVariable String pageNumber, @PathVariable String items) {
        return giftCertificateService.findByTadName(tagName,pageNumber,items);
    }

    @GetMapping("/{id}")
    public GiftCertificateDto findById(@PathVariable Integer id) {
        return giftCertificateService.findById(id);
    }

    @PostMapping("/")
    @ResponseBody
    public void save(@RequestBody GiftCertificateDto giftCertificateDto) {
        giftCertificateService.insert(giftCertificateDto);
    }

    @PutMapping("/{id}")
    public GiftCertificateDto update(@PathVariable Integer id, @RequestBody GiftCertificateDto giftCertificateDto) {
        return giftCertificateService.update(id, giftCertificateDto);
    }

}
