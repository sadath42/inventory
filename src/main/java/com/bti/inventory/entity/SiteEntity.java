package com.bti.inventory.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IV40200")
public class SiteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCNCODIND")
	private Long id;

	@Column(name = "LOCNCODE", unique = true)
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

	@OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "siteEntity")
	private Set<BinEntity> bins = new HashSet<BinEntity>(0);

	public Set<BinEntity> getBins() {
		return bins;
	}

	public void setBins(Set<BinEntity> bins) {
		this.bins = bins;
	}
	@Column(name = "LOCDSCR")
	private String description;

	@Column(name = "LOCDSCRA")
	private String arabicDesc;

	@Column(name = "LOCADRESS")
	private String adressLineOne;

	@Column(name = "LOCADRESSA")
	private String adressLineTwo;

	@Column(name = "LOCCITY")
	private String city;

	@Column(name = "LOCCONTRY")
	private String country;

	@Column(name = "LOCPHONE")
	private String phone;

	@Column(name = "LOCFAX")
	private String fax;

	@Column(name = "DIMINXVALUE")
	private Integer financialDimension;

	@Column(name = "TAXSCHDIDS")
	private String scheduledSalesTaxID;

	@Column(name = "TAXSCHDIDP")
	private String scheduledPurchaseTaxID;

	@Column(name = "CREATDDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "MODIFDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	@Column(name = "CHANGEBY")
	private String changedBy;

	@Column(name = "DEX_ROW_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dexRowTS;

	@Column(name = "DEX_ROW_ID")
	private Integer dexRowID;

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

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
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

}
