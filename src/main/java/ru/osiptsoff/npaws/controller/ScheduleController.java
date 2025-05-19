package ru.osiptsoff.npaws.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.osiptsoff.npaws.dto.ScheduleDto;
import ru.osiptsoff.npaws.model.schedule.Schedule;
import ru.osiptsoff.npaws.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
@Validated
public class ScheduleController extends AbstractCrudController<Schedule, ScheduleDto> {

    public ScheduleController(ScheduleService service) {
        super(service);
    }
    
}
