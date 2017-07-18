package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.model.Seller;
import com.musicstadium.repository.SellerRepository;


@Named("sellerService")
@RequestScoped
public class SellerService extends EntityService<Seller>{
	
	@Inject
	private SellerRepository sellerRepository;
	
	public List<Seller> showEntities(SellerRepository sellerRepository){
		List<Seller> list = sellerRepository.getDbSeller();
		return list;
	}

	
	//adicionar
	public void addSeller(Seller seller){
		sellerRepository.addToDb(seller);
	}
	
	//editar
	public void editSeller(Seller seller){
		sellerRepository.alterInDb(seller);
	}
	 //getter SellerRepository
	public SellerRepository getSellerRepository() {
		return sellerRepository;
	}
	
}
