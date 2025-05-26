package ru.osiptsoff.npaws.service;

import org.springframework.stereotype.Service;

import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.EmployeeDto;
import ru.osiptsoff.npaws.model.subject.Employee;
import ru.osiptsoff.npaws.repository.EmployeeRepository;
import ru.osiptsoff.npaws.util.UuidUtil;

@Service
public class EmployeeService extends AbstractPagingCrudService<Employee> {

    protected EmployeeService(EmployeeRepository employeeRepository) {
        super(employeeRepository, employeeRepository);
    }

    @Override
    protected Employee upsert(Employee obj) {
        obj.getContacts().forEach(c -> {
            if (c.getId() == null) {
                c.setId(UuidUtil.generateUuid());
                c.setOwnerId(obj.getId());
            }
        });

        return super.upsert(obj);
    }

    @Override
    Class<? extends Dto<Employee>> getDtoClass() {
        return EmployeeDto.class;
    }
    
}
