package ru.osiptsoff.npaws.dto;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.EmployeeContact;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeContactDto extends Dto<EmployeeContact> {
    private UUID id;
    private String contactMean;
    private String comment;

    @Override
    public EmployeeContact getEntity() {
        EmployeeContact contact = new EmployeeContact();

        contact.setComment(getComment());
        contact.setContactMean(getContactMean());
        contact.setId(getId());

        return contact;
    }

    @Override
    public EmployeeContactDto fillByEntity(EmployeeContact entity) {
        setComment(entity.getComment());
        setContactMean(entity.getContactMean());
        setId(entity.getId());

        return this;
    }
}