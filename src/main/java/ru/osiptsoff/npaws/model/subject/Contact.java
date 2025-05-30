package ru.osiptsoff.npaws.model.subject;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
public class Contact {
    @Column(name = "id")
    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "contact")
    private String contactMean;

    @Column(name = "comment")
    private String comment;

    @Column(name = "person_id")
    private UUID ownerId;
}