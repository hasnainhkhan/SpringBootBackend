package com.spring.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.web.dao.UserEntity;
import com.spring.boot.web.services.UserService;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    	
       @PostMapping("/user")	
       public UserEntity SignUp(@RequestBody UserEntity userEntity) {
	   return userService.createUser(userEntity);
	    
       }
       
       @GetMapping("/users")
       public List<UserEntity> getAllData(){
	   
	   List<UserEntity> list = userService.getAllUser();
	   
	   return list;
       }
       
       @PutMapping("/user/{id}")
       public UserEntity updateUser(@RequestBody @PathVariable("id") int id, UserEntity userEntity) {
	 UserEntity user = userService.updateUser(userEntity);
	   return user;
       }
       
       @DeleteMapping("/user")
       public void deleteUser(@RequestBody UserEntity userEntity) {
	   userService.deleteAll(userEntity);
       }
}
