package com.spring.boot.web.dao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "UserDetails")
public class UserEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int UserId;
    
    @Column(name = "Names")
    private String UserName;
    
    @Column(name = "Passwords")
    private String UserPass;
    
    @Column(name = "Emails")
    private String UserEmail;
}
