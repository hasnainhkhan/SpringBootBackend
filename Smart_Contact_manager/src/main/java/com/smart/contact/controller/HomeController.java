package com.smart.contact.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.contact.dao.UserRepository;
import com.smart.contact.entities.UserEntity;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("pname", "Smart Contact Manager");
		model.addAttribute("title", "Home~Smart Contact Manager");
//		model.addAttribute("copyright","© 2025 Smart Contact Manager, Inc");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About~Smart Contact Manager");
		return "about";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("tittle", "Signup~Smart Contact Manager");
		model.addAttribute("userEntity", new UserEntity());
		return "signup";
	}

	// registering user
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userEntity") UserEntity userEntity,
			@RequestParam(value = "agrement", defaultValue = "false") boolean agrement, Model model) {
		if (!agrement) {
		}

		userEntity.setRole("User_role");
		userEntity.setEnabled(true);
		model.addAttribute("userEntity", userEntity);
		System.out.println("UserEntity" + userEntity);

		UserEntity result = this.userRepository.save(userEntity);
		return "signup";

	}
	
	@RequestMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("title","This is Login Page");
		model.addAttribute("msg","Hello Plese insert your Cridential");
		return "login";
	}
}
