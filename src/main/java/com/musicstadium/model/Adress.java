package com.musicstadium.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="ADRESS")
public class Adress extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

//	variaveis
	
	@OneToMany(mappedBy="adress")
	private List<Event> event;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CODIGOPOSTAL")
	private String codigoPostal;
	
	@Column(name="NOME")
	private String name;
	
	@Column(name="LOCAL")
	private String local;
	
//	setter e getter
	
	
	public String getStreet() {
		return street;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
	    return String.valueOf(this.getLocal());
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
//	construtor
	public Adress(){
		
	}
	
	@Override
	public boolean equals(Object adress){
		return this.name.equals(((Adress) adress).getName());
	}
	
}
