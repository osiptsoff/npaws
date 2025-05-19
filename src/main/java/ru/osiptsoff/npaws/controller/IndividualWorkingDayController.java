package ru.osiptsoff.npaws.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.osiptsoff.npaws.dto.IndividualWorkingDayDto;
import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;
import ru.osiptsoff.npaws.model.schedule.IndividualWorkingDay;
import ru.osiptsoff.npaws.service.IndividualWorkingDayService;

@RestController
@RequestMapping("/individualWorkingDay")
@Validated
public class IndividualWorkingDayController 
        extends AbstractPagedCrudController<IndividualWorkingDay, IndividualWorkingDayDto> {

    protected IndividualWorkingDayController(IndividualWorkingDayService individualWorkingDayService) {
        super(individualWorkingDayService, individualWorkingDayService);
    }

    @GetMapping("/schedule/{scheduleId}")
    public PageDto<IndividualWorkingDay> readByClientId(@RequestParam Integer pageNumber,
            @RequestParam Integer pageSize, @PathVariable UUID scheduleId) {
        return getPService().findByScheduleId(new PageRequestDto(pageNumber, pageSize), scheduleId);
    }

    @Override
    public IndividualWorkingDayService getPService() {
        return (IndividualWorkingDayService)super.getPService();
    }
    
}
