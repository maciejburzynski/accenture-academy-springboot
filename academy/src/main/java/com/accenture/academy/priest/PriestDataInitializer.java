package com.accenture.academy.priest;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriestDataInitializer {

    private final PriestService priestService;

    @PostConstruct
    void initPriests() {
        PriestDao priestDao = new PriestDao(
                "Andrzej",
                170,
                40
        );
        PriestDao priestDao1 = new PriestDao(
                "Karol",
                175,
                35
        );
        PriestDao priestDao2 = new PriestDao(
                "Igor",
                160,
                60
        );

        priestService.addPriest(priestDao);
        priestService.addPriest(priestDao1);
        priestService.addPriest(priestDao2);
    }

}
