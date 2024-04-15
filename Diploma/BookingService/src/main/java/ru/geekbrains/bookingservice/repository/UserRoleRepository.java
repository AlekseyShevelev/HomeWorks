package ru.geekbrains.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.bookingservice.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
