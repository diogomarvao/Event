package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.model.Adress;
import com.musicstadium.model.Event;
import com.musicstadium.repository.EventRepository;

@Named("eventService")
@RequestScoped
public class EventService extends EntityService<Event>{
	
	@Inject
	private EventRepository eventRepository;
	
public List<Event> showEntities(EventRepository eventRepository){
	List<Event> list = eventRepository.getDbEvent();
	return list;
}                   

public List<Event> showFeatured(){
	List<Event> list = eventRepository.getDbFeatured();
	return list;
}
	
public List<Event> showNextEvent(){
	List<Event> list = eventRepository.getDbNextEvent();
	return list;
}

public List<Event> showAllEvent(){
	List<Event> list = eventRepository.getDbAllEvents();
	return list;
}


// adicionar os dados
	public void addEvent(Event event){
		eventRepository.addToDb(event);
	}

// editar
	public void editEvent(Event event){
		eventRepository.alterInDb(event);
	}

	public EventRepository getEventRepository() {
		return eventRepository;
	}
	

}
