package com.bti.inventory.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IV40201")
public class BinEntity {
	
	@Column(name = "LOCNCODIND")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
/*@Column(name = "LOCNCODE", unique = true)
	private String siteID;
	
	public String getSiteID() {
		return siteID;
	}
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCNCODE", nullable = false)
	private SiteEntity siteEntity;
	
	public SiteEntity getSiteEntity() {
		return siteEntity;
	}

	public void setSiteEntity(SiteEntity siteEntity) {
		this.siteEntity = siteEntity;
	}
	
	@Column(name = "LOCBIN")
	private String binName;

	@Column(name = "LOCPHONE")
	private String phone;

	@Column(name = "LOCFAX")
	private String fax;

	
	@Column(name = "LOCNBINSEQ")
	private Integer locBinSeq;

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

	public String getBinName() {
		return binName;
	}

	public void setBinName(String binName) {
		this.binName = binName;
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

	public Integer getLocBinSeq() {
		return locBinSeq;
	}

	public void setLocBinSeq(Integer locBinSeq) {
		this.locBinSeq = locBinSeq;
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
