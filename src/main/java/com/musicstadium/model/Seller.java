package com.musicstadium.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="SELLER")
public class Seller extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;

//	variaveis
//	@OneToMany(mappedBy="id")
//	private List<Event> event;
//	//one to many biderectional
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SELLERURL")
	private String sellerUrl;
	
	@Column(name="PRICE")
	private double price;

//	setter & getter


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public Seller(){
		
	}

//	public List<Event> getEvent() {
//		return event;
//	}
//
//	public void setEvent(List<Event> event) {
//		this.event = event;
//	}
	
}