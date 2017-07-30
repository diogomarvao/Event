package com.musicstadium.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;

@javax.persistence.Entity
@Table(name = "EVENT")
public class Event extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	// Variaveis
	@Column(name = "EVENT_NAME")
	private String name;

	@Column(name = "IMG_URL")
	private String imgUrl;
	
	@Column(name = "DATE_START")
	@Future
	private Date dateS;

	@Column(name = "DATE_END")
	@Future
	private Date dateF;
	
	@Column(name = "HOUR_START")
	private Date hourS;

	@Column(name = "HOUR_END")
	private Date hourF;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "VIDEOLINK")
	private String videoLink;

	@ManyToOne
	private Adress adress;

	@Column(name = "GENRE")
	private String genre;

	@Column(name = "FEATURED")
	private boolean featured;

	@OneToOne
	private Seller seller;
	
	@Column(name="PRICE")
	private double price;

	// getter & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getDateS() {
		return dateS;
	}

	public void setDateS(Date dateS) {
		this.dateS = dateS;
	}

	public Date getDateF() {
		return dateF;
	}

	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	
	public Date getHourS() {
		return hourS;
	}

	public void setHourS(Date hourS) {
		this.hourS = hourS;
	}

	public Date getHourF() {
		return hourF;
	}

	public void setHourF(Date hourF) {
		this.hourF = hourF;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		//System.out.println(adress.GETLO);
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

//	public List<Seller> getSellerList() {
//		return sellerList;
//	}
//
//	public void setSellerList(List<Seller> sellerList) {
//		this.sellerList = sellerList;
//	}


	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	// Construtor Event
	public Event() {

	}

}
