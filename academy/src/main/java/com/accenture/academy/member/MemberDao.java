package com.accenture.academy.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "MEMBER")
public class MemberDao {

    @Id
    @GeneratedValue
    private Long Id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

}
