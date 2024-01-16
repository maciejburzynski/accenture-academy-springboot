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

    void addChurch(ChurchDao churchDao) {
        churchRepository.save(churchDao);
    }

    void addChurch(ChurchDto churchDto) {
        churchRepository.save(ChurchMapper.mapDtoToDao(churchDto));
    }

    ChurchDao getChurchById(Long id) {
        return churchRepository
                .findById(id)
                .orElseThrow(() -> new ChurchNotFoundException("Church with id " + id + " not found"));
    }

    public void update(ChurchDto churchDto, Long id) {
        churchRepository.save(ChurchMapper.mapDtoToDao(churchDto, id));
    }

    public void deleteById(Long id) {
        churchRepository.deleteById(id);
    }
}
