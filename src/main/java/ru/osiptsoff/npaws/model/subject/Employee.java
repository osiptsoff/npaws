package ru.osiptsoff.npaws.model.subject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.schedule.Schedule;

@Entity
@Table(schema = "subject", name = "employee_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {
    @Column(name = "institution")
    private String institution;

    @Enumerated(EnumType.STRING)
    @Column(name = "education")
    private Education education;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @OneToOne(mappedBy = "employee")
    @EqualsAndHashCode.Exclude
    private Schedule schedule;
}
