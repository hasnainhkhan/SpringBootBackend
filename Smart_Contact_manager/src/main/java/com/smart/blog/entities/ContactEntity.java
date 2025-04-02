package com.smart.blog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Blogs")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String blogTitle;
    private String blogType;
    private String image;
    @Column(length = 5000)
    private String BlogContent;

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


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getBlogContent() {
		return BlogContent;
	}


	public void setBlogContent(String blogContent) {
		BlogContent = blogContent;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	public ContactEntity() {
	super();
	// this is default constructor
    }

}
