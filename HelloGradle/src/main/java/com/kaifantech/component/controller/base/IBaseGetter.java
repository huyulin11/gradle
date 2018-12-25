package com.kaifantech.component.controller.base;

import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.util.FormMap;

/**
 * 
 * @author ytgrading Email：ytgrading11@126.com
 */
public interface IBaseGetter<TT extends FormMap<String, Object>> {

	BaseMapper getMapper();

}