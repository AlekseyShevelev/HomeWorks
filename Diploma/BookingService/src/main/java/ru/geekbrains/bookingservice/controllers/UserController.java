package ru.geekbrains.bookingservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.bookingservice.model.Role;
import ru.geekbrains.bookingservice.model.User;
import ru.geekbrains.bookingservice.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/add")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        List<Role> roles = userService.getAllRoles();
        model.addAttribute("roles", roles);
        return "user-create";
    }

    @PostMapping("/add")
    public String createUser(User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        List<Role> roles = userService.getAllRoles();
        model.addAttribute("roles", roles);
        return "user-update";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }
}
