/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.bean;

import java.math.BigDecimal;

/**
 * 
 * @Title:Review
 * @Description:
 * @Copyright:Copyright (c) 2013
 * @Company:FandaSoft
 * @Date:2013-5-7
 * @author jiangxx
 * @version 1.0
 */
public class Review {

	/**
	 * 年号
	 */
	private String years;
	/**
	 * 国家
	 */
	private Integer country;
	/**
	 * 题材
	 */
	private String shortsubject;
	/**
	 * 重量
	 */
	private BigDecimal weight;
	/**
	 * 重量单位
	 */
	private Integer unitofmeasurement;
	/**
	 * 重量+重量单位
	 */
	private String zhongliang;
	/**
	 * 制造质量
	 */
	private Integer mquality;
	/**
	 * 材质
	 */
	private Integer material;
	/**
	 * 版别
	 */
	private String version;
	/**
	 * 数量
	 */
	private Integer amount;
	/**
	 * 面值
	 */
	private BigDecimal facevalue;
	/**
	 * 估价
	 */
	private BigDecimal evaluate;
	/**
	 * 最低评分
	 */
	private Integer score;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * request_detail主键
	 */
	private String id;
	/**
	 * code值转换为key
	 */
	private String zhiliang;
	/**
	 * code值转换为key
	 */
	private String caizhi;
	/**
	 * 成分说明
	 */
	private String components;
	/**
	 * code值转换为key
	 */
	private String guojia;
	/**
	 * Coin表中主键
	 */
	private int coinid;

	private int numindex;
	private String amountofissue;// 发行量
	/**
	 * 合计评级费
	 */
	private BigDecimal totalreqcost;
	/**
	 * 合计估价
	 */
	private String fullsubject;
	private BigDecimal totalevaluate;
	private String requestid;
	private String wmk; // 水印
	private String whetherSample; // 是否票样
	private String blockNum; // 冠字号

	private String catalogue;
	private BigDecimal guestappraisal;// 客户估价

	private String weightshow;// 重量的分数形式
	private String fulltitle; // 完整题材
	private String facevaluedis; // 面值
	private String cointypename;// 币类型
	private String enfullsubject;// 英文题材全称

	private String dynasty; // 朝代
	private String dynastyname; // 朝代名称
	private String grade; // 古钱等级
	private String gradename; // 古钱等级名称
	private String size;// 规格
	private String whetherSeries; // 纸钞是否连号

	private String zhino; //
	private String issuetime; // 时期
	private String issuedate; // 发行日期
	private String color; // 发行日期
	private String stampjointype;
	private String boxCost;
	private String issuingquantity;
	private String detinformation;

	public String getBoxCost() {
		return boxCost;
	}

	public void setBoxCost(String boxCost) {
		this.boxCost = boxCost;
	}

	public String getWhetherSeries() {
		return whetherSeries;
	}

	public void setWhetherSeries(String whetherSeries) {
		this.whetherSeries = whetherSeries;
	}

	public String getWmk() {
		return wmk;
	}

	public void setWmk(String wmk) {
		this.wmk = wmk;
	}

	public String getWhetherSample() {
		return whetherSample;
	}

	public void setWhetherSample(String whetherSample) {
		this.whetherSample = whetherSample;
	}

	public String getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(String blockNum) {
		this.blockNum = blockNum;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public BigDecimal getGuestappraisal() {
		return guestappraisal;
	}

	public void setGuestappraisal(BigDecimal guestappraisal) {
		this.guestappraisal = guestappraisal;
	}

	public String getFullsubject() {
		return fullsubject;
	}

	public void setFullsubject(String fullsubject) {
		this.fullsubject = fullsubject;
	}

	public String getCointypename() {
		return cointypename;
	}

	public void setCointypename(String cointypename) {
		this.cointypename = cointypename;
	}

	public String getEnfullsubject() {
		return enfullsubject;
	}

	public void setEnfullsubject(String enfullsubject) {
		this.enfullsubject = enfullsubject;
	}

	public String getFacevaluedis() {
		return facevaluedis;
	}

	public void setFacevaluedis(String facevaluedis) {
		this.facevaluedis = facevaluedis;
	}

	public String getFulltitle() {
		return fulltitle;
	}

	public void setFulltitle(String fulltitle) {
		this.fulltitle = fulltitle;
	}

	public String getWeightshow() {
		return weightshow;
	}

	public void setWeightshow(String weightshow) {
		this.weightshow = weightshow;
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

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getShortsubject() {
		return shortsubject;
	}

	public void setShortsubject(String shortsubject) {
		this.shortsubject = shortsubject;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Integer getUnitofmeasurement() {
		return unitofmeasurement;
	}

	public void setUnitofmeasurement(Integer unitofmeasurement) {
		this.unitofmeasurement = unitofmeasurement;
	}

	public Integer getMquality() {
		return mquality;
	}

	public void setMquality(Integer mquality) {
		this.mquality = mquality;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getFacevalue() {
		return facevalue;
	}

	public void setFacevalue(BigDecimal facevalue) {
		this.facevalue = facevalue;
	}

	public BigDecimal getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(BigDecimal evaluate) {
		this.evaluate = evaluate;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZhongliang() {
		return zhongliang;
	}

	public void setZhongliang(String zhongliang) {
		this.zhongliang = zhongliang;
	}

	public String getZhiliang() {
		return zhiliang;
	}

	public void setZhiliang(String zhiliang) {
		this.zhiliang = zhiliang;
	}

	public String getCaizhi() {
		return caizhi;
	}

	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public String getGuojia() {
		return guojia;
	}

	public void setGuojia(String guojia) {
		this.guojia = guojia;
	}

	public int getCoinid() {
		return coinid;
	}

	public void setCoinid(int coinid) {
		this.coinid = coinid;
	}

	public int getNumindex() {
		return numindex;
	}

	public void setNumindex(int numindex) {
		this.numindex = numindex;
	}

	public String getAmountofissue() {
		return amountofissue;
	}

	public void setAmountofissue(String amountofissue) {
		this.amountofissue = amountofissue;
	}

	public BigDecimal getTotalreqcost() {
		return totalreqcost;
	}

	public void setTotalreqcost(BigDecimal totalreqcost) {
		this.totalreqcost = totalreqcost;
	}

	public BigDecimal getTotalevaluate() {
		return totalevaluate;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public void setTotalevaluate(BigDecimal totalevaluate) {
		this.totalevaluate = totalevaluate;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public String getDynastyname() {
		return dynastyname;
	}

	public void setDynastyname(String dynastyname) {
		this.dynastyname = dynastyname;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getStampjointype() {
		return stampjointype;
	}

	public void setStampjointype(String stampjointype) {
		this.stampjointype = stampjointype;
	}

	public String getZhino() {
		return zhino;
	}

	public void setZhino(String zhino) {
		this.zhino = zhino;
	}

	public String getIssuingquantity() {
		return issuingquantity;
	}

	public void setIssuingquantity(String issuingquantity) {
		this.issuingquantity = issuingquantity;
	}

	public String getDetinformation() {
		return detinformation;
	}

	public void setDetinformation(String detinformation) {
		this.detinformation = detinformation;
	}
	

}