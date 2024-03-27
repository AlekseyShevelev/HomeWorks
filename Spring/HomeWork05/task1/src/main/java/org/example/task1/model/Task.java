package org.example.task1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    public Task() {
        this.status = TaskStatus.NOT_STARTED;
        this.createDate = LocalDateTime.now();
    }
}
