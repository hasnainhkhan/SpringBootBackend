package com.spring.boot.web.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.boot.web.dao.UserEntity;
import com.spring.boot.web.services.UserService;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    	
       @PostMapping("/user")	
       public ResponseEntity<UserEntity>SignUp(@RequestBody UserEntity userEntity) {
	      try{
		  UserEntity data =  userService.createUser(userEntity);
		  return ResponseEntity.status(HttpStatus.CREATED).body(data);
		  } catch(Exception e) {
		      e.printStackTrace();
		      return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }
	  }
	  
	   
       
       @GetMapping("/users")
       public ResponseEntity<List<UserEntity>> getAllData(){
	   try {
	       List<UserEntity> list = userService.getAllUser();
	       return ResponseEntity.status(HttpStatus.OK).body(list);
	   }catch (Exception e) {
	       e.printStackTrace();
	       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
       }
	   
//       @PutMapping("/user/{id}")
//       public ResponseEntity<UserEntity> updateUser(@RequestBody @PathVariable("id") int id, UserEntity userEntity) {
//	 UserEntity user = userService.updateUser(userEntity);
//	   return user;
//       }
       
       @DeleteMapping("/user")
       public ResponseEntity<Void> deleteUser(@RequestBody UserEntity userEntity) {
	   try {
	   userService.deleteAll(userEntity);
	   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	   }catch(Exception e) {
	   e.printStackTrace();
	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
       }
}
