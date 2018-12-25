package com.ytgrading.dto;


public class BackRequestCoin {
	private String rowid;

	private String id;

	private Integer coinid;

	private String requestid;

	private String requestdetailid;

	private String coincode;

	private Integer score;

	private Integer customerscore;

	private String remark;

	private String difversion;

	private String ratingreasondis;

	private String tagindex;
	private String backrecordsid;
	private String blockNum;
	private int difversioncode;
	private String weight;
	private String whetherSample;
	private String customSize;
	private String guestWRGrade;

	public String getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(String blockNum) {
		this.blockNum = blockNum;
	}

	public int getDifversioncode() {
		return difversioncode;
	}

	public void setDifversioncode(int difversioncode) {
		this.difversioncode = difversioncode;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWhetherSample() {
		return whetherSample;
	}

	public void setWhetherSample(String whetherSample) {
		this.whetherSample = whetherSample;
	}

	public String getCustomSize() {
		return customSize;
	}

	public void setCustomSize(String customSize) {
		this.customSize = customSize;
	}

	public String getGuestWRGrade() {
		return guestWRGrade;
	}

	public void setGuestWRGrade(String guestWRGrade) {
		this.guestWRGrade = guestWRGrade;
	}

	public String getBackrecordsid() {
		return backrecordsid;
	}

	public void setBackrecordsid(String backrecordsid) {
		this.backrecordsid = backrecordsid;
	}

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid == null ? null : rowid.trim();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
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
		this.requestid = requestid == null ? null : requestid.trim();
	}

	public String getRequestdetailid() {
		return requestdetailid;
	}

	public void setRequestdetailid(String requestdetailid) {
		this.requestdetailid = requestdetailid == null ? null : requestdetailid
				.trim();
	}

	public String getCoincode() {
		return coincode;
	}

	public void setCoincode(String coincode) {
		this.coincode = coincode == null ? null : coincode.trim();
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getCustomerscore() {
		return customerscore;
	}

	public void setCustomerscore(Integer customerscore) {
		this.customerscore = customerscore;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getDifversion() {
		return difversion;
	}

	public void setDifversion(String difversion) {
		this.difversion = difversion == null ? null : difversion.trim();
	}

	public String getRatingreasondis() {
		return ratingreasondis;
	}

	public void setRatingreasondis(String ratingreasondis) {
		this.ratingreasondis = ratingreasondis == null ? null : ratingreasondis
				.trim();
	}

	public String getTagindex() {
		return tagindex;
	}

	public void setTagindex(String tagindex) {
		this.tagindex = tagindex == null ? null : tagindex.trim();
	}
}