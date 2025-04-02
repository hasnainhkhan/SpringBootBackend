package com.smart.blog.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.blog.dao.ContactRepository;
import com.smart.blog.dao.UserRepository;
import com.smart.blog.entities.ContactEntity;
import com.smart.blog.entities.UserEntity;
import com.smart.blog.validation.OnCreate;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

	private static final String UPLOAD_DIR = "uploads/";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {

		String userName = principal.getName();

		UserEntity user = userRepository.getUeserByUserName(userName);

		model.addAttribute("user", user);
		model.addAttribute("title", "User Dashboard");
		return "normal/user_dashboard";
	}

	@RequestMapping("/createblog")
	public String blogpost() {
		return "normal/createblog";
	}

	@PostMapping("/postblog")
    public String createBlog(@ModelAttribute ContactEntity blog, 
                             @RequestParam("imageFile") MultipartFile imageFile,
                             Model model) {

        // Generate unique file name
        String imageFileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        File uploadPath = new File(UPLOAD_DIR);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        try {
            imageFile.transferTo(new File(UPLOAD_DIR + imageFileName));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }

        // Save image filename in BlogEntity
        blog.setImage(imageFileName);
        contactRepository.save(blog);

        // Fetch all blogs for display
        List<ContactEntity> blogs = contactRepository.findAll();
        model.addAttribute("blogs", blogs);

        return "normal/user_dashboard";
    }

}
