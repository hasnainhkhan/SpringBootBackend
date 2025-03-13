package com.smart.contact.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String name;
    private String nickName;
    private String work;
    private String email;
    @Column(unique = true)
    private String phone;
    private String image;
    @Column(length = 1000)
    private String description;

    @ManyToOne
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public int getcId() {
	return cId;
    }

    public void setcId(int cId) {
	this.cId = cId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getNickName() {
	return nickName;
    }

    public void setNickName(String nickName) {
	this.nickName = nickName;
    }

    public String getWork() {
	return work;
    }

    public void setWork(String work) {
	this.work = work;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }


    public ContactEntity() {
	super();
	// this is default constructor
    }

}
