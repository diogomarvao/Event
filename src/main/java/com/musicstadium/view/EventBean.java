package com.musicstadium.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.musicstadium.model.Adress;
import com.musicstadium.model.Event;
import com.musicstadium.model.Seller;
import com.musicstadium.repository.EventRepository;
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
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
//	adressnew
	
	private Adress adressNew;

	public Adress getAdressNew() {
		return adressNew;
	}
	public void setAdressNew(Adress adressNew) {
		System.out.println(adressNew.getLocal());
		this.adressNew = adressNew;
	}

//	sellernew
	private Seller sellerNew;
	
	public Seller getSellerNew() {
		return sellerNew;
	}
	public void setSellerNew(Seller sellerNew) {
		this.sellerNew = sellerNew;
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
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento criado com sucesso", null));
	}
	
// editar eventos
	public void editEventInDb(){
		System.out.println(activeEvent.getAdress());	
		System.out.println(activeEvent.getSeller());
		System.out.println(activeEvent.getId());
		eventService.editEvent(activeEvent);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento editado com sucesso", null));
	}
	
// eliminar Evento
	public void delEventInDb(Event activeEvent){
		eventService.delEntity(eventService.getEventRepository(), activeEvent);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento eliminado com sucesso", null));
	}
	
// Fazer print nas tabelas
	public List<Event> getEventList(){
		return eventService.showEntities(eventService.getEventRepository());
	}
	
	public List<Event> getFeaturedList(){
		List<Event> featuredList = new ArrayList<Event>();
		for(int i =0; i<eventService.showFeatured().size(); i++){
			if(Calendar.getInstance().getTime().before(eventService.showFeatured().get(i).getDateS())){
				featuredList.add(eventService.showFeatured().get(i));
			}	
		}
		return featuredList;
		
//		return eventService.showFeatured();
	}
	
	public List<Event> getNextEvents(){
		List<Event> nextEvents = new ArrayList<Event>();
		for(int i =0; i<getEventList().size(); i++){
			if(Calendar.getInstance().getTime().before(getEventList().get(i).getDateS())){
				nextEvents.add(getEventList().get(i));
			}	
		}
		return nextEvents;
	}
	
	public long daysLeft(Event event){
//		LocalDate endofCentury = LocalDate.of(2014, 01, 01);
//		LocalDate now = LocalDate.now();
//
//		Period diff = Period.between(endofCentury, now);
		    
		    
		    
		long eventDay = event.getDateS().getTime();
		System.out.println(eventDay);
		long today = Calendar.getInstance().getTime().getTime();
		long daysLeft = eventDay - today;
		
		return daysLeft;
	}
}
