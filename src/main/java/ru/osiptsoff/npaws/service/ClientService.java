package ru.osiptsoff.npaws.service;

import org.springframework.stereotype.Service;

import ru.osiptsoff.npaws.dto.ClientDto;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.model.subject.Client;
import ru.osiptsoff.npaws.repository.ClientRepository;
import ru.osiptsoff.npaws.util.UuidUtil;

@Service
public class ClientService extends AbstractPagingCrudService<Client> {

    protected ClientService(ClientRepository clientRepository) {
        super(clientRepository, clientRepository);
    }

    @Override
    protected Client upsert(Client obj) {
        obj.getContacts().forEach(c -> {
            if (c.getId() == null) {
                c.setId(UuidUtil.generateUuid());
                c.setOwnerId(obj.getId());
            }
        });
        obj.getPatients().forEach(c -> {
            if (c.getId() == null) {
                c.setId(UuidUtil.generateUuid());
                c.setOwner(obj);
            }
        });

        return super.upsert(obj);
    }

    @Override
    Class<? extends Dto<Client>> getDtoClass() {
        return ClientDto.class;
    }
}
