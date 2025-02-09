package com.spring.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class UserController {
    
    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String userHome(Model model) {
	
	model.addAttribute("name","Hasnain");	
	return "About.html";
    }
}
