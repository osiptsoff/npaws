package ru.osiptsoff.npaws.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.osiptsoff.npaws.model.visit.Appointment;

@Repository
public interface AppointmentRepository extends
        CrudRepository<Appointment, UUID>,
        PagingAndSortingRepository<Appointment, UUID> {
        
    Page<Appointment> findAllByEmployeeId(Pageable pageable, UUID id);

    Page<Appointment> findAllByPatientId(Pageable pageable, UUID id);
}
