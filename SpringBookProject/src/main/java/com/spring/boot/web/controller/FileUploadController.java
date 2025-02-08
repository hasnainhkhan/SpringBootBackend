package com.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.web.helper.FileUploadHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FileUploadController {
    
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//	
	try {
	if (file.isEmpty()) {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
	}
	if(!file.getContentType().equals("image/jpeg")) {
	    
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request only Jpeg file are allowed");
	 
	}
	boolean f = fileUploadHelper.uploadFile(file);
	if(f) {
	    log.info(this.fileUploadHelper + "**** File Upload Helper");
	    return ResponseEntity.ok("File Uploaded Successfully");
	 }
	} catch(Exception e) {
	    e.printStackTrace();
	}
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		.body("Something Went Wrong ! try again");
    }

    
}
