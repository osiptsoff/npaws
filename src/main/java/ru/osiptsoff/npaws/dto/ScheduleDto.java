package ru.osiptsoff.npaws.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.schedule.Schedule;
import ru.osiptsoff.npaws.model.subject.Employee;

@Data
@EqualsAndHashCode(callSuper = true)
public class ScheduleDto extends Dto<Schedule> {
    private UUID id;
    private UUID employeeId;
    private List<PeriodicalWorkingDto> periodicalWorkingDays = new ArrayList<>();

    @Override
    public Schedule getEntity() {
        Schedule schedule = new Schedule();
        Employee employee = new Employee();

        if (getEmployeeId() != null) {
            schedule.setEmployee(employee);
        }
        schedule.setId(getId());
        schedule.setPeriodicalWorkingDays(getPeriodicalWorkingDays().stream()
            .map(p -> p.getEntity())
            .collect(Collectors.toSet())
        );
        employee.setId(getEmployeeId());

        return schedule;
    }

    @Override
    public Dto<Schedule> fillByEntity(Schedule entity) {
        if (entity.getEmployee() != null) {
            setEmployeeId(entity.getEmployee().getId());
        }
        setId(entity.getId());
        periodicalWorkingDays.clear();
        setPeriodicalWorkingDays(entity.getPeriodicalWorkingDays().stream()
            .map(p -> new PeriodicalWorkingDto().fillByEntity(p))
            .toList()
        );

        return this;
    }
}
