package com.smart.contact.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
public class SessionConttroller {
	
	@GetMapping("/session")
	public String setSession(@RequestParam String value,HttpSession session) {
		session.setAttribute("userName", "Hasnain");
		session.setAttribute("userEmail", "Hasnain");
		session.setAttribute("userNumber", "Hasnain");
		session.setAttribute("userDOB", "Hasnain");
		session.setAttribute("userPaswword", "Hasnain");
		log.info(session.getAttribute("userName")+" ");
		return "Data Saved in Session";
	}
	
	@GetMapping("/sessiondata")
	public HashMap<String, String> getSession(HttpSession session) {
		HashMap<String, String> hmSession = new HashMap<String,String>();
		hmSession.put("userName", session.getAttribute("userName") + " ");
		return hmSession;
	}
}
