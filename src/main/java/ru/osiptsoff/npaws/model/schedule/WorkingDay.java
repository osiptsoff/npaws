package ru.osiptsoff.npaws.model.schedule;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class WorkingDay {
    @Id
    @Column(name = "entry_id")
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "schedule_id")
    private Schedule owningSchedule;

    @Column(name = "day_start")
    private LocalTime dayStart;

    @Column(name = "working_hours")
    private int dayDurationHours;
}
