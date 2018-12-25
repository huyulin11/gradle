package com.kaifantech.component.controller.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kaifantech.entity.ResFormMap;
import com.kaifantech.mappings.ErpResourcesMapper;
import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.erp.util.SessionUtil;
import com.ytgrading.util.Common;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.TreeObject;
import com.ytgrading.util.TreeUtil;

public class BaseController<TT extends FormMap<String, Object>> implements IBaseController<TT> {
	public PageView pageView = null;

	public static final String METHOD_ADD = "新增";
	public static final String METHOD_EDIT = "修改";
	public static final String METHOD_DELETE = "删除";

	@Autowired
	private ErpResourcesMapper resourcesMapper;

	public List<TreeObject> getMenuTree() throws Exception {
		List<ResFormMap> mps = this.findResListForCuurentUser(null);
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : mps) {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}
		return new TreeUtil().getChildTreeObjects(list, 0);
	}

	public List<ResFormMap> findResListForCuurentUser(String addedSql) {
		ResFormMap res = new ResFormMap();
		Object userId = SessionUtil.getUserId();
		res.put("where",
				" where (id in (SELECT resId from `ly_res_user` where userid=" + userId + ") " + " OR "
						+ " id IN ( SELECT resId FROM ly_role_res " + "WHERE roleId IN ( "
						+ "SELECT roleId FROM ly_user_role WHERE userId = " + userId + " ))) " + " and ishide = 0 "
						+ (AppTool.isNullStr(addedSql) ? "" : addedSql));
		res.put("$orderby", " order by id desc ");
		List<ResFormMap> mps = resourcesMapper.findByWhere(res);
		return mps;
	}

	public PageView getPageView(String pageNow, String pageSize) {
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		if (Common.isEmpty(pageSize)) {
			pageSize = "20";
		}
		pageView.setPageSize(Integer.parseInt(pageSize));
		return pageView;
	}

	public PageView getPageView() {
		return pageView;
	}

	public List<ResFormMap> findByRes() {
		String id = getParam("id");
		List<ResFormMap> rse = findResListForCuurentUser(" and parentId = " + id);
		for (ResFormMap resFormMap : rse) {
			Object o = resFormMap.get("description");
			if (o != null && !Common.isEmpty(o.toString())) {
				resFormMap.put("description", Common.stringtohtml(o.toString()));
			}
		}
		return rse;
	}

	public static void main(String[] args) {
		System.out.println(new BaseController<>().isArrayParam("sysDicFormMap.dicvalue[0]"));
		;
	}
}