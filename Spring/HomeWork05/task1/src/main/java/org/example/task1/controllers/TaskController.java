package org.example.task1.controllers;

import lombok.AllArgsConstructor;
import org.example.task1.model.Task;
import org.example.task1.model.TaskStatus;
import org.example.task1.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

//    @PutMapping("/{id}")
//    public void updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatus status) {
//        taskService.updateTaskStatus(id, status);
//    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatus status) {
        return taskService.updateTaskStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
