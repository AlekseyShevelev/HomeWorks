package ru.geekbrains.bookingservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.bookingservice.model.*;
import ru.geekbrains.bookingservice.services.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    private final UserService userService;
    private final EmployeeService employeeService;
    private final OperationService operationService;
    private final ReservationService reservationService;

    @GetMapping("/add")
    public String addReservationForm(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        List<Operation> operations = operationService.getAllOperations();
        model.addAttribute("operations", operations);

        model.addAttribute("reservation", new Reservation());

        return "reservation";
    }

    @PostMapping("/add")
    public String addReservation(
            Principal principal,
            @ModelAttribute("reservation") Reservation reservation) {

        String userName = principal.getName();
        //UserDetails userDetails = (UserDetails) principal;
        //User user = (User) userDetails;
        User user = userService.getUserByName(userName);

        reservation.setUser(user);
        reservationService.addReservation(reservation);

        return "client";
    }
}
