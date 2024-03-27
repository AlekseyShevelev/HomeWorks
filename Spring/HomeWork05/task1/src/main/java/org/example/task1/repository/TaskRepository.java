package org.example.task1.repository;

import org.example.task1.model.Task;
import org.example.task1.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT * FROM tasks WHERE status = :status")
    List<Task> findTasksByStatus(TaskStatus status);

    @Modifying
    @Query("UPDATE tasks SET status = :status WHERE id = :id")
    Task updateTaskStatus(Long id, TaskStatus status);
}
