package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.List;

import com.ytgrading.util.AppTool;

@Deprecated
public class RequestCoin implements Comparable<RequestCoin> {
	private String id;

	private Integer coinid;

	private String requestid;

	private String requestdetailid;

	private String coincode;

	private BigDecimal score;

	private BigDecimal customerscore;

	private String tagindex;
	private List<String> pathlist;
	private List<String> pathlistbase;
	private String remark;
	private String difversion;
	private String ratingreasondis;
	private int difversioncode; // 版别ID
	private String wmk; // 水印
	private String whetherSample; // 是否票样
	private String blockNum; // 冠字号

	private String weight;
	private String guestWRGrade;
	private String customSize;

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getGuestWRGrade() {
		return guestWRGrade;
	}

	public void setGuestWRGrade(String guestWRGrade) {
		this.guestWRGrade = guestWRGrade;
	}

	public String getCustomSize() {
		return customSize;
	}

	public void setCustomSize(String customSize) {
		this.customSize = customSize;
	}

	public int getDifversioncode() {
		return difversioncode;
	}

	public void setDifversioncode(int difversioncode) {
		this.difversioncode = difversioncode;
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

	public String getDifversion() {
		return difversion;
	}

	public void setDifversion(String difversion) {
		this.difversion = difversion;
	}

	public String getRatingreasondis() {
		return ratingreasondis;
	}

	public void setRatingreasondis(String ratingreasondis) {
		this.ratingreasondis = ratingreasondis;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<String> getPathlistbase() {
		return pathlistbase;
	}

	public void setPathlistbase(List<String> pathlistbase) {
		this.pathlistbase = pathlistbase;
	}

	private int imgnum;

	public synchronized List<String> getPathlist() {
		return pathlist;
	}

	public synchronized void setPathlist(List<String> pathlist) {
		this.pathlist = pathlist;
	}

	public synchronized int getImgnum() {
		return imgnum;
	}

	public synchronized void setImgnum(int imgnum) {
		this.imgnum = imgnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCoinid() {
		return coinid;
	}

	public void setCoinid(Integer coinid) {
		this.coinid = coinid;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getRequestdetailid() {
		return requestdetailid;
	}

	public void setRequestdetailid(String requestdetailid) {
		this.requestdetailid = requestdetailid;
	}

	public String getCoincode() {
		return coincode;
	}

	public void setCoincode(String coincode) {
		this.coincode = coincode;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public BigDecimal getCustomerscore() {
		return customerscore;
	}

	public void setCustomerscore(BigDecimal customerscore) {
		this.customerscore = customerscore;
	}

	public String getTagindex() {
		return tagindex;
	}

	public void setTagindex(String tagindex) {
		this.tagindex = tagindex;
	}

	/** 按照coincode排序 */
	public int compareTo(RequestCoin o) {
		if (AppTool.isNullStr(this.coincode)) {
			return -1;
		}
		if (AppTool.isNullStr(o.coincode)) {
			return 1;
		}
		if (Integer.parseInt(this.getCoincode()) > Integer.parseInt(o
				.getCoincode())) {
			return 1;
		}
		return -1;
	}

}