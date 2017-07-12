package com.musicstadium.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="EVENTSELLER")
public class EventSeller extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;

//	variaveis
	@Column(name="EVENT ID")
	private Integer eventId;
	
	@Column(name="SELLER")
	private String seller;
	
	@Column(name="SELLERURL")
	private String sellerUrl;
	
	@Column(name="PRICE")
	private double price;

//	setter & getter
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

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
	
}
