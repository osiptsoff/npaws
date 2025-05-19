package ru.osiptsoff.npaws.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.schedule.Schedule;
import ru.osiptsoff.npaws.model.schedule.VacationPeriod;

@Data
@EqualsAndHashCode(callSuper = false)
public class VacationPeriodDto extends Dto<VacationPeriod> {
    private UUID id;
    private UUID scheduleId;
    private LocalDate startDate;
    private int durationDays;

    @Override
    public VacationPeriod getEntity() {
        VacationPeriod vacationPeriod = new VacationPeriod();
        Schedule schedule = new Schedule();

        vacationPeriod.setDurationDays(getDurationDays());
        vacationPeriod.setId(getId());
        if (getScheduleId() != null) {
            vacationPeriod.setOwningSchedule(schedule);
        }
        vacationPeriod.setStartDate(getStartDate());
        schedule.setId(getScheduleId());

        return vacationPeriod;
    }

    @Override
    public VacationPeriodDto fillByEntity(VacationPeriod entity) {
        setDurationDays(entity.getDurationDays());
        setId(entity.getId());
        if (entity.getOwningSchedule() != null) {
            setScheduleId(entity.getOwningSchedule().getId());
        }
        setStartDate(entity.getStartDate());

        return this;
    }
}
