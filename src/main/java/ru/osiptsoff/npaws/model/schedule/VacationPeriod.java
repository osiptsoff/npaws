package ru.osiptsoff.npaws.model.schedule;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "schedule", name = "vacation_period")
@Data
public class VacationPeriod {
    @Id
    @Column(name = "vacation_period_id")
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "schedule_id")
    private Schedule owningSchedule;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "duration_days")
    private int durationDays;
}
