package ru.osiptsoff.npaws.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.osiptsoff.npaws.dto.VacationPeriodDto;
import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;
import ru.osiptsoff.npaws.model.schedule.VacationPeriod;
import ru.osiptsoff.npaws.service.VacationPeriodService;

@RestController
@RequestMapping("/vacationPeriod")
@Validated
public class VacationPeriodController
        extends AbstractPagedCrudController<VacationPeriod, VacationPeriodDto> {

    protected VacationPeriodController(VacationPeriodService vacationPeriodService) {
        super(vacationPeriodService, vacationPeriodService);
    }

        @GetMapping("/schedule/{scheduleId}")
    public PageDto<VacationPeriod> readByClientId(@RequestParam Integer pageNumber,
            @RequestParam Integer pageSize, @PathVariable UUID scheduleId) {
        return getPService().findByScheduleId(new PageRequestDto(pageNumber, pageSize), scheduleId);
    }

    @Override
    public VacationPeriodService getPService() {
        return (VacationPeriodService)super.getPService();
    }
}
