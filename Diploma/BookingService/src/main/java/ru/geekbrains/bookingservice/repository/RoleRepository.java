package ru.geekbrains.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.bookingservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
