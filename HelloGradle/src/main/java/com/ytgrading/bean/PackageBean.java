package com.ytgrading.bean;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class PackageBean {
	
	private PackageInfoBean packageInfoBean = new PackageInfoBean();
	private PackageRelationBean packageRelationBean = new PackageRelationBean();
	
	private List<PackageMainBean> packageMainlist = new AutoArrayList(PackageMainBean.class);
	
	public PackageInfoBean getPackageInfoBean() {
		return packageInfoBean;
	}

	public void setPackageInfoBean(PackageInfoBean packageInfoBean) {
		this.packageInfoBean = packageInfoBean;
	}

	public PackageRelationBean getPackageRelationBean() {
		return packageRelationBean;
	}

	public void setPackageRelationBean(PackageRelationBean packageRelationBean) {
		this.packageRelationBean = packageRelationBean;
	}

	public List<PackageMainBean> getPackageMainlist() {
		return packageMainlist;
	}

	public void setPackageMainlist(List<PackageMainBean> packageMainlist) {
		this.packageMainlist.clear();
		this.packageMainlist.addAll(packageMainlist);
	}
	
	public void initTime(){
		Date time = new Date();
		for(PackageMainBean list:packageMainlist){
			list.setCreateusertime(time);
		}
	}
	 
	public void initUserId(){
		int userId = 10000;
		for(PackageMainBean list:packageMainlist){
			list.setCreateuserid(userId);
		}
	}
	

}
