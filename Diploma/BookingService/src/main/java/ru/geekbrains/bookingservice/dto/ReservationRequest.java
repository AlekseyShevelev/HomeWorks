package ru.geekbrains.bookingservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationRequest {
    private Long userId;
    private Long employeeId;
    private Long operationId;
    private LocalDateTime serviceDate;
}
