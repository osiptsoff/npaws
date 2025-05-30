package ru.osiptsoff.npaws.model.subject;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema = "subject", name = "contact")
@Data
@EqualsAndHashCode(callSuper = true)
public class ClientContact extends Contact {
}
