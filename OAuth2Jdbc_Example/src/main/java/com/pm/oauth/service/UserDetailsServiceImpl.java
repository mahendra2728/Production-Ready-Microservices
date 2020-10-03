package com.pm.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pm.oauth.model.CustomUserDetails;
import com.pm.oauth.repository.UserRepository;
import com.pm.rentapp.commons.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User users = userRepository.findByUsername(username);
		if (users == null)
			throw new UsernameNotFoundException("Username not found : " + username);

		CustomUserDetails user = new CustomUserDetails();
		user.setUser(users);
		return user;
	}

}
