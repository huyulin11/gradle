package com.kaifantech.bean.tasksite;

import java.util.ArrayList;
import java.util.List;

import com.ytgrading.util.AppTool;

public class TaskSiteInfoBean implements Cloneable {
	private Integer id;
	private String sitename;
	private String sitecode;
	private Integer sitetype;
	private Integer line;
	private Integer keyId;

	private TaskSiteInfoBean pre;

	private TaskSiteInfoBean left;
	private TaskSiteInfoBean right;

	private double distanceToLeft = 0;
	private double distanceToRight = 0;

	public static final Integer SITE_TYPE_ALLOC = 1;
	public static final Integer SITE_TYPE_INIT = 2;
	public static final Integer SITE_TYPE_WINDOW = 3;
	public static final Integer SITE_TYPE_CHARGE = 4;
	public static final Integer SITE_TYPE_OUT = 5;
	public static final Integer SITE_TYPE_BACK = 6;
	public static final Integer SITE_TYPE_BAY = 7;

	public static final Integer SITE_ID_LOOP_INIT_BRANCH = 65;
	public static final Integer SITE_ID_LOOP = 68;

	public static final Integer SITE_ID_INIT_BRANCH_1 = 10;
	public static final Integer SITE_ID_INIT_BRANCH_2 = 7;
	public static final Integer SITE_ID_INIT_BRANCH_3 = 70;
	public static final Integer SITE_ID_INIT_BRANCH_4 = 66;

	public static final Integer SITE_ID_CHARGE_1_BRANCH = 15;
	public static final Integer SITE_ID_CHARGE_1_OUT = 19;

	public static final Integer SITE_ID_BACK_1 = 6;
	public static final Integer SITE_ID_BACK_2 = 5;
	public static final Integer SITE_ID_BACK_3 = 4;
	public static final Integer SITE_ID_BACK_4 = 69;

	public static final Integer SITE_ID_INIT_1 = 8;
	public static final Integer SITE_ID_INIT_2 = 9;
	public static final Integer SITE_ID_INIT_3 = 11;
	public static final Integer SITE_ID_INIT_4 = 12;

	public static final Integer SITE_ID_OUT_234 = 20;

	public static final Integer SITE_ID_OUT_FAR_FROM_CHARGE = 22;

	public Integer getSitetype() {
		return sitetype;
	}

	public String getIndex() {
		return "";
	}

	public void setSitetype(Integer sitetype) {
		this.sitetype = sitetype;
	}

	public Integer getKeyId() {
		return keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getSitecode() {
		return sitecode;
	}

	public void setSitecode(String sitecode) {
		this.sitecode = sitecode;
	}

	public boolean isAllocSite() {
		return SITE_TYPE_ALLOC.equals(getSitetype());
	}

	public boolean isWindowSite() {
		return SITE_TYPE_WINDOW.equals(getSitetype());
	}

	public boolean isInitSite() {
		return SITE_TYPE_INIT.equals(getSitetype());
	}

	public boolean isChargeSite() {
		return SITE_TYPE_CHARGE.equals(getSitetype());
	}

	public boolean isOutSite() {
		return SITE_TYPE_OUT.equals(getSitetype());
	}

	public boolean isOutOrWindowSite() {
		return SITE_TYPE_OUT.equals(getSitetype()) || SITE_TYPE_WINDOW.equals(getSitetype());
	}

	public boolean isBackSite() {
		return SITE_TYPE_BACK.equals(getSitetype());
	}

	public boolean isBaySite() {
		return SITE_TYPE_BAY.equals(getSitetype());
	}

	public boolean isInitOrBaySite() {
		return SITE_TYPE_INIT.equals(getSitetype()) || SITE_TYPE_BAY.equals(getSitetype());
	}

	public static boolean isCorner(TaskSiteInfoBean current, TaskSiteInfoBean next) {
		if (AppTool.isAllNull(current, next, current.getSitetype(), next.getSitetype())) {
			return true;
		}
		if (current.getSitetype().equals(next.getSitetype())) {
			return false;
		}
		if (current.isOutOrWindowSite() && next.isOutOrWindowSite()) {
			return false;
		}
		return true;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public TaskSiteInfoBean getLeft() {
		return left;
	}

	public void setLeft(TaskSiteInfoBean left) {
		this.left = left;
	}

	public TaskSiteInfoBean getRight() {
		return right;
	}

	public List<TaskSiteInfoBean> getNexts() {
		List<TaskSiteInfoBean> list = new ArrayList<>();
		if (!AppTool.isNull(left)) {
			list.add(left);
		}
		if (!AppTool.isNull(right)) {
			list.add(right);
		}
		return list;
	}

	public void setRight(TaskSiteInfoBean rigtht) {
		this.right = rigtht;
	}

	public TaskSiteInfoBean getPre() {
		return pre;
	}

	public void setPre(TaskSiteInfoBean pre) {
		this.pre = pre;
	}

	public String toString() {
		String preStr = "";
		// if (!AppTool.isNullObj(pre)) {
		// preStr = ";pre:" + pre.getId();
		// }
		return "" + id + preStr;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public double getDistanceToLeft() {
		return distanceToLeft;
	}

	public void setDistanceToLeft(double distanceToLeft) {
		this.distanceToLeft = distanceToLeft;
	}

	public double getDistanceToRight() {
		return distanceToRight;
	}

	public void setDistanceToRight(double distanceToRight) {
		this.distanceToRight = distanceToRight;
	}

}
