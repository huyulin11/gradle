package com.kaifantech.bean.dic;

import com.ytgrading.util.AppTool;

public class SysDic implements Comparable<SysDic> {
	/**
	 * 字典值
	 */
	private String key;
	/**
	 * 中文名称
	 */
	private String value;
	/**
	 * 别名
	 */
	private String alias;
	/**
	 * 英文名称
	 */
	private String valueUs;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 默认
	 */
	private String defau;
	private String isNormalUser;

	public SysDic() {
	}

	public SysDic(String type, String key) {
		this.type = type;
		this.key = key;
	}

	public SysDic(String type, String key, String isNormalUser) {
		this.type = type;
		this.key = key;
		this.isNormalUser = isNormalUser;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueUs() {
		return valueUs;
	}

	public void setValueUs(String valueUs) {
		this.valueUs = valueUs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/** 按照key排序 */
	public int compareTo(SysDic o) {
		if (AppTool.isNullStr(this.key)) {
			return -1;
		}
		if (AppTool.isNullStr(o.key)) {
			return 1;
		}
		if (Integer.parseInt(this.getKey()) > Integer.parseInt(o.getKey())) {
			return 1;
		}
		if (Integer.parseInt(this.getKey()) < Integer.parseInt(o.getKey())) {
			return -1;
		}
		return 0;
	}

	public String getDefau() {
		return defau;
	}

	public void setDefau(String defau) {
		this.defau = defau;
	}

	public String getIsNormalUser() {
		return isNormalUser;
	}

	public void setIsNormalUser(String isNormalUser) {
		this.isNormalUser = isNormalUser;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
