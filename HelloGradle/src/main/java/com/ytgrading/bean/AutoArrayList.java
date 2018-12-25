/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */  
package com.ytgrading.bean;

import java.util.ArrayList;

/** 
 *  
 * @Title:AutoArrayList 
 * @Description: 
 * @Copyright:Copyright (c) 2013 
 * @Company:FandaSoft
 * @Date:2013-5-21 
 * @author jiangxx 
 * @version 1.0 
 */
public class AutoArrayList extends ArrayList{
	private Class itemClass;
	public AutoArrayList(Class itemClass) {
		  this.itemClass = itemClass;
	}
	public Object get(int index) {
		try {
			while (index >= size()) {
				add(itemClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.get(index);
	}

}
