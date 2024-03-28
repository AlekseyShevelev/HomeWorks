package org.example.task1.services;

import lombok.AllArgsConstructor;
import org.example.task1.exceptions.TaskNotFoundException;
import org.example.task1.model.Task;
import org.example.task1.model.TaskStatus;
import org.springframework.stereotype.Service;
import org.example.task1.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findTasksByStatus(status);
    }

    public Task updateTaskStatus(Long id, TaskStatus status) {
        Task task = taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
