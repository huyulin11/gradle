package com.ytgrading.bean;

public class BillReview {
	private String years;
	private String country;
	private String fullsubject[];
	private String weight;
	private String unitofmeasurement;
	private String mquality;
	private String material;
	private String catalogue;
	private String weightshow;
	private String facevaluedis;
	private int startRow;
	
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
	public String getWeightshow() {
		return weightshow;
	}
	public void setWeightshow(String weightshow) {
		this.weightshow = weightshow;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getFullsubject() {
		return fullsubject;
	}
	public void setFullsubject(String[] fullsubject) {
		this.fullsubject = fullsubject;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getUnitofmeasurement() {
		return unitofmeasurement;
	}
	public void setUnitofmeasurement(String unitofmeasurement) {
		this.unitofmeasurement = unitofmeasurement;
	}
	public String getMquality() {
		return mquality;
	}
	public void setMquality(String mquality) {
		this.mquality = mquality;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}
