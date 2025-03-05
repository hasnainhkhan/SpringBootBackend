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
			@RequestParam(value = "agrement", defaultValue = "false") boolean agrement, Model model,
			HttpSession session) {
		try {
			if (!agrement) {
				System.out.println("You have not agreed t&c");
				throw new Exception("You have not agreed t&c");
			}

			userEntity.setRole("User_role");
			userEntity.setEnabled(true);
			model.addAttribute("userEntity", userEntity);
			System.out.println("UserEntity" + userEntity);

			UserEntity result = this.userRepository.save(userEntity);
			session.setAttribute("message", new MsgConfig("Data Submitted" , "aleart-success"));
			
			return "signup";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new MsgConfig("Something went wrong" + e.getMessage(), "aleart-danger"));
			
			return "signup";
			
		}
		
		
	}

//    @RequestMapping(value = "/submit", method = RequestMethod.POST) 
//    public String submit(@Valid @ModelAttribute("userEntity") UserEntity userEntity, BindingResult result) { 
//        if (result.hasErrors()) { 
//            return "userEntity"; 
//        } 
//        else { 
//            return "summary"; 
//        } 
//    }


	@RequestMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("title", "This is Login Page");
		model.addAttribute("msg", "Hello Plese insert your Cridential");
		return "login";
	}

}
