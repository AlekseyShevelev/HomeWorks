package ru.geekbrains.bookingservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.bookingservice.configurations.MyUserDetails;
import ru.geekbrains.bookingservice.dto.ReservationRequest;
import ru.geekbrains.bookingservice.model.*;
import ru.geekbrains.bookingservice.services.*;

import java.util.List;

import static ru.geekbrains.bookingservice.model.enums.RoleType.MANAGER;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    private final EmployeeService employeeService;
    private final OperationService operationService;
    private final ReservationService reservationService;

    @GetMapping
    public String getAllReservations(
            Authentication authentication,
            Model model) {

        List<Reservation> reservations;
        String title;

        boolean hasManagerRole = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList().contains(MANAGER.toString());

        if (hasManagerRole) {
            title = "Бронирования";
            reservations = reservationService.getAllReservations();
        } else {
            title = "Мои бронирования";
            User user = ((MyUserDetails) authentication.getPrincipal()).getUser();
            reservations = reservationService.getReservationsByUserId(user.getId());
        }

        model.addAttribute("title", title);
        model.addAttribute("reservations", reservations);

        return "reservation-list";
    }

    @GetMapping("/add")
    public String addReservationForm(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        List<Operation> operations = operationService.getAllOperations();
        model.addAttribute("operations", operations);

        model.addAttribute("reservationRequest", new ReservationRequest());

        return "reservation";
    }

    @PostMapping("/add")
    public String addReservation(
            Authentication authentication,
            @ModelAttribute("reservationRequest") ReservationRequest reservationRequest,
            BindingResult bindingResult,
            Model model) {

        User user = ((MyUserDetails) authentication.getPrincipal()).getUser();
        reservationRequest.setUserId(user.getId());

        String errMessage = reservationService.validateReservationRequest(reservationRequest);
        if (errMessage != null) {
            ObjectError error = new ObjectError("validationError", errMessage);
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()) {
            List<Employee> employees = employeeService.getAllEmployees();
            model.addAttribute("employees", employees);

            List<Operation> operations = operationService.getAllOperations();
            model.addAttribute("operations", operations);

            return "reservation";
        }

        reservationService.addReservation(reservationRequest);

        return "redirect:/reservations";
    }
}
