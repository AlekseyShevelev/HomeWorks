package org.example.task2.controllers;

import lombok.AllArgsConstructor;
import org.example.task2.model.Project;
import org.example.task2.model.User;
import org.example.task2.services.UsersProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UsersProjectController {
    private UsersProjectService usersProjectService;

    /**
     * Получение списка пользователей, связанных с определенным проектом
     *
     * @param projectId идентификатор проекта
     * @return список пользователей
     */
    @GetMapping("/users/{projectId}")
    public List<User> getUsersByProjectId(@PathVariable Long projectId) {
        return usersProjectService.getUsersByProjectId(projectId);
    }

    /**
     * Получение списка проектов, связанных с определенным пользователем
     *
     * @param userId идентификатор пользователя
     * @return список проектов
     */
    @GetMapping("/projects/{userId}")
    public List<Project> getProjectsByUserId(@PathVariable Long userId) {
        return usersProjectService.getProjectsByUserId(userId);
    }

    /**
     * Добавление пользователя к проекту
     *
     * @param projectId идентификатор проекта
     * @param userId идентификатор пользователя
     */
    @PostMapping("/projects/{projectId}/users/{userId}")
    public Project addUserToProject(@PathVariable Long projectId, @PathVariable Long userId) {
        return usersProjectService.addUserToProject(projectId, userId);
    }

    /**
     * Удаление пользователя из проекта
     *
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
    @DeleteMapping("/projects/{projectId}/users/{userId}")
    public Project removeUserFromProject(@PathVariable Long projectId, @PathVariable Long userId) {
        return usersProjectService.removeUserFromProject(projectId, userId);
    }
}
