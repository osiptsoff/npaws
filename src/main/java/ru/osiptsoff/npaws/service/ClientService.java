package ru.osiptsoff.npaws.service;

import org.springframework.stereotype.Service;

import ru.osiptsoff.npaws.dto.ClientDto;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.model.subject.Client;
import ru.osiptsoff.npaws.repository.ClientRepository;

@Service
public class ClientService extends AbstractPagingCrudService<Client> {

    protected ClientService(ClientRepository clientRepository) {
        super(clientRepository, clientRepository);
    }

    @Override
    Class<? extends Dto<Client>> getDtoClass() {
        return ClientDto.class;
    }
}
