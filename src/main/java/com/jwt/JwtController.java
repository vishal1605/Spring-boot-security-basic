package com.jwt;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jwt.beans.Clinit;
import com.jwt.beans.Role;
import com.jwt.dao.ClinitDao;
import com.jwt.dao.UserDetailsServiceImpl;

@Controller
public class JwtController {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

//	@Autowired
//	private AuthenticationManager authenticationManager;

	@Autowired
	private ClinitDao dao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("title", "Home");
		Clinit client = new Clinit();
		m.addAttribute("clinit", client);
		return "index";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("clinit") Clinit clinit, @ModelAttribute("role") Role role, Model m) {
		clinit.setPassword(encoder.encode(clinit.getPassword()));
		String name = role.getRoleName();
		role.setClinit(clinit);
		System.out.println(name);
		Set<Role> set = new HashSet<Role>();
		set.add(role);
		clinit.setRole(set);
		if (clinit.getIsChecked() == null) {
			return "index";
		} else {

			dao.saveUser(clinit);
		}

		return "redirect:/";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "login";

	}

	@GetMapping("/default")
	public String defaultUrl(Principal principal) {
		String userName = principal.getName();
		String role = null;
		Clinit clinit = dao.getUser(userName);
		Set<Role> set = clinit.getRole();
		for (Role r : set) {
			role = r.getRoleName();
		}
		if (role.equals("USER")) {

			return "redirect:/user/" + userName;
		}
		return "redirect:/admin/" + userName;

	}

}
