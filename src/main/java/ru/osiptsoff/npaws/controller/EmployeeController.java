package ru.osiptsoff.npaws.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.osiptsoff.npaws.dto.EmployeeDto;
import ru.osiptsoff.npaws.model.subject.Employee;
import ru.osiptsoff.npaws.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController extends AbstractPagedCrudController<Employee, EmployeeDto> {

    protected EmployeeController(EmployeeService employeeService) {
        super(employeeService, employeeService);
    }
    
}
