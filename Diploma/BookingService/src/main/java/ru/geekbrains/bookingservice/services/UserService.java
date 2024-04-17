package ru.geekbrains.bookingservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.bookingservice.exceptions.ResourceNotFoundException;
import ru.geekbrains.bookingservice.model.Role;
import ru.geekbrains.bookingservice.model.User;
import ru.geekbrains.bookingservice.model.enums.RoleType;
import ru.geekbrains.bookingservice.repository.ReservationRepository;
import ru.geekbrains.bookingservice.repository.RoleRepository;
import ru.geekbrains.bookingservice.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ReservationRepository reservationRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    public void createOrUpdateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        reservationRepository.deleteByUserId(userId);
        userRepository.deleteById(userId);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleByName(RoleType name) {
        return roleRepository.findByName(name);
    }
}
