package ru.osiptsoff.npaws.service;

import org.springframework.stereotype.Service;

import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.PatientDto;
import ru.osiptsoff.npaws.model.subject.Patient;
import ru.osiptsoff.npaws.repository.PatientRepository;

@Service
public class PatientService extends AbstractPagingCrudService<Patient> {

    protected PatientService(PatientRepository repository) {
        super(repository, repository);
    }

    @Override
    Class<? extends Dto<Patient>> getDtoClass() {
        return PatientDto.class;
    }
    
}
