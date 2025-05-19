package ru.osiptsoff.npaws.dto;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.Contact;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContactDto extends Dto<Contact> {
    private UUID id;
    private String contactMean;
    private String comment;

    @Override
    public Contact getEntity() {
        Contact contact = new Contact();

        contact.setComment(getComment());
        contact.setContactMean(getContactMean());
        contact.setId(getId());

        return contact;
    }

    @Override
    public ContactDto fillByEntity(Contact entity) {
        setComment(entity.getComment());
        setContactMean(entity.getContactMean());
        setId(entity.getId());

        return this;
    }
}
