
package com.ytgrading.bean;
public class WalletRefundSel {
	 private String mtype;//类型
     private String id; //申请单号
     private String sortid;
     private String amount; //退款金额
     private String sortamount;
     private String type; //退款方式
     private String sorttype;
     private String refundno; //申请单号
     private String sortrefundno;
     private String walletid; //钱包
     private String sortwalletid;
     private String remark; //备注
     private String sortremark;
     private String status; //状态
     private String sortstatus;
     private String confirmdate; //确认日期
     private String sortconfirmdate;
     private String confirmuserid; //确认人
     private String sortconfirmuserid;
     private String delflag; //是否删除
     private String sortdelflag;
     private String userid; //所有人
     private String sortuserid;
     private String refunddate; //申请时间
     private String sortrefunddate;
     private String capitalid; //银行账号/邮政汇款id
     private String sortcapitalid;
     private String orderdate; //上门自取预约时间
     private String sortorderdate;
     private String capitalvalue; //内容
     private String sortcapitalvalue;
     private String sortname;
     private String sortorder;
     private int pagenum;
     private int pageSize;
     private String usercode;
     private String sortusercode;
     private String username;
     private String sortusername;
     private String refunddateend; //
     private String sortrefunddateend; 
     private String EWallet;
     private String documentType;
     private String documentCode;
     private String defaultmobile;
     private String defaultmail;
     
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getEWallet() {
		return EWallet;
	}
	public void setEWallet(String eWallet) {
		EWallet = eWallet;
	}
	public String getId(){
          return id;
     }
     public void setId(String id){
          this.id = id;
     }
     public String getSortid(){
          return sortid;
     }
     public void setSortid(String sortid){
          this.sortid = sortid;
     }
     public String getAmount(){
          return amount;
     }
     public void setAmount(String amount){
          this.amount = amount;
     }
     public String getSortamount(){
          return sortamount;
     }
     public void setSortamount(String sortamount){
          this.sortamount = sortamount;
     }
     public String getType(){
          return type;
     }
     public void setType(String type){
          this.type = type;
     }
     public String getSorttype(){
          return sorttype;
     }
     public void setSorttype(String sorttype){
          this.sorttype = sorttype;
     }
     public String getRefundno(){
          return refundno;
     }
     public void setRefundno(String refundno){
          this.refundno = refundno;
     }
     public String getSortrefundno(){
          return sortrefundno;
     }
     public void setSortrefundno(String sortrefundno){
          this.sortrefundno = sortrefundno;
     }
     public String getWalletid(){
          return walletid;
     }
     public void setWalletid(String walletid){
          this.walletid = walletid;
     }
     public String getSortwalletid(){
          return sortwalletid;
     }
     public void setSortwalletid(String sortwalletid){
          this.sortwalletid = sortwalletid;
     }
     public String getRemark(){
          return remark;
     }
     public void setRemark(String remark){
          this.remark = remark;
     }
     public String getSortremark(){
          return sortremark;
     }
     public void setSortremark(String sortremark){
          this.sortremark = sortremark;
     }
     public String getStatus(){
          return status;
     }
     public void setStatus(String status){
          this.status = status;
     }
     public String getSortstatus(){
          return sortstatus;
     }
     public void setSortstatus(String sortstatus){
          this.sortstatus = sortstatus;
     }
     public String getConfirmdate(){
          return confirmdate;
     }
     public void setConfirmdate(String confirmdate){
          this.confirmdate = confirmdate;
     }
     public String getSortconfirmdate(){
          return sortconfirmdate;
     }
     public void setSortconfirmdate(String sortconfirmdate){
          this.sortconfirmdate = sortconfirmdate;
     }
     public String getConfirmuserid(){
          return confirmuserid;
     }
     public void setConfirmuserid(String confirmuserid){
          this.confirmuserid = confirmuserid;
     }
     public String getSortconfirmuserid(){
          return sortconfirmuserid;
     }
     public void setSortconfirmuserid(String sortconfirmuserid){
          this.sortconfirmuserid = sortconfirmuserid;
     }
     public String getDelflag(){
          return delflag;
     }
     public void setDelflag(String delflag){
          this.delflag = delflag;
     }
     public String getSortdelflag(){
          return sortdelflag;
     }
     public void setSortdelflag(String sortdelflag){
          this.sortdelflag = sortdelflag;
     }
     public String getUserid(){
          return userid;
     }
     public void setUserid(String userid){
          this.userid = userid;
     }
     public String getSortuserid(){
          return sortuserid;
     }
     public void setSortuserid(String sortuserid){
          this.sortuserid = sortuserid;
     }
     public String getRefunddate(){
          return refunddate;
     }
     public void setRefunddate(String refunddate){
          this.refunddate = refunddate;
     }
     public String getSortrefunddate(){
          return sortrefunddate;
     }
     public void setSortrefunddate(String sortrefunddate){
          this.sortrefunddate = sortrefunddate;
     }
     public String getCapitalid(){
          return capitalid;
     }
     public void setCapitalid(String capitalid){
          this.capitalid = capitalid;
     }
     public String getSortcapitalid(){
          return sortcapitalid;
     }
     public void setSortcapitalid(String sortcapitalid){
          this.sortcapitalid = sortcapitalid;
     }
     public String getOrderdate(){
          return orderdate;
     }
     public void setOrderdate(String orderdate){
          this.orderdate = orderdate;
     }
     public String getSortorderdate(){
          return sortorderdate;
     }
     public void setSortorderdate(String sortorderdate){
          this.sortorderdate = sortorderdate;
     }
     public String getCapitalvalue(){
          return capitalvalue;
     }
     public void setCapitalvalue(String capitalvalue){
          this.capitalvalue = capitalvalue;
     }
     public String getSortcapitalvalue(){
          return sortcapitalvalue;
     }
     public void setSortcapitalvalue(String sortcapitalvalue){
          this.sortcapitalvalue = sortcapitalvalue;
     }
	 public int getPagenum() {
	  return pagenum;
	 }
	
	 public void setPagenum(int pagenum) {
	  this.pagenum = pagenum;
	 }
	
	 public int getPageSize() {
	  return pageSize;
	 }
	
	 public void setPageSize(int pageSize) {
	  this.pageSize = pageSize;
	 }
	
	 public String getSortname() {
	  return sortname;
	 }
	
	 public void setSortname(String sortname) {
	  this.sortname = sortname;
	 }
	
	 public String getSortorder() {
	  return sortorder;
	 }
	
	 public void setSortorder(String sortorder) {
	  this.sortorder = sortorder;
	 }
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getSortusercode() {
		return sortusercode;
	}
	public void setSortusercode(String sortusercode) {
		this.sortusercode = sortusercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSortusername() {
		return sortusername;
	}
	public void setSortusername(String sortusername) {
		this.sortusername = sortusername;
	}
	public String getRefunddateend() {
		return refunddateend;
	}
	public void setRefunddateend(String refunddateend) {
		this.refunddateend = refunddateend;
	}
	public String getSortrefunddateend() {
		return sortrefunddateend;
	}
	public void setSortrefunddateend(String sortrefunddateend) {
		this.sortrefunddateend = sortrefunddateend;
	}
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDefaultmobile() {
		return defaultmobile;
	}
	public void setDefaultmobile(String defaultmobile) {
		this.defaultmobile = defaultmobile;
	}
	public String getDefaultmail() {
		return defaultmail;
	}
	public void setDefaultmail(String defaultmail) {
		this.defaultmail = defaultmail;
	}
	 
}
