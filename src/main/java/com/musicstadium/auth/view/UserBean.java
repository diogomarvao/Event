package com.musicstadium.auth.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.auth.model.User;
import com.musicstadium.auth.service.UserService;

@Named("userBean")
@RequestScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;
	
	User user = new User();
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// adiconar users
	public void addUserToDb(){
		userService.addUser(user);	
	}
	
}