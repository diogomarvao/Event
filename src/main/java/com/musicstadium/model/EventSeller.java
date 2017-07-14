package com.musicstadium.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="EVENTSELLER")
public class EventSeller extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;

//	variaveis
//	@OneToMany(mappedBy="id")
//	private List<Event> event;
	//one to many biderectional
	
	@Column(name="SELLER")
	private String seller;
	
	@Column(name="SELLERURL")
	private String sellerUrl;
	
	@Column(name="PRICE")
	private double price;

//	setter & getter


	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSellerUrl() {
		return sellerUrl;
	}

	public void setSellerUrl(String sellerUrl) {
		this.sellerUrl = sellerUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
//	construtor
	public EventSeller(){
		
	}

//	public List<Event> getEvent() {
//		return event;
//	}
//
//	public void setEvent(List<Event> event) {
//		this.event = event;
//	}
//	
}
