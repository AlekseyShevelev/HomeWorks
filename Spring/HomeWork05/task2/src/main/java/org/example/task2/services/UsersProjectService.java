package org.example.task2.services;

import lombok.AllArgsConstructor;
import org.example.task2.exceptions.ResourceNotFoundException;
import org.example.task2.model.Project;
import org.example.task2.model.User;
import org.example.task2.repository.ProjectRepository;
import org.example.task2.repository.UserRepository;
import org.example.task2.repository.UsersProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersProjectService {
    UsersProjectRepository usersProjectRepository;
    ProjectRepository projectRepository;
    UserRepository userRepository;

    /**
     * Получение списка пользователей, связанных с определенным проектом
     *
     * @param projectId идентификатор проекта
     * @return список пользователей
     */
    public List<User> getUsersByProjectId(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + projectId))
                .getUsers().stream().toList();
    }

    /**
     * Получение списка проектов, связанных с определенным пользователем
     *
     * @param userId идентификатор пользователя
     * @return список проектов
     */
    public List<Project> getProjectsByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId))
                .getProjects().stream().toList();
    }

    /**
     * Добавление пользователя к проекту
     *
     * @param projectId идентификатор проекта
     * @param userId идентификатор пользователя
     * @return объект проекта
     */
    public Project addUserToProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + projectId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        project.getUsers().add(user);
        return projectRepository.save(project);
    }

    /**
     * Удаление пользователя из проекта
     *
     * @param projectId идентификатор проекта
     * @param userId идентификатор пользователя
     * @return объект проекта
     */
    public Project removeUserFromProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + projectId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        project.getUsers().remove(user);
        return projectRepository.save(project);
    }
}
