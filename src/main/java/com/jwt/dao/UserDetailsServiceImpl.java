package com.jwt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.Repository.ClientRepository;
import com.jwt.beans.Clinit;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private ClientRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Clinit clinit = userRepo.findByName(username);
		if(clinit==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new UserDetailsImpl(clinit);
	}

}
