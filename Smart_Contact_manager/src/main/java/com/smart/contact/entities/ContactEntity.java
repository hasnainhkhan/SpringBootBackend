package com.smart.contact.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter @Setter @NoArgsConstructor 
public class ContactEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(unique = true) //email column are unique key 
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    private String imageUrl;
    
    @Column(length = 500) // length are 500 words
    private String about;
}
