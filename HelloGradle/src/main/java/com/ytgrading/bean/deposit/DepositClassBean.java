/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.bean.deposit;

import java.util.UUID;

import com.ytgrading.bean.EntityAliasBean;

public class DepositClassBean {
	private String id = UUID.randomUUID().toString();
	private EntityAliasBean entityAliasBean = new EntityAliasBean();
	private String depositid;
	private int amount;
	private String remark;
	private int numindex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepositid() {
		return depositid;
	}

	public void setDepositid(String depositid) {
		this.depositid = depositid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public EntityAliasBean getEntityAliasBean() {
		return entityAliasBean;
	}

	public void setEntityAliasBean(EntityAliasBean entityAliasBean) {
		this.entityAliasBean = entityAliasBean;
	}

	public int getNumindex() {
		return numindex;
	}

	public void setNumindex(int numindex) {
		this.numindex = numindex;
	}
	
}