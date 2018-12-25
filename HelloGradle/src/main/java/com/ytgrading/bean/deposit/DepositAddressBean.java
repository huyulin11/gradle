package com.ytgrading.bean.deposit;

import java.util.Date;

public class DepositAddressBean {
	private String depositid;
	private String sendtype;
	private String receivername;
	private String receivertel;
	private String receivermobile;
	private String receivermail;
	private Integer country;
	private Integer province;
	private Integer city;
	private Integer area;
	private String address;
	private String zip;
	private String packagecode;
	private String usercardtype;
	private String usercardcode;
	private Date updatetime;
	private Date createtime;

	public String getDepositid() {
		return depositid;
	}

	public void setDepositid(String depositid) {
		this.depositid = depositid;
	}

	public String getSendtype() {
		return sendtype;
	}

	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPackagecode() {
		return packagecode;
	}

	public void setPackagecode(String packagecode) {
		this.packagecode = packagecode;
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

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
