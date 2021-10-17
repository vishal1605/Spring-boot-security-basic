package com.jwt.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.jwt.beans.Clinit;
import com.jwt.beans.Role;
@Service
public class UserDetailsImpl implements UserDetails {

	@Autowired
	private Clinit clinit;
	
	public UserDetailsImpl(Clinit clinit) {
		super();
		this.clinit = clinit;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<GrantedAuthority> set = new HashSet<>();
		for(Role role: clinit.getRole()) {
			set.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return clinit.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return clinit.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
