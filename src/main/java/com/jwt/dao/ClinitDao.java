package com.jwt.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jwt.Repository.ClientRepository;
import com.jwt.Repository.RoleRepository;
import com.jwt.beans.Clinit;
import com.jwt.beans.Role;
@Service
public class ClinitDao {
	
	@Autowired
	private ClientRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public Clinit saveUser(Clinit clinit) {
		Clinit save = userRepo.save(clinit);
		
		return save;		
	}
	
	public Clinit getUser(String name) {
		Clinit clinit = userRepo.findByName(name);
		return clinit;
	}

}
