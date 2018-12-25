package com.ytgrading.util.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.log4j.Logger;

import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.erp.plugin.ReflectHelper;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.interceptor.tool.AppSqlJoint;
import com.ytgrading.util.interceptor.tool.PageInterceptorTool;

@SuppressWarnings("unchecked")
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	public final static Logger logger = Logger.getLogger(PageInterceptor.class);
	private static String pageSqlId = "";

	@SuppressWarnings("rawtypes")
	public Object intercept(Invocation ivk) throws Throwable {
		if (!(ivk.getTarget() instanceof RoutingStatementHandler)) {
			return ivk.proceed();
		}

		RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk.getTarget();
		BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler,
				"delegate");
		MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate,
				"mappedStatement");
		BoundSql boundSql = delegate.getBoundSql();
		Object parameterObject = boundSql.getParameterObject();
		if (parameterObject == null) {
			return ivk.proceed();
		} else {
			if (mappedStatement.getId().indexOf(".BaseMapper.") > -1) {
				Connection connection = (Connection) ivk.getArgs()[0];
				FormMap formMap = null;
				if (parameterObject instanceof FormMap) {
					formMap = PageInterceptorTool.toHashMap(parameterObject);
				} else if (parameterObject instanceof Map) {
					Map map = (Map) parameterObject;
					if (map.containsKey("list")) {
						List<Object> lists = (List<Object>) map.get("list");
						String sql = AppSqlJoint.joinSql(connection, mappedStatement, boundSql, formMap, lists);
						ReflectHelper.setValueByFieldName(boundSql, "sql", sql);
						return ivk.proceed();
					} else {
						Class fm = (Class) map.get("param3");
						Object o = fm.newInstance();
						formMap = PageInterceptorTool.toHashMap(o);
						formMap.put("key", map.get("param1"));
						formMap.put("value", map.get("param2"));
					}
				} else {
					throw new NullPointerException("调用公共方法，传入参数有错误！具体请看参数说明！");
				}
				String sql = AppSqlJoint.joinSql(connection, mappedStatement, boundSql, formMap, null);
				ReflectHelper.setValueByFieldName(boundSql, "sql", sql);
				return ivk.proceed();
			}
			PageView pageView = null;
			if (parameterObject instanceof PageView) {
				pageView = (PageView) parameterObject;
			} else if (parameterObject instanceof Map) {
				for (Entry entry : (Set<Entry>) ((Map) parameterObject).entrySet()) {
					if (entry.getValue() instanceof PageView) {
						pageView = (PageView) entry.getValue();
						break;
					}
				}
			} else {
				pageView = ReflectHelper.getValueByFieldType(parameterObject, PageView.class);
				if (pageView == null) {
					return ivk.proceed();
				}
			}
			if (pageView == null) {
				return ivk.proceed();
			}
			String sql = boundSql.getSql();
			Connection connection = (Connection) ivk.getArgs()[0];
			setPageParameter(sql, connection, mappedStatement, boundSql, parameterObject, pageView);
			String pageSql = PageInterceptorTool.generatePagesSql(sql, pageView);
			ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql);
		}

		return ivk.proceed();
	}

	@SuppressWarnings("resource")
	private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject, PageView pageView) throws SQLException {
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			String countSql = "";
			try {
				countSql = "SELECT COUNT(1) FROM "
						+ PageInterceptorTool.suffixStr(PageInterceptorTool.removeOrderBys(sql));
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

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties p) {
		String dialect = p.getProperty("dialect");
		if (AppTool.isEmpty(dialect)) {
			try {
				throw new PropertyException("dialectName or dialect property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
		PageInterceptorTool.dialect = dialect;

		pageSqlId = p.getProperty("pageSqlId");
		if (AppTool.isEmpty(pageSqlId)) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
	}

}
