package org.example.task1.controller;

import lombok.RequiredArgsConstructor;
import org.example.task1.service.AdminService;
import org.example.task1.service.HomeService;
import org.example.task1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final HomeService homeService;
	private final UserService userService;
	private final AdminService adminService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("text", homeService.getText());
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
	@GetMapping("/public-data")
	public String user(Model model) {
		model.addAttribute("text", userService.getText());
		return "public-data";
	}
	
	@GetMapping("/private-data")
	public String admin(Model model) {
		model.addAttribute("text", adminService.getText());
		return "private-data";
	}
}
