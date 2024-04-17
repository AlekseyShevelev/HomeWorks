package ru.geekbrains.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.bookingservice.model.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserIdOrderByServiceDate(Long userId);
    List<Reservation> findByEmployeeId(Long employeeId);
    void deleteByUserId(Long userId);
}