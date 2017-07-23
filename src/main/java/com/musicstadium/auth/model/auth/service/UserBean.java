package com.musicstadium.auth.model.auth.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.musicstadium.auth.model.User;

@Named("userBean")
@RequestScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	  private boolean showLoginBt=true;
	  private boolean showUserBt=false;	  
	  boolean loggedIn = false;
	  
	  	public boolean isShowLoginBt() {
		return showLoginBt;
	}

	public void setShowLoginBt(boolean showLoginBt) {
		this.showLoginBt = showLoginBt;
	}

	public boolean isShowUserBt() {
		return showUserBt;
	}

	public void setShowUserBt(boolean showUserBt) {
		this.showUserBt = showUserBt;
	}

	
	private User user = new User();
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void login(){
		FacesMessage message = null;

		RequestContext context = RequestContext.getCurrentInstance();
		
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
			setShowLoginBt(false);
			setShowUserBt(true);
			
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome ", user.getUsername());
			
			
		}else{
			
			loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
			
		}
			
		FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
	}
	
	public void logout(){
		FacesMessage message = null;
		RequestContext context = RequestContext.getCurrentInstance();

			setShowLoginBt(false);
			setShowUserBt(true);
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Good Bye ", user.getUsername());

	
		FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedOut", loggedIn);
	}
	
	
}
