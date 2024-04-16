package ru.geekbrains.bookingservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.bookingservice.exceptions.ResourceNotFoundException;
import ru.geekbrains.bookingservice.model.Operation;
import ru.geekbrains.bookingservice.repository.OperationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {
    private final OperationRepository operationRepository;

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Operation getOperationById(Long operationId) {
        return operationRepository.findById(operationId)
                .orElseThrow(() -> new ResourceNotFoundException("Operation not found with id: " + operationId));
    }
}
