package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.musicstadium.model.EventSeller;
import com.musicstadium.repository.EntityRepository;


@Named("eventSellerService")
@RequestScoped
public class EventSellerService extends EntityRepository<EventSeller>{
	
	//vai buscar os dados e coloca numa tabela 
	public List<EventSeller> getDbEventSeller() {
		Query query = getDb().createQuery("FROM EventSeller");
		List<EventSeller> dbElements = (List<EventSeller>) query.getResultList();
		return dbElements; 
	}
	
	
	//adicionar
	public void addEventSeller(EventSeller eventSeller){
		addToDb(eventSeller);
	}
	
	//editar
	public void editEventSeller(EventSeller eventSeller){
		alterInDb(eventSeller);
	}
	
	//eliminar 
	
	public void removethisEventSeller(EventSeller eventSeller) {
		removeFromDb(eventSeller);
	}
}
