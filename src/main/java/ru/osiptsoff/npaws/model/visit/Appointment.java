package ru.osiptsoff.npaws.model.visit;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.osiptsoff.npaws.model.subject.Employee;
import ru.osiptsoff.npaws.model.subject.Patient;

@Entity
@Table(schema = "visit", name = "visit")
@Data
public class Appointment {
    @Id
    @Column(name = "visit_id")
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne @MapsId
    private Employee employee;

    @ManyToOne @MapsId
    private Patient patient;

    @Column(name = "datetime")
    private LocalDateTime dateTime;

    @OneToOne(mappedBy = "owningAppointment", fetch = FetchType.EAGER)
    private Protocol protocol;
}
