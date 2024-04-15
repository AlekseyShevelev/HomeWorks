package ru.geekbrains.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.bookingservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
