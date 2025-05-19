package ru.osiptsoff.npaws.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.osiptsoff.npaws.model.schedule.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, UUID> {
    
}
