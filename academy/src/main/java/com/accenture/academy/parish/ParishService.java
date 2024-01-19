package com.accenture.academy.parish;

import com.accenture.academy.priest.PriestDao;
import com.accenture.academy.priest.PriestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParishService {

    private final ParishRepository parishRepository;
    private final PriestService priestService;

    public List<ParishDao> getAllParishes() {
        return parishRepository.findAll();
    }


    void assignPriestToParish(PriestAssignmentDto priestAssignmentDto, Long parishId) {
        PriestDao priestDao = priestService.getPriestById(priestAssignmentDto.getPriestId());

        ParishDao parishDao = getById(parishId);
        parishDao.setPriestDao(priestDao);
        parishRepository.save(parishDao);
    }

    public void addParish(ParishDto parishDto) {
        ParishMapper parishMapper = new ParishMapper();
        ParishDao parishDao = parishMapper.mapDtoToDao(parishDto);
        parishRepository.save(parishDao);
    }
    public void addParish(ParishDao parishDao) {
        parishRepository.save(parishDao);
    }

    public ParishDao getById(Long id) {
        return parishRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Parish with id " + id + " does not exist"));
    }
}
