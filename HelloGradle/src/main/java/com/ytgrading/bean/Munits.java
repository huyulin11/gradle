/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */  
package com.ytgrading.bean;

import java.math.BigDecimal;

/** 
 *  
 * @Title:Munits 
 * @Description: 
 * @Copyright:Copyright (c) 2013 
 * @Company:FandaSoft
 * @Date:2013-5-8 
 * @author jiangxx 
 * @version 1.0 
 */
public class Munits {
	private int id;
	private String danwei;
	private BigDecimal value;
	private String showValue; //下拉列表的分数形式
	public String getShowValue() {
		return showValue;
	}
	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
}
