package com.musicstadium.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="ADRESS")
public class Adress implements Serializable{

	private static final long serialVersionUID = 1L;

//	variaveis
	@Column(name="STREET")
	private String street;
	
	@Column(name="CP4")
	private Integer cp4;
	
	@Column(name="CP3")
	private Integer cp3;
	
	@Column(name="LOCAL")
	private String local;
	
//	setter e getter
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getCp4() {
		return cp4;
	}

	public void setCp4(Integer cp4) {
		this.cp4 = cp4;
	}

	public Integer getCp3() {
		return cp3;
	}

	public void setCp3(Integer cp3) {
		this.cp3 = cp3;
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
	
	
}
