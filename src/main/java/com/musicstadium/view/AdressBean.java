package com.musicstadium.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.model.Adress;
import com.musicstadium.service.AdressService;

@Named("adressBean")
@RequestScoped
public class AdressBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Adress activeAdress = new Adress();
	

	public void setActiveAdress(Adress activeAdress) {
		this.activeAdress = activeAdress;
	}


	public Adress getActiveAdress() {
		return activeAdress;
	}

	@Inject
	private AdressService adressService;
	
	Adress adress = new Adress();
	
	
//	Adicionar Endereços
	
	
	public void addAdress(){
		adressService.addToDb(adress);
	}
	
	
	
//	editar endereços
	
	public void editAdress(){
		adressService.alterInDb(adress);

	}
	
//	eliminar endreço
	
	public void delAdress(){
		adressService.removeFromDb(adress);
	}
	
	

}
