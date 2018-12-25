package com.ytgrading.component.service.basicsysinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.kaifantech.util.HTMLGeneralTool;
import com.ytgrading.util.Pageable;
import com.ytgrading.util.AppTool;

@Service
public class BasicsysinfoService extends AbstractBasicsysinfoService {

	/* key tasks */
	@Override
	public boolean saveData(String tableName, HttpServletRequest req, String saveType) throws Exception {
		String sql = null;
		if ("ADD".equals(saveType)) {
			sql = getSQL(tableName, "insert_sql");
		} else if ("EDIT".equals(saveType)) {
			sql = getSQL(tableName, "update_sql");
		} else {
			return false;
		}
		List<Map<String, Object>> tableDetailsList = queryTableDetailList(tableName);
		for (Map<String, Object> tempTableDetailsList : tableDetailsList) {
			String columnname = tempTableDetailsList.get("columnname").toString();
			String columnnameValue = req.getParameter(columnname);
			if (!AppTool.isNullStr(columnnameValue)) {
				sql = sql.replace("$&" + columnname + "&$", columnnameValue);
			} else { // 以null填充
				if (sql.indexOf("'$&" + columnname + "&$'") > 0) { // 文本类型，以null填充
					sql = sql.replace("'$&" + columnname + "&$'", "null");
				} else { // 数字类型，也以null填充
					sql = sql.replace("$&" + columnname + "&$", "null");
				}
			}
		}
		if (sql.indexOf("$&") >= 0 && sql.indexOf("&$") >= 0) {
			if (!MAINTAIN_INFO_TABLE.equals(tableName)) {
				throw new Exception("wrong sql :" + sql + " ,before executing sql");
			}

		}
		if (jdbcTemplate.update(sql) > 0) {
			return true;
		} else {
			throw new Exception("wrong sql:" + sql + " ,at executing sql duration");
		}
	}

	@Override
	public boolean deleteData(String tableName, String id, boolean isIdNum) {
		boolean rtn = false;
		String sql = getSQL(tableName, "del_sql");
		if (AppTool.isNullStr(sql)) {
			sql = "DELETE FROM " + tableName + " \n" + "WHERE id = " + ((isIdNum) ? "" : "'") + id
					+ ((isIdNum) ? "" : "'") + " ;";
		}
		try {
			jdbcTemplate.execute(sql);
			rtn = true;
		} catch (Exception e) {
			rtn = false;
		}
		return rtn;
	}

	/* get json */
	/** 获取新增、修改、查看时单条数据的HTML表单代码 */
	@Override
	public JSONObject getTableDetailJSON(String tableName) {
		List<Map<String, Object>> list = (List<Map<String, Object>>) this.queryTableDetailList(tableName);
		Iterator<Map<String, Object>> iterator = list.iterator();
		JSONObject columnList = new JSONObject();
		JSONObject column = null;
		while (iterator.hasNext()) {
			Map<String, Object> map = iterator.next();
			column = new JSONObject();
			column.put("chncolname", map.get("chncolname"));
			column.put("columnname", map.get("columnname"));
			column.put("inputtype", map.get("inputtype"));
			column.put("defaultvalue", map.get("defaultvalue"));
			column.put("isaddcol", "1".equals(map.get("isaddcol")));
			column.put("isaddmust", "1".equals(map.get("isaddmust")));
			column.put("isquerycol", "1".equals(map.get("isquerycol")));
			column.put("isquerymust", "1".equals(map.get("isquerymust")));
			column.put("isNum", "1".equals(map.get("isNum")));
			column.put("ordercol", map.get("ordercol"));
			if (map.get("defaultvalue") != null) {
				column.put("defaultvalue", map.get("defaultvalue"));
			}
			if (map.get("maxLength") != null) {
				String maxLength = map.get("maxLength").toString().trim();
				if (!"".equals(maxLength)) {
					column.put("maxLength", maxLength);
				}
			}
			column.put("selectOptions", getSelectedOptionsJson(map));
			columnList.put(column.getString("columnname"), column);
		}
		return columnList;
	}

	@Override
	public JSONObject getDataJSON(String tableName, int start, int count) {
		String select_sql = getSelectSql(tableName);
		List<Map<String, Object>> tableDataList = null;
		int totalDataCount = getTableDataCount(tableName);
		try {
			if (select_sql != null) {
				select_sql += "\nLIMIT " + start + "," + count;
				tableDataList = jdbcTemplate.queryForList(select_sql);
			}
		} catch (DataAccessException e) {
			System.out.println("SQL执行出错:" + select_sql);
		}
		for (Map<String, Object> map : tableDataList) {
			map.put("detinformation", "<pre>" + map.get("detinformation") + "</pre>");
		}
		JSONObject json = new JSONObject();
		json.put("totalDataCount", totalDataCount);
		json.put("data", new JSONArray(tableDataList));
		return json;
	}

	protected JSONObject getSelectedOptionsJson(Map<String, Object> map) {
		JSONObject json = null;
		String sql = null;
		Object queryoptionssql = map.get("queryoptionssql");
		Object dictype = map.get("dictype");
		if (queryoptionssql != null) {
			sql = queryoptionssql.toString();
		} else if (dictype != null && !"".equals(dictype.toString().trim())) {
			sql = "select dickey value , dicvalue text  \n" + "from sys_dictionary_basic_data_info \n"
					+ "where dictype = '" + dictype + "'";
		} else {
			Object linkedtable = map.get("linkedtable");
			Object linkedcolumn = map.get("linkedcolumn");
			Object linkedcolmeaning = map.get("linkedcolmeaning");
			if (linkedtable != null && linkedcolumn != null && linkedcolmeaning != null
					&& !"".equals(linkedtable.toString().trim()) && !"".equals(linkedcolumn.toString().trim())
					&& !"".equals(linkedcolmeaning.toString().trim())) {
				sql = "SELECT " + linkedcolumn + " value," + linkedcolmeaning + " text " + "FROM " + linkedtable;
			}
		}
		if (sql != null) {
			List<Map<String, Object>> query = null;
			try {
				query = jdbcTemplate.queryForList(sql);
			} catch (Exception e) {
				System.out.println("bad sql in function getSelectedOptionsJson " + sql);
			}
			json = new JSONObject();
			Iterator<Map<String, Object>> iter = query.iterator();
			while (iter.hasNext()) {
				Map<String, Object> tvMap = iter.next();
				Object value = tvMap.get("value");
				if (value != null) {
					json.put(value.toString(), tvMap.get("text"));
				}
			}
		}
		return json;

	}

	/* get html */
	@Override
	public String getFormHtml(String tableName) {
		List<Map<String, Object>> list = (List<Map<String, Object>>) this.queryTableDetailList(tableName);
		return getFormHtml(list);
	}

	@Override
	public String getDataHtml(String tableName, int start, int count) {
		String select_sql = getSelectSql(tableName);
		List<Map<String, Object>> tableDataList = null;
		try {
			if (select_sql != null) {
				select_sql += "\nLIMIT " + start + "," + count;
				tableDataList = jdbcTemplate.queryForList(select_sql);
			}

		} catch (DataAccessException e) {
			System.out.println("SQL执行出错:" + select_sql);
			e.printStackTrace();
		}
		String html = getDataHtml(tableName, tableDataList);
		return html;
	}

	/** 获取新增、修改、查看时单条数据的HTML表单代码 */
	protected String getFormHtml(List<Map<String, Object>> list) {
		StringBuffer tablehtml = new StringBuffer();
		Iterator<Map<String, Object>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Map<String, Object> map = iterator.next();
			String inputtype = null;
			String chncolname = null;
			String columnname = null;
			boolean isaddmust = false;
			boolean isNum = false;
			Map<String, Object> attributes = new HashMap<String, Object>();
			Map<Object, String> selectOptions = null;
			if (Arrays.asList("TEXT", "SELECT", "TEXTAREA").contains(map.get("inputtype"))) {
				inputtype = map.get("inputtype").toString();
			} else {
				System.out.println("<p>ERROR:Not support " + inputtype + " type."
						+ "Please check the inputtype column in " + MAINTAIN_INFO_TABLE + " table</p>");
				continue;
			}
			if (map.get("chncolname") != null) {
				chncolname = map.get("chncolname").toString();
			} else {
				System.out.println("the chncolname of table " + map.get("tablename") + " defined in "
						+ MAINTAIN_DETAIL_TABLE + " table can't be null");
				continue;
			}
			if (map.get("columnname") != null) {
				columnname = map.get("columnname").toString();
			}
			if (map.get("isaddmust") != null && "1".equals(map.get("isaddmust").toString())) {
				isaddmust = true;
				attributes.put("data-isaddmust", "true");
			}
			if (map.get("isquerycol") != null && "1".equals(map.get("isquerycol").toString())) {
				attributes.put("data-isquerycol", "true");
			}
			if (map.get("isquerymust") != null && "1".equals(map.get("isquerymust").toString())) {
				attributes.put("data-isquerymust", "true");
			}
			if (map.get("isNum") != null && "1".equals(map.get("isNum").toString())) {
				isNum = true;
				attributes.put("data-isNum", "true");
			}
			if (map.get("defaultvalue") != null) {
				attributes.put("data-defaultvalue", map.get("defaultvalue"));
			}
			if (map.get("maxLength") != null && "".equals(map.get("maxLength").toString())) {
				try {
					int maxLength = Integer.valueOf(map.get("maxLength").toString());
					if (maxLength > 0) {
						attributes.put("data-maxLength", maxLength);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (!AppTool.isNull(map.get("dictype")) && "BOOLEAN".equalsIgnoreCase(map.get("dictype").toString())) {
				attributes.put("dictype", "BOOLEAN");
				selectOptions = new HashMap<Object, String>();
				selectOptions.put("1", "是");
				selectOptions.put("0", "否");
			} else {
				String linkedtable = AppTool.isNull(map.get("linkedtable")) ? null : map.get("linkedtable").toString();
				String linkedcolumn = AppTool.isNull(map.get("linkedcolumn")) ? null
						: map.get("linkedcolumn").toString();
				String linkedcolmeaning = AppTool.isNull(map.get("linkedcolmeaning")) ? null
						: map.get("linkedcolmeaning").toString();
				if (linkedtable != null && linkedcolumn != null && linkedcolmeaning != null) {
					attributes.put("linkedtable", linkedtable);
					attributes.put("linkedcolumn", linkedcolumn);
					attributes.put("linkedcolmeaning", linkedcolmeaning);
					String sql = "SELECT " + linkedcolumn + " value," + linkedcolmeaning + " text " + "FROM "
							+ linkedtable + " ;";
					try {
						List<Map<String, Object>> query = jdbcTemplate.queryForList(sql);
						Iterator<Map<String, Object>> iter = query.iterator();
						selectOptions = new TreeMap<Object, String>();
						while (iter.hasNext()) {
							Map<String, Object> tvMap = iter.next();
							Object text = tvMap.get("text");
							Object value = tvMap.get("value");
							if (isNum && java.util.regex.Pattern.compile("\\d+").matcher(value.toString()).matches()) {
								try {
									// 转换成数字类型方便排序
									// SortedMap的key如果是Integer类型按数字递增排序，
									// 如果是String类型会按“1、11、2、21...”这样的顺序排序
									value = Integer.parseInt(tvMap.get("value").toString());
								} catch (NumberFormatException e) {
									System.out
											.println(tvMap.get("value") + "isn't a integer, can not parse to integer");
								}
							}
							if (value != null) { // value不能为空，text如果为空则在<select>中以""填充显示
								selectOptions.put(value, (text != null) ? text.toString() : "");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			tablehtml.append(HTMLGeneralTool.genFormTableRow(inputtype, columnname, chncolname, isaddmust, attributes,
					selectOptions));
		}
		return tablehtml.toString();
	}

	protected String getDataHtml(String tableName, List<Map<String, Object>> tableDataList) {
		List<Map<String, Object>> columnlist = null;
		LinkedList<String> columnList = new LinkedList<String>();
		Map<String, String> columnNameTitleMap = new HashMap<String, String>();
		String key = null;
		String value = null;
		Iterator<Map<String, Object>> rowIter = null;
		Iterator<String> colIter = null;
		Map<String, Object> map = null;
		columnlist = this.queryTableDetailList(tableName);
		StringBuffer html = new StringBuffer("<table>\n\t<tr>");
		Map<String, Map<String, String>> selectMap = getSelectOptions(tableName);
		// get data
		rowIter = columnlist.iterator();
		while (rowIter.hasNext()) {
			map = rowIter.next();
			if (map.get("columnname") != null || "".equals(map.get("columnname"))) {
				key = map.get("columnname").toString();
			} else {
				continue;
			}
			if (map.get("chncolname") != null) {
				value = map.get("chncolname").toString();
			} else {
				value = "";
			}
			if (tableDataList.get(0).containsKey(key)) {
				columnList.add(key);
				columnNameTitleMap.put(key, value);
			}
		}
		// generate table tittle
		colIter = columnList.iterator();
		while (colIter.hasNext()) {
			key = colIter.next();
			String title = columnNameTitleMap.get(key);
			if ("id".equals(key)) {
				html.append("<th title=\"" + key + "\" hidden='hidden' >").append(title).append("</th>");
			} else {
				html.append("<th title=\"" + key + "\" >").append(title).append("</th>");
			}

		}
		html.append("<th></th>");
		html.append("</tr>\n");
		// generate table content
		rowIter = tableDataList.iterator();
		while (rowIter.hasNext()) {
			map = rowIter.next();
			// only show the field descripted in sys_tables_maintain_detail
			// table
			colIter = columnList.iterator();
			html.append("\t<tr>");
			while (colIter.hasNext()) {
				key = colIter.next();
				if (selectMap.containsKey(key)) {
					if (map.get(key) != null) {
						value = map.get(key).toString();
						html.append("<td title='" + key + "' hidden='hidden' >").append(value).append("</td>\n");
						value = selectMap.get(key).get(value);
						html.append("<td >").append((value != null) ? value : "").append("</td>\n");
					} else {
						html.append("<td title='" + key + "'></td>\n");
					}

				} else {
					value = (map.get(key) != null) ? map.get(key).toString() : "";
					if ("id".equals(key)) {
						html.append("<td title=\"" + key + "\" hidden='hidden' >").append(value).append("</td>");
					} else {
						html.append("<td title=\"" + key + "\" >").append(value).append("</td>");
					}
				}
			}
			html.append("<td><button name='edit' >编辑</button>");
			html.append("<button name='delete' >删除</button></td>\n");
			html.append("</tr>\n");
		}
		html.append("</table>");
		return html.toString();
	}

	/* query */
	/**
	 * 获取查询的所有数据
	 * 
	 */
	@Override
	public Pageable getTableDataList(Map<String, Object> queryMap, String tableName, int page, int pageSize) {
		List<Map<String, Object>> list = queryTableInfoList(tableName);
		if (list == null || list.size() != 1) {
			return null;
		}
		StringBuffer sql = new StringBuffer("SELECT * FROM " + tableName + " WHERE 1 = 1");
		if (queryMap != null) {
			Collection<String> c = queryMap.keySet();
			Iterator<String> it = c.iterator();
			for (; it.hasNext();) {
				sql.append(" AND " + it.next() + " = '" + queryMap.get(it.next()) + "'");
			}
		}

		// 总数量
		List<Map<String, Object>> numList = jdbcTemplate.queryForList(" SELECT COUNT(1) NUM FROM ( " + sql + " ) A");
		int length = Integer.parseInt((numList.get(0)).get("NUM").toString());
		// 数据包
		List<Map<String, Object>> dataList = jdbcTemplate.queryForList(sql + " LIMIT " + page + " , " + pageSize);

		// 实际页数
		int realPage = realPage(page, pageSize, length);

		Pageable pageable = new Pageable(realPage, pageSize, length, dataList);
		return pageable;
	}

	/* tools */
	@Override
	public String checkTableName(String tableName) {
		return existTable(tableName) ? tableName : "sys_country";
	}

	@Override
	public boolean existTable(String tableName) {
		if (tableName != null && !"".equals(tableName)) {
			List<Map<String, Object>> list = queryTableInfoList(tableName);
			if (list.size() == 1) {
				return true;
			}
		}
		return false;
	}

	/** 获取所有数据实际的页数 */
	protected int realPage(int page, int pageSize, int length) {
		if ((page - 1) * pageSize >= length) {
			page = (length + pageSize - 1) / pageSize;
		}
		if (page <= 0) {
			return 1;
		}
		return page;
	}

	protected Map<String, Map<String, String>> getSelectOptions(String tablename) {
		Map<String, Map<String, String>> selectOptions = null;
		selectOptions = new HashMap<String, Map<String, String>>();
		List<Map<String, Object>> selectDetails = null;
		String getOptionsSql = "SELECT columnname,linkedtable,linkedcolumn,linkedcolmeaning\n" + "FROM "
				+ MAINTAIN_DETAIL_TABLE + "\n" + "WHERE tablename = '" + tablename + "' "
				+ "AND inputtype = 'SELECT' AND dictype != 'BOOLEAN' ;";
		try {
			selectDetails = jdbcTemplate.queryForList(getOptionsSql);
			Iterator<Map<String, Object>> iterator = selectDetails.iterator();
			while (iterator.hasNext()) {
				Map<String, Object> map = iterator.next();
				try {
					String columnname = map.get("columnname").toString();
					String linkedtable = map.get("linkedtable").toString();
					String linkedcolumn = map.get("linkedcolumn").toString();
					String linkedcolmeaning = map.get("linkedcolmeaning").toString();
					List<Map<String, Object>> query = jdbcTemplate.queryForList("SELECT " + linkedcolumn + " value,"
							+ linkedcolmeaning + " text " + "FROM " + linkedtable + " ;");
					Iterator<Map<String, Object>> iter = query.iterator();
					Map<String, String> kvOptions = new HashMap<String, String>();
					while (iter.hasNext()) {
						Map<String, Object> vtMap = iter.next();
						Object text = vtMap.get("text");
						Object value = vtMap.get("value");
						if (value != null && text != null) { // value不能为空，text如果为空则在<select>中以""填充显示
							kvOptions.put(value.toString(), text.toString());
						}
					}
					selectOptions.put(columnname, kvOptions);
				} catch (NullPointerException ne) {
					;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 查找Yes/NO SELECT类型的字段
		List<Map<String, Object>> choiceDetails = null;
		String getChoiceSql = "SELECT columnname\n" + "FROM " + MAINTAIN_DETAIL_TABLE + "\n" + "WHERE tablename = '"
				+ tablename + "' " + "AND inputtype = 'SELECT' AND dictype = 'BOOLEAN' ;";
		try {
			choiceDetails = jdbcTemplate.queryForList(getChoiceSql);
			Map<String, String> choiceMap = new HashMap<String, String>();
			choiceMap.put("1", "是");
			choiceMap.put("0", "否");
			Iterator<Map<String, Object>> iterator = choiceDetails.iterator();
			while (iterator.hasNext()) {
				String choiceCluName = iterator.next().get("columnname").toString();
				selectOptions.put(choiceCluName, choiceMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectOptions;
	}

	/**
	 * 方法：以关键词查询数据 实现过程：获取表column名列表 生成sql形如"select * from [tablename] where
	 * col1 like '%keywords%' AND ... AND coln like '%keywords%' "
	 * 执行sql多的tableDataList列表， 调用getHtmlFormList（）方法生成表格html代码
	 */
	@Override
	public JSONObject searchData(String tableName, int start, int count, Map<String, String[]> paraMap) { // request.getParameterMap()
		String sql = getSelectSql(tableName);
		Iterator<Map<String, Object>> listIter = this.queryTableDetailList(tableName).iterator();
		List<String> conditions = new ArrayList<String>();
		while (listIter.hasNext()) {
			Map<String, Object> map = listIter.next();
			if ("1".equals(map.get("isquerycol"))) {
				String name = map.get("columnname").toString();
				String[] values = paraMap.get(name);
				if (map.get("querysqlitem") != null) {
					String querysqlitem = map.get("querysqlitem").toString().trim();
					if (!"".equals(querysqlitem)) {
						name = querysqlitem;
					}
				}
				if (values == null || values.length <= 0) {
					continue;
				}
				List<String> cList = new ArrayList<String>();
				for (String value : values) {
					String condition = parseCondition(name, value);
					if (condition != null) {
						cList.add(condition);
					}
				}
				conditions.add(StringUtils.join(cList.toArray(), " OR "));
			}
		}
		if (conditions.size() > 0) {
			sql += "\nWHERE " + StringUtils.join(conditions.toArray(), " AND ");
		}
		// SELECT 用LIKE, TEXT/TextArea 用'='
		List<Map<String, Object>> tableDataList = null;
		int totalDataCount = getTableDataCount(tableName);
		try {
			if (sql != null) {
				sql += "\nLIMIT " + start + "," + count;
				tableDataList = jdbcTemplate.queryForList(sql);
				sql = "SELECT COUNT(*)\n FROM " + tableName
						+ ((conditions.size() > 0) ? "\nWHERE " + StringUtils.join(conditions.toArray(), " AND ") : "");
				totalDataCount = jdbcTemplate.queryForObject(sql, Integer.class);
			}
		} catch (DataAccessException e) {
			System.out.println("SQL执行出错:" + sql);
		}
		JSONObject json = new JSONObject();
		json.put("totalDataCount", totalDataCount);
		json.put("data", new JSONArray(tableDataList));
		return json;
	}

	private String parseCondition(String name, String param) {
		if (!AppTool.isNullStr(param)) {
			if (param.startsWith("EQUAL")) {
				String con = param.substring("EQUAL".length()).trim();
				return name + " = '" + con + "'";
			} else if (param.startsWith("LIKE")) {
				String con = param.substring("LIKE".length()).trim();
				return name + " LIKE '%" + con + "%'";
			} else if (param.contains("LTE") || param.contains("LT") || param.contains("GTE") || param.contains("GT")) {
				String operate1 = null, con1 = null;
				String operate2 = null, con2 = null;
				String[][] operates = { { "LTE", "LT", "GTE", "GT" }, { "<=", "<", ">=", ">" } };
				operate1 = param.split(" ")[0];
				param = param.substring(operate1.length());
				for (String str : operates[0]) {
					if (!str.equals(operate1) && param.contains(str)) {
						operate2 = str;
						break;
					}
				}
				if (operate2 != null) {
					con1 = param.split(operate2)[0];
					con2 = param.substring(param.indexOf(operate2) + operate2.length());
				} else {
					con1 = param.trim();
				}
				for (int i = 0; i < operates.length; i++) {
					if (operates[0][i].equals(operate1)) {
						operate1 = operates[1][i];
					}
					if (operates[0][i].equals(operate2)) {
						operate2 = operates[1][i];
					}
				}
				String con = null;
				if (!AppTool.isNullStr(operate1) && !AppTool.isNullStr(con1)) {
					con += name + " " + operate1 + "'" + con1 + "'";
				}
				if (!AppTool.isNullStr(operate2) && !AppTool.isNullStr(con2)) {
					con += (con != null) ? " AND " : "" + name + " " + operate2 + "'" + con2 + "'";
				}
				return con;
			}
		}
		return null;
	}

	/* old method name */
	@Override
	public String getHtmlFormAEV(String tableName) {
		return getFormHtml(tableName);
	}

	@Override
	public String getHtmlFormList(String tableName, int start, int count) {
		return getDataHtml(tableName, start, count);
	}

	@Override
	public int getTableCount(String tableName) {
		return 0;
	}

	@Override
	public String getFormHTML(String tableName) {
		return null;
	}

}