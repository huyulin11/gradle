package com.ytgrading.bean;

import java.math.BigDecimal;

public class Statement {
	//申请单编号
	private int requestcode;
	//硬币编号
	private String coincode;
	//名称（年号+题材+重量+面值+精/普+材质）
	private String tagindex;
	//硬币备注
	private String remark;
	//估价
	private BigDecimal evaluate;
	//行号
	private int numindex;
	//用户编号
	private int usercode;
	//申请人姓名
	private String customer;
	//手机
	private String mobile;
	//邮件地址
	private String mail;
	//服务类型
	private String serviceid;
	//速度
	private String speed;
	//总枚数
	private int totalamount;
	//总重量
	private BigDecimal totalweight;
	//总估价
	private BigDecimal totalevaluate;
	//总评级费
	private BigDecimal totalreqcost;
	//总保险费
	private BigDecimal totalpremium;
	//总运输费
	private BigDecimal totaltransportation;
	//总保价费
	private BigDecimal totalinsurance;
	//总费用
	private BigDecimal totalcost;
	//取件方式
	private String sendtype;
	//付款方式
	private String payment;
	//国家
	private String country;
	//省份
	private String province;
	//城市
	private String city;
	//地区
	private String area;
	//街道地址
	private String address;
	//地址信息全称
	private String fulladdress;
	//大写金额
	private String amountInWords;
	//format单枚币估价
	private String formatEvaluate;
	//总消费format金额
	private String formatTotalCost;
	//得分
	private BigDecimal score;
	//支付状态(0为未支付，1为已支付)
	private String paystatus;
	//发行量
	private int amountofissue;
	//format总估价
	private String formatTotalevaluate;
	//format总评级费
	private String formatTotalreqcost;
	//format总保险费
	private String formatTotalpremium;
	//format总运输费
	private String formatTotaltransportation;
	//format总保价费
	private String formatTotalinsurance;
	private String guestappraisal;
	private BigDecimal totalcoincost;
	private int sameCoinNum;//同种币的数量
	private BigDecimal totalpreferential;//总优惠
	private String othercost;//其他费用 
	private String ratingreasondis;//不评级原因
	private String coincountry;//币的国别
	private String entitytype;//币的类别
	private String scores;
	
	public String getEntitytype() {
		return entitytype;
	}
	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}
	public String getCoincountry() {
		return coincountry;
	}
	public void setCoincountry(String coincountry) {
		this.coincountry = coincountry;
	}
	public String getRatingreasondis() {
		return ratingreasondis;
	}
	public void setRatingreasondis(String ratingreasondis) {
		this.ratingreasondis = ratingreasondis;
	}
	public BigDecimal getTotalpreferential() {
		return totalpreferential;
	}
	public void setTotalpreferential(BigDecimal totalpreferential) {
		this.totalpreferential = totalpreferential;
	}
	public String getOthercost() {
		return othercost;
	}
	public void setOthercost(String othercost) {
		this.othercost = othercost;
	}
	public int getSameCoinNum() {
		return sameCoinNum;
	}
	public void setSameCoinNum(int sameCoinNum) {
		this.sameCoinNum = sameCoinNum;
	}
	public BigDecimal getTotalcoincost() {
		return totalcoincost;
	}
	public void setTotalcoincost(BigDecimal totalcoincost) {
		this.totalcoincost = totalcoincost;
	}
	public String getGuestappraisal() {
		return guestappraisal;
	}
	public void setGuestappraisal(String guestappraisal) {
		this.guestappraisal = guestappraisal;
	}
	public synchronized String getFormatEvaluate() {
		return formatEvaluate;
	}
	public synchronized void setFormatEvaluate(String formatEvaluate) {
		this.formatEvaluate = formatEvaluate;
	}
	public synchronized String getFormatTotalpremium() {
		return formatTotalpremium;
	}
	public synchronized void setFormatTotalpremium(String formatTotalpremium) {
		this.formatTotalpremium = formatTotalpremium;
	}
	public synchronized String getFormatTotaltransportation() {
		return formatTotaltransportation;
	}
	public synchronized void setFormatTotaltransportation(
			String formatTotaltransportation) {
		this.formatTotaltransportation = formatTotaltransportation;
	}
	public synchronized String getFormatTotalinsurance() {
		return formatTotalinsurance;
	}
	public synchronized void setFormatTotalinsurance(String formatTotalinsurance) {
		this.formatTotalinsurance = formatTotalinsurance;
	}
	public synchronized String getFormatTotalreqcost() {
		return formatTotalreqcost;
	}
	public synchronized void setFormatTotalreqcost(String formatTotalreqcost) {
		this.formatTotalreqcost = formatTotalreqcost;
	}
	public synchronized String getFormatTotalevaluate() {
		return formatTotalevaluate;
	}
	public synchronized void setFormatTotalevaluate(String formatTotalevaluate) {
		this.formatTotalevaluate = formatTotalevaluate;
	}
	public synchronized int getAmountofissue() {
		return amountofissue;
	}
	public synchronized void setAmountofissue(int amountofissue) {
		this.amountofissue = amountofissue;
	}
	public synchronized String getPaystatus() {
		return paystatus;
	}
	public synchronized void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}
	public synchronized BigDecimal getScore() {
		return score;
	}
	public synchronized void setScore(BigDecimal score) {
		this.score = score;
	}
	public synchronized String getFormatTotalCost() {
		return formatTotalCost;
	}
	public synchronized void setFormatTotalCost(String formatTotalCost) {
		this.formatTotalCost = formatTotalCost;
	}
	public synchronized String getAmountInWords() {
		return amountInWords;
	}
	public synchronized void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}
	public synchronized String getCountry() {
		return country;
	}
	public synchronized void setCountry(String country) {
		this.country = country;
	}
	public synchronized String getProvince() {
		return province;
	}
	public synchronized void setProvince(String province) {
		this.province = province;
	}
	public synchronized String getCity() {
		return city;
	}
	public synchronized void setCity(String city) {
		this.city = city;
	}
	public synchronized String getArea() {
		return area;
	}
	public synchronized void setArea(String area) {
		this.area = area;
	}
	public synchronized String getAddress() {
		return address;
	}
	public synchronized void setAddress(String address) {
		this.address = address;
	}
	public synchronized String getFulladdress() {
		return fulladdress;
	}
	public synchronized void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	public synchronized int getRequestcode() {
		return requestcode;
	}
	public synchronized void setRequestcode(int requestcode) {
		this.requestcode = requestcode;
	}
	public synchronized String getCoincode() {
		return coincode;
	}
	public synchronized void setCoincode(String coincode) {
		this.coincode = coincode;
	}
	public synchronized String getTagindex() {
		return tagindex;
	}
	public synchronized void setTagindex(String tagindex) {
		this.tagindex = tagindex;
	}
	public synchronized String getRemark() {
		return remark;
	}
	public synchronized void setRemark(String remark) {
		this.remark = remark;
	}
	public synchronized BigDecimal getEvaluate() {
		return evaluate;
	}
	public synchronized void setEvaluate(BigDecimal evaluate) {
		this.evaluate = evaluate;
	}
	public synchronized int getNumindex() {
		return numindex;
	}
	public synchronized void setNumindex(int numindex) {
		this.numindex = numindex;
	}
	public synchronized int getUsercode() {
		return usercode;
	}
	public synchronized void setUsercode(int usercode) {
		this.usercode = usercode;
	}
	public synchronized String getCustomer() {
		return customer;
	}
	public synchronized void setCustomer(String customer) {
		this.customer = customer;
	}
	public synchronized String getMobile() {
		return mobile;
	}
	public synchronized void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public synchronized String getMail() {
		return mail;
	}
	public synchronized void setMail(String mail) {
		this.mail = mail;
	}
	public synchronized String getServiceid() {
		return serviceid;
	}
	public synchronized void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}
	public synchronized String getSpeed() {
		return speed;
	}
	public synchronized void setSpeed(String speed) {
		this.speed = speed;
	}
	public synchronized int getTotalamount() {
		return totalamount;
	}
	public synchronized void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	public synchronized BigDecimal getTotalweight() {
		return totalweight;
	}
	public synchronized void setTotalweight(BigDecimal totalweight) {
		this.totalweight = totalweight;
	}
	public synchronized BigDecimal getTotalevaluate() {
		return totalevaluate;
	}
	public synchronized void setTotalevaluate(BigDecimal totalevaluate) {
		this.totalevaluate = totalevaluate;
	}
	public synchronized BigDecimal getTotalreqcost() {
		return totalreqcost;
	}
	public synchronized void setTotalreqcost(BigDecimal totalreqcost) {
		this.totalreqcost = totalreqcost;
	}
	public synchronized BigDecimal getTotalpremium() {
		return totalpremium;
	}
	public synchronized void setTotalpremium(BigDecimal totalpremium) {
		this.totalpremium = totalpremium;
	}
	public synchronized BigDecimal getTotaltransportation() {
		return totaltransportation;
	}
	public synchronized void setTotaltransportation(BigDecimal totaltransportation) {
		this.totaltransportation = totaltransportation;
	}
	public synchronized BigDecimal getTotalinsurance() {
		return totalinsurance;
	}
	public synchronized void setTotalinsurance(BigDecimal totalinsurance) {
		this.totalinsurance = totalinsurance;
	}
	public synchronized BigDecimal getTotalcost() {
		return totalcost;
	}
	public synchronized void setTotalcost(BigDecimal totalcost) {
		this.totalcost = totalcost;
	}
	public synchronized String getSendtype() {
		return sendtype;
	}
	public synchronized void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}
	public synchronized String getPayment() {
		return payment;
	}
	public synchronized void setPayment(String payment) {
		this.payment = payment;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	
}
