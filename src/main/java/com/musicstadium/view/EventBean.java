package com.musicstadium.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
	
	private List<String> genreList = new ArrayList<String>();
	
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
	
//	adicionar genre
	
//	public List<String> selectGenre(){
//	genreList.addAll(Arrays.asList("Varios", "Pop", "Rock", "Metal", "Hip Hop", "Rap", "Classica", "Opera", "Fado", "Electrónica" ));
//	return genreList;
//	}
//	public List<String> getGenreList() {
//		return genreList;
//	}
//	public void setGenreList(List<String> genreList) {
//		this.genreList = genreList;
//	}

//	conversores
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

// adiconar Eventos

	public void addEventToDb(){
		eventService.addEvent(event);	
	}
	
// editar eventos
	public void editEventInDb(){
		eventService.editEvent(activeEvent);
	}
	
// eliminar Evento
	public void delEventInDb(Event activeEvent){
		eventService.delEntity(eventService.getEventRepository(), activeEvent);
	}
	
// Fazer print nas tabelas
	public List<Event> getEventList(){
		return eventService.showEntities(eventService.getEventRepository());
	}
	
//connections
	
	
}
