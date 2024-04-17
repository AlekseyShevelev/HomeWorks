package ru.geekbrains.bookingservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.bookingservice.dto.ReservationRequest;
import ru.geekbrains.bookingservice.model.Employee;
import ru.geekbrains.bookingservice.model.Operation;
import ru.geekbrains.bookingservice.model.Reservation;
import ru.geekbrains.bookingservice.model.User;
import ru.geekbrains.bookingservice.repository.ReservationRepository;

import java.time.LocalDateTime;
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
        return reservationRepository.findByUserIdOrderByServiceDate(userId);
    }

    public List<Reservation> getReservationsByEmployeeId(Long employeeId) {
        return reservationRepository.findByEmployeeId(employeeId);
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

    public String validateReservationRequest(ReservationRequest reservationRequest) {
        String message = null;

        if (reservationRequest.getServiceDate().isBefore(LocalDateTime.now())) {
            message = "Дата не может быть в прошлом";
        }

        List<Reservation> reservations = getReservationsByEmployeeId(reservationRequest.getEmployeeId());

        LocalDateTime curStartDate = reservationRequest.getServiceDate();
        int duration = operationService.getOperationById(reservationRequest.getOperationId()).getDuration();
        LocalDateTime curEndDate = curStartDate.plusMinutes(duration);

        boolean hasConflict = false;
        LocalDateTime startDate, endDate;

        for (Reservation reservation : reservations) {
            startDate = reservation.getServiceDate();
            duration = operationService.getOperationById(reservation.getOperation().getId()).getDuration();
            endDate = startDate.plusMinutes(duration);

            if (startDate.isAfter(curStartDate) && startDate.isBefore(curEndDate)) {
                hasConflict = true;
                break;
            }

            if (endDate.isAfter(curStartDate) && endDate.isBefore(curEndDate)) {
                hasConflict = true;
                break;
            }
        }

        if (hasConflict) {
            message = "Выбранное время занято";
        }

        return message;
    }
}
