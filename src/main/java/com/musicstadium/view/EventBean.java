package com.musicstadium.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

	
	
	
	
}
