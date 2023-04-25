package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DataController {
//    private final TagServiceImpl tagService;
//
//    @Autowired
//    public DataController(TagServiceImpl tagService) {
//        this.tagService = tagService;
//    }
//
//    @GetMapping(value = "/json")
//    @ResponseBody
//    public List<TagDto> json() {
//        tagService.insertData();
//        TagDto name = TagDto.builder()
//                .id(10)
//                .name("Name")
//                .build();
//        return List.of(TagDto.builder()
//                .id(10)
//                .name("Name")
//                .build(), TagDto.builder()
//                .id(11)
//                .name("Certificate")
//                .build());
//    }
}
