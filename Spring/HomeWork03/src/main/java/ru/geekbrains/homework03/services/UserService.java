package ru.geekbrains.homework03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework03.domain.User;
import ru.geekbrains.homework03.repository.UserRepository;

import java.util.List;

/**
 * Сервис пользователя
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private final NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Создание пользователя
     * @param name имя пользователя
     * @param age возраст пользователя
     * @param email email пользователя
     * @return объект пользователя
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notificationService.notifyUser(user);

        return user;
    }

    /**
     * Добавление пользователя
     * @param user объект пользователя
     */
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    /**
     * Получение списка пользователей
     * @return список пользователей
     */
    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
