package ru.geekbrains.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.bookingservice.model.Role;
import ru.geekbrains.bookingservice.model.enums.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType name);
}
