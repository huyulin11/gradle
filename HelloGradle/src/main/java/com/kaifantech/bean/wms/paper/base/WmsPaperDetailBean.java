package com.kaifantech.bean.wms.paper.base;

import java.util.Comparator;

public class WmsPaperDetailBean {
	private String id;
	private String userdef1;
	private Integer sequence;
	private String paperid;
	private String status;

	private String opflag;

	public static Comparator<WmsPaperDetailBean> comparator = (h1, h2) -> {
		int i = h1.getSequence().compareTo(h2.getSequence());
		if (i != 0) {
			return i;
		}
		return h1.getUserdef1().compareTo(h2.getUserdef1());
	};

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserdef1() {
		return userdef1;
	}

	public void setUserdef1(String userdef1) {
		this.userdef1 = userdef1;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getPaperid() {
		return paperid;
	}

	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOpflag(String opflag) {
		this.opflag = opflag;
	}

	public String getOpflag() {
		return opflag;
	}

}
