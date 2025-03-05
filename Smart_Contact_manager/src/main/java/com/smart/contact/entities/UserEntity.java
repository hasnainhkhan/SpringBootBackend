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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Users") @ToString
@Getter @Setter @NoArgsConstructor 
public class UserEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotBlank(message = "Name must Not Null")
    private String name;
    @Column(unique = true) //email column are unique key 
    @Email(message = "Insert Valid Email!! Email shouldn't blank")
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    private String imageUrl;
    
    @Column(length = 500) // length are 500 words
    private String about;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy = "userEntity") 
    // cascade to create all and delete all MapedBy change permission to create another table
    private List<ContactEntity> contacts = new ArrayList<>();
    
    
}
