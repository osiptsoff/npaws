package ru.osiptsoff.npaws.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.Valid;
import lombok.Setter;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.EmployeeDto;
import ru.osiptsoff.npaws.dto.SecurityUserDto;
import ru.osiptsoff.npaws.model.subject.Employee;
import ru.osiptsoff.npaws.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController extends AbstractPagedCrudController<Employee, EmployeeDto> {

    private final RestTemplate restTemplate;

    @Setter
    @Value("${app.config.security.userCreationEndpoint}")
    private String userCreationEndpoint;

    protected EmployeeController(EmployeeService employeeService, RestTemplate restTemplate) {
        super(employeeService, employeeService);
        this.restTemplate = restTemplate;
    }

    @PostMapping("")
    @Override
    public Dto<Employee> create(@Valid @RequestBody EmployeeDto dto) {
        restTemplate.postForEntity(
            userCreationEndpoint,
            dto.getSecurityInfo(),
            SecurityUserDto.class
        );

        return super.create(dto);
    }
    
}
