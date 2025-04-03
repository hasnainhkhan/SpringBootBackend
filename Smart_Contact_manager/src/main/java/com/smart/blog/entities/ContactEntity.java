package com.smart.blog.entities;


import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Blogs")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String blogTitle;
    private String blogType;
    
    @Lob  //  Store full image as a BLOB (Binary Large Object)
    @Column(columnDefinition = "LONGBLOB")  // MySQL, PostgreSQL, or `BLOB` for H2
    private byte[] image;
    @Column(length = 5000)
    private String blogContent;
    
    @Transient  // This prevents MultipartFile from being stored in the DB
    private transient MultipartFile imageFile;
    
    @ManyToOne
    private UserEntity userEntity;


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getBlogTitle() {
		return blogTitle;
	}


	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}


	public String getBlogType() {
		return blogType;
	}


	public void setBlogType(String blogType) {
		this.blogType = blogType;
	}



	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public String getBlogContent() {
		return blogContent;
	}


	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}


	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}


	public ContactEntity() {
	super();
	// this is default constructor
    }

}
