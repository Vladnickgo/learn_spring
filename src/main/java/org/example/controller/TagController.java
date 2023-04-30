package org.example.controller;

import org.example.service.TagServiceImpl;
import org.example.service.dto.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagServiceImpl tagService;

    @Autowired
    public TagController(TagServiceImpl tagService) {
        this.tagService = tagService;
    }


    @GetMapping(value = "/")
    @ResponseBody
    public List<TagDto> findAll() {
        return tagService.findAll();
    }

    @GetMapping(value = "/{id}")
    public TagDto findById(@PathVariable("id") Integer id) {
        return tagService.findById(id);
    }

    @PostMapping("/")
    @ResponseBody
    public void save(@RequestBody TagDto tagDto) {
        tagService.insert(tagDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Integer id) {
        tagService.deleteById(id);
    }


}
