package ru.geekbrains.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.bookingservice.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
