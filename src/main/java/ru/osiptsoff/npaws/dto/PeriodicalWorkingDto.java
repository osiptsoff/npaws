package ru.osiptsoff.npaws.dto;

import java.time.LocalTime;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.schedule.DayOfWeek;
import ru.osiptsoff.npaws.model.schedule.PeriodicalWorkingDay;
import ru.osiptsoff.npaws.model.schedule.Schedule;

@Data
@EqualsAndHashCode(callSuper = false)
public class PeriodicalWorkingDto extends Dto<PeriodicalWorkingDay> {
    private UUID id;
    private UUID scheduleId;
    private LocalTime dayStart;
    private int dayDuratuinHours;
    private String dayOfWeek;

    @Override
    public PeriodicalWorkingDay getEntity() {
        PeriodicalWorkingDay day = new PeriodicalWorkingDay();
        Schedule schedule = new Schedule();

        day.setId(getId());
        if (getScheduleId() != null) {
            day.setOwningSchedule(schedule);
        }
        day.setDayStart(getDayStart());
        day.setDayDurationHours(getDayDuratuinHours());
        day.setDayOfWeek(DayOfWeek.valueOf(getDayOfWeek()));
        schedule.setId(getScheduleId());

        return day;
    }

    @Override
    public PeriodicalWorkingDto fillByEntity(PeriodicalWorkingDay entity) {
        setId(entity.getId());
        if (entity.getOwningSchedule() != null) {
            setScheduleId(entity.getOwningSchedule().getId());
        }
        setDayStart(entity.getDayStart());
        setDayDuratuinHours(entity.getDayDurationHours());
        setDayOfWeek(entity.getDayOfWeek().getName());

        return this;
    }
}
