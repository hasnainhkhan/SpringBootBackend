package com.smart.contact.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.contact.dao.UserRepository;
import com.smart.contact.entities.UserEntity;

public class UsserDetatilsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity users = userRepository.getUeserByUserName(username);
		if(users == null) {
			throw new UsernameNotFoundException("Could not found this user");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(users);
		
		return customUserDetails;
	}

}
