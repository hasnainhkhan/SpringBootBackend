package com.smart.contact.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart.contact.entities.UserSession;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
public class SessionConttroller {
	
	
	@GetMapping("/session")
	public String setSession(UserSession userSession,HttpSession session) {
		session.setAttribute(userSession.getName(), "Hasnain");
		session.setAttribute(userSession.getEmail(), "hasnain@gmail.coom");
		log.info("Session details : {}",userSession.getName());
		return "Data Saved in Session";
	}
	
	@GetMapping("/sessiondata")
	public HashMap<String, String> getSession(HttpSession session) {
		HashMap<String, String> hmSession = new HashMap<String,String>();
		hmSession.put("userName", session.getAttribute("userName") + " ");
		return hmSession;
	}
}
