package com.spring.boot.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.standard.expression.Each;

@Controller
public class UserController {
    
    @GetMapping("/about") // Using @GetMapping for simplicity
    public String userHome(Model model) {
        // Create a list of users
        List<String> users = new ArrayList<>();
        
        for(int i = 1; i<100; i++){
            users.add("++");
            for(int j = 1; j<2; j++) {
        	users.add("Hasnain=> " + i);
        	
        }
        }

        model.addAttribute("name", "Hasnain");
        model.addAttribute("users", users); // ✅ Ensure it matches the Thymeleaf variable

        return "About"; // Make sure you have About.html
    }
}
