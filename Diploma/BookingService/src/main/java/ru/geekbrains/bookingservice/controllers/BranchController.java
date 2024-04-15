package ru.geekbrains.bookingservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.bookingservice.model.Branch;
import ru.geekbrains.bookingservice.services.BranchService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/branches")
public class BranchController {
    private final BranchService branchService;

    @GetMapping
    public String getAllBranches(Model model) {
        List<Branch> branches = branchService.getAllBranches();
        model.addAttribute("branches", branches);
        return "branch-list";
    }
}
