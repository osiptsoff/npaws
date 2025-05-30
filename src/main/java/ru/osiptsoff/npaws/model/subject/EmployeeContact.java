package ru.osiptsoff.npaws.model.subject;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema = "subject", name = "employee_contact")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmployeeContact extends Contact {
}