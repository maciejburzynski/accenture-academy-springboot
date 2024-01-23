package com.accenture.academy.church;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ChurchServiceTest {

    @Mock
    ChurchRepository churchRepository;
    @InjectMocks
    ChurchService churchService;

    @Test
    void testGetAllChurches() {
        // given
        ChurchDao churchDao = new ChurchDao(
                "Kościół św. Krzyża",
                "Warszawa",
                150,
                50000,
                20000.00);

        ChurchDao churchDao1 = new ChurchDao(
                "Kościół św. Stanisława",
                "Łódź",
                250,
                10000,
                10000.00);

        Mockito.when(churchRepository.findAll()).thenReturn(List.of(churchDao, churchDao1));

        // when + then
        assertEquals(List.of(churchDao, churchDao1), churchService.getAllChurches());


        Mockito.verify(churchRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testAddChurch() {
        // given
        ChurchDao churchDao = new ChurchDao(
                "Kościół św. Krzyża",
                "Warszawa",
                150,
                50000,
                20000.00);
        ChurchDao churchDao1 = new ChurchDao(
                "Kościół św. Stanisława",
                "Łódź",
                250,
                10000,
                10000.00);

        // when + then

        churchService.addChurch(churchDao);
        Mockito.verify(churchRepository, Mockito.times(1)).save(churchDao);
        churchService.addChurch(churchDao1);
        Mockito.verify(churchRepository, Mockito.times(1)).save(churchDao);
    }

    @Test
    void testGetChurchByIdHappy() {
        // given
        ChurchDao churchDao = new ChurchDao(
                "Kościół św. Krzyża",
                "Warszawa",
                150,
                50000,
                20000.00);
        // when + then
        Mockito.when(churchRepository.findById(any())).thenReturn(Optional.of(churchDao));
        Assertions.assertEquals(churchDao, churchService.getChurchById(any()));
        
    }

    @Test
    void testGetChurchByIdException() {
        Mockito.when(churchRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(ChurchNotFoundException.class, () -> churchService.getChurchById(any()));
    }


}