package com.musicstadium.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.musicstadium.model.Event;

@Named("eventRepository")
@ApplicationScoped
public class EventRepository extends EntityRepository<Event>{
	
	// vai buscar os dados
		public List<Event> getDbEvent(){
			Query query = getDb().createQuery("FROM Event");
			List<Event> dbElements = (List<Event>) query.getResultList();
			return dbElements;
		}
		
		// eliminar
		@Override
		@Transactional
		public void removeFromDb(Event event){
			Event activeEvent = getDb().find(Event.class, event.getId());
			getDb().remove(activeEvent);
		}	
	
}
