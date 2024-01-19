package com.accenture.academy.parish;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IParishRepository extends JpaRepository<ParishDao, Long> {
}
