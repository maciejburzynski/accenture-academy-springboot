package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.priest.PriestDao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

import static jakarta.persistence.CascadeType.*;

@Entity
@Data
@Table(name = "PARISH")
@NoArgsConstructor
public class ParishDao {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = ALL)
    private PriestDao priestDao;
    @OneToOne(cascade = ALL)
    private ChurchDao churchDao;
    @OneToMany(cascade = ALL)
    @JoinColumn(name = "PARISH_ID")
    private Set<MemberDao> members;

    public ParishDao(PriestDao priestDao, ChurchDao churchDao, Set<MemberDao> members) {
        this.priestDao = priestDao;
        this.churchDao = churchDao;
        this.members = members;
    }
}
