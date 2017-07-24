package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
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
		adressRepository.addToDb(adress);
	}
	
	public void editAdress(Adress adress){
			adressRepository.alterInDb(adress);
	}
	
	
	//getter productRepository
	public AdressRepository getAdressRepository(){	
		return adressRepository;
	}
	
}