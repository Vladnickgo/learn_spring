package org.example.service;

import org.example.exception.NotFoundException;
import org.example.repository.entity.GiftCertificate;
import org.example.repository.impl.GiftCertificateDaoImpl;
import org.example.service.dto.GiftCertificateDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GiftCertificateServiceImplTest {

    private static final List<GiftCertificate> ENTITY_LIST = new ArrayList<>(List.of(
            GiftCertificate.builder()
                    .id(1)
                    .name("Alpha")
                    .price(19)
                    .description("Crete")
                    .duration(54)
                    .createDate(LocalDate.of(2021, 7, 16))
                    .lastUpdateDate(LocalDate.of(2025, 8, 1))
                    .build(),
            GiftCertificate.builder()
                    .id(2)
                    .name("Beta")
                    .price(45)
                    .description("Prime")
                    .duration(61)
                    .createDate(LocalDate.of(2021, 4, 15))
                    .lastUpdateDate(LocalDate.of(2025, 12, 15))
                    .build(),
            GiftCertificate.builder()
                    .id(3)
                    .name("Gamma")
                    .price(10)
                    .description("Jupiter")
                    .duration(52)
                    .createDate(LocalDate.of(2022, 5, 10))
                    .lastUpdateDate(LocalDate.of(2024, 6, 1))
                    .build()));
    private static final List<GiftCertificateDto> EXPECTED_GIFT_CERTIFICATE_DTO_LIST = new ArrayList<>(List.of(
            GiftCertificateDto.builder()
                    .id(1)
                    .name("Alpha")
                    .price(19)
                    .description("Crete")
                    .duration(54)
                    .createDate(LocalDate.of(2021, 7, 16))
                    .lastUpdateDate(LocalDate.of(2025, 8, 1))
                    .build(),
            GiftCertificateDto.builder()
                    .id(2)
                    .name("Beta")
                    .price(45)
                    .description("Prime")
                    .duration(61)
                    .createDate(LocalDate.of(2021, 4, 15))
                    .lastUpdateDate(LocalDate.of(2025, 12, 15))
                    .build(),
            GiftCertificateDto.builder()
                    .id(3)
                    .name("Gamma")
                    .price(10)
                    .description("Jupiter")
                    .duration(52)
                    .createDate(LocalDate.of(2022, 5, 10))
                    .lastUpdateDate(LocalDate.of(2024, 6, 1))
                    .build()));
    private static final Optional<GiftCertificate> TEST_ENTITY = Optional.of(
            GiftCertificate.builder()
                    .id(1)
                    .name("Alpha")
                    .price(19)
                    .description("Crete")
                    .duration(54)
                    .createDate(LocalDate.of(2021, 7, 16))
                    .lastUpdateDate(LocalDate.of(2025, 8, 1))
                    .build());
    private static final GiftCertificateDto EXPECTED_GIFT_CERTIFICATE_DTO =
            GiftCertificateDto.builder()
                    .id(1)
                    .name("Alpha")
                    .price(19)
                    .description("Crete")
                    .duration(54)
                    .createDate(LocalDate.of(2021, 7, 16))
                    .lastUpdateDate(LocalDate.of(2025, 8, 1))
                    .build();
    @Mock
    private GiftCertificateDaoImpl giftCertificateDao;
    @InjectMocks
    private GiftCertificateServiceImpl giftCertificateService;

    @Test
    void findAll() {
        when(giftCertificateDao.findAll()).thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.findAll();
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void findByIdTestForSuccess() {
        when(giftCertificateDao.findById(1)).thenReturn(TEST_ENTITY);
        GiftCertificateDto actual = giftCertificateService.findById(1);
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO, actual);
    }

    @Test
    void findByIdTestForNotFoundException() {
        String expectedExceptionMessage = "GiftCertificate resource not found (id = 1)";
        when(giftCertificateDao.findById(1)).thenReturn(Optional.empty());
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> giftCertificateService.findById(1));
        String actual = exception.getMessage();
        Assertions.assertEquals(expectedExceptionMessage, actual);
    }

    @Test
    void findByTagNameTest() {
        when(giftCertificateDao.findByTagName("a", 0, 3)).thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.findByTagName("a", "1", "3");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void findByNameTest() {
        when(giftCertificateDao.findByName("name")).thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.findByName("name");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void paginatedFindByNameSortedByNameAndDateTest() {
        when(giftCertificateDao.paginatedFindByNameSortedByNameAndDate("name", 3, 0, "ASC", "ASC"))
                .thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.paginatedFindByNameSortedByNameAndDate("name", "1", "3", "ASC", "ASC");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void paginatedFindByNameSortedByNameTest() {
        when(giftCertificateDao.paginatedFindByNameSortedByName("name", 3, 0, "ASC"))
                .thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.paginatedFindByNameSortedByName("name", "1", "3", "ASC");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void paginatedFindByNameSortedByDateTest() {
        when(giftCertificateDao.paginatedFindByNameSortedByDate("name", 3, 0, "ASC"))
                .thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.paginatedFindByNameSortedByDate("name", "1", "3", "ASC");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void paginatedFindByNameTest() {
        when(giftCertificateDao.paginatedFindByName("name", 3, 0))
                .thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.paginatedFindByName("name", "1", "3");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void findByDescription() {
        when(giftCertificateDao.findByDescription("description")).thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.findByDescription("description");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void paginatedFindByDescriptionTest() {
        when(giftCertificateDao.paginatedFindByDescription("description", 3, 0)).thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.paginatedFindByDescription("description", "1", "3");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void paginatedFindByDescriptionSortedByNameAndDate() {
        when(giftCertificateDao.paginatedFindByDescriptionSortedByNameAndDate("description", 3, 0, "ASC", "ASC")).thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.paginatedFindByDescriptionSortedByNameAndDate("description", "1", "3", "ASC", "ASC");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void paginatedFindByDescriptionSortedByDate() {
        when(giftCertificateDao.paginatedFindByDescriptionSortedByDate("description", 3, 0, "ASC")).thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.paginatedFindByDescriptionSortedByDate("description", "1", "3", "ASC");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }

    @Test
    void paginatedFindByDescriptionSortedByName() {
        when(giftCertificateDao.paginatedFindByDescriptionSortedByName("description", 3, 0, "ASC")).thenReturn(ENTITY_LIST);
        List<GiftCertificateDto> actual = giftCertificateService.paginatedFindByDescriptionSortedByName("description", "1", "3", "ASC");
        Assertions.assertEquals(EXPECTED_GIFT_CERTIFICATE_DTO_LIST, actual);
    }
}