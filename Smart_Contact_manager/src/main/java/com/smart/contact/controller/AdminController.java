package com.smart.contact.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.smart.contact.validation.*;

import jakarta.transaction.Transactional;

import com.smart.contact.dao.UserRepository;
import com.smart.contact.entities.UserEntity;

@Controller
@Transactional
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/index")
	public String dashboard(Model model) {
		model.addAttribute("title", "Admin Index");
		return "admin/index";
	}
	@RequestMapping("/users")
	public String usersInfo(Model model) {
		
		List<UserEntity> users = userRepository.findAll()
		        .stream()
		        .filter(user -> "ROLE_USER".equals(user.getRole()))
		        .toList();
		model.addAttribute("users",users);
		model.addAttribute("title","Users Information");
		return "admin/users.html";
	}
	@PostMapping("/users/toggleStatus")
	public String toggleUserStatus(@RequestParam("id") Integer id) {
	    UserEntity user = userRepository.findById(id)
	                                    .orElseThrow(() -> new RuntimeException("User not found"));

	    // Toggle Status
	    user.setEnabled(!user.isEnabled());
	    userRepository.save(user);

	    return "redirect:/admin/users"; // Redirect back to the user list
	}
	
	//search button controller
	@GetMapping("/users/search")
	public String searchUsers(@RequestParam("keyword") String keyword, Model model) {
	    List<UserEntity> users;
	    if (keyword != null && !keyword.isEmpty()) {
	        users = userRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword);
	    } else {
	        users = userRepository.findAll();
	    }

	    if (users.isEmpty()) {
	        model.addAttribute("message", "No Users found for: " + keyword);
	    }
	    
	    model.addAttribute("users", users);
	    return "admin/users.html";
	}
	
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        UserEntity user = userRepository.findById(id)
                      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "/admin/edit-user"; // Thymeleaf template
    }
    @PostMapping("/update/{id}")
    public String updateUser(@Validated(OnUpdate.class) @PathVariable Integer id, @ModelAttribute UserEntity user) {
        user.setId(id); // Ensure the correct ID
        
        UserEntity existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found")); //get all data of Entity
        
        if (user.getName() != null && !user.getName().isEmpty()) {
            existingUser.setName(user.getName());
        }
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            existingUser.setEmail(user.getEmail());
        }
        // Update enabled status
        existingUser.setEnabled(user.isEnabled());
        
        userRepository.save(existingUser);
        
        return "redirect:/admin/users"; // Redirect to user list
    }
    
    //delete user controller
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        // Check if user exists
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")); 

        // Delete user
        userRepository.delete(existingUser);

        return "redirect:/admin/users"; // Redirect to user list after deletion
    }

	

}
