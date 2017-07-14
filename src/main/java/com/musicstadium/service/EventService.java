package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.musicstadium.model.Event;
import com.musicstadium.repository.EntityRepository;

@Named("eventService")
@ApplicationScoped
public class EventService extends EntityRepository<Event>{
	
// vai buscar os dados
	public List<Event> getDbEvent(){
		Query query = getDb().createQuery("FROM Event");
		List<Event> dbElements = (List<Event>) query.getResultList();
		return dbElements;
	}
	
// adicionar os dados
	public void addEvent(Event event){
		addToDb(event);
	}

// editar
	public void editEvent(Event event){
		alterInDb(event);
	}
	
// eliminar
	@Override
	@Transactional
	public void removeFromDb(Event event){
		Event activeEvent = getDb().find(Event.class, event.getId());
		getDb().remove(activeEvent);
	}
}
