package ru.osiptsoff.npaws.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.osiptsoff.npaws.dto.PatientDto;
import ru.osiptsoff.npaws.model.subject.Patient;
import ru.osiptsoff.npaws.service.PatientService;

@RestController
@RequestMapping("/patient")
@Validated
public class PatientController extends AbstractPagedCrudController<Patient, PatientDto> {

    protected PatientController(PatientService patientService) {
        super(patientService, patientService);
    }
    
}
