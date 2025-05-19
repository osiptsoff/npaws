package ru.osiptsoff.npaws.service;

import org.springframework.stereotype.Service;

import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.EmployeeDto;
import ru.osiptsoff.npaws.model.subject.Employee;
import ru.osiptsoff.npaws.repository.EmployeeRepository;

@Service
public class EmployeeService extends AbstractPagingCrudService<Employee> {

    protected EmployeeService(EmployeeRepository employeeRepository) {
        super(employeeRepository, employeeRepository);
    }

    @Override
    Class<? extends Dto<Employee>> getDtoClass() {
        return EmployeeDto.class;
    }
    
}
