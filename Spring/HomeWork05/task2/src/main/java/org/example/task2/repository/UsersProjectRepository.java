package org.example.task2.repository;

import org.example.task2.model.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    List<UsersProject> findUsersProjectByUserId(Long id);
}
