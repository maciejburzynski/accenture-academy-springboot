package com.accenture.academy;


import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.parish.ParishDao;
import com.accenture.academy.parish.ParishService;
import com.accenture.academy.priest.PriestDao;
import com.accenture.academy.priest.PriestService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final PriestService priestService;
    private final ParishService parishService;

    @PostConstruct
    void initData() {
//        PriestDao priestDao = new PriestDao(
//                "Andrzej",
//                170,
//                40
//        );
//        PriestDao priestDao1 = new PriestDao(
//                "Karol",
//                175,
//                35
//        );
//        PriestDao priestDao2 = new PriestDao(
//                "Igor",
//                160,
//                60
//        );
//
//        priestService.addPriest(priestDao);
//        priestService.addPriest(priestDao1);
//        priestService.addPriest(priestDao2);


        ParishDao parishDao = new ParishDao(
                new PriestDao("Jerzy", 160, 65),
                new ChurchDao(
                        "Kościół św. Jakuba",
                        "Skierniewice",
                        80,
                        50000,
                        240.00),
                Set.of(new MemberDao("Marcin", "NieMarcin", "28-06-1993"),
                        new MemberDao("Maciej", "NieMaciej", "28-06-1993")));

        parishService.addParish(parishDao);
    }

}
