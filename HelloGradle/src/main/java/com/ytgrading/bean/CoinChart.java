package com.ytgrading.bean;

import java.math.BigDecimal;

public class CoinChart {
	/**
	 * 年份
	 */
	private String years;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 制造质量（更名为工艺？）
	 */
	private String mquality;
	/**
	 * 题材
	 */
	private String shortsubject;// 题材中文简称
	private String fullsubject;// 题材中文全称
	private String enshortsubject; // 题材英文简称
	private String enfullsubject; // 题材英文全称
	/**
	 * 材质
	 */
	private String material;
	/**
	 * 用于显示的面值
	 */
	private String facevaluedis;
	/**
	 * 版别
	 */
	private String version;
	/**
	 * 目录编号
	 */
	private String catalogue;
	/**
	 * 纸钞编号
	 */
	private String billnum;
	/**
	 * 钱币编号
	 */
	private String coincode;
	/**
	 * 钱币最终得分
	 */
	private BigDecimal score;

	private Integer issuecode;// 钱币类型：1.贵金属币，2章，3流通纪念币
	private String weightshow;// 重量
	private String size;

	private String dynastyname;// 朝代
	private String weight;// 重量
	private String grade;// 等级
	private String gradename;// 等级名称

	private String wmk;
	private String bank;
	private String blocknum;
	private String printingcompany;
	private String sign;
	private String placenames;
	private String zhino;
	private String coinfeatures;
	
	private String addremarks;
	private String scores;
	private String[] scoreArrayFirstLine;
	private String[] scoreArraySecondLines;
	private int scoresLength;
	
	
	
	public int getScoresLength() {
		return scoresLength;
	}

	public void setScoresLength(int scoresLength) {
		this.scoresLength = scoresLength;
	}

	public String[] getScoreArrayFirstLine() {
		return scoreArrayFirstLine;
	}

	public void setScoreArrayFirstLine(String[] scoreArrayFirstLine) {
		this.scoreArrayFirstLine = scoreArrayFirstLine;
	}

	public String[] getScoreArraySecondLines() {
		return scoreArraySecondLines;
	}

	public void setScoreArraySecondLines(String[] scoreArraySecondLines) {
		this.scoreArraySecondLines = scoreArraySecondLines;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	public String getAddremarks() {
		return addremarks;
	}

	public void setAddremarks(String addremarks) {
		this.addremarks = addremarks;
	}

	public String getCoinfeatures() {
		return coinfeatures;
	}

	public void setCoinfeatures(String coinfeatures) {
		this.coinfeatures = coinfeatures;
	}

	public String getZhino() {
		return zhino;
	}

	public void setZhino(String zhino) {
		this.zhino = zhino;
	}

	public String getWeightshow() {
		return weightshow;
	}

	public void setWeightshow(String weightshow) {
		this.weightshow = weightshow;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getEnshortsubject() {
		return enshortsubject;
	}

	public void setEnshortsubject(String enshortsubject) {
		this.enshortsubject = enshortsubject;
	}

	public Integer getIssuecode() {
		return issuecode;
	}

	public void setIssuecode(Integer issuecode) {
		this.issuecode = issuecode;
	}

	private String ratingreasondis; // 不评分原因

	private String netreason; // 评NET原因

	public String getRatingreasondis() {
		return ratingreasondis;
	}

	public void setRatingreasondis(String ratingreasondis) {
		this.ratingreasondis = ratingreasondis;
	}

	private String difversioncode;// 版别ID
	private String difversion;// 版别

	public String getDifversion() {
		return difversion;
	}

	public void setDifversion(String difversion) {
		this.difversion = difversion;
	}

	/**
	 * 二维码地址url
	 */
	private String qrurl;

	public synchronized String getYears() {
		return years;
	}

	public synchronized void setYears(String years) {
		this.years = years;
	}

	public synchronized String getCountry() {
		return country;
	}

	public synchronized void setCountry(String country) {
		this.country = country;
	}

	public synchronized String getMquality() {
		return mquality;
	}

	public synchronized void setMquality(String mquality) {
		this.mquality = mquality;
	}

	public synchronized String getShortsubject() {
		return shortsubject;
	}

	public synchronized void setShortsubject(String shortsubject) {
		this.shortsubject = shortsubject;
	}

	public synchronized String getMaterial() {
		return material;
	}

	public synchronized void setMaterial(String material) {
		this.material = material;
	}

	public synchronized String getFacevaluedis() {
		return facevaluedis;
	}

	public synchronized void setFacevaluedis(String facevaluedis) {
		this.facevaluedis = facevaluedis;
	}

	public synchronized String getVersion() {
		return version;
	}

	public synchronized void setVersion(String version) {
		this.version = version;
	}

	public synchronized String getCatalogue() {
		return catalogue;
	}

	public synchronized void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public synchronized String getCoincode() {
		return coincode;
	}

	public synchronized void setCoincode(String coincode) {
		this.coincode = coincode;
	}

	public synchronized BigDecimal getScore() {
		return score;
	}

	public synchronized void setScore(BigDecimal score) {
		this.score = score;
	}

	public synchronized String getQrurl() {
		return qrurl;
	}

	public synchronized void setQrurl(String qrurl) {
		this.qrurl = qrurl;
	}

	public String getDynastyname() {
		return dynastyname;
	}

	public void setDynastyname(String dynastyname) {
		this.dynastyname = dynastyname;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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
		this.fullsubject = fullsubject;
	}

	public String getEnfullsubject() {
		return enfullsubject;
	}

	public void setEnfullsubject(String enfullsubject) {
		this.enfullsubject = enfullsubject;
	}

	public String getWmk() {
		return wmk;
	}

	public void setWmk(String wmk) {
		this.wmk = wmk;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBlocknum() {
		return blocknum;
	}

	public void setBlocknum(String blocknum) {
		this.blocknum = blocknum;
	}

	public String getPrintingcompany() {
		return printingcompany;
	}

	public void setPrintingcompany(String printingcompany) {
		this.printingcompany = printingcompany;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPlacenames() {
		return placenames;
	}

	public void setPlacenames(String placenames) {
		this.placenames = placenames;
	}

	public String getDifversioncode() {
		return difversioncode;
	}

	public void setDifversioncode(String difversioncode) {
		this.difversioncode = difversioncode;
	}

	public String getNetreason() {
		return netreason;
	}

	public void setNetreason(String netreason) {
		this.netreason = netreason;
	}

	public String getBillnum() {
		return billnum;
	}

	public void setBillnum(String billnum) {
		this.billnum = billnum;
	}

}
