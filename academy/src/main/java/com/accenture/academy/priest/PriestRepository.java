package com.accenture.academy.priest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class PriestRepository {

    private final IPriestRepository iPriestRepository;

    public Optional<PriestDao> findById(Long id) {
        return iPriestRepository.findById(id);
    }

    public void save(PriestDao priestDao) {
        iPriestRepository.save(priestDao);
    }
}
