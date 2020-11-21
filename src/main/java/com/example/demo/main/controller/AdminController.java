package com.example.demo.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin/admin")
	public String getAdmin() {
		return "/admin/admin";
	}

}
