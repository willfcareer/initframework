package com.miui.sec.dao.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class User {

	private int id;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<Role>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		// TODO 临时值
		return roles;
	}

	public void addRoles(List<Role> roles) {
		this.roles.addAll(roles);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
