package org.example.task1.repository;

import org.example.task1.model.Task;
import org.example.task1.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.status = :status")
    List<Task> findTasksByStatus(@Param("status") TaskStatus status);

//    @Modifying
//    @Query("UPDATE Task t SET t.status = :status WHERE t.id = :id")
//    void updateTaskStatus(@Param("id") Long id, @Param("status") TaskStatus status);
}
