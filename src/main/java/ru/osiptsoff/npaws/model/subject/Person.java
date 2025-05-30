package ru.osiptsoff.npaws.model.subject;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
public class Person {
    @Id
    @Column(name = "person_id")
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "name")
    private String name;
}
