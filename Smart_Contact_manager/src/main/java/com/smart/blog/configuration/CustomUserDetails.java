package com.smart.blog.configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.blog.entities.UserEntity;

public class CustomUserDetails implements UserDetails{

//step 1. Config user Detail
//     2. Adding User Detail Service
//     3. Adding UserDetailServiceImpl
//     4. write security configuration WebsecurityConfigurer
	@Autowired
	private UserEntity userEntity;
	
	public CustomUserDetails(UserEntity userEntity) {
		super();
		this.userEntity = userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userEntity.getRole());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
	    return true; // Change this as per your logic
	}

	@Override
	public boolean isAccountNonLocked() {
	    return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	    return true;
	}

	@Override
	public boolean isEnabled() {
	    return userEntity.isEnabled(); // Assuming your entity has this field
	}



}
