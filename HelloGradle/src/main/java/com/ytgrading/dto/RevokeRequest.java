package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.Date;

public class RevokeRequest {
    private String rowid;

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

    private BigDecimal totalpreferential;

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

    private String applytype;

    private Date applytime;

    private BigDecimal othercost;

    private String costremark;

    private Date duetime;

    private String usedeals;

    private Integer resid;

    private String dealtype;

    private Integer serialnumber;
    private int entitytype;

    public int getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(int entitytype) {
		this.entitytype = entitytype;
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
        this.packagecode = packagecode == null ? null : packagecode.trim();
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
        this.userid = userid == null ? null : userid.trim();
    }

    public String getBoxcode() {
        return boxcode;
    }

    public void setBoxcode(String boxcode) {
        this.boxcode = boxcode == null ? null : boxcode.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid == null ? null : serviceid.trim();
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed == null ? null : speed.trim();
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
        this.wapper = wapper == null ? null : wapper.trim();
    }

    public String getSendtype() {
        return sendtype;
    }

    public void setSendtype(String sendtype) {
        this.sendtype = sendtype == null ? null : sendtype.trim();
    }

    public String getSendmethod() {
        return sendmethod;
    }

    public void setSendmethod(String sendmethod) {
        this.sendmethod = sendmethod == null ? null : sendmethod.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getReceivertel() {
        return receivertel;
    }

    public void setReceivertel(String receivertel) {
        this.receivertel = receivertel == null ? null : receivertel.trim();
    }

    public String getReceivermobile() {
        return receivermobile;
    }

    public void setReceivermobile(String receivermobile) {
        this.receivermobile = receivermobile == null ? null : receivermobile.trim();
    }

    public String getReceivermail() {
        return receivermail;
    }

    public void setReceivermail(String receivermail) {
        this.receivermail = receivermail == null ? null : receivermail.trim();
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
        this.address = address == null ? null : address.trim();
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public BigDecimal getTotalpreferential() {
        return totalpreferential;
    }

    public void setTotalpreferential(BigDecimal totalpreferential) {
        this.totalpreferential = totalpreferential;
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
        this.zip = zip == null ? null : zip.trim();
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
        this.requeststatus = requeststatus == null ? null : requeststatus.trim();
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
        this.delflag = delflag == null ? null : delflag.trim();
    }

    public String getInternalstates() {
        return internalstates;
    }

    public void setInternalstates(String internalstates) {
        this.internalstates = internalstates == null ? null : internalstates.trim();
    }

    public String getImgpath() {
        return imgpath;
    }
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getOwnid() {
        return ownid;
    }

    public void setOwnid(String ownid) {
        this.ownid = ownid == null ? null : ownid.trim();
    }

    public String getDeliveryno() {
        return deliveryno;
    }

    public void setDeliveryno(String deliveryno) {
        this.deliveryno = deliveryno == null ? null : deliveryno.trim();
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public String getConfirmstatus() {
        return confirmstatus;
    }

    public void setConfirmstatus(String confirmstatus) {
        this.confirmstatus = confirmstatus == null ? null : confirmstatus.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype == null ? null : applytype.trim();
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
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
        this.costremark = costremark == null ? null : costremark.trim();
    }

    public Date getDuetime() {
        return duetime;
    }

    public void setDuetime(Date duetime) {
        this.duetime = duetime;
    }

    public String getUsedeals() {
        return usedeals;
    }

    public void setUsedeals(String usedeals) {
        this.usedeals = usedeals == null ? null : usedeals.trim();
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }

    public String getDealtype() {
        return dealtype;
    }

    public void setDealtype(String dealtype) {
        this.dealtype = dealtype == null ? null : dealtype.trim();
    }

    public Integer getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(Integer serialnumber) {
        this.serialnumber = serialnumber;
    }
}