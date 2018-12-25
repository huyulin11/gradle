
package com.ytgrading.bean;

import java.util.Date;

public class StockSel {

     private String id; //ID
     private String sortid;
     private String postion; // 库位
     private String sortpostion;
     private String type; //R 申请单 P 包裹
     private String sorttype;
     private String remark; //备注
     private String sortremark;
     private Date accepttime; //修改时间
     private String sortaccepttime;
     private String acceptid; //入库人
     private String sortacceptid;
     private String sendid; //接收人
     private String sortsendid;
     private String stockno; //申请单号/包裹单号
     private String sortstockno;
     //R对应request表中internalstates字段
     //Plogistics_pack包裹表  前台显示--
     private String internalstates;
     private String sortinternalstates;
     private String requeststatus;
     private String sortrequeststatus;
     private String sendtype;
     private String sortsendtype;
     private String sortname;
     private String sortorder;
     private int pagenum;
     private int pageSize;
     private String reqremark;
     private int notifytimes;
     private String notice;
     private String requestcode;
     public int getNotifytimes() {
		return notifytimes;
	}
	public void setNotifytimes(int notifytimes) {
		this.notifytimes = notifytimes;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getReqremark() {
		return reqremark;
	}
	public void setReqremark(String reqremark) {
		this.reqremark = reqremark;
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
     public String getPostion(){
          return postion;
     }
     public void setPostion(String postion){
          this.postion = postion;
     }
     public String getSortpostion(){
          return sortpostion;
     }
     public void setSortpostion(String sortpostion){
          this.sortpostion = sortpostion;
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
     public Date getAccepttime(){
          return accepttime;
     }
     public void setAccepttime(Date accepttime){
          this.accepttime = accepttime;
     }
     public String getSortaccepttime(){
          return sortaccepttime;
     }
     public void setSortaccepttime(String sortaccepttime){
          this.sortaccepttime = sortaccepttime;
     }
     public String getAcceptid(){
          return acceptid;
     }
     public void setAcceptid(String acceptid){
          this.acceptid = acceptid;
     }
     public String getSortacceptid(){
          return sortacceptid;
     }
     public void setSortacceptid(String sortacceptid){
          this.sortacceptid = sortacceptid;
     }
     public String getSendid(){
          return sendid;
     }
     public void setSendid(String sendid){
          this.sendid = sendid;
     }
     public String getSortsendid(){
          return sortsendid;
     }
     public void setSortsendid(String sortsendid){
          this.sortsendid = sortsendid;
     }
     public String getStockno(){
          return stockno;
     }
     public void setStockno(String stockno){
          this.stockno = stockno;
     }
     public String getSortstockno(){
          return sortstockno;
     }
     public void setSortstockno(String sortstockno){
          this.sortstockno = sortstockno;
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
	public String getInternalstates() {
		return internalstates;
	}
	public void setInternalstates(String internalstates) {
		this.internalstates = internalstates;
	}
	public String getSortinternalstates() {
		return sortinternalstates;
	}
	public void setSortinternalstates(String sortinternalstates) {
		this.sortinternalstates = sortinternalstates;
	}
	public String getRequeststatus() {
		return requeststatus;
	}
	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}
	public String getSortrequeststatus() {
		return sortrequeststatus;
	}
	public void setSortrequeststatus(String sortrequeststatus) {
		this.sortrequeststatus = sortrequeststatus;
	}
	public String getSendtype() {
		return sendtype;
	}
	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}
	public String getSortsendtype() {
		return sortsendtype;
	}
	public void setSortsendtype(String sortsendtype) {
		this.sortsendtype = sortsendtype;
	}
	public String getRequestcode() {
		return requestcode;
	}
	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}
	
}
