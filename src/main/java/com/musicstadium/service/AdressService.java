package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.musicstadium.model.Adress;
import com.musicstadium.repository.AdressRepository;
import com.musicstadium.repository.EntityRepository;
import com.musicstadium.repository.EntityService;

@Named("AdressService")
@RequestScoped
public class AdressService extends EntityService<Adress>{

	@Inject
	private AdressRepository adressRepository;
	
	public List<Adress> showEntities(AdressRepository productRepository){
		List<Adress> list = productRepository.getDbAdress();
		return list;
	}
	
	public void addProduct(Adress adress){
		AdressRepository.addToDb(adress);
	}
	
	public void editProduct(Adress adress){
			AdressRepository.alterInDb(adress);
	}
	
	
	//getter productRepository
	public AdressRepository getAdressRepository(){	
		return adressRepository;
	}
	
}