package ru.geekbrains.homework03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework03.domain.User;
import ru.geekbrains.homework03.services.RegistrationService;

import java.util.List;

/**
 * Контроллер пользователя
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService registrationService;

    /**
     * Получение списка пользователей
     * @return список пользователей
     */
    @GetMapping
    public List<User> userList() {
        return registrationService
                .getUserService()
                .getUsers();
    }

    /**
     * Добавление пользователя из тела запроса
     * @param user объект пользователя
     * @return сообщение о добавлении пользователя
     */
    @PostMapping("/body")
    public String addUserFromBody(@RequestBody User user) {
        registrationService.getUserService().addUser(user);
        return "User added from body!";
    }

    /**
     * Добавление пользователя из параметров запроса
     * @param name имя пользователя
     * @param age возраст пользователя
     * @param email email пользователя
     * @return сообщение о добавлении пользователя
     */
    @PostMapping("/user")
    public String addUserFromParam(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String email) {
        registrationService.processRegistration(name, age, email);
        return "User added from parameters!";
    }
}
