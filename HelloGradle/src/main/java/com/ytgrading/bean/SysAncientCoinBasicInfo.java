package com.ytgrading.bean;

import java.math.BigDecimal;

public class SysAncientCoinBasicInfo {

	private Integer id;

	private String catalogue;

	private Integer country;

	private String dynasty;

	private String castingtime;

	private String facevaluedis;

	private String material;

	private String grade;

	private String weight;

	private String size;

	private String version;

	private BigDecimal evaluate;

	private String fullsubject;

	private String shortsubject;

	private String commonlysubject;

	private String remarks;

	private String guojia;
	private String dynastyname;
	private String caizhi;
	private String gradename;
	private String boxCost;

	public String getBoxCost() {
		return boxCost;
	}

	public void setBoxCost(String boxCost) {
		this.boxCost = boxCost;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
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

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty == null ? null : dynasty.trim();
	}

	public String getCastingtime() {
		return castingtime;
	}

	public void setCastingtime(String castingtime) {
		this.castingtime = castingtime == null ? null : castingtime.trim();
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

	public String getDynastyname() {
		return dynastyname;
	}

	public void setDynastyname(String dynastyname) {
		this.dynastyname = dynastyname;
	}

	public String getCaizhi() {
		return caizhi;
	}

	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}


}