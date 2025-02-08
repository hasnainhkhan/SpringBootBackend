package com.spring.boot.web.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileUploadHelper {

//    public final String Upload_DIR = "C:\\Users\\Hasnain Haidar\\Documents\\workspace-spring-tool-suite-4-4.19.0.RELEASE\\SpringBookProject\\src\\main\\resources\\static\\Images";
    public final String Upload_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
    
    public FileUploadHelper() throws IOException{
	
    }
    
    public boolean uploadFile(MultipartFile multipartFile) {
	boolean f = false;
	try {
	    
//	    InputStream is = multipartFile.getInputStream();
//	    byte data [] = new byte[is.available()];
//	    is.read(data);
//	    FileOutputStream fos = new FileOutputStream
//		    (Upload_DIR+File.separator + multipartFile
//			    .getOriginalFilename());
//	   fos.write(data);
//	   
//	   fos.flush();
//	   fos.close();
	    
	   Files.copy(multipartFile.getInputStream(),Paths.get(Upload_DIR+File.separator + multipartFile.getOriginalFilename()) ,StandardCopyOption.REPLACE_EXISTING);
	   f=true;
	    

	} catch (Exception e) {
	    
	    e.printStackTrace();
	}
	return f;
    }
    
}
