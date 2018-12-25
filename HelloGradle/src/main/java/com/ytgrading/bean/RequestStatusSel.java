
package com.ytgrading.bean;
public class RequestStatusSel {

     private String id; //ID
     private String sortid;
     private String requestid; //requestID
     private String sortrequestid;
     private String status; //状态
     private String sortstatus;
     private String updateby; //修改人
     private String sortupdateby;
     private String updatetime; //修改时间
     private String sortupdatetime;
     private String ownerid; //所有人
     private String sortownerid;
     private String internalstates; //内在状态
     private String sortinternalstates;
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
     public String getRequestid(){
          return requestid;
     }
     public void setRequestid(String requestid){
          this.requestid = requestid;
     }
     public String getSortrequestid(){
          return sortrequestid;
     }
     public void setSortrequestid(String sortrequestid){
          this.sortrequestid = sortrequestid;
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
     public String getUpdateby(){
          return updateby;
     }
     public void setUpdateby(String updateby){
          this.updateby = updateby;
     }
     public String getSortupdateby(){
          return sortupdateby;
     }
     public void setSortupdateby(String sortupdateby){
          this.sortupdateby = sortupdateby;
     }
     public String getUpdatetime(){
          return updatetime;
     }
     public void setUpdatetime(String updatetime){
          this.updatetime = updatetime;
     }
     public String getSortupdatetime(){
          return sortupdatetime;
     }
     public void setSortupdatetime(String sortupdatetime){
          this.sortupdatetime = sortupdatetime;
     }
     public String getOwnerid(){
          return ownerid;
     }
     public void setOwnerid(String ownerid){
          this.ownerid = ownerid;
     }
     public String getSortownerid(){
          return sortownerid;
     }
     public void setSortownerid(String sortownerid){
          this.sortownerid = sortownerid;
     }
     public String getInternalstates(){
          return internalstates;
     }
     public void setInternalstates(String internalstates){
          this.internalstates = internalstates;
     }
     public String getSortinternalstates(){
          return sortinternalstates;
     }
     public void setSortinternalstates(String sortinternalstates){
          this.sortinternalstates = sortinternalstates;
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
