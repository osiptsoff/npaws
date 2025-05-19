package ru.osiptsoff.npaws.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.IndividualWorkingDayDto;
import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;
import ru.osiptsoff.npaws.model.schedule.IndividualWorkingDay;
import ru.osiptsoff.npaws.repository.IndividualWorkingDayRepository;

@Service
public class IndividualWorkingDayService extends AbstractPagingCrudService<IndividualWorkingDay> {

    protected IndividualWorkingDayService(IndividualWorkingDayRepository individualWorkingDayRepository) {
        super(individualWorkingDayRepository, individualWorkingDayRepository);
    }

    @Transactional
    public PageDto<IndividualWorkingDay> findByScheduleId(PageRequestDto dto, UUID scheduleId) {
        return findPage(dto, p -> getPsRepository().findPageByOwningScheduleId(p, scheduleId));
    }

    @Override
    public IndividualWorkingDayRepository getPsRepository() {
        return (IndividualWorkingDayRepository)super.getPsRepository();
    }

    @Override
    Class<? extends Dto<IndividualWorkingDay>> getDtoClass() {
        return IndividualWorkingDayDto.class;
    }
    
}
