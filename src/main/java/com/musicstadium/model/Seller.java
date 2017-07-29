package com.musicstadium.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="SELLER")
public class Seller extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SELLERURL")
	private String sellerUrl;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;

//	setter & getter

	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSellerUrl() {
		return sellerUrl;
	}

	public void setSellerUrl(String sellerUrl) {
		this.sellerUrl = sellerUrl;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
//	construtor
	public Seller(){
		
	}
	
	@Override
	public String toString() {
	    return String.format("%s[id=%d]",getClass().getSimpleName(),getId());
	}
	
	@Override
    public boolean equals(Object other) {
        return (other instanceof Seller) && (getId() != null)
            ? getId().equals(((Seller) other).getId())
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (getId() != null)
            ? (this.getClass().hashCode() + getId().hashCode())
            : super.hashCode();
    }
}
