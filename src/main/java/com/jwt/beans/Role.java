package com.jwt.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user_roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String roleName;
	
	@ManyToOne
	private Clinit clinit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Clinit getClinit() {
		return clinit;
	}

	public void setClinit(Clinit clinit) {
		this.clinit = clinit;
	}

	public Role(int id, String roleName, Clinit clinit) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.clinit = clinit;
	}

	public Role(String roleName, Clinit clinit) {
		super();
		this.roleName = roleName;
		this.clinit = clinit;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", clinit=" + clinit + "]";
	}

	
}
