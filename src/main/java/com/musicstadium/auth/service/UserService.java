package com.musicstadium.auth.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.auth.model.User;
import com.musicstadium.auth.repository.UserRepository;
import com.musicstadium.service.EntityService;

	@Named("userService")
	@RequestScoped
	public class UserService extends EntityService<User>{

		@Inject
		private UserRepository userRepository;
		
		public List<User> showEntities(){
			List<User> list = userRepository.getDbUser();
			return list;
		}
		
		public void addUser(User user){
			List<User> duplicateList = userRepository.duplicate(user);
			if (duplicateList.isEmpty()){
				userRepository.addToDb(user);
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Nome de Utilizador indisponivel!"));
			}
		}
		
		public void login(User user){
			List<User> duplicateList = userRepository.duplicate(user);
			if (duplicateList.isEmpty()){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Utilizador Invalido!"));
			}else{
				if(duplicateList.get(0).getPassword() == user.getPassword()){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Olá!!", "Bem Vindo "+ user.getUsername() + "!"));
				}else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Password Invalida!"));
				}
			}
		}
		
		public void editUser(User user){
				userRepository.alterInDb(user);
		}
		
		
		//getter productRepository
		public UserRepository getUserRepository(){	
			return userRepository;
		}
		
	}

