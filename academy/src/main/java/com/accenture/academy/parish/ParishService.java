package com.accenture.academy.parish;

import com.accenture.academy.priest.PriestDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParishService {

    private final ParishRepository parishRepository;

    public List<ParishDao> getAllParishes() {
        return parishRepository.findAll();
    }


    void assignPriestToParish(PriestDao priestDao, ParishDao parishDao){

    }
}
