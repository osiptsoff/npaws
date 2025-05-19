package ru.osiptsoff.npaws.model.subject;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema = "subject", name = "contact")
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
}
