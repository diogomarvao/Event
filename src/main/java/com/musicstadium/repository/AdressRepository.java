package com.musicstadium.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.musicstadium.model.Adress;

@Named("adressRepository")
@ApplicationScoped
public class AdressRepository extends EntityRepository<Adress>{

	public List<Adress> getDbAdress() {
		Query query = getDb().createQuery("FROM Adress");
		List<Adress> dbElements = (List<Adress>) query.getResultList();
		return dbElements;
	}
	
	public List<Adress> duplicate (Adress adress){
		String s = adress.getName();
		Query query = getDb().createQuery("SELECT c FROM Adress AS c WHERE c.name = :name ");
		query.setParameter("name",s);
		List<Adress> dbElements = (List<Adress>) query.getResultList();
		return dbElements;
	}
	
	@Override
	@Transactional
	public void removeFromDb(Adress adress){
		Adress activeAdress = getDb().find(Adress.class, adress.getId());
		getDb().remove(activeAdress);
	}

}


