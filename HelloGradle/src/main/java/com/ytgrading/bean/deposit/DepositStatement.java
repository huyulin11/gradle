package com.ytgrading.bean.deposit;

import java.math.BigDecimal;

public class DepositStatement{

		// 托管单内部流转号
		private Integer innerno;
		// 托管单预约号
		private Integer reservno;
		//硬币编号
		private String coincode;
		//名称（年号+题材+重量+面值+精/普+材质）
		private String tagindex;
		//硬币备注
		private String remark;
		//估价
		private BigDecimal evaluate;
		//行号
		private Integer numindex;
		//用户编号
		private Integer usercode;
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
		private Integer totalamount;
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
		private String paystate;
		//发行量
		private Integer amountofissue;
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
		private Integer sameCoinNum;//同种币的数量
		private BigDecimal totalpreferential;//总优惠
		private String othercost;//其他费用 
		private String ratingreasondis;//不评级原因
		private String coincountry;//币的国别
		private String entitytype;//币的类别
		public Integer getInnerno() {
			return innerno;
		}
		public Integer getReservno() {
			return reservno;
		}
		public String getCoincode() {
			return coincode;
		}
		public String getTagindex() {
			return tagindex;
		}
		public String getRemark() {
			return remark;
		}
		public BigDecimal getEvaluate() {
			return evaluate;
		}
		public Integer getNumindex() {
			return numindex;
		}
		public Integer getUsercode() {
			return usercode;
		}
		public String getCustomer() {
			return customer;
		}
		public String getMobile() {
			return mobile;
		}
		public String getMail() {
			return mail;
		}
		public String getServiceid() {
			return serviceid;
		}
		public String getSpeed() {
			return speed;
		}
		public Integer getTotalamount() {
			return totalamount;
		}
		public BigDecimal getTotalweight() {
			return totalweight;
		}
		public BigDecimal getTotalevaluate() {
			return totalevaluate;
		}
		public BigDecimal getTotalreqcost() {
			return totalreqcost;
		}
		public BigDecimal getTotalpremium() {
			return totalpremium;
		}
		public BigDecimal getTotaltransportation() {
			return totaltransportation;
		}
		public BigDecimal getTotalinsurance() {
			return totalinsurance;
		}
		public BigDecimal getTotalcost() {
			return totalcost;
		}
		public String getSendtype() {
			return sendtype;
		}
		public String getPayment() {
			return payment;
		}
		public String getCountry() {
			return country;
		}
		public String getProvince() {
			return province;
		}
		public String getCity() {
			return city;
		}
		public String getArea() {
			return area;
		}
		public String getAddress() {
			return address;
		}
		public String getFulladdress() {
			return fulladdress;
		}
		public String getAmountInWords() {
			return amountInWords;
		}
		public String getFormatEvaluate() {
			return formatEvaluate;
		}
		public String getFormatTotalCost() {
			return formatTotalCost;
		}
		public BigDecimal getScore() {
			return score;
		}
		public String getPaystate() {
			return paystate;
		}
		public Integer getAmountofissue() {
			return amountofissue;
		}
		public String getFormatTotalevaluate() {
			return formatTotalevaluate;
		}
		public String getFormatTotalreqcost() {
			return formatTotalreqcost;
		}
		public String getFormatTotalpremium() {
			return formatTotalpremium;
		}
		public String getFormatTotaltransportation() {
			return formatTotaltransportation;
		}
		public String getFormatTotalinsurance() {
			return formatTotalinsurance;
		}
		public String getGuestappraisal() {
			return guestappraisal;
		}
		public BigDecimal getTotalcoincost() {
			return totalcoincost;
		}
		public Integer getSameCoinNum() {
			return sameCoinNum;
		}
		public BigDecimal getTotalpreferential() {
			return totalpreferential;
		}
		public String getOthercost() {
			return othercost;
		}
		public String getRatingreasondis() {
			return ratingreasondis;
		}
		public String getCoincountry() {
			return coincountry;
		}
		public String getEntitytype() {
			return entitytype;
		}
		public void setInnerno(Integer innerno) {
			this.innerno = innerno;
		}
		public void setReservno(Integer reservno) {
			this.reservno = reservno;
		}
		public void setCoincode(String coincode) {
			this.coincode = coincode;
		}
		public void setTagindex(String tagindex) {
			this.tagindex = tagindex;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public void setEvaluate(BigDecimal evaluate) {
			this.evaluate = evaluate;
		}
		public void setNumindex(Integer numindex) {
			this.numindex = numindex;
		}
		public void setUsercode(Integer usercode) {
			this.usercode = usercode;
		}
		public void setCustomer(String customer) {
			this.customer = customer;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public void setServiceid(String serviceid) {
			this.serviceid = serviceid;
		}
		public void setSpeed(String speed) {
			this.speed = speed;
		}
		public void setTotalamount(Integer totalamount) {
			this.totalamount = totalamount;
		}
		public void setTotalweight(BigDecimal totalweight) {
			this.totalweight = totalweight;
		}
		public void setTotalevaluate(BigDecimal totalevaluate) {
			this.totalevaluate = totalevaluate;
		}
		public void setTotalreqcost(BigDecimal totalreqcost) {
			this.totalreqcost = totalreqcost;
		}
		public void setTotalpremium(BigDecimal totalpremium) {
			this.totalpremium = totalpremium;
		}
		public void setTotaltransportation(BigDecimal totaltransportation) {
			this.totaltransportation = totaltransportation;
		}
		public void setTotalinsurance(BigDecimal totalinsurance) {
			this.totalinsurance = totalinsurance;
		}
		public void setTotalcost(BigDecimal totalcost) {
			this.totalcost = totalcost;
		}
		public void setSendtype(String sendtype) {
			this.sendtype = sendtype;
		}
		public void setPayment(String payment) {
			this.payment = payment;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setFulladdress(String fulladdress) {
			this.fulladdress = fulladdress;
		}
		public void setAmountInWords(String amountInWords) {
			this.amountInWords = amountInWords;
		}
		public void setFormatEvaluate(String formatEvaluate) {
			this.formatEvaluate = formatEvaluate;
		}
		public void setFormatTotalCost(String formatTotalCost) {
			this.formatTotalCost = formatTotalCost;
		}
		public void setScore(BigDecimal score) {
			this.score = score;
		}
		public void setPaystate(String paystate) {
			this.paystate = paystate;
		}
		public void setAmountofissue(Integer amountofissue) {
			this.amountofissue = amountofissue;
		}
		public void setFormatTotalevaluate(String formatTotalevaluate) {
			this.formatTotalevaluate = formatTotalevaluate;
		}
		public void setFormatTotalreqcost(String formatTotalreqcost) {
			this.formatTotalreqcost = formatTotalreqcost;
		}
		public void setFormatTotalpremium(String formatTotalpremium) {
			this.formatTotalpremium = formatTotalpremium;
		}
		public void setFormatTotaltransportation(String formatTotaltransportation) {
			this.formatTotaltransportation = formatTotaltransportation;
		}
		public void setFormatTotalinsurance(String formatTotalinsurance) {
			this.formatTotalinsurance = formatTotalinsurance;
		}
		public void setGuestappraisal(String guestappraisal) {
			this.guestappraisal = guestappraisal;
		}
		public void setTotalcoincost(BigDecimal totalcoincost) {
			this.totalcoincost = totalcoincost;
		}
		public void setSameCoinNum(Integer sameCoinNum) {
			this.sameCoinNum = sameCoinNum;
		}
		public void setTotalpreferential(BigDecimal totalpreferential) {
			this.totalpreferential = totalpreferential;
		}
		public void setOthercost(String othercost) {
			this.othercost = othercost;
		}
		public void setRatingreasondis(String ratingreasondis) {
			this.ratingreasondis = ratingreasondis;
		}
		public void setCoincountry(String coincountry) {
			this.coincountry = coincountry;
		}
		public void setEntitytype(String entitytype) {
			this.entitytype = entitytype;
		}
}
