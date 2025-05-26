package ru.osiptsoff.npaws.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ru.osiptsoff.npaws.dto.AppointmentDto;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;
import ru.osiptsoff.npaws.model.visit.Appointment;
import ru.osiptsoff.npaws.repository.AppointmentRepository;

@Service
public class AppointmentService extends AbstractPagingCrudService<Appointment> {

    protected AppointmentService(AppointmentRepository appointmentRepository) {
        super(appointmentRepository, appointmentRepository);
    }

    @Transactional
    public PageDto<Appointment> findPageByEmployeeId(PageRequestDto dto, UUID employeeId) {
        return findPage(dto, p -> getPsRepository().findAllByEmployeeId(p, employeeId));
    }

    @Transactional
    public PageDto<Appointment> findPageByPatientId(PageRequestDto dto, UUID patientId) {
        return findPage(dto, p -> getPsRepository().findAllByPatientId(p, patientId));
    }

    @Override
    public AppointmentRepository getPsRepository() {
        return (AppointmentRepository)super.getPsRepository();
    }

    @Override
    Class<? extends Dto<Appointment>> getDtoClass() {
        return AppointmentDto.class;
    }
}
