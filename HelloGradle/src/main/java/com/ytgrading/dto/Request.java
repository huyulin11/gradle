package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.ytgrading.bean.RequestFeeBean;

public class Request { 
	private Date duetime;
	private String resid;
	private String totalpreferential;// 优惠费用
	// 是否使用优惠券
	private String usedeals;
	// 送评方式
	private String applytype;
	// 其他费用
	private BigDecimal othercost;
	// 其他费用备注
	private String costremark;
	private String reqowner;
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
	private BigDecimal totalpremium;
	private BigDecimal totaltransportation;
	private BigDecimal totalinsurance;
	private BigDecimal totalreqcost;
	private BigDecimal totalcost;
	private BigDecimal totalweight;
	private Integer totalamount;
	private BigDecimal totalevaluate;
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
	private String agreement;
	private String isproxy;
	private String usercardtype;
	private String usercardcode;
	private String addedcoinremark;
	private String payinfo;
	private int entitytype;
	private String scroes;

	private RequestFeeBean requestFee = new RequestFeeBean();

	public Date getDuetime() {
		return duetime;
	}

	public void setDuetime(Date duetime) {
		this.duetime = duetime;
	}

	public BigDecimal getOthercost() {
		return othercost;
	}

	public void setOthercost(BigDecimal othercost) {
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

	public String getResid() {
		return resid;
	}

	public void setResid(String resid) {
		this.resid = resid;
	}

	public String getTotalpreferential() {
		return totalpreferential;
	}

	public void setTotalpreferential(String totalpreferential) {
		this.totalpreferential = totalpreferential;
	}

	public String getUsedeals() {
		return usedeals;
	}

	public void setUsedeals(String usedeals) {
		this.usedeals = usedeals;
	}

	public String getReqowner() {
		return reqowner;
	}

	public void setReqowner(String reqowner) {
		this.reqowner = reqowner;
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

	public BigDecimal getTotalpremium() {
		return totalpremium;
	}

	public void setTotalpremium(BigDecimal totalpremium) {
		this.totalpremium = totalpremium;
	}

	public BigDecimal getTotaltransportation() {
		return totaltransportation;
	}

	public void setTotaltransportation(BigDecimal totaltransportation) {
		this.totaltransportation = totaltransportation;
	}

	public BigDecimal getTotalinsurance() {
		return totalinsurance;
	}

	public void setTotalinsurance(BigDecimal totalinsurance) {
		this.totalinsurance = totalinsurance;
	}

	public BigDecimal getTotalreqcost() {
		return totalreqcost;
	}

	public void setTotalreqcost(BigDecimal totalreqcost) {
		this.totalreqcost = totalreqcost;
	}

	public BigDecimal getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(BigDecimal totalcost) {
		this.totalcost = totalcost;
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

	public BigDecimal getTotalevaluate() {
		return totalevaluate;
	}

	public void setTotalevaluate(BigDecimal totalevaluate) {
		this.totalevaluate = totalevaluate;
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

	public String getPayinfo() {
		return payinfo;
	}

	public void setPayinfo(String payinfo) {
		this.payinfo = payinfo;
	}

	public String getAddedcoinremark() {
		return addedcoinremark;
	}

	public void setAddedcoinremark(String addedcoinremark) {
		this.addedcoinremark = addedcoinremark;
	}

	public int getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(int entitytype) {
		this.entitytype = entitytype;
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

	public String getScroes() {
		return scroes;
	}

	public void setScroes(String scroes) {
		this.scroes = scroes;
	}
	
	
}