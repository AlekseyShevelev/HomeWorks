package ru.geekbrains.bookingservice.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.geekbrains.bookingservice.model.enums.RoleType;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType name;
}
