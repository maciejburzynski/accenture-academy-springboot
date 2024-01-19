package com.accenture.academy.parish;

public class ParishMapper {

    static ParishDao mapDtoToDao(ParishDto parishDto){
        ParishDao parishDao = new ParishDao();
        parishDao.setPriestDao(parishDto.getPriestDao());
        parishDao.setChurchDao(parishDto.getChurchDao());
        parishDao.setMembers(parishDto.getMembers());
        return parishDao;
    }
}
