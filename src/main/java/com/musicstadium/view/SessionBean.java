package com.musicstadium.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.model.Event;
import com.musicstadium.model.Seller;
import com.musicstadium.repository.EntityRepository;
import com.musicstadium.service.EventService;
import com.musicstadium.service.SellerService;

@Named("sessionBean")
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Seller activeSeller = new Seller();
	@Inject
	private EventService eventService;
	@Inject
	private SellerService sellerService;
	
	Seller seller = new Seller();
	
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public void setActiveSeller(Seller activeSeller) {
		this.activeSeller = activeSeller;
	}

	public Seller getActiveSeller() {
		if(activeSeller.getId() == null)
			return null;
			else{
				return activeSeller;
			}
	}
	
	public List<Seller> ActiveSellerToList(){
		List<Seller> activeSellerList = new ArrayList<Seller>();
		activeSellerList.add(activeSeller);
		return activeSellerList;
	}
	
	public void alterActiveSellerInDb(){
		sellerService.editSeller(activeSeller);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seller editado com sucesso", null));
	}
	
	public void login(){
		if (sellerService.login(seller) != null){
			setActiveSeller(sellerService.login(seller));
		}
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";
	}
	
	public List<Event> getSellersEvent(){
		return eventService.showSellersEvent(activeSeller);
	}
}
