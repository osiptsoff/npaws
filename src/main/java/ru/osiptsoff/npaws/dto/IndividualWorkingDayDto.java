package ru.osiptsoff.npaws.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.schedule.IndividualWorkingDay;
import ru.osiptsoff.npaws.model.schedule.Schedule;

@Data
@EqualsAndHashCode(callSuper = false)
public class IndividualWorkingDayDto extends Dto<IndividualWorkingDay> {
    private UUID id;
    private UUID scheduleId;
    private LocalTime dayStart;
    private int dayDuratuinHours;
    private LocalDate date;

    @Override
    public IndividualWorkingDay getEntity() {
        IndividualWorkingDay day = new IndividualWorkingDay();
        Schedule schedule = new Schedule();

        day.setId(getId());
         if (getScheduleId() != null) {
            day.setOwningSchedule(schedule);
        }
        day.setDayStart(getDayStart());
        day.setDayDurationHours(getDayDuratuinHours());
        day.setDate(getDate());
        schedule.setId(getScheduleId());

        return day;
    }

    @Override
    public IndividualWorkingDayDto fillByEntity(IndividualWorkingDay entity) {
        setId(entity.getId());
        if (entity.getOwningSchedule() != null) {
            setScheduleId(entity.getOwningSchedule().getId());
        }
        setDayStart(entity.getDayStart());
        setDayDuratuinHours(entity.getDayDurationHours());
        setDate(entity.getDate());

        return this;
    }
    
}
