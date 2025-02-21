package com.smart.contact.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter @Setter @NoArgsConstructor 
public class UserEntity {
    
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
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY) // cascade to create all and delete all
    private List<ContactEntity> contacts = new ArrayList<>();
}
