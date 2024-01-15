package com.accenture.academy.church;

public class ChurchMapper {
    private ChurchMapper() {
    }

    static ChurchDao mapDtoToDao(ChurchDto churchDto) {
        ChurchDao churchDao = new ChurchDao();
        churchDao.setName(churchDto.getName());
        churchDao.setNameOfCity(churchDto.getNameOfCity());
        churchDao.setBudget(churchDto.getBudget());
        churchDao.setNumberOfSeats(churchDto.getNumberOfSeats());
        churchDao.setNumberOfMembers(churchDto.getNumberOfMembers());

        return churchDao;
    }

}
