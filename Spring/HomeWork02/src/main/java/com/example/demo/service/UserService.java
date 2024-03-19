package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис пользователя
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * Конструктор сервиса пользователя.
     *
     * @param userRepository репозиторий пользователя
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Получение списка всех пользователей.
     *
     * @return список пользователей
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Получение пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     * @return объект пользователя
     */
    public User getOne(int id) {
        return userRepository.getOne(id);
    }

    /**
     * Добавление пользователя.
     *
     * @param user объект пользователя
     * @return объект пользователя
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Удаление пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    /**
     * Изменение пользователя.
     *
     * @param user объект пользователя
     */
    public void updateUser(User user) {
        userRepository.update(user);
    }
}
