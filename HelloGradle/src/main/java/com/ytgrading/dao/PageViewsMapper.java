package com.ytgrading.dao;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.PageViews;

public interface PageViewsMapper {
	PageViews getPageViews(@Param("page")String page);
	String checkPageExists(@Param("page")String page);
	int insertPageViews(@Param("page")String page);
	int updatePageViews(PageViews pageViews);
}
