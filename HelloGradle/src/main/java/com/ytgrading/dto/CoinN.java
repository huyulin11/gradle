package com.ytgrading.dto;

import java.math.BigDecimal;

public class CoinN {
	private Integer id;

	private String years;

	private Integer country;

	private Integer unitofmeasurement;

	private BigDecimal weight;

	private Integer material;

	private String version;

	private BigDecimal facevalue;

	private String catalogue;

	private Integer issuecode;

	private Integer amountofplan;

	private Integer amountofcasting;

	private Integer amountofissue;

	private Integer publisher;

	private Integer manufacturer;

	private String issuedate;

	private String issueendtime;

	private Integer shapecode;

	private Integer size;

	private Integer mquality;

	private Integer artisticeffect;

	private Integer mprocess;

	private Integer toothing;

	private BigDecimal evaluate;
	private String facevaluedis;

	public synchronized String getFacevaluedis() {
		return facevaluedis;
	}

	public synchronized void setFacevaluedis(String facevaluedis) {
		this.facevaluedis = facevaluedis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public Integer getCountry() {
		return country;
	}

	private String fullsubject;

	private String shortsubject;

	private String components;

	public String getFullsubject() {
		return fullsubject;
	}

	public void setFullsubject(String fullsubject) {
		this.fullsubject = fullsubject;
	}

	public String getShortsubject() {
		return shortsubject;
	}

	public void setShortsubject(String shortsubject) {
		this.shortsubject = shortsubject;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getUnitofmeasurement() {
		return unitofmeasurement;
	}

	public void setUnitofmeasurement(Integer unitofmeasurement) {
		this.unitofmeasurement = unitofmeasurement;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Integer getMaterial() {
		return material;
	}

	public void setMaterial(Integer material) {
		this.material = material;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BigDecimal getFacevalue() {
		return facevalue;
	}

	public void setFacevalue(BigDecimal facevalue) {
		this.facevalue = facevalue;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public Integer getIssuecode() {
		return issuecode;
	}

	public void setIssuecode(Integer issuecode) {
		this.issuecode = issuecode;
	}

	public Integer getAmountofplan() {
		return amountofplan;
	}

	public void setAmountofplan(Integer amountofplan) {
		this.amountofplan = amountofplan;
	}

	public Integer getAmountofcasting() {
		return amountofcasting;
	}

	public void setAmountofcasting(Integer amountofcasting) {
		this.amountofcasting = amountofcasting;
	}

	public Integer getAmountofissue() {
		return amountofissue;
	}

	public void setAmountofissue(Integer amountofissue) {
		this.amountofissue = amountofissue;
	}

	public Integer getPublisher() {
		return publisher;
	}

	public void setPublisher(Integer publisher) {
		this.publisher = publisher;
	}

	public Integer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Integer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getIssueendtime() {
		return issueendtime;
	}

	public void setIssueendtime(String issueendtime) {
		this.issueendtime = issueendtime;
	}

	public Integer getShapecode() {
		return shapecode;
	}

	public void setShapecode(Integer shapecode) {
		this.shapecode = shapecode;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getMquality() {
		return mquality;
	}

	public void setMquality(Integer mquality) {
		this.mquality = mquality;
	}

	public Integer getArtisticeffect() {
		return artisticeffect;
	}

	public void setArtisticeffect(Integer artisticeffect) {
		this.artisticeffect = artisticeffect;
	}

	public Integer getMprocess() {
		return mprocess;
	}

	public void setMprocess(Integer mprocess) {
		this.mprocess = mprocess;
	}

	public Integer getToothing() {
		return toothing;
	}

	public void setToothing(Integer toothing) {
		this.toothing = toothing;
	}

	public BigDecimal getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(BigDecimal evaluate) {
		this.evaluate = evaluate;
	}
}