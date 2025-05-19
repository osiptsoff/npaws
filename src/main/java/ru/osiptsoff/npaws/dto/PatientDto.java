package ru.osiptsoff.npaws.dto;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.Client;
import ru.osiptsoff.npaws.model.subject.Patient;

@Data
@EqualsAndHashCode(callSuper = false)
public class PatientDto extends Dto<Patient> {
    private UUID id;
    private String name;
    private String taxometry;
    private boolean isMale;
    private int age;
    private UUID ownerId;

    @Override
    public Patient getEntity() {
        Patient patient = new Patient();
        Client client = new Client();

        patient.setAge(getAge());
        patient.setId(getId());
        patient.setMale(isMale());
        patient.setName(getName());
        patient.setToxometry(getTaxometry());
        if (getOwnerId() != null) {
            patient.setOwner(client);
        }
        client.setId(getOwnerId());

        return patient;
    }

    @Override
    public PatientDto fillByEntity(Patient entity) {
        setAge(entity.getAge());
        setId(entity.getId());
        setMale(entity.isMale());
        setName(entity.getName());
        if (entity.getOwner() != null) {
            setOwnerId(entity.getOwner().getId());
        }
        setTaxometry(entity.getToxometry());

        return this;
    }    
}
