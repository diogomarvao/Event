package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import com.musicstadium.model.Adress;
import com.musicstadium.repository.AdressRepository;


@Named("AdressService")
@RequestScoped
public class AdressService extends EntityService<Adress>{

	@Inject
	private AdressRepository adressRepository;
	
	public List<Adress> showEntities(){
		List<Adress> list = adressRepository.getDbAdress();
		return list;
	}
	
public void addAdress(Adress adress){
		
		List<Adress> duplicateList = adressRepository.duplicate(adress);
		if (duplicateList.isEmpty()){
			adressRepository.addToDb(adress);
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Morada ja existe!"));
		}
	}
	
	public void editAdress(Adress adress){
			adressRepository.alterInDb(adress);
	}
	
	
	//getter productRepository
	public AdressRepository getAdressRepository(){	
		return adressRepository;
	}
	
}