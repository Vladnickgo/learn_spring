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

    @GetMapping(value = {"/name/{name}",
            "/name/{name}/page/{page}/items/{items}/sorted_name/{sortedName}/sorted_date/{sortedDate}",
            "/name/{name}/page/{page}/items/{items}/sorted_date/{sortedDate}/sorted_name/{sortedName}",
            "/name/{name}/page/{page}/items/{items}/sorted_date/{sortedDate}",
            "/name/{name}/page/{page}/items/{items}/sorted_name/{sortedName}",
            "/name/{name}/page/{page}/items/{items}"})
    public List<GiftCertificateDto> findByName(@PathVariable String name,
                                               @PathVariable Optional<String> page,
                                               @PathVariable Optional<String> items,
                                               @PathVariable Optional<String> sortedName,
                                               @PathVariable Optional<String> sortedDate) {
        if (page.isPresent() && items.isPresent() && sortedName.isPresent() && sortedDate.isPresent()) {
            return giftCertificateService.paginatedFindByNameSortedByNameAndDate(name, page.get(), items.get(), sortedName.get(), sortedDate.get());
        }
        if (page.isPresent() && items.isPresent() && sortedDate.isPresent()) {
            return giftCertificateService.paginatedFindByNameSortedByDate(name, page.get(), items.get(), sortedDate.get());
        }
        if (page.isPresent() && items.isPresent() && sortedName.isPresent()) {
            return giftCertificateService.paginatedFindByNameSortedByName(name, page.get(), items.get(), sortedName.get());
        }
        if (page.isPresent() && items.isPresent()) {
            return giftCertificateService.paginatedFindByName(name, page.get(), items.get());
        }
        return giftCertificateService.findByName(name);
    }

    @GetMapping(value = {"/description/{description}",
            "/description/{description}/page/{page}/items/{items}/sorted_name/{sortedName}/sorted_date/{sortedDate}",
            "/description/{description}/page/{page}/items/{items}/sorted_date/{sortedDate}",
            "/description/{description}/page/{page}/items/{items}/sorted_name/{sortedName}",
            "/description/{description}/page/{page}/items/{items}"})
    public List<GiftCertificateDto> findByDescription(@PathVariable String description,
                                                      @PathVariable Optional<String> page,
                                                      @PathVariable Optional<String> items,
                                                      @PathVariable Optional<String> sortedName,
                                                      @PathVariable Optional<String> sortedDate) {
        if (page.isPresent() && items.isPresent() && sortedName.isPresent() && sortedDate.isPresent()) {
            return giftCertificateService.paginatedFindByDescriptionSortedByNameAndDate(description, page.get(), items.get(), sortedName.get(), sortedDate.get());
        }
        if (page.isPresent() && items.isPresent() && sortedDate.isPresent()) {
            return giftCertificateService.paginatedFindByDescriptionSortedByDate(description, page.get(), items.get(), sortedDate.get());
        }
        if (page.isPresent() && items.isPresent() && sortedName.isPresent()) {
            return giftCertificateService.paginatedFindByDescriptionSortedByName(description, page.get(), items.get(), sortedName.get());
        }
        if (page.isPresent() && items.isPresent()) {
            return giftCertificateService.paginatedFindByDescription(description, page.get(), items.get());
        }
        return giftCertificateService.findByDescription(description);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        giftCertificateService.deleteById(id);
    }

}
