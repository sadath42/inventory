package com.bti.inventory.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class SiteDto {

	@NotEmpty
	private String siteID;

	@NotEmpty
	private String description;
	private String arabicDesc;
	private String adressLineOne;
	private String adressLineTwo;
	private String city;
	private String country;
	private String phone;
	private String fax;
	private Integer financialDimension;
	private String scheduledSalesTaxID;
	private String scheduledPurchaseTaxID;
	private Date creationDate;
	private Date modifiedDate;
	private String changedBy;
	private Date dexRowTS;
	private Integer dexRowID;
	private List<BinDto> bins;

	public List<BinDto> getBins() {
		return bins;
	}

	public void setBins(List<BinDto> bins) {
		this.bins = bins;
	}

	public Date getDexRowTS() {
		return dexRowTS;
	}

	public void setDexRowTS(Date dexRowTS) {
		this.dexRowTS = dexRowTS;
	}

	public Integer getDexRowID() {
		return dexRowID;
	}

	public void setDexRowID(Integer dexRowID) {
		this.dexRowID = dexRowID;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArabicDesc() {
		return arabicDesc;
	}

	public void setArabicDesc(String arabicDesc) {
		this.arabicDesc = arabicDesc;
	}

	public String getAdressLineOne() {
		return adressLineOne;
	}

	public void setAdressLineOne(String adressLineOne) {
		this.adressLineOne = adressLineOne;
	}

	public String getAdressLineTwo() {
		return adressLineTwo;
	}

	public void setAdressLineTwo(String adressLineTwo) {
		this.adressLineTwo = adressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getFinancialDimension() {
		return financialDimension;
	}

	public void setFinancialDimension(Integer financialDimension) {
		this.financialDimension = financialDimension;
	}

	public String getScheduledSalesTaxID() {
		return scheduledSalesTaxID;
	}

	public void setScheduledSalesTaxID(String scheduledSalesTaxID) {
		this.scheduledSalesTaxID = scheduledSalesTaxID;
	}

	public String getScheduledPurchaseTaxID() {
		return scheduledPurchaseTaxID;
	}

	public void setScheduledPurchaseTaxID(String scheduledPurchaseTaxID) {
		this.scheduledPurchaseTaxID = scheduledPurchaseTaxID;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
