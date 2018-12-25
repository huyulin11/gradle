package com.ytgrading.dao;

import java.util.List;

import com.ytgrading.bean.PackageInfoBean;
import com.ytgrading.bean.PackageRelationBean;
import com.ytgrading.bean.RequestBean;

public interface PackageMapper {
	
	int insertPackage(PackageInfoBean packageInfo);
	
	int updatePackage(PackageInfoBean packageInfo);
	
	List<PackageInfoBean> selectPackage(String packageid);
	
	int insertPackageRelation(PackageRelationBean packageRelation);
	
	int updatePackageRelation(PackageRelationBean packageRelation);
	
	int changePackage(RequestBean request);
	
	int doPackage(RequestBean request);

}
