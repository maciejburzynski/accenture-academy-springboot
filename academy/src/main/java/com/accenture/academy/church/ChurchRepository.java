package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChurchRepository {

    private final IChurchRepository iChurchRepository;

    public List<ChurchDao> findAll() {
        return iChurchRepository.findAll();
    }

    public void save(ChurchDao churchDao) {
        iChurchRepository.save(churchDao);
    }
}
