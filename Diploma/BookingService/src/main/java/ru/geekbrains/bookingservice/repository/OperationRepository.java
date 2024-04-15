package ru.geekbrains.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.bookingservice.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
