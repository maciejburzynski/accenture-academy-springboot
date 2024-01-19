package com.accenture.academy.parish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ParishRepository {

    private final IParishRepository iParishRepository;

    public List<ParishDao> findAll() {
        return iParishRepository.findAll();
    }

    public void save(ParishDao parishDao) {
        iParishRepository.save(parishDao);
    }

    public Optional<ParishDao> findById(Long id) {
        return iParishRepository.findById(id);
    }
}
