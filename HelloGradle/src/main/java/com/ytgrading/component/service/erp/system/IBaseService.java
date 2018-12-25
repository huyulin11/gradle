package com.ytgrading.component.service.erp.system;

import com.kaifantech.component.controller.base.IBaseGetter;
import com.ytgrading.util.FormMap;

public interface IBaseService<TT extends FormMap<String, Object>> extends IBaseGetter<TT> {
	default void doAddEntity(TT formMap) throws Exception {
		getMapper().addEntity(formMap);
	}
}