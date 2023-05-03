package org.example.controller;

import org.example.service.GiftCertificateServiceImpl;
import org.example.service.dto.GiftCertificateDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return giftCertificateService.findByTagName(tagName, pageNumber, items);
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

    @GetMapping("/name/{name}")
    public List<GiftCertificateDto> findByName(@PathVariable String name,
                                               @RequestParam(value = "page", defaultValue = "1", required = false) int page,
                                               @RequestParam(value = "items", defaultValue = "3", required = false) int items,
                                               @RequestParam(value = "sorted_name", defaultValue = "ASC", required = false) String sortedName,
                                               @RequestParam(value = "sorted_date", defaultValue = "ASC", required = false) String sortedDate) {
        return giftCertificateService.paginatedFindByNameSortedByNameAndDate(name, page, items, sortedName, sortedDate);
    }

    @GetMapping("/description/{description}")
    public List<GiftCertificateDto> findByDescription(
            @PathVariable String description,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "items", defaultValue = "3", required = false) int items,
            @RequestParam(value = "sorted_name", defaultValue = "ASC", required = false) String sortedName,
            @RequestParam(value = "sorted_date", defaultValue = "ASC", required = false) String sortedDate

    ) {
        return giftCertificateService.paginatedFindByDescriptionSortedByNameAndDate(description, page, items, sortedName, sortedDate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        giftCertificateService.deleteById(id);
    }

}
