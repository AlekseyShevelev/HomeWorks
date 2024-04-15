package ru.geekbrains.bookingservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Employee employee;

    @ManyToOne
    Operation operation;

    @Column(name = "service_date", nullable = false)
    private LocalDateTime serviceDate;

    //TODO
    @Column(name = "notice_date")
    private LocalDateTime noticeDate;
}
