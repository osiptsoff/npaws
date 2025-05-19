package ru.osiptsoff.npaws.model.schedule;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.Employee;

@Entity
@Table(schema = "schedule", name = "schedule")
@Data
public class Schedule {
    @Id
    @Column(name = "employee_id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "person_id")
    @EqualsAndHashCode.Include
    private Employee employee;

    @OneToMany(mappedBy = "owningSchedule", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    private Set<PeriodicalWorkingDay> periodicalWorkingDays;

    @OneToMany(mappedBy = "owningSchedule")
    private List<IndividualWorkingDay> individualWorkingDays;

    @OneToMany(mappedBy = "owningSchedule")
    private List<VacationPeriod> vacationPeriods;
}
