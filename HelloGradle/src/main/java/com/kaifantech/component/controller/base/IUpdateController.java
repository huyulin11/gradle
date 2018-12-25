package com.kaifantech.component.controller.base;

import com.ytgrading.component.service.erp.system.IBaseService;
import com.ytgrading.util.FormMap;

public interface IUpdateController<TT extends FormMap<String, Object>> extends IBaseService<TT>, IBaseController<TT> {
	default String defaultAddEntity() throws Exception {
		getService().doAddEntity(getFormMap());
		return "success";
	}

	default String defaultDeleteEntityByLogic() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		TT formMap = getFormMap();
		for (String id : ids) {
			formMap.set("id", "'" + id + "'");
			getMapper().deleteByLogic(formMap);
		}
		return "success";
	}

	default String defaultEditEntity(String txtGroupsSelect) throws Exception {
		TT formMap = getFormMap();
		getMapper().editEntity(formMap);
		return "success";
	}

	IBaseService<TT> getService();
}