package com.accenture.academy.priest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriestService {

    private final PriestRepository priestRepository;


    public PriestDao getPriestById(Long id) {
        return priestRepository
                .findById(id)
                .orElseThrow(()
                        -> new PriestNotFoundException("Priest with id: " + id + " not found"));
    }

    public void addPriest(PriestDao priestDao) {
        priestRepository.save(priestDao);
    }
    public void addPriest(PriestDto priestDto) {
        priestRepository.save(PriestMapper.mapDtoToDao(priestDto));
    }
}
