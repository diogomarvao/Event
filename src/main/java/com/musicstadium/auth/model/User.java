package com.musicstadium.auth.model;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Table;
import com.musicstadium.model.Entity;

@javax.persistence.Entity
@Table(name="USER")
public class User extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	
	
	public String getUsername(){
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
	
	
//	construtor
	public User(){
		
	}
	
}