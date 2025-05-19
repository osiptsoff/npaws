package ru.osiptsoff.npaws.service;

import org.springframework.stereotype.Service;

import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.ScheduleDto;
import ru.osiptsoff.npaws.model.schedule.Schedule;
import ru.osiptsoff.npaws.repository.ScheduleRepository;

@Service
public class ScheduleService extends AbstractCrudService<Schedule> {

    protected ScheduleService(ScheduleRepository scheduleRepository) {
        super(scheduleRepository);
    }

    @Override
    Class<? extends Dto<Schedule>> getDtoClass() {
        return ScheduleDto.class;
    }
    
}
