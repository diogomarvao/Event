package com.musicstadium.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.musicstadium.model.Adress;
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
	
	private Event event = new Event();
	
	private Adress adressNew;
	
	
	public Adress getAdressNew() {
		return adressNew;
	}
	public void setAdressNew(Adress adressNew) {
		System.out.println(adressNew.getLocal());
		this.adressNew = adressNew;
	}
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
//	adicionar genre
	
	private List<String> selectGenre = new ArrayList<String>(Arrays.asList("Varios", "Pop", "Rock", "Metal", "Hip Hop", "Rap", "Classica", "Opera", "Fado", "Electrónica"));

	public List<String> getSelectGenre() {
		return selectGenre;
	}
	public void setSelectGenre(List<String> selectGenre) {
		this.selectGenre = selectGenre;
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
	public void delEventInDb(Event activeEvent){
		eventService.delEntity(eventService.getEventRepository(), activeEvent);
	}
	
// Fazer print nas tabelas
	public List<Event> getEventList(){
		return eventService.showEntities(eventService.getEventRepository());
	}
	
}
