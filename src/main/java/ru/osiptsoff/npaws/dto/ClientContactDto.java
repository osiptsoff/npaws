package ru.osiptsoff.npaws.dto;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.ClientContact;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientContactDto extends Dto<ClientContact> {
    private UUID id;
    private String contactMean;
    private String comment;

    @Override
    public ClientContact getEntity() {
        ClientContact contact = new ClientContact();

        contact.setComment(getComment());
        contact.setContactMean(getContactMean());
        contact.setId(getId());

        return contact;
    }

    @Override
    public ClientContactDto fillByEntity(ClientContact entity) {
        setComment(entity.getComment());
        setContactMean(entity.getContactMean());
        setId(entity.getId());

        return this;
    }
}
