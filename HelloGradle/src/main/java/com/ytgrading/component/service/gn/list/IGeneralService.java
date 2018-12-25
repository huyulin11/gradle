package com.ytgrading.component.service.gn.list;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.impl.util.json.JSONObject;

import com.ytgrading.util.Pageable;

public interface IGeneralService {

	int getTableCount(String keyword);

	String getFormHTML(String keyword);

	/*
	 * Ajax返回表单维护详情：如列名、输入类型等
	 */
	public JSONObject getTableDetailJSON(String keyword);

	public JSONObject getDataJSON(String keyword, int start, int count);

	public String getFormHtml(String keyword);

	public String getDataHtml(String keyword, int start, int number);

	/**
	 * 获取新增、修改、查看时单条数据的HTML表单代码
	 * 
	 * @
	 */
	public String getHtmlFormAEV(String keyword);

	/**
	 * 获取列表查看时数据的HTML表单代码
	 * 
	 * @
	 */
	public String getHtmlFormList(String keyword, int start, int count);

	public String checkKeyword(String keyword);

	public boolean existTable(String keyword);

	int getTableDataCount(String keyword);

	List<Map<String, Object>> queryTableInfoList(String keyword);

	public Pageable getTableDataList(Map<String, Object> queryList, String keyword, int page, int pageSize);

	public boolean saveData(String keyword, HttpServletRequest req, String saveType) throws Exception;

	public boolean deleteData(String keyword, String id, boolean isIdNum);

	public JSONObject searchData(String keyword, int start, int count, Map<String, String[]> paraMap);
}
