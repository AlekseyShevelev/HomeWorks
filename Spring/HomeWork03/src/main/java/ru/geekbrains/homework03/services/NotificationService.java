package ru.geekbrains.homework03.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.homework03.domain.User;

/**
 * Сервис нотификации
 */
@Service
public class NotificationService {
    /**
     * Нотификация создания пользователя
     * @param user объект пользователя
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
}
