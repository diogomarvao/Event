package com.musicstadium.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.model.Seller;
import com.musicstadium.service.SellerService;

@Named("sellerBean")
@RequestScoped

public class SellerBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Seller activeSeller = new Seller();	
	
	@Inject
	private SellerService sellerService;
	
	public void setActiveEventSeller(Seller activeSeller) {
		this.activeSeller = activeSeller;
	}
		
	public Seller getActiveSeller() {
		return activeSeller;
	}
	
	
	Seller seller = new Seller();

	public Seller getSeller() {
		return seller;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

//	Adicionar Endereços
	
	public void addSellerToDb(){
		sellerService.addSeller(seller);
	}
	
	
	
//	editar endereços
	
	public void editSellerInDb(){
		sellerService.editSeller(seller);

	}
	
//	eliminar endereço
	
	public void delSellerInDb (Seller activeSeller){
		sellerService.delEntity(sellerService.getSellerRepository(),activeSeller);
	}
	
	// Fazer print nas tabelas
		public List<Seller> getSellerList(){
			return sellerService.showEntities();
		}
	
	
	
	
	
	
	
}
	