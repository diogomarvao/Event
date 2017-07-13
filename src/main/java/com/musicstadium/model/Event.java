package com.musicstadium.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="EVENT")
public class Event extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;

	//	Variaveis
	private String name;
	
	@Column(name="DATE_START")
	private Date dateS;
	
	@Column(name="DATE_END")
	private Date dateF;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Localization")
	private String localization;
	
	@Column(name="Genre")
	private String genre;
	
	
	
	//getter & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateS() {
		return dateS;
	}
	public void setDateS(Date dateS) {
		this.dateS = dateS;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
//	Construtor Event
	public Event(){
		
	}
	
	
}
