package ru.osiptsoff.npaws.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.osiptsoff.npaws.model.visit.Appointment;

@Repository
public interface AppointmentRepository extends
        CrudRepository<Appointment, UUID>,
        PagingAndSortingRepository<Appointment, UUID> {
        
    @Query(value = "select a from Appointment a where a.employee.id = ?2")
    Page<Appointment> findPageByEmployeeId(Pageable pageable, UUID id);

    @Query(value = "select a from Appointment a where a.patient.id = ?2")
    Page<Appointment> findPageByPatientId(Pageable pageable, UUID id);
}
