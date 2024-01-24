package com.accenture.academy.priest;


class PriestMapper {

    static PriestDao mapDtoToDao(PriestDto priestDto) {
        return new PriestDao(priestDto.getName(), priestDto.getHeight(), priestDto.getAge());
    }
}
