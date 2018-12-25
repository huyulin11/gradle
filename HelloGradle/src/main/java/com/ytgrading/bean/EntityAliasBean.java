package com.ytgrading.bean;

import com.ytgrading.util.AppTool;
import com.ytgrading.util.sys.Repeatable;

public class EntityAliasBean implements Repeatable<EntityAliasBean> {
	private Integer entityid;
	private String aliasname;
	private String userid;

	public Integer getEntityid() {
		return entityid;
	}

	public void setEntityid(Integer entityid) {
		this.entityid = entityid;
	}

	public String getAliasname() {
		return aliasname;
	}

	public void setAliasname(String aliasname) {
		this.aliasname = aliasname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	/** 比较是否重复 */
	@Override
	public boolean isRepeatedTo(EntityAliasBean o) {
		if (this.entityid == null || AppTool.isNull(this.userid)) {
			return false;
		}
		if (this.getEntityid().equals(o.getEntityid())
				&& this.getUserid().equals(o.getUserid())) {
			return true;
		}
		return false;
	}
}
