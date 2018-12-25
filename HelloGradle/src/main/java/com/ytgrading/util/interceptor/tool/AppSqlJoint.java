package com.ytgrading.util.interceptor.tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;

import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.interceptor.PageInterceptor;

public class AppSqlJoint {
	public static final String joinSql(Connection connection, MappedStatement mappedStatement, BoundSql boundSql,
			Map<String, Object> formMap, List<Object> formMaps) throws Exception {
		Object table = null;
		String sql = "";
		if (null != formMap) {
			table = formMap.get(AppConfiguration.LY_TABLE);
			sql = " select * from " + table.toString();
		}
		String sqlId = mappedStatement.getId();
		sqlId = sqlId.substring(sqlId.lastIndexOf(".") + 1);
		if (AppConfiguration.FINDBYWHERE.equals(sqlId)) {
			if (null != formMap.get("where") && !StringUtils.isBlank(formMap.get("where").toString())) {
				sql += " " + formMap.get("where").toString();
			}
		} else if (AppConfiguration.FINDBYPAGE.equals(sqlId)) {
			Map<String, Object> mapfield = AppSqlRunner.findByTablefield(connection, boundSql, table.toString());
			String field = mapfield.get(AppConfiguration.FIELD).toString();
			String[] fe = field.split(",");
			String param = "";
			for (String string : fe) {
				if (formMap.containsKey(string)) {
					Object v = formMap.get(string);
					if (v.toString().indexOf("%") > -1) {
						param += " and " + string + " like '" + v + "'";
					} else if (v.toString().indexOf(">") > -1 || v.toString().indexOf("<") > -1
							|| v.toString().indexOf("=") > -1) {
						param += " and " + string + v + "";
					} else {
						param += " and " + string + " = '" + v + "'";
					}
				}
			}
			if (StringUtils.isNotBlank(param)) {
				param = param.substring(param.indexOf("and") + 4);
				sql += " where " + param;
			}
			Object by = formMap.get("$orderby");
			if (null != by) {
				sql += " " + by;
			} else {
				if (mapfield.get("FIELD").toString().toLowerCase().indexOf("updatetime") > 0) {
					sql += " order by updatetime desc ";
				}
			}
			Object paging = formMap.get("paging");
			if (null == paging) {
				throw new Exception("调用findByPage接口,必须传入PageView对象! formMap.set(\"paging\", pageView);");
			} else if (StringUtils.isBlank(paging.toString())) {
				throw new Exception("调用findByPage接口,必须传入PageView对象! formMap.set(\"paging\", pageView);");
			}
			PageView pageView = (PageView) paging;
			setCount(sql, connection, boundSql, pageView);
			sql = PageInterceptorTool.generatePagesSql(sql, pageView);
		} else if (AppConfiguration.DELETEBYNAMES.equals(sqlId) || AppConfiguration.DELETEBYLOGIC.equals(sqlId)) {
			if (AppConfiguration.DELETEBYNAMES.equals(sqlId)) {
				sql = "delete from " + table.toString() + " where ";
			} else {
				sql = "update " + table.toString() + "  set delflag = 1 where ";
			}
			String param = "";
			for (Entry<String, Object> entry : formMap.entrySet()) {
				if (!"ly_table".equals(entry.getKey()) && null != entry.getValue() && !"_t".equals(entry.getKey()))
					param += " and " + entry.getKey() + " in (" + entry.getValue() + ")";
			}
			if (StringUtils.isNotBlank(param)) {
				param = param.substring(param.indexOf("and") + 4);
				sql += param;
			}
		} else if (AppConfiguration.UPDATESTATUS.equals(sqlId)) {
			sql = "update " + table.toString() + "  set status=" + formMap.get("toStatus") + " where 1=1"
					+ (!AppTool.isNull(formMap.get("fromStatus")) ? (" and status= " + formMap.get("fromStatus")) : "");
			String param = "";
			param += " and id in ('" + formMap.get("id") + "')";
			sql += param;
		} else if (AppConfiguration.DELETEBYATTRIBUTE.equals(sqlId)) {
			sql = "delete from " + table.toString() + " where " + formMap.get("key");
			if (null != formMap.get("value")) {
				sql += " in (" + formMap.get("value") + ")";
			}
		} else if (AppConfiguration.FINDBYNAMES.equals(sqlId)) {
			Map<String, Object> mapfield = AppSqlRunner.findByTablefield(connection, boundSql, table.toString());
			String field = mapfield.get(AppConfiguration.FIELD).toString();
			String[] fe = field.split(",");
			String param = "";
			for (String string : fe) {
				if (formMap.containsKey(string)) {
					Object v = formMap.get(string);
					if (v.toString().indexOf("%") > -1)// 处理模糊查询
					{
						param += " and " + string + " like '" + v + "'";
					} else {
						param += " and " + string + " = '" + v + "'";
					}
				}
			}
			if (StringUtils.isNotBlank(param)) {
				param = param.substring(param.indexOf("and") + 4);
				sql += " where " + param;

			}
			Object by = formMap.get("$orderby");
			if (null != by) {
				sql += " " + by;
			}
		} else if (AppConfiguration.FINDBYATTRIBUTE.equals(sqlId)) {
			sql = "select * from " + table.toString() + " where " + formMap.get("key");
			if (null != formMap.get("value") && formMap.get("value").toString().indexOf("%") > -1)// 处理模糊查询
			{
				sql += " LIKE '" + formMap.get("value") + "'";
			} else {
				Object v = formMap.get("value");
				sql += " in ('" + v + "')";
			}
		} else if (AppConfiguration.ADDENTITY.equals(sqlId)) {
			Map<String, Object> mapfield = AppSqlRunner.findByTablefield(connection, boundSql, table.toString());
			String field = mapfield.get(AppConfiguration.FIELD).toString();
			String[] fe = field.split(",");
			String fieldString = "";
			String fieldValues = "";
			for (String string : fe) {
				Object v = formMap.get(string);
				if (null != v && !StringUtils.isBlank(v.toString())) {
					fieldString += string + ",";
					fieldValues += "'" + v + "',";
				}
			}
			sql = "insert into " + table.toString() + " (" + AppTool.trimComma(fieldString) + ")  values ("
					+ AppTool.trimComma(fieldValues) + ")";
		} else if (AppConfiguration.EDITENTITY.equals(sqlId)) {
			Map<String, Object> mapfield = AppSqlRunner.findByTablefield(connection, boundSql, table.toString());
			String field = mapfield.get(AppConfiguration.FIELD).toString();
			String[] fe = field.split(",");
			String fieldString = "";
			String where = "";
			String key = mapfield.get(AppConfiguration.COLUMN_KEY).toString();
			for (String string : fe) {
				Object v = formMap.get(string);
				if (null != v && !StringUtils.isBlank(v.toString())) {
					if (!StringUtils.isBlank(key)) {
						if (key.equals(string)) {
							where = "WHERE " + key + " = '" + v + "'";
						} else {
							fieldString += string + "='" + v + "',";
						}
					} else {
						throw new NullPointerException("update操作没有找到主键!");
					}
				}
			}

			if (AppTool.isNull(where) || AppTool.isNull(fieldString)) {
				return null;
			}

			sql = "update " + table.toString() + " set " + AppTool.trimComma(fieldString) + " " + where;
		} else if (AppConfiguration.FINDBYFRIST.equals(sqlId)) {
			sql = "select * from " + table.toString() + " where " + formMap.get("key");
			if (null != formMap.get("value") && !"".equals(formMap.get("value").toString())) {
				sql += " = '" + formMap.get("value") + "'";
			} else {
				throw new Exception(sqlId + " 调用公共方法异常!,传入参数错误！");
			}
		} else if (AppConfiguration.TRUNCATE.equals(sqlId)) {
			sql = "truncate table " + table.toString();
		} else if (AppConfiguration.BATCHSAVE.equals(sqlId)) {
			Map<String, Object> mapfield = null;
			String field = null;
			if (null != formMaps && formMaps.size() > 0) {
				table = FormMap.toHashMap(formMaps.get(0)).get(AppConfiguration.LY_TABLE);
				mapfield = AppSqlRunner.findByTablefield(connection, boundSql, table.toString());
				field = mapfield.get(AppConfiguration.FIELD).toString();
			}
			sql = "insert into " + table.toString();
			String fieldString = "";
			String fs = "";
			String fd = "";
			String fieldValues = "";
			String fvs = "";
			for (int i = 0; i < formMaps.size(); i++) {
				Object object = formMaps.get(i);
				@SuppressWarnings("unchecked")
				Map<String, Object> froMmap = (Map<String, Object>) object;
				String[] fe = field.split(",");
				for (String string : fe) {
					Object v = froMmap.get(string);
					if (null != v && !StringUtils.isBlank(v.toString())) {
						fieldString += string + ",";
						fieldValues += "'" + v + "',";
					}
				}
				if (i == 0) {
					fd = fieldString;
				}
				fvs += "(" + AppTool.trimComma(fieldValues) + "),";
				fs += " insert into " + table.toString() + " (" + AppTool.trimComma(fieldString) + ")  values ("
						+ AppTool.trimComma(fieldValues) + ");";
				fieldValues = "";
				fieldString = "";
			}
			String v = AppTool.trimComma(fvs);
			sql = "insert into " + table.toString() + " (" + AppTool.trimComma(fd) + ")  values "
					+ AppTool.trimComma(fvs) + "";
			String[] vs = v.split("\\),");
			boolean b = false;
			for (String string : vs) {
				if (string.split(",").length != fd.split(",").length) {
					b = true;
				}
			}
			if (b) {
				sql = fs.substring(0, fs.length() - 1);
			}

		} else {
			throw new Exception("调用公共方法异常!");
		}
		return sql;
	}

	@SuppressWarnings("resource")
	public static void setCount(String sql, Connection connection, BoundSql boundSql, PageView pageView)
			throws SQLException {
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			String countSql = "";
			try {
				countSql = "SELECT COUNT(1) FROM " + suffixStr(removeOrderBys(sql));
				countStmt = connection.prepareStatement(countSql);
				rs = countStmt.executeQuery();
			} catch (Exception e) {
				PageInterceptor.logger.error(countSql + " 统计Sql出错,自动转换为普通统计Sql语句!");
				countSql = "select count(1) from (" + sql + ") tmp_count";
				countStmt = connection.prepareStatement(countSql);
				rs = countStmt.executeQuery();
			}
			int count = 0;
			if (rs.next()) {
				count = ((Number) rs.getObject(1)).intValue();
			}
			pageView.setRowCount(count);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				countStmt.close();
			} catch (Exception e) {
			}
		}

	}

	private static String removeOrderBys(String toSql) {
		toSql = toSql.toUpperCase();
		int sun = toSql.indexOf("ORDER");
		if (sun > -1) {
			String f1 = toSql.substring(sun - 1, sun);
			String f2 = toSql.substring(sun + 5, sun + 5);
			if (f1.trim().isEmpty() && f2.trim().isEmpty()) {
				String zb = toSql.substring(sun);
				int s0 = zb.indexOf(")");
				if (s0 > -1) {
					String s1 = toSql.substring(0, sun);
					String s2 = zb.substring(s0);
					return removeOrderBys(s1 + s2);
				} else {
					toSql = toSql.substring(0, sun);
				}
			}
		}
		return toSql;
	}

	public static String suffixStr(String toSql) {
		toSql = toSql.toUpperCase();
		int sun = toSql.indexOf("FROM");
		String f1 = toSql.substring(sun - 1, sun);
		String f2 = toSql.substring(sun + 4, sun + 5);
		if (f1.trim().isEmpty() && f2.trim().isEmpty()) {
			String s1 = toSql.substring(0, sun);
			int s0 = s1.indexOf("(");
			if (s0 > -1) {
				int se1 = s1.indexOf("SELECT");
				if (s0 < se1) {
					if (se1 > -1) {
						String ss1 = s1.substring(se1 - 1, se1);
						String ss2 = s1.substring(se1 + 6, se1 + 7);
						if (ss1.trim().isEmpty() && ss2.trim().isEmpty()) {
							return suffixStr(toSql.substring(sun + 5));
						}
					}
				}
				int se2 = s1.indexOf("(SELECT");
				if (se2 > -1) {
					String ss2 = s1.substring(se2 + 7, se2 + 8);
					if (ss2.trim().isEmpty()) {
						return suffixStr(toSql.substring(sun + 5));
					}
				}
				if (se1 == -1 && se2 == -1) {
					return toSql.substring(sun + 5);
				} else {
					toSql = toSql.substring(sun + 5);
				}
			} else {
				toSql = toSql.substring(sun + 5);
			}
		}
		return toSql;
	}

}
