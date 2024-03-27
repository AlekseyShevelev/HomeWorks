package org.example.task2.repository;

import org.example.task2.model.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
}
