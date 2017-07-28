package com.musicstadium.auth.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.auth.model.User;
import com.musicstadium.auth.service.UserService;

@Named("sessionBean")
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private User activeUser = new User();
	
	@Inject
	private UserService userService;
	
	User user = new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}

	public User getActiveUser() {
		if(activeUser.getId() == null)
			return null;
			else{
				return activeUser;
			}
	}
	
	public void login(){
		setActiveUser(userService.login(user));
	}
	
	public void logout(){
		setActiveUser(null);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
