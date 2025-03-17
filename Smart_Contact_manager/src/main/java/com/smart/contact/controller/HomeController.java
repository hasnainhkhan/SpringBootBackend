package com.smart.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.smart.contact.configuration.MsgConfig;
import com.smart.contact.dao.UserRepository;
import com.smart.contact.entities.UserEntity;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
	public String register(@Valid @ModelAttribute("userEntity") UserEntity userEntity, BindingResult result,
			@RequestParam(value = "agrement", defaultValue = "false") boolean agrement, Model model,
			HttpSession session) {

		try {
			// 🚀 1. Check if user accepted Terms & Conditions
			if (!agrement) {
				session.setAttribute("message",
						new MsgConfig("You must accept the Terms & Conditions!", "alert-danger"));
				return "signup";
			}

			// 2. Check for validation errors
			if (result.hasErrors()) {
				log.info("Validation errors: {}", result.getAllErrors());
				model.addAttribute("userEntity", userEntity); // Preserve entered data
				return "signup"; // Show form again with validation messages
			}

			// 3. Save user
			userEntity.setRole("ROLE_USER");
			userEntity.setEnabled(true);
			userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
			userRepository.save(userEntity);

			session.setAttribute("message", new MsgConfig("Registration Successful!", "alert-success"));
			return "login";

		} catch (Exception e) {
			log.error("Error during registration", e);
			session.setAttribute("message", new MsgConfig("Something went wrong: " + e.getMessage(), "alert-danger"));
			return "signup";
		}
	}

	@RequestMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("title", "This is Login Page");
		model.addAttribute("msg", "Hello Plese insert your Cridential");
		return "login";
	}
}
