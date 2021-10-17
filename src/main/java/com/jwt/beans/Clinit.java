package com.jwt.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Clinit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String city;
	private int age;
	
	@Transient
	private String isChecked;
	
	@OneToMany(mappedBy = "clinit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Role> role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Clinit(String name, String password, String city, int age, String isChecked, Set<Role> role) {
		super();
		this.name = name;
		this.password = password;
		this.city = city;
		this.age = age;
		this.isChecked = isChecked;
		this.role = role;
	}

	public Clinit(int id, String name, String password, String city, int age, String isChecked, Set<Role> role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.city = city;
		this.age = age;
		this.isChecked = isChecked;
		this.role = role;
	}

	public Clinit() {
		super();
		// TODO Auto-generated constructor stub
	}


		
}
