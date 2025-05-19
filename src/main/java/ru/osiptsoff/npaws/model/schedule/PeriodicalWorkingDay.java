package ru.osiptsoff.npaws.model.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema = "schedule", name = "periodic_schedule_entry")
@Data
@EqualsAndHashCode(callSuper = false)
public class PeriodicalWorkingDay extends WorkingDay {
    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week_name")
    @EqualsAndHashCode.Include
    private DayOfWeek dayOfWeek;

    @Column(name = "period_weeks")
    private int periodWeeks;
}
