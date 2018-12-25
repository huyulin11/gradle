package com.ytgrading.bean;

import java.math.BigDecimal;

public class SysMechanismCoinBasicInfo {

	private Integer id;

	private String catalogue;

	private Integer country;

	private String years;

	private String facevaluedis;

	private String material;

	private String weight;

	private String size;

	private String version;

	private BigDecimal evaluate;

	private String fullsubject;

	private String shortsubject;

	private String commonlysubject;

	private String remarks;

	private String guojia;
	private String caizhi;
	private String boxCost;

	public String getBoxCost() {
		return boxCost;
	}

	public void setBoxCost(String boxCost) {
		this.boxCost = boxCost;
	}

	public String getFullsubject() {
		return fullsubject;
	}

	public void setFullsubject(String fullsubject) {
		this.fullsubject = fullsubject == null ? null : fullsubject.trim();
	}

	public String getShortsubject() {
		return shortsubject;
	}

	public void setShortsubject(String shortsubject) {
		this.shortsubject = shortsubject == null ? null : shortsubject.trim();
	}

	public String getCommonlysubject() {
		return commonlysubject;
	}

	public void setCommonlysubject(String commonlysubject) {
		this.commonlysubject = commonlysubject == null ? null : commonlysubject
				.trim();
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue == null ? null : catalogue.trim();
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getFacevaluedis() {
		return facevaluedis;
	}

	public void setFacevaluedis(String facevaluedis) {
		this.facevaluedis = facevaluedis == null ? null : facevaluedis.trim();
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material == null ? null : material.trim();
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight == null ? null : weight.trim();
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size == null ? null : size.trim();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	public BigDecimal getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(BigDecimal evaluate) {
		this.evaluate = evaluate;
	}

	public String getGuojia() {
		return guojia;
	}

	public void setGuojia(String guojia) {
		this.guojia = guojia;
	}

	public String getCaizhi() {
		return caizhi;
	}

	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

}