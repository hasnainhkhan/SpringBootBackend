package com.smart.contact.controller;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
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
			if (!agrement) {
				throw new Exception("You have not agreed to terms & conditions.");
			}

			// ** Check for validation errors **
			if (result.hasErrors()) {
				log.info("Validation errors: {}", result.getAllErrors());
				session.setAttribute("message",
						new MsgConfig("Validation Error! Please fill all fields.", "alert-danger"));
				return "signup"; // Return signup page if validation fails
			}

			// Set default values
			userEntity.setRole("User_role");
			userEntity.setEnabled(true);

			UserEntity savedUser = userRepository.save(userEntity);
			session.setAttribute("message", new MsgConfig("Data Submitted", "alert-success"));

			return "signup";
		} catch (Exception e) {
			log.error("Error during registration", e);
			session.setAttribute("message", new MsgConfig("Something went wrong: " + e.getMessage(), "alert-danger"));
			UserEntity result1 = this.userRepository.save(userEntity);
			session.setAttribute("message", new MsgConfig("Data Submitted" , "aleart-success"));
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
