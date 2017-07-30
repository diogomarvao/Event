package com.musicstadium.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.model.Seller;
import com.musicstadium.repository.SellerRepository;


@Named("sellerService")
@RequestScoped
public class SellerService extends EntityService<Seller>{
	
	@Inject
	private SellerRepository sellerRepository;
	
	public List<Seller> showEntities(){
		List<Seller> list = sellerRepository.getDbSeller();
		return list;
	}

	
	//adicionar
	public void addSeller(Seller seller){
		List<Seller> duplicateList = sellerRepository.duplicate(seller);
		if (duplicateList.isEmpty()) {
			sellerRepository.addToDb(seller);
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Nome de Utilizador indisponivel!"));
		}
	}
	
	public Seller login(Seller seller){
		List<Seller> duplicateList = sellerRepository.duplicate(seller);
		if (duplicateList.isEmpty()){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Utilizador Invalido!"));
				return null;
		}else{
			if(duplicateList.get(0).getPassword().equals(seller.getPassword())){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Olá!!", "Bem Vindo "+ seller.getName() + "!"));
				return duplicateList.get(0);
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Password Invalida!"));
				return null;
			}
		}
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
