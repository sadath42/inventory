package com.bti.inventory.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class SiteEntityID implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCNCODIND")
	private Long id;

	@Column(name = "LOCNCODCODE", unique = true)
	private String siteID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public SiteEntityID(Long id, String siteID) {
		super();
		this.id = id;
		this.siteID = siteID;
	}
	
	

}
