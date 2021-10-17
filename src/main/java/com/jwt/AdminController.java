package com.jwt;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.jwt.beans.Clinit;
import com.jwt.dao.ClinitDao;

@Controller
public class AdminController {
	
	@Autowired
	private ClinitDao dao;
	
	@ModelAttribute
	public void userCommonData(Model m, Principal principal) {
		String userName=principal.getName();
		System.out.println(userName);
		Clinit clinit = dao.getUser(userName);
		m.addAttribute("allDetails", clinit);
	}
	
	@GetMapping("/admin/{name}")
	public String userHome(@PathVariable("name") String name, Model m) {
//		m.addAttribute("myName", name);
		return "admin/admin";
		
	}


}
