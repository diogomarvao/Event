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
	
		
	public void setActiveSeller(Seller activeSeller) {
		this.activeSeller = activeSeller;
	}
		
	public Seller getActiveSeller() {
		return activeSeller;
	}
	

	@Inject
	private SellerService sellerService;
		
	Seller seller = new Seller();

	public Seller getSeller() {
		return seller;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	
//	private List<Seller> sellerList;
//	
//	public List<Seller> getSellerList() {
//		sellerList  = sellersInDb(); 
//		return sellerList;
//	}
//
//	public void setSellerList(List<Seller> sellerList) {
//		this.sellerList = sellerList;
//	}

//	Adicionar seller
	
	public void addSellerToDb(){
		sellerService.addSeller(seller);
	}
	
	
//	editar seller
	
	public void editSellerInDb(){
		sellerService.editSeller(activeSeller);
	}
	
//	eliminar seller
	
	public void delSellerInDb (Seller activeSeller){
		sellerService.delEntity(sellerService.getSellerRepository(), activeSeller);
	}
	
	// Fazer print nas tabelas
		public List<Seller> getSellerList(){
			return sellerService.showEntities();
		}
//	
// connections

}
	