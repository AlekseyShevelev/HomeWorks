package ru.geekbrains.bookingservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.bookingservice.exceptions.ResourceNotFoundException;
import ru.geekbrains.bookingservice.model.Role;
import ru.geekbrains.bookingservice.model.User;
import ru.geekbrains.bookingservice.model.UserRole;
import ru.geekbrains.bookingservice.repository.RoleRepository;
import ru.geekbrains.bookingservice.repository.UserRepository;
import ru.geekbrains.bookingservice.repository.UserRoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    public User getUserByName(String userName) {
        return userRepository.findByName(userName)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with name: " + userName));
    }

    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }
//TODO
//    public User updateUser(Long userId, User user) {
//        User updatedUser = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
//        updatedUser.setName(user.getName());
//        return userRepository.save(updatedUser);
//    }
//@Transactional
//public void createNewUser(User user, String role) {
//    User u = userRepository.save(user);
//    Role r = roleRepository.findRoleByName(role);
//    u.getRoles().add(r);
//    userRepository.save(u);
//}

    public void deleteUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        userRepository.deleteById(userId);
    }

    public UserRole addRoleToUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + roleId));

        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return userRoleRepository.save(userRole);
    }

    //TODO сохранение с ролями (получение id роли из базы по enum
}
