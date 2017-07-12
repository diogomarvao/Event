package com.musicstadium.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

//	setter & getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
//	construtor
	public Entity(){
		
	}
}
