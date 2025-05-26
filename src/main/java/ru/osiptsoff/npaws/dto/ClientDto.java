package ru.osiptsoff.npaws.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.Client;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientDto extends Dto<Client> {
    private UUID id;
    private String name;
    private List<ContactDto> contacts = new ArrayList<>();
    private List<PatientDto> patients = new ArrayList<>();
    
    @Override
    public Client getEntity() {
        Client client = new Client();

        client.setContacts(getContacts().stream()
            .map(c -> c.getEntity())
            .toList()
        );
        client.setId(getId());
        client.setName(getName());
        client.setPatients(getPatients().stream()
            .map(p -> p.getEntity())
            .toList()
        );

        return client;
    }

    @Override
    public ClientDto fillByEntity(Client entity) {
        getContacts().clear();
        getContacts().addAll(entity.getContacts().stream()
            .map(c -> new ContactDto().fillByEntity(c))
            .toList()
        );
        setId(entity.getId());
        setName(entity.getName());
        getPatients().clear();
        setPatients(entity.getPatients().stream()
            .map(c -> new PatientDto().fillByEntity(c))
            .toList()
        );

        return this;
    }    
}
