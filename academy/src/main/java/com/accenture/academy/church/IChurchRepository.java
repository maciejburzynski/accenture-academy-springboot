package com.accenture.academy.church;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IChurchRepository extends JpaRepository<ChurchDao, Long> {
}
