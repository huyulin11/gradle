/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.bean.deposit;

import java.util.LinkedList;
import java.util.List;

import com.ytgrading.bean.AutoArrayList;
import com.ytgrading.bean.EntityAliasBean;

@SuppressWarnings("unchecked")
public class DepositBean {
	private DepositMainBean depositMainBean = new DepositMainBean();
	private DepositFeeBean depositFeeBean = new DepositFeeBean();
	private DepositAddressBean depositAddressBean = new DepositAddressBean();

	private List<DepositClassBean> depositClasslist = new AutoArrayList(
			DepositClassBean.class);

	public DepositMainBean getDepositMainBean() {
		return depositMainBean;
	}

	public void setDepositMainBean(DepositMainBean depositMainBean) {
		this.depositMainBean = depositMainBean;
	}

	public DepositFeeBean getDepositFeeBean() {
		return depositFeeBean;
	}

	public void setDepositFeeBean(DepositFeeBean depositFeeBean) {
		this.depositFeeBean = depositFeeBean;
	}

	public DepositAddressBean getDepositAddressBean() {
		return depositAddressBean;
	}

	public void setDepositAddressBean(DepositAddressBean depositAddressBean) {
		this.depositAddressBean = depositAddressBean;
	}

	public List<DepositClassBean> getDepositClasslist() {
		return depositClasslist;
	}

	public void setDepositClasslist(List<DepositClassBean> list) {
		this.depositClasslist.clear();
		this.depositClasslist.addAll(list);
	}

	public void initAdd(String newInnerno, String newReservno) {
		depositMainBean.setInnerno(newInnerno);
		depositMainBean.setReservno(newReservno);

		init();
	}

	public List<DepositClassBean> getDepositClassBean() {
		List<DepositClassBean> depositClassBean = new LinkedList<DepositClassBean>();
		for (DepositClassBean depositClassBean2 : this.depositClasslist) {
			depositClassBean.add(depositClassBean2);
		}
		return depositClassBean;
	}

	public List<EntityAliasBean> getEntityAliasBean() {
		List<EntityAliasBean> entityAliasBean = new LinkedList<EntityAliasBean>();
		for (DepositClassBean depositClassBean : this.depositClasslist) {
			entityAliasBean.add(depositClassBean.getEntityAliasBean());
		}
		return entityAliasBean;
	}

	public void init() {
		depositAddressBean.setDepositid(depositMainBean.getId());

		depositFeeBean.setDepositid(depositMainBean.getId());
		for (DepositClassBean dcb : this.depositClasslist) {
			dcb.setDepositid(depositMainBean.getId());
			dcb.getEntityAliasBean().setUserid((depositMainBean.getUserid()));
		}
	}
}
