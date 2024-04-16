package ru.geekbrains.bookingservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.bookingservice.dto.ReservationRequest;
import ru.geekbrains.bookingservice.model.Employee;
import ru.geekbrains.bookingservice.model.Operation;
import ru.geekbrains.bookingservice.model.Reservation;
import ru.geekbrains.bookingservice.model.User;
import ru.geekbrains.bookingservice.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final EmployeeService employeeService;
    private final OperationService operationService;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public void addReservation(ReservationRequest reservationRequest) {
        User user = userService.getUserById(reservationRequest.getUserId());
        Employee employee = employeeService.getEmployeeById(reservationRequest.getEmployeeId());
        Operation operation = operationService.getOperationById(reservationRequest.getOperationId());

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setEmployee(employee);
        reservation.setOperation(operation);
        reservation.setServiceDate(reservationRequest.getServiceDate());

        reservationRepository.save(reservation);
    }
}
