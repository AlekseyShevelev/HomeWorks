package ru.geekbrains.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.bookingservice.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
