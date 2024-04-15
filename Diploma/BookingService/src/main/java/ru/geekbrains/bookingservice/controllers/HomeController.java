package ru.geekbrains.bookingservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
//TODO
	//private final HomeService homeService;
	//private final UserService userService;
	//private final AdminService adminService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("text", "Welcome!");
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/client")
	public String client(Model model) {
		model.addAttribute("text", "Client Page");
		return "client";
	}

	@GetMapping("/manager")
	public String manager(Model model) {
		model.addAttribute("text", "Manager Page");
		return "manager";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("text", "Admin Page");
		return "admin";
	}
}
