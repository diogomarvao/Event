package com.musicstadium.repository;

import com.musicstadium.model.Entity;

public class EntityService <E extends Entity> {
	
	public void addEntity(EntityRepository<E> entityList, E entity){
		entityList.addToDb(entity);
	}
	
	public void delEntity(EntityRepository<E> entityList, E entity){
		entityList.removeFromDb(entity);
	}
	
	public void editEntity(EntityRepository<E> entityList, E entity){
		entityList.alterInDb(entity);
	}
	
}
