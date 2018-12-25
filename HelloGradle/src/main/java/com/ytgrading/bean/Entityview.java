package com.ytgrading.bean;

public class Entityview {
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
	private String fullname[];
	private String billnum;
	private String placenames;
	private String sign;
	private String pattern;
	private String color;
	private int entitytype;// 实体，区分金银币、纸钞、古钱
	private String version; // 版别
	private String wmk; // 水印
	private String shortsubject;
	/** 古钱特有 */
	private int dynasty;// 朝代
	private int level;// 级别
	private String castingtime;// 铸期
	private String size;// 规格

	private String zhino;
	private String issuedate;

	
	
	public String getShortsubject() {
		return shortsubject;
	}

	public void setShortsubject(String shortsubject) {
		this.shortsubject = shortsubject;
	}

	public int getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(int entitytype) {
		this.entitytype = entitytype;
	}

	public String[] getFullname() {
		return fullname;
	}

	public void setFullname(String[] fullname) {
		this.fullname = fullname;
	}

	public String getWmk() {
		return wmk;
	}

	public void setWmk(String wmk) {
		this.wmk = wmk;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	public int getDynasty() {
		return dynasty;
	}

	public void setDynasty(int dynasty) {
		this.dynasty = dynasty;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCastingtime() {
		return castingtime;
	}

	public void setCastingtime(String castingtime) {
		this.castingtime = castingtime;
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
