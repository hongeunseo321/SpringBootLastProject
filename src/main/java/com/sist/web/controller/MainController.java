package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	// => 데이터베이스
	@GetMapping("/main")
	public String main_page(Model model) {
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
	}
}
