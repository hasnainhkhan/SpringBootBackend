package com.smart.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/index")
	public String dashboard(Model model) {
		model.addAttribute("title", "Admin Index");
		return "admin/index";
	}
}
