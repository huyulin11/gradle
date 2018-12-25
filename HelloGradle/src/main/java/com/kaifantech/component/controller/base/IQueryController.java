package com.kaifantech.component.controller.base;

import java.util.List;

import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.util.FormMap;

public interface IQueryController<TT extends FormMap<String, Object>> extends IBaseGetter<TT>, IBaseController<TT> {
	default PageView defaultFindByPage(String pageNow, String pageSize, boolean withDel) throws Exception {
		TT formMap = getFormMap();
		formMap = toFormMap(formMap, pageNow, pageSize);
		if (!withDel) {
			formMap.set("delflag", "0");
		}
		return getPageView().setRecords(defaultFindByPage(formMap));
	}

	default List<TT> defaultFindByPage(TT formMap) throws Exception {
		return getMapper().findByPage(formMap);
	}

	default PageView defaultFindFirstPage() throws Exception {
		return defaultFindByPage("1", "10", false);
	}
}