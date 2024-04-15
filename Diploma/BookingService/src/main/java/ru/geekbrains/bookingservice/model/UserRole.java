package ru.geekbrains.bookingservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "user_roles",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})}
)
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "role_id", nullable = false)
    private Long roleId;
}
