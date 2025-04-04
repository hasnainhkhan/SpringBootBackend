package com.smart.blog.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.blog.dao.ContactRepository;
import com.smart.blog.dao.UserRepository;
import com.smart.blog.entities.ContactEntity;
import com.smart.blog.entities.UserEntity;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

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
	public String blogpost(Model model) {
		model.addAttribute("contactEntity", new ContactEntity());
		return "normal/createblog";
	}

	@PostMapping("/blogpost")
	public String createBlog(@RequestParam("blogTitle") String blogTitle, @RequestParam("blogType") String blogType,
			@RequestParam("blogContent") String blogContent, @RequestParam("image") MultipartFile imageFile,
			Model model) {

		ContactEntity contactEntity = new ContactEntity();
		contactEntity.setBlogTitle(blogTitle);
		contactEntity.setBlogType(blogType);
		contactEntity.setBlogContent(blogContent);

		try {
			if (!imageFile.isEmpty()) {
				contactEntity.setImage(imageFile.getBytes()); // Convert MultipartFile to byte[]
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to process image", e);
		}

		contactRepository.save(contactEntity);
		model.addAttribute("message", "Blog saved successfully!");

		return "normal/blogslist";
	}

	@RequestMapping("/blogslist")
	public String bloglist(Model model) {
		List<ContactEntity> blogs = contactRepository.findAll().stream().toList();
		model.addAttribute("blogs", blogs);
		model.addAttribute("title", "Users Information");
		return "normal/blogslist";
	}

	@GetMapping("/images/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable int id) {
		Optional<ContactEntity> blog = contactRepository.findById(id);

		if (blog.isPresent() && blog.get().getImage() != null) {
			byte[] imageBytes = blog.get().getImage(); // FIXED: Use getImage()

			log.info("File content size: {}", imageBytes.length);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(determineImageMediaType(imageBytes)); // Detect image type

			return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
		}

		return ResponseEntity.notFound().build();
	}

	// ✅ Fix MIME Type Detection
	private MediaType determineImageMediaType(byte[] imageBytes) {
		String mimeType = "image/jpeg"; // Default MIME type

		try {
			String detectedType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(imageBytes));
			if (detectedType != null) {
				mimeType = detectedType;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return MediaType.parseMediaType(mimeType);
	}

	// get single element
	@GetMapping("/blogs/{id}")
	public String getsingleblog(@PathVariable int id, Model model) {
		Optional<ContactEntity> contactEntity = contactRepository.findById(id);

		model.addAttribute("blogTitle", contactEntity.get().getBlogTitle());
		model.addAttribute("blogContent", contactEntity.get().getBlogContent());
		contactRepository.findById(id);
		return "blog";
	}
	
	@PostMapping("/blogs/delete/{id}")
	public String deleteblog(@PathVariable int id) {
		 ContactEntity existingUser = contactRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));
		contactRepository.delete(existingUser);
		return "blogslist";
	}

}
