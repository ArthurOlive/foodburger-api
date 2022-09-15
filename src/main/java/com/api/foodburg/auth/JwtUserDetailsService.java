package com.api.foodburg.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.foodburg.config.UserCustomDetails;
import com.api.foodburg.models.UserSystem;
import com.api.foodburg.services.UserService;

import javax.transaction.Transactional;


@Service
@Transactional
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserSystem user = userService.getByUsername(email);
		
		if (user != null) {
			return new UserCustomDetails(user);
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
	}
    
}