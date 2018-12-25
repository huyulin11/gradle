/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @Description:
 * @Copyright:Copyright (c) 2013
 * @Company:FandaSoft
 * @Date:2013-5-17
 * @author jiangxx
 * @version 1.0
 */
public class RequestBean implements Comparable<RequestBean> {

	private List<RequestDetailBean> list = new AutoArrayList(
			RequestDetailBean.class);

	private List<RequestCoinBean> billReq = new AutoArrayList(
			RequestCoinBean.class);

	private List<RequestCoinBean> coinlst = new AutoArrayList(
			RequestCoinBean.class);

	private String id;

	private Integer requestcode;

	private String packagecode;

	private Integer usercode;

	private String userid;

	private String boxcode;

	private String customer;

	private String mobile;

	private String tel;

	private String fax;

	private String mail;

	private String serviceid;

	private String speed;

	private Integer speedext;

	private String wapper;

	private String sendtype;

	private String sendmethod;

	private String receiver;

	private String receivertel;

	private String receivermobile;

	private String receivermail;

	private Integer country;

	private Integer province;

	private Integer city;

	private Integer area;

	private String address;

	private String payment;

	private String remark;
	/**
	 * 送评方式（1为上门，2为物流）
	 */
	private String applytype;
	// 其他费用
	private String othercost;
	// 其他费用备注
	private String costremark;
	// 是否使用优惠券
	private String usedeals;
	private Integer resid; // 优惠券编号
	private String cointypename;// 币类型
	private String enfullsubject;// 英文题材全称
	private String isproxy;

	/**
	 * 鉴评总数(总数量)
	 */
	private Integer totalamount;
	/**
	 * 总重量
	 */
	private BigDecimal totalweight;
	/**
	 * 总估价
	 */
	private String totalevaluate;
	/**
	 * 总评级费
	 */
	private String totalreqcost;
	/**
	 * 总保险费
	 */
	private String totalpremium;
	/**
	 * 总运输费
	 */
	private String totaltransportation;
	/**
	 * 总保价费
	 */
	private String totalinsurance;
	/**
	 * 总费用(合计费用)
	 */
	private String totalcost;
	private String totalpreferential;// 优惠费用
	private String zip;
	private Date requesttime;
	private String requeststatus;
	private Date updatetime;
	private String delflag;
	private String internalstates;
	private String imgpath;
	private String ownid;
	private String deliveryno;
	private String paystatus;
	private String confirmstatus;
	private String notice;
	private Date applytime;
	private String isopen;
	private String agreement;// 1代表同意，0代表不同意
	private String usercardtype;
	private String usercardcode;
	private String addedcoinremark;
	private String sms;
	private int entitytype;

	private String reservationtypeid;// 活动编号
	private String couponid;// 活动对应电子券编号
	private Date createtime;

	private RequestFeeBean requestFee = new RequestFeeBean();

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

	public Integer getResid() {
		return resid;
	}

	public void setResid(Integer resid) {
		this.resid = resid;
	}

	public String getUsedeals() {
		return usedeals;
	}

	public void setUsedeals(String usedeals) {
		this.usedeals = usedeals;
	}

	public String getOthercost() {
		return othercost;
	}

	public void setOthercost(String othercost) {
		this.othercost = othercost;
	}

	public String getCostremark() {
		return costremark;
	}

	public void setCostremark(String costremark) {
		this.costremark = costremark;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getTotalpreferential() {
		return totalpreferential;
	}

	public void setTotalpreferential(String totalpreferential) {
		this.totalpreferential = totalpreferential;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRequestcode() {
		return requestcode;
	}

	public void setRequestcode(Integer requestcode) {
		this.requestcode = requestcode;
	}

	public String getPackagecode() {
		return packagecode;
	}

	public void setPackagecode(String packagecode) {
		this.packagecode = packagecode;
	}

	public Integer getUsercode() {
		return usercode;
	}

	public void setUsercode(Integer usercode) {
		this.usercode = usercode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBoxcode() {
		return boxcode;
	}

	public void setBoxcode(String boxcode) {
		this.boxcode = boxcode;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getServiceid() {
		return serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public Integer getSpeedext() {
		return speedext;
	}

	public void setSpeedext(Integer speedext) {
		this.speedext = speedext;
	}

	public String getWapper() {
		return wapper;
	}

	public void setWapper(String wapper) {
		this.wapper = wapper;
	}

	public String getSendtype() {
		return sendtype;
	}

	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}

	public String getSendmethod() {
		return sendmethod;
	}

	public void setSendmethod(String sendmethod) {
		this.sendmethod = sendmethod;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceivertel() {
		return receivertel;
	}

	public void setReceivertel(String receivertel) {
		this.receivertel = receivertel;
	}

	public String getReceivermobile() {
		return receivermobile;
	}

	public void setReceivermobile(String receivermobile) {
		this.receivermobile = receivermobile;
	}

	public String getReceivermail() {
		return receivermail;
	}

	public void setReceivermail(String receivermail) {
		this.receivermail = receivermail;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(BigDecimal totalweight) {
		this.totalweight = totalweight;
	}

	public Integer getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Integer totalamount) {
		this.totalamount = totalamount;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Date getRequesttime() {
		return requesttime;
	}

	public void setRequesttime(Date requesttime) {
		this.requesttime = requesttime;
	}

	public String getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getInternalstates() {
		return internalstates;
	}

	public void setInternalstates(String internalstates) {
		this.internalstates = internalstates;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getOwnid() {
		return ownid;
	}

	public void setOwnid(String ownid) {
		this.ownid = ownid;
	}

	public String getDeliveryno() {
		return deliveryno;
	}

	public void setDeliveryno(String deliveryno) {
		this.deliveryno = deliveryno;
	}

	public String getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

	public String getConfirmstatus() {
		return confirmstatus;
	}

	public void setConfirmstatus(String confirmstatus) {
		this.confirmstatus = confirmstatus;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Date getApplytime() {
		return applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public String getIsopen() {
		return isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

	public String getTotalevaluate() {
		return totalevaluate;
	}

	public void setTotalevaluate(String totalevaluate) {
		this.totalevaluate = totalevaluate;
	}

	public String getTotalreqcost() {
		return totalreqcost;
	}

	public void setTotalreqcost(String totalreqcost) {
		this.totalreqcost = totalreqcost;
	}

	public String getTotalpremium() {
		return totalpremium;
	}

	public void setTotalpremium(String totalpremium) {
		this.totalpremium = totalpremium;
	}

	public String getTotaltransportation() {
		return totaltransportation;
	}

	public void setTotaltransportation(String totaltransportation) {
		this.totaltransportation = totaltransportation;
	}

	public String getTotalinsurance() {
		return totalinsurance;
	}

	public void setTotalinsurance(String totalinsurance) {
		this.totalinsurance = totalinsurance;
	}

	public String getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getUsercardtype() {
		return usercardtype;
	}

	public void setUsercardtype(String usercardtype) {
		this.usercardtype = usercardtype;
	}

	public String getUsercardcode() {
		return usercardcode;
	}

	public void setUsercardcode(String usercardcode) {
		this.usercardcode = usercardcode;
	}

	public String getAddedcoinremark() {
		return addedcoinremark;
	}

	public void setAddedcoinremark(String addedcoinremark) {
		this.addedcoinremark = addedcoinremark;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public List<RequestDetailBean> getList() {
		return list;
	}

	public void setList(List<RequestDetailBean> list) {
		this.list.clear();
		this.list.addAll(list);
	}

	public List<RequestCoinBean> getBillReq() {
		return billReq;
	}

	public void setBillReq(List<RequestCoinBean> billReq) {
		this.billReq.clear();
		this.billReq.addAll(billReq);
	}

	public int getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(int entitytype) {
		this.entitytype = entitytype;
	}

	public String getReservationtypeid() {
		return reservationtypeid;
	}

	public void setReservationtypeid(String reservationtypeid) {
		this.reservationtypeid = reservationtypeid;
	}

	public String getCouponid() {
		return couponid;
	}

	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}

	public List<RequestCoinBean> getCoinlst() {
		return coinlst;
	}

	public void setCoinlst(List<RequestCoinBean> coinlst) {
		this.coinlst = coinlst;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getIsproxy() {
		return isproxy;
	}

	public void setIsproxy(String isproxy) {
		this.isproxy = isproxy;
	}

	public RequestFeeBean getRequestFee() {
		return requestFee;
	}

	public void setRequestFee(RequestFeeBean requestFee) {
		this.requestFee = requestFee;
	}

	@Override
	public int compareTo(RequestBean o) {
		if (o instanceof RequestBean) {
			RequestBean rb = (RequestBean) o;
			if (this.mobile == rb.mobile) {
				return 0;
			}
			if (this.country == rb.country) {
				return 0;
			}
			if (this.province == rb.province) {
				return 0;
			}
			if (this.city == rb.city) {
				return 0;
			}
			if (this.area == rb.area) {
				return 0;
			}
			if (this.address.equals(rb.address)) {
				return 0;
			}
		}
		return -1;
	}
}
