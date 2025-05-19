package ru.osiptsoff.npaws.model.schedule;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema = "schedule", name = "individual_schedule_entry")
@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualWorkingDay extends WorkingDay {
    @Column(name = "date")
    private LocalDate date;
}
