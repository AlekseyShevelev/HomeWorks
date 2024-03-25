package org.example.task1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Controller
public class TodayController {
    @GetMapping("/today")
    public String getToday(Model model) {
        model.addAttribute("date", LocalDate.now()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        model.addAttribute("time", LocalTime.now()
                .format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        return "today";
    }

}
