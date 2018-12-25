package com.ytgrading.util.interceptor.tool;

import org.apache.log4j.Logger;

import com.ytgrading.annotation.FormMapTableName;
import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.erp.plugin.SQLServer2008Dialect;
import com.ytgrading.util.FormMap;

@SuppressWarnings("unchecked")
public class PageInterceptorTool {
	public static String dialect = null;
	public final static Logger logger = Logger.getLogger(PageInterceptorTool.class);

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

	public static String removeOrderBys(String toSql) {
		toSql = toSql.toUpperCase();
		int sun = toSql.indexOf("ORDER");
		if (sun > -1) {
			String f1 = toSql.substring(sun - 1, sun);
			String f2 = toSql.substring(sun + 5, sun + 5);
			if (f1.trim().isEmpty() && f2.trim().isEmpty()) {
				String zb = toSql.substring(sun);
				int s0 = zb.indexOf(")");
				if (s0 > -1) {
					String s1 = "", s2 = "";
					s1 = toSql.substring(0, sun);
					if (zb.replace("(", "").length() != zb.replace(")", "").length()) {
						s2 = zb.substring(s0);
					}
					return removeOrderBys(s1 + s2);
				} else {
					toSql = toSql.substring(0, sun);
				}
			}
		}
		return toSql;
	}

	public static String generatePagesSql(String sql, PageView page) {
		if (page != null) {
			if ("mysql".equals(dialect)) {
				return buildPageSqlForMysql(sql, page).toString();
			} else if ("oracle".equals(dialect)) {
				return buildPageSqlForOracle(sql, page).toString();
			} else if ("SQLServer2008".equals(dialect)) {
				return buildPageSqlForSQLServer2008Dialect(sql, page).toString();
			}
		}
		return sql;
	}

	public static StringBuilder buildPageSqlForMysql(String sql, PageView page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getPageNow() - 1) * page.getPageSize());
		pageSql.append(sql);
		pageSql.append(" limit " + beginrow + "," + page.getPageSize());
		return pageSql;
	}

	public static StringBuilder buildPageSqlForOracle(String sql, PageView page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getPageNow()) * page.getPageSize());
		String endrow = String.valueOf(page.getPageNow() + 1 * page.getPageSize());

		pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
		pageSql.append(sql);
		pageSql.append(" ) temp where rownum <= ").append(endrow);
		pageSql.append(") where row_id > ").append(beginrow);
		return pageSql;
	}

	public static String buildPageSqlForSQLServer2008Dialect(String sql, PageView page) {
		SQLServer2008Dialect dialect = new SQLServer2008Dialect();
		String sqlbuild = dialect.getLimitString(sql, (page.getPageNow() - 1) * page.getPageSize(), page.getPageSize());
		return sqlbuild;
	}

	public static FormMap<String, Object> toHashMap(Object parameterObject) {
		FormMap<String, Object> froMmap = (FormMap<String, Object>) parameterObject;
		try {
			String name = parameterObject.getClass().getName();
			Class<?> clazz = Class.forName(name);
			boolean flag = clazz.isAnnotationPresent(FormMapTableName.class);
			if (flag) {
				FormMapTableName table = (FormMapTableName) clazz.getAnnotation(FormMapTableName.class);
				logger.info(" 公共方法被调用,传入参数 ==>> " + froMmap);
				froMmap.put("ly_table", table.value());
			} else {
				throw new NullPointerException("在" + name + " 没有找到数据库表对应该的注解!");
			}
			return froMmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return froMmap;
	}
}
