package com.ytgrading.bean;

import java.math.BigDecimal;

public class SysStampBasicInfo {

	private Integer id;
	private String catalogue;

	private String zhino;

	private String color;

	private String issuedate;

	private String issuetime;

	private Integer country;

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
	private String caizhi;
	private String gradename;
	private String boxCost;
	private String issuingquantity;

	private String basictype;
	private String specialtype;
	private String features;
	private String gum;
	private String hole;
	private String summary;
	private String shortname;
	
	

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

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

	public String getCaizhi() {
		return caizhi;
	}

	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}

	public String getZhino() {
		return zhino;
	}

	public void setZhino(String zhino) {
		this.zhino = zhino;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getIssuingquantity() {
		return issuingquantity;
	}

	public void setIssuingquantity(String issuingquantity) {
		this.issuingquantity = issuingquantity;
	}

	public String getBasictype() {
		return basictype;
	}

	public void setBasictype(String basictype) {
		this.basictype = basictype;
	}

	public String getSpecialtype() {
		return specialtype;
	}

	public void setSpecialtype(String specialtype) {
		this.specialtype = specialtype;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getGum() {
		return gum;
	}

	public void setGum(String gum) {
		this.gum = gum;
	}

	public String getHole() {
		return hole;
	}

	public void setHole(String hole) {
		this.hole = hole;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}