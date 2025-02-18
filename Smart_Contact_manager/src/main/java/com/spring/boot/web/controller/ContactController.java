package com.spring.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    
    @GetMapping("/login")
    public String login() {
	System.out.println("form , html printed");
	return "form";
    }
}
