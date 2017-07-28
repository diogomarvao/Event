package com.musicstadium.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.musicstadium.model.Adress;
import com.musicstadium.service.AdressService;

@Named("adressBean")
@RequestScoped
public class AdressBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Adress activeAdress = new Adress();
	

	public void setActiveAdress(Adress activeAdress) {
		this.activeAdress = activeAdress;
	}


	public Adress getActiveAdress() {
		return activeAdress;
	}

	@Inject
	private AdressService adressService;
	
	Adress adress = new Adress();
	
	
	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	
	//	adicionar Event
	public void addAdressToEvent(){
		
	}

	// adiconar adressos

	public void addAdressToDb(){
		
			adressService.addAdress(adress);	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Localização adicionada à base de dados", null));
	}
	
// editar adressos
	public void editAdressInDb(){
			adressService.editAdress(activeAdress);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Localização editada com sucesso", null));
	}
	
// eliminar adresso
	public void delAdressInDb(Adress activeadress){
		try {
		adressService.delEntity(adressService.getAdressRepository(), activeadress);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Localização eliminada com sucesso", null));
		} catch (Exception e) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Esta morada pertence a um evento", null));
		}
	}
// Fazer print nas tabelas
	public List<Adress> getAdressList(){
		return adressService.showEntities();
	}
	
	
//connections
//	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
//	    if (modelValue == null) {
//	        return "";
//	    }
//
//	    if (modelValue instanceof Adress) {
//	        return String.valueOf(((Adress) modelValue).getId());
//	    }
//	    return "";
//	}
	
	// connections
	
	
}