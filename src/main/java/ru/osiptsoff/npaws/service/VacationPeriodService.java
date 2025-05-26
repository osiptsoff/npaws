package ru.osiptsoff.npaws.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.VacationPeriodDto;
import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;
import ru.osiptsoff.npaws.model.schedule.VacationPeriod;
import ru.osiptsoff.npaws.repository.VacationPeriodRepository;

@Service
public class VacationPeriodService extends AbstractPagingCrudService<VacationPeriod> {

    protected VacationPeriodService(VacationPeriodRepository vacationPeriodRepository) {
        super(vacationPeriodRepository, vacationPeriodRepository);
    }

    @Transactional
    public PageDto<VacationPeriod> findByScheduleId(PageRequestDto dto, UUID scheduleId) {
        return findPage(dto, p -> getPsRepository().findAllByOwningScheduleId(p, scheduleId));
    }

    @Override
    public VacationPeriodRepository getPsRepository() {
        return (VacationPeriodRepository)super.getPsRepository();
    }

    @Override
    Class<? extends Dto<VacationPeriod>> getDtoClass() {
        return VacationPeriodDto.class;
    }
    
}
