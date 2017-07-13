package com.musicstadium.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.musicstadium.model.Event;
import com.musicstadium.service.EventService;

@Named("eventBean")
@RequestScoped
public class EventBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Event activeEvent = new Event();
	
	public Event getActiveEvent() {
		return activeEvent;
	}
	public void setActiveEvent(Event activeEvent) {
		this.activeEvent = activeEvent;
	}
		
	@Inject
	private EventService eventService;
	
	Event event = new Event();
	
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	//	adicionar adress
	public void addAdressToEvent(){
		
	}

// adiconar Eventos

	public void addEventToDb(){
		eventService.addEvent(event);	
	}
	
// editar eventos
	public void editEventInDb(){
		eventService.editEvent(activeEvent);
	}
	
// eliminar Evento
	public void delEventInDb(){
		eventService.removeFromDb(activeEvent);
	}
	
// Fazer print nas tabelas
	public List<Event> getEventList(){
		return eventService.getDbEvent();
	}
	
//connections
	
	
}
