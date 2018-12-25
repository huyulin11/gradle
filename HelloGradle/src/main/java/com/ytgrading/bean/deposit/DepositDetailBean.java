/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.bean.deposit;

import java.math.BigDecimal;
import java.util.UUID;

import com.ytgrading.util.AppTool;

/**
 * 
 * @Description:
 * @Copyright:Copyright (c) 2013
 * @Company:FandaSoft
 * @Date:2013-5-20
 * @author jiangxx
 * @version 1.0
 */
public class DepositDetailBean implements Comparable<DepositDetailBean> {

	protected String id = UUID.randomUUID().toString();

	protected String depositid;
	protected String innerno;
	private String numindex;
	
	private String coinid;
	private String amount;
	private String guestappraisal;
	private String evaluate;
	private String score;
	private String amountofissue;
	private Integer stampjointype;
	protected String remark;

	protected String years;

	protected String guojia;

	protected String fullsubject;

	protected String zhongliang;

	protected String zhiliang;

	protected String caizhi;

	protected String version;
	/**
	 * 合计评级费
	 */
	protected String total1;
	/**
	 * 合计估价
	 */
	protected String total2;

	protected String facevaluedis;// 显示面值
	protected String weightshow;// 重量的
	protected String cointypename;// 币类型
	protected String enfullsubject;// 英文题材全称
	protected String wmk; // 水印
	protected String whetherSample; // 是否票样
	protected String blockNum; // 冠字号

	protected String dynasty;
	protected String dynastyname;
	protected String size;
	protected String gradename; // 古币珍稀度
	protected String whetherSeries; // 纸钞是否连号

	protected String fulltitle; // 完整题材

	protected String guestWRWeight; // 古币客户修改后的重量
	protected String guestWRSize; // 古币客户修改后的规格
	protected String guestWRGrade;// 古币客户填写的珍稀度
	protected BigDecimal totalreqcost;
	protected BigDecimal totalevaluate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getDepositid() {
		return depositid;
	}

	public String getInnerno() {
		return innerno;
	}

	public void setDepositid(String depositid) {
		this.depositid = depositid;
	}

	public void setInnerno(String innerno) {
		this.innerno = innerno;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getTotal1() {
		return total1;
	}

	public void setTotal1(String total1) {
		this.total1 = total1;
	}

	public String getTotal2() {
		return total2;
	}

	public void setTotal2(String total2) {
		this.total2 = total2;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public String getWhetherSeries() {
		return whetherSeries;
	}

	public void setWhetherSeries(String whetherSeries) {
		this.whetherSeries = whetherSeries;
	}

	public String getFulltitle() {
		return fulltitle;
	}

	public void setFulltitle(String fulltitle) {
		this.fulltitle = fulltitle;
	}

	public String getGuestWRWeight() {
		return guestWRWeight;
	}

	public void setGuestWRWeight(String guestWRWeight) {
		this.guestWRWeight = guestWRWeight;
	}

	public String getGuestWRSize() {
		return guestWRSize;
	}

	public void setGuestWRSize(String guestWRSize) {
		this.guestWRSize = guestWRSize;
	}

	public String getGuestWRGrade() {
		return guestWRGrade;
	}

	public void setGuestWRGrade(String guestWRGrade) {
		this.guestWRGrade = guestWRGrade;
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

	public void setTotalevaluate(BigDecimal totalevaluate) {
		this.totalevaluate = totalevaluate;
	}

	/** 按照numindex排序 */
	public int compareTo(DepositDetailBean o) {
		if (AppTool.isNullStr(this.numindex)) {
			return -1;
		}
		if (AppTool.isNullStr(o.numindex)) {
			return 1;
		}
		if (Integer.parseInt(this.getNumindex()) > Integer.parseInt(o
				.getNumindex())) {
			return 1;
		}
		return -1;
	}

	public String getCoinid() {
		return coinid;
	}

	public void setCoinid(String coinid) {
		this.coinid = coinid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getNumindex() {
		return numindex;
	}

	public void setNumindex(String numindex) {
		this.numindex = numindex;
	}

	public String getAmountofissue() {
		return amountofissue;
	}

	public void setAmountofissue(String amountofissue) {
		this.amountofissue = amountofissue;
	}

	public String getGuestappraisal() {
		return guestappraisal;
	}

	public void setGuestappraisal(String guestappraisal) {
		this.guestappraisal = guestappraisal;
	}

	public Integer getStampjointype() {
		return stampjointype;
	}

	public void setStampjointype(Integer stampjointype) {
		this.stampjointype = stampjointype;
	}

	private String formatBigDecimal(String price){
		if(price == null || "".equals(price)){
			return "0.00";
		}
		return price.replace(",", "");
	}
}
