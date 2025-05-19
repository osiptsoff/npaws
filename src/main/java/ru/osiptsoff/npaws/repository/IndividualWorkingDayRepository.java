package ru.osiptsoff.npaws.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.osiptsoff.npaws.model.schedule.IndividualWorkingDay;

@Repository
public interface IndividualWorkingDayRepository extends
        CrudRepository<IndividualWorkingDay, UUID>,
        PagingAndSortingRepository<IndividualWorkingDay, UUID> {
            
    @Query(value = "select d from IndividualWorkingDay d where d.owningSchedule.id = ?2")
    Page<IndividualWorkingDay> findPageByOwningScheduleId(Pageable pageable, UUID id);
}
