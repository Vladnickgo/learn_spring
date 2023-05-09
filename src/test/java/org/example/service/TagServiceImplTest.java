package org.example.service;

import org.example.exception.NotFoundException;
import org.example.repository.entity.Tag;
import org.example.repository.impl.TagDaoImpl;
import org.example.service.dto.TagDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {
    private static final List<Tag> ENTITY_LIST = new ArrayList<>(List.of(
            Tag.builder()
                    .id(1)
                    .name("Alpha")
                    .build(),
            Tag.builder()
                    .id(2)
                    .name("Beta")
                    .build(),
            Tag.builder()
                    .id(3)
                    .name("Gamma")
                    .build()));

    private static final List<TagDto> EXPECTED_TAG_DTO_LIST = new ArrayList<>(List.of(
            TagDto.builder()
                    .id(1)
                    .name("Alpha")
                    .build(),
            TagDto.builder()
                    .id(2)
                    .name("Beta")
                    .build(),
            TagDto.builder()
                    .id(3)
                    .name("Gamma")
                    .build()));
    private static final Optional<Tag> TEST_ENTITY = Optional.of(Tag.builder()
            .id(1)
            .name("Alpha")
            .build());
    private static final TagDto EXPECTED_TAG_DTO = TagDto.builder()
            .id(1)
            .name("Alpha")
            .build();

    @Mock
    private TagDaoImpl tagDaoImpl;
    @InjectMocks
    private TagServiceImpl tagService;

    @Test
    void testFindAll() {
        when(tagDaoImpl.findAll()).thenReturn(ENTITY_LIST);
        List<TagDto> actual = tagService.findAll();
        Assertions.assertEquals(EXPECTED_TAG_DTO_LIST, actual);
    }

    @Test
    void findByIdIfPresent() {
        when(tagDaoImpl.findById(1)).thenReturn(TEST_ENTITY);
        TagDto actual = tagService.findById(1);
        Assertions.assertEquals(EXPECTED_TAG_DTO, actual);
    }

    @Test
    void findByIdIfEmpty() {
        String expectedExceptionMessage = "Tag resource not found (id = 5)";
        when(tagDaoImpl.findById(5)).thenReturn(Optional.empty());
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> tagService.findById(5));
        Assertions.assertEquals(expectedExceptionMessage, exception.getMessage());
    }

}