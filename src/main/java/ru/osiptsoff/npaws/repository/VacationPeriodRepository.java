package ru.osiptsoff.npaws.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.osiptsoff.npaws.model.schedule.VacationPeriod;

@Repository
public interface VacationPeriodRepository extends
        CrudRepository<VacationPeriod, UUID>,
        PagingAndSortingRepository<VacationPeriod, UUID> {
    
    Page<VacationPeriod> findAllByOwningScheduleId(Pageable pageable, UUID id);
}
