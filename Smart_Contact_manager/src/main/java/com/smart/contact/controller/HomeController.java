package com.smart.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.contact.dao.UserRepository;
import com.smart.contact.entities.UserEntity;


@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository; 
    
    @GetMapping("/test")
    @ResponseBody
    public String Home(){
	
	UserEntity user = new UserEntity();
	user.setName("Hasnain");
	user.setEmail("hhk@gmail.com");
	userRepository.save(user);
        return "This is home controller";
    }
  
}
