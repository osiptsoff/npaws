package ru.osiptsoff.npaws.model.subject;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.schedule.Schedule;

@Entity
@Table(schema = "subject", name = "employee")
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {
    @Column(name = "institution")
    private String institution;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_level")
    private Education education;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @OneToOne(mappedBy = "employee")
    @EqualsAndHashCode.Exclude
    private Schedule schedule;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "person_id")
    private List<EmployeeContact> contacts;
}
