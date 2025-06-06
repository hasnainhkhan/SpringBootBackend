package com.smart.contact.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.contact.validation.OnCreate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Users")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "Name must Not Null")
	@Size(min = 5, max = 20, message = "Insert Min 5 and max 20")
	private String name;
	@Column(unique = true) // email column are unique key
	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Insert a valid email!")
	private String email;
	
	@NotNull(message = "Password not be null" , groups = OnCreate.class)
	private String password;
	private String role;
	private boolean enabled;
	private String imageUrl;

	@NotBlank(message = "Insert Something in About Section", groups = OnCreate.class)
	@Column(length = 500) // length are 500 words
	private String about;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userEntity")
	// cascade to create all and delete all MapedBy change permission to create
	// another table
	private List<ContactEntity> contacts = new ArrayList<>();

	
    
 
    
}
