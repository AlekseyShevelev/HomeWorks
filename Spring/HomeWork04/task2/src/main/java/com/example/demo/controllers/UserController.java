package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Контроллер пользователя
 */
@Controller
@Log
public class UserController {
    private final UserService userService;

    /**
     * Конструктор контроллера пользователя.
     *
     * @param userService сервис пользователя
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получение списка всех пользователей.
     *
     * @param model модель для передачи данных в представление
     * @return представление со списком пользователей
     */
    @GetMapping("/users")
    public String getAll(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Создание пользователя.
     *
     * @param user объект пользователя
     * @return представление для создания пользователя
     */
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    /**
     * Получение данных о новом пользователе
     *
     * @param user объект пользователя
     * @return перенаправление на страницу со списком пользователей
     */
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        log.info("Создан пользователь " + user);
        return "redirect:/users";
    }

    /**
     * Удаление пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     * @return перенаправление на страницу со списком пользователей
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        log.info("Удален пользователь с id=" + id);
        return "redirect:/users";
    }

    /**
     * Изменение пользователя.
     *
     * @param id    идентификатор пользователя
     * @param model модель для передачи данных в представление
     * @return представление для изменения пользователя
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable int id, Model model) {
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Получение измененных данных пользователя
     *
     * @param user объект пользователя
     * @return перенаправление на страницу со списком пользователей
     */
    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        log.info("Обновлен пользователь " + user);
        return "redirect:/users";
    }
}
