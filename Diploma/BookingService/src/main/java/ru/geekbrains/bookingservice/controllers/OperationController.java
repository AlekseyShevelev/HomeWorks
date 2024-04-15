package ru.geekbrains.bookingservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.bookingservice.model.Operation;
import ru.geekbrains.bookingservice.services.OperationService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/operations")
public class OperationController {
    private final OperationService operationService;

    @GetMapping
    public String getOperations(Model model) {
        List<Operation> operations = operationService.getAllOperations();
        model.addAttribute("operations", operations);
        return "operation-list";
    }
}
