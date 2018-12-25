/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.bean;

/**
 * 
 * @Description:
 * @Copyright:Copyright (c) 2013
 * @Company:FandaSoft
 * @Date:2013-5-9
 * @author jiangxx
 * @version 1.0
 */
public class Condition {
	private String year;
	private String country;
	private String material;
	private String fullsubject;
	private String munits;
	private String mquality;
	private String catalogue;
	private String facevaluedis;
	private int startRow;
	private String fullname; // 全称
	private String shortname; //简称
	private String billnum; // 编号
	private String placenames; // 地名
	private String sign;
	private String pattern;
	private String color;
	private int entitytype;
	private String version; // 版别
	private String wmk; // 水印

	private int dynasty; // 朝代
	private String size; // 规格

	private String zhino;
	private String issuedate;

	public int getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(int entitytype) {
		this.entitytype = entitytype;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getWmk() {
		return wmk;
	}

	public void setWmk(String wmk) {
		this.wmk = wmk;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getBillnum() {
		return billnum;
	}

	public void setBillnum(String billnum) {
		this.billnum = billnum;
	}

	public String getPlacenames() {
		return placenames;
	}

	public void setPlacenames(String placenames) {
		this.placenames = placenames;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public String getFacevaluedis() {
		return facevaluedis;
	}

	public void setFacevaluedis(String facevaluedis) {
		this.facevaluedis = facevaluedis;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMunits() {
		return munits;
	}

	public void setMunits(String munits) {
		this.munits = munits;
	}

	public String getMquality() {
		return mquality;
	}

	public void setMquality(String mquality) {
		this.mquality = mquality;
	}

	public String getFullsubject() {
		return fullsubject;
	}

	public void setFullsubject(String fullsubject) {
		this.fullsubject = fullsubject;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public int getDynasty() {
		return dynasty;
	}

	public void setDynasty(int dynasty) {
		this.dynasty = dynasty;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getZhino() {
		return zhino;
	}

	public void setZhino(String zhino) {
		this.zhino = zhino;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

}
