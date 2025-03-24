package com.smart.contact.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.contact.dao.UserRepository;
import com.smart.contact.entities.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/index")
	public String dashboard(Model model , Principal principal) {
		
		String userName = principal.getName();
		
		UserEntity user = userRepository.getUeserByUserName(userName);
		
		model.addAttribute("user",user);
		model.addAttribute("title","User Dashboard");
		return "normal/user_dashboard";
	}
	public String profile() {
		return "";
	}
}
