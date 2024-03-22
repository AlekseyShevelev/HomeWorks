package ru.geekbrains.homework03.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.homework03.domain.User;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
}
