package com.musicstadium.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.model.Event;
import com.musicstadium.model.Seller;
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
	
	public void login(){
		if (sellerService.login(seller) != null){
			setActiveSeller(sellerService.login(seller));
		}
	}
	
	public void logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	public List<Event> getSellersEvent(){
		return eventService.showSellersEvent(activeSeller);
	}
}
