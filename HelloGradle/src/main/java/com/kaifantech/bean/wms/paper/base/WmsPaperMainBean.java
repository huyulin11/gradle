package com.kaifantech.bean.wms.paper.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.kaifantech.init.sys.SystemInitiator;
import com.ytgrading.util.AppTool;

public class WmsPaperMainBean<T extends WmsPaperDetailBean> {
	private String id;
	private Integer name;
	private String status;
	private String paperid;

	public String getPaperid() {
		return paperid;
	}

	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}

	private List<T> detailList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public List<T> getDetailList() {
		return detailList;
	}

	public String getDetailsAlloc() {
		if (AppTool.isNull(detailList)) {
			return null;
		}
		List<String> allocs = new ArrayList<>();
		for (T detail : detailList) {
			allocs.add(detail.getUserdef1());
		}
		return StringUtils.join(allocs.toArray(), SystemInitiator.SPLIT);
	}

	public void setDetailList(List<T> detailList) {
		this.detailList = detailList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
