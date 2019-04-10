package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	
	
	
	//@Column
	@Id
	private int sno;
	
	public Login(int sno) {
		super();
		this.sno = sno;
	}

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	@Column(name="username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
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
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Login() {
		
	}

}
