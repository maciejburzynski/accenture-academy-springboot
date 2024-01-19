package com.accenture.academy.priest;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRIEST")
public class PriestDao {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    String name;
    Integer heightInCm;
    Integer age;

    public PriestDao(String name, Integer heightInCm, Integer age) {
        this.name = name;
        this.heightInCm = heightInCm;
        this.age = age;
    }
}
