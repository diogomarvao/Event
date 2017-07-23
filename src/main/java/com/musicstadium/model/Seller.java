package com.musicstadium.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="SELLER")
public class Seller extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;

//	variaveis
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//		      name="event_id",
//		      joinColumns=@JoinColumn(name="EVENT_ID", referencedColumnName="id"),
//		      inverseJoinColumns=@JoinColumn(name="SELLER_ID", referencedColumnName="id"))
	//@JoinColumn(name = "ID" ,  insert="false", update="false")
	@OneToMany(mappedBy="seller")
	private List<Event> event;
	
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

//	@Override
//	public boolean equals(Object seller){
//		return this.name.equals(((Seller) seller).getName());
//	}
	
//	public List<Event> getEvent() {
//		return event;
//	}
//
//	public void setEvent(List<Event> event) {
//		this.event = event;
//	}
	
}
