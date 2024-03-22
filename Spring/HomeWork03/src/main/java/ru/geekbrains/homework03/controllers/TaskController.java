package ru.geekbrains.homework03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.homework03.domain.User;
import ru.geekbrains.homework03.services.DataProcessingService;
import ru.geekbrains.homework03.services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер задач
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Сортировка пользователей по возрасту
     * @return отсортированный список пользователей
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge(userService.getUsers());
    }

    /**
     * Фильтрация пользователей по возрасту
     * @param age возраст
     * @return отфильтрованный список пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return dataProcessingService.filterUsersByAge(userService.getUsers(), age);
    }

    /**
     * Расчет среднего возраста пользователей
     * @return средний возраст пользователей
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge(userService.getUsers());
    }
}
