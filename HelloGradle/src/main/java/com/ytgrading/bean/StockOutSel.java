
package com.ytgrading.bean;
public class StockOutSel {

     private String id; //ID
     private String sortid;
     private String outby; //requestID
     private String sortoutby;
     private String outtime; //出库时间
     private String sortouttime;
     private String goodsid; //修改人
     private String sortgoodsid;
     private String confirmtime; //确认时间
     private String sortconfirmtime;
     private String confirmby; //确认人
     private String sortconfirmby;
     private String type; //内在状态
     private String sorttype;
     private String status; //状态
     private String sortstatus;
     private String sortname;
     private String sortorder;
     private int pagenum;
     private int pageSize;
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
     public String getOutby(){
          return outby;
     }
     public void setOutby(String outby){
          this.outby = outby;
     }
     public String getSortoutby(){
          return sortoutby;
     }
     public void setSortoutby(String sortoutby){
          this.sortoutby = sortoutby;
     }
     public String getOuttime(){
          return outtime;
     }
     public void setOuttime(String outtime){
          this.outtime = outtime;
     }
     public String getSortouttime(){
          return sortouttime;
     }
     public void setSortouttime(String sortouttime){
          this.sortouttime = sortouttime;
     }
     public String getGoodsid(){
          return goodsid;
     }
     public void setGoodsid(String goodsid){
          this.goodsid = goodsid;
     }
     public String getSortgoodsid(){
          return sortgoodsid;
     }
     public void setSortgoodsid(String sortgoodsid){
          this.sortgoodsid = sortgoodsid;
     }
     public String getConfirmtime(){
          return confirmtime;
     }
     public void setConfirmtime(String confirmtime){
          this.confirmtime = confirmtime;
     }
     public String getSortconfirmtime(){
          return sortconfirmtime;
     }
     public void setSortconfirmtime(String sortconfirmtime){
          this.sortconfirmtime = sortconfirmtime;
     }
     public String getConfirmby(){
          return confirmby;
     }
     public void setConfirmby(String confirmby){
          this.confirmby = confirmby;
     }
     public String getSortconfirmby(){
          return sortconfirmby;
     }
     public void setSortconfirmby(String sortconfirmby){
          this.sortconfirmby = sortconfirmby;
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
}
