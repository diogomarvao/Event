package com.musicstadium.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.musicstadium.model.Seller;

@Named("sellerRepository")
@ApplicationScoped
public class SellerRepository extends EntityRepository<Seller>{
	
	//vai buscar os dados e coloca numa tabela 
	public List<Seller> getDbSeller() {
		Query query = getDb().createQuery("FROM Seller");
		List<Seller> dbElements = (List<Seller>) query.getResultList();
		return dbElements; 
	}
	
	
	// eliminar
		@Override
		@Transactional
		public void removeFromDb(Seller seller){
			Seller activeSeller = getDb().find(Seller.class, seller.getId());
			getDb().remove(activeSeller);
		}

}
