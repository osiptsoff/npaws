package ru.osiptsoff.npaws.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.Employee;
import ru.osiptsoff.npaws.model.subject.Patient;
import ru.osiptsoff.npaws.model.visit.Appointment;
import ru.osiptsoff.npaws.model.visit.AppointmentStatus;
import ru.osiptsoff.npaws.model.visit.Protocol;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentDto extends Dto<Appointment> {
    private UUID id;
    private UUID employeeId;
    private UUID patientId;
    private LocalDateTime dateTime;
    private String status;
    private UUID appointedAppointmentId;
    private String diagnosis;
    private String comment;

    @Override
    public Appointment getEntity() {
        Appointment appointment = new Appointment();
        Employee employee = new Employee();
        Patient patient = new Patient();
        Protocol protocol = new Protocol();

        appointment.setDateTime(getDateTime());
        if (getEmployeeId() != null) {
            appointment.setEmployee(employee);
        }
        appointment.setAppointmentStatus(AppointmentStatus.valueOf(getStatus()));
        appointment.setId(getId());
        if (getPatientId() != null) {
            appointment.setPatient(patient);
        }
        if (hasProtocol()) {
            appointment.setProtocol(protocol);
        }
        employee.setId(getEmployeeId());
        patient.setId(getPatientId());
        protocol.setAppointedAppointmentId(getAppointedAppointmentId());
        protocol.setDisgnosis(getDiagnosis());
        protocol.setComment(getComment());
        protocol.setId(getId());
        protocol.setOwningAppointment(appointment);

        return appointment;
    }

    @Override
    public Dto<Appointment> fillByEntity(Appointment entity) {
        if (entity.getProtocol() != null) {
            setAppointedAppointmentId(entity.getProtocol().getAppointedAppointmentId());
            setComment(entity.getProtocol().getComment());
            setDiagnosis(entity.getProtocol().getDisgnosis());
        }
        setDateTime(entity.getDateTime());
        if (entity.getEmployee() != null) {
            setEmployeeId(entity.getEmployee().getId());
        }
        setStatus(entity.getAppointmentStatus().getName());
        setId(entity.getId());
        if (entity.getPatient() != null) {
            setPatientId(entity.getPatient().getId());
        }

       return this;
    }

    private boolean hasProtocol() {
        return getAppointedAppointmentId() != null
            || getDiagnosis() != null
            || getComment() != null;
    }
}
