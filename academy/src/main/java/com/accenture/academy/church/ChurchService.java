package com.accenture.academy.church;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ChurchService {

    private final ChurchRepository churchRepository;
    List<ChurchDao> getAllChurches() {
        return churchRepository.findAll();
    }

    void addChurch(ChurchDao churchDao){
        churchRepository.save(churchDao);
    }
}
