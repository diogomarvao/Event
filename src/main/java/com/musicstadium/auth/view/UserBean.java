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
	private User activeUser = new User();
	

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}


	public User getActiveUser() {
		return activeUser;
	}

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
	
// editar adressos
	public void editUserInDb(){
		userService.editUser(activeUser);
	}
	
// eliminar adresso
	public void delUserInDb(User activeUser){
		userService.delEntity(userService.getUserRepository(), activeUser);
	}

	public void login(){
		userService.login(user);
	}

}