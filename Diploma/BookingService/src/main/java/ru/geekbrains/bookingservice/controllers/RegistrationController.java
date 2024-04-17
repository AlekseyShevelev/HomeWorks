package ru.geekbrains.bookingservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.bookingservice.model.Role;
import ru.geekbrains.bookingservice.model.User;
import ru.geekbrains.bookingservice.model.enums.RoleType;
import ru.geekbrains.bookingservice.services.UserService;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String registration(User user) {
        Role clientRole = userService.getRoleByName(RoleType.CLIENT);
        user.getRoles().add(clientRole);
        userService.createOrUpdateUser(user);
        return "redirect:/login";
    }
}
