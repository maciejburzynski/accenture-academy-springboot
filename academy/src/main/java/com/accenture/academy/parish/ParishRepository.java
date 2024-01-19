package com.accenture.academy.parish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParishRepository {

    private final IParishRepository iParishRepository;

    public List<ParishDao> findAll() {
        return iParishRepository.findAll();
    }
}
