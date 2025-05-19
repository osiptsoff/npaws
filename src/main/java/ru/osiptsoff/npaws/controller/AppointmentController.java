package ru.osiptsoff.npaws.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.osiptsoff.npaws.dto.AppointmentDto;
import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;
import ru.osiptsoff.npaws.model.visit.Appointment;
import ru.osiptsoff.npaws.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
@Validated
public class AppointmentController extends AbstractPagedCrudController<Appointment, AppointmentDto> {

    protected AppointmentController(AppointmentService service) {
        super(service, service);
    }
    
    @GetMapping("/employee/{employeeId}")
    public PageDto<Appointment> readByEmployeeId(@RequestParam Integer pageNumber,
            @RequestParam Integer pageSize, @PathVariable UUID employeeId) {
        return getPService().findPageByEmployeeId(new PageRequestDto(pageNumber, pageSize), employeeId);
    }

    @GetMapping("/client/{clientId}")
    public PageDto<Appointment> readByClientId(@RequestParam Integer pageNumber,
            @RequestParam Integer pageSize, @PathVariable UUID clientId) {
        return getPService().findPageByPatientId(new PageRequestDto(pageNumber, pageSize), clientId);
    }

    @Override
    public AppointmentService getPService() {
        return (AppointmentService)super.getPService();
    }
}
