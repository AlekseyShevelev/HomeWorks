package ru.geekbrains.homework03.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.homework03.domain.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис обработки данных
 */
@Service
public class DataProcessingService {
    /**
     * Сортировка пользователей по возрасту
     * @param users список пользователей
     * @return отсортированный список пользователей
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрация пользователей по возрасту
     * @param users список пользователей
     * @param age возраст
     * @return отфильтрованный список пользователей
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Расчет среднего возраста пользователей
     * @param users список пользователей
     * @return средний возраст пользователей
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
