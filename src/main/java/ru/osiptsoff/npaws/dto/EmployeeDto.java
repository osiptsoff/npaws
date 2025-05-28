package ru.osiptsoff.npaws.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.micrometer.common.lang.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.Education;
import ru.osiptsoff.npaws.model.subject.Employee;
import ru.osiptsoff.npaws.model.subject.Position;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeDto extends Dto<Employee> {
    private UUID id;
    private UUID scheduleId;
    private String name;
    private List<ContactDto> contacts = new ArrayList<>();
    private String institution;
    private String education;
    private String position;
    @Nullable
    private SecurityUserDto securityInfo;

    @Override
    public Employee getEntity() {
        Employee employee = new Employee();

        employee.setContacts(getContacts().stream()
            .map(c -> c.getEntity())
            .toList()
        );
        employee.setEducation(Education.valueOf(getEducation()));
        employee.setId(getId());
        employee.setInstitution(getInstitution());
        employee.setName(getName());
        employee.setPosition(Position.valueOf(getPosition()));

        return employee;
    }

    @Override
    public EmployeeDto fillByEntity(Employee entity) {
        getContacts().clear();
        getContacts().addAll(entity.getContacts().stream()
            .map(c -> new ContactDto().fillByEntity(c))
            .toList()
        );
        setEducation(entity.getEducation().getName());
        setId(entity.getId());
        setScheduleId(entity.getId());
        setInstitution(entity.getInstitution());
        setName(entity.getName());
        setPosition(entity.getPosition().getName());

        return this;
    }
}
