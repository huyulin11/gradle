/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.bean;

import java.math.BigDecimal;

/**
 * 
 * @Title:SecondScore
 * @Description:
 * @Copyright:Copyright (c) 2013
 * @Company:FandaSoft
 * @Date:2013-5-29
 * @author jiangxx
 * @version 1.0
 */
public class SecondScore {
	/**
	 * Request_coin 中主键
	 */
	private String id;
	/**
	 * 鉴品编号
	 */
	private String coincode;
	/**
	 * 年号
	 */
	private String years;
	/**
	 * 国家
	 */
	private String guojia;
	/**
	 * 题材
	 */
	private String fullsubject;
	/**
	 * 重量
	 */
	private String zhongliang;
	/**
	 * 质量
	 */
	private String zhiliang;
	/**
	 * 材质
	 */
	private String caizhi;
	/**
	 * 版别
	 */
	private String version;
	/**
	 * 面值
	 */
	private BigDecimal facevalue;
	/**
	 * 鉴品状态
	 */
	private String status;
	/**
	 * 客户分数
	 */
	private BigDecimal customerscore;
	/**
	 * 评分A
	 */
	private BigDecimal Ascore;
	/**
	 * 评分B
	 */
	private BigDecimal Bscore;
	/**
	 * 二审分数
	 */
	private BigDecimal SecondScore;
	/**
	 * 评审状态 1 一审 2 二审
	 */
	private String level;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * request_coin_score 主键
	 */
	private String scoreid;
	/*
	 * 面值的显示形式
	 */
	private String facevaluedis;
	/*
	 * 重量的分数形式用于显示
	 */
	private String weightshow;
	private String difversion;// 版别
	private String ratingreasondis;// 评级原因
	/*
	 * 平均分
	 */
	private BigDecimal avgscore;
	private String pubremark;
	private String wmk;// 水印
	private String whetherSample;
	private String blockNum;// 冠字号
	private String dynasty;// 朝代
	private String size; // 尺寸
	private String grade; // 古币等级

	private String zhino;
	private String issuetime;
	private String color;
	private String covernewold;
	private String coinremark;
	private String coinnum;
	private String coincovernewold;
	private String coinfullsubject;
	private String coinstampjointype;
	private String addremarks;
	private String scores;
	private String ascores;
	private String bscores;
	private String newinformation;

	public String getCoincovernewold() {
		return coincovernewold;
	}

	public void setCoincovernewold(String coincovernewold) {
		this.coincovernewold = coincovernewold;
	}

	public String getCoinfullsubject() {
		return coinfullsubject;
	}

	public void setCoinfullsubject(String coinfullsubject) {
		this.coinfullsubject = coinfullsubject;
	}

	public String getCoinstampjointype() {
		return coinstampjointype;
	}

	public void setCoinstampjointype(String coinstampjointype) {
		this.coinstampjointype = coinstampjointype;
	}

	public String getCoinnum() {
		return coinnum;
	}

	public void setCoinnum(String coinnum) {
		this.coinnum = coinnum;
	}

	public String getZhino() {
		return zhino;
	}

	public void setZhino(String zhino) {
		this.zhino = zhino;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCovernewold() {
		return covernewold;
	}

	public void setCovernewold(String covernewold) {
		this.covernewold = covernewold;
	}

	public String getCoinremark() {
		return coinremark;
	}

	public void setCoinremark(String coinremark) {
		this.coinremark = coinremark;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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

	public String getRatingreasondis() {
		return ratingreasondis;
	}

	public void setRatingreasondis(String ratingreasondis) {
		this.ratingreasondis = ratingreasondis;
	}

	public String getDifversion() {
		return difversion;
	}

	public void setDifversion(String difversion) {
		this.difversion = difversion;
	}

	public String getPubremark() {
		return pubremark;
	}

	public void setPubremark(String pubremark) {
		this.pubremark = pubremark;
	}

	public BigDecimal getAvgscore() {
		return avgscore;
	}

	public void setAvgscore(BigDecimal avgscore) {
		this.avgscore = avgscore;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoincode() {
		return coincode;
	}

	public void setCoincode(String coincode) {
		this.coincode = coincode;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getGuojia() {
		return guojia;
	}

	public void setGuojia(String guojia) {
		this.guojia = guojia;
	}

	public String getFullsubject() {
		return fullsubject;
	}

	public void setFullsubject(String fullsubject) {
		this.fullsubject = fullsubject;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public BigDecimal getCustomerscore() {
		return customerscore;
	}

	public void setCustomerscore(BigDecimal customerscore) {
		this.customerscore = customerscore;
	}

	public BigDecimal getAscore() {
		return Ascore;
	}

	public void setAscore(BigDecimal ascore) {
		Ascore = ascore;
	}

	public BigDecimal getBscore() {
		return Bscore;
	}

	public void setBscore(BigDecimal bscore) {
		Bscore = bscore;
	}

	public BigDecimal getSecondScore() {
		return SecondScore;
	}

	public void setSecondScore(BigDecimal secondScore) {
		SecondScore = secondScore;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getScoreid() {
		return scoreid;
	}

	public void setScoreid(String scoreid) {
		this.scoreid = scoreid;
	}

	public String getAddremarks() {
		return addremarks;
	}

	public void setAddremarks(String addremarks) {
		this.addremarks = addremarks;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	public String getAscores() {
		return ascores;
	}

	public void setAscores(String ascores) {
		this.ascores = ascores;
	}

	public String getBscores() {
		return bscores;
	}

	public void setBscores(String bscores) {
		this.bscores = bscores;
	}

	public String getNewinformation() {
		return newinformation;
	}

	public void setNewinformation(String newinformation) {
		this.newinformation = newinformation;
	}
	
	

}
