package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.musicstadium.model.Adress;
import com.musicstadium.repository.EntityRepository;

@Named("adressService")
@RequestScoped
public class AdressService extends EntityRepository<Adress>{
	
	public List<Adress> getDbAdress() {
		Query query = getDb().createQuery("FROM Adress");
		List<Adress> dbElements = (List<Adress>) query.getResultList();
		return dbElements;
	}
	
	public void addAdress(Adress adress){
		addToDb(adress);
	}
	
	public void editAdress(Adress adress){
		alterInDb(adress);
	}
	
	@Override
	@Transactional
	public void removeFromDb(Adress adress){
		Adress activeAdress = getDb().find(Adress.class, adress.getId());
		getDb().remove(activeAdress);
	}

}