package com.smart.contact.configuration;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.contact.entities.UserEntity;

public class CustomUserDetails implements UserDetails{

	
	private UserEntity userEntity;
	
	public CustomUserDetails(UserEntity userEntity) {
		super();
		this.userEntity = userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
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
