package com.ytgrading.component.service.basicsysinfo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.impl.util.json.JSONObject;

import com.ytgrading.util.Pageable;

public interface IBasicsysinfoService {

	int getTableCount(String tableName);
	
	String getFormHTML(String tableName);

	/*
	 * Ajax返回表单维护详情：如列名、输入类型等
	 */
	public JSONObject getTableDetailJSON(String tableName);
	public JSONObject getDataJSON(String tableName,int start,int count);
	
			
	public String getFormHtml(String tableName);
	public String getDataHtml(String tableName,int start,int number);
	/**
	 * 获取新增、修改、查看时单条数据的HTML表单代码
	 * 
	 * @
	 */
	public String getHtmlFormAEV(String tableName);
	/**
	 * 获取列表查看时数据的HTML表单代码
	 * 
	 * @
	 */
	public String getHtmlFormList(String tableName,int start,int count);
	
	public String checkTableName(String tableName);
	public boolean existTable(String tableName);

	int getTableDataCount(String tableName);
	List<Map<String, Object>> queryTableInfoList(String tableName);
	public Pageable getTableDataList(Map<String, Object> queryList, String tableName,
			int page, int pageSize);
	
	
	public boolean saveData(String tableName, HttpServletRequest req,
			String saveType) throws Exception ;
	
	public boolean deleteData(String tableName,String id, boolean isIdNum);

	

	// List<Map<String, Object>> getTableColumns(String tableName);


	public JSONObject searchData(String tableName,int start,int count,
			Map<String,String[]>  paraMap);
}
