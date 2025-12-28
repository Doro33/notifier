package org.example.notifier.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.notifier.enums.ContactType;

@Entity
@Data
public class ContactPoint {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Client client;
    @Enumerated(value = EnumType.STRING)
    private ContactType contactType;
    private String address;
    private Boolean isActive;
}
