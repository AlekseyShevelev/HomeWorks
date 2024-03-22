package ru.geekbrains.homework03.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.homework03.domain.User;

@Service
public class RegistrationService {
    UserService userService;
    DataProcessingService dataProcessingService;
    NotificationService notificationService;

    public RegistrationService(
            UserService userService,
            DataProcessingService dataProcessingService,
            NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        userService.addUser(user);
        notificationService.notifyUser(user);
    }
}
