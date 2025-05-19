package ru.osiptsoff.npaws.model.visit;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "visit", name = "protocol")
@Data
public class Protocol {
    @Id
    @Column(name = "visit_id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "visit_id")
    private Appointment owningAppointment;

    @Column(name = "appointed_visit_id")
    private UUID appointedAppointmentId;

    @Column(name = "diagnosis")
    private String disgnosis;

    @Column(name = "comment")
    private String comment;
}
