package org.example.rick_and_morty.controllers;

import lombok.RequiredArgsConstructor;
import org.example.rick_and_morty.model.Characters;
import org.example.rick_and_morty.model.Result;
import org.example.rick_and_morty.services.ServiceApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ControllerApi {
    private final ServiceApi serviceApi;

    @GetMapping
    public String getCharacters(Model model) {
        Characters characters = serviceApi.getAllCharacters();
        model.addAttribute("characters", characters);
        return "index";
    }

    @GetMapping("/characters/{id}")
    public String getCharacterInfo(@PathVariable Integer id, Model model) {
        Result result = serviceApi.getCharacterById(id);
        model.addAttribute("result", result);
        return "character";
    }
}
