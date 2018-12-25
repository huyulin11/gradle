package com.ytgrading.component.service.basicsysinfo;

import java.util.*;

import com.ytgrading.dao.MemberMapper;
import com.ytgrading.dao.BasicsysinfoMapper;
import com.ytgrading.util.AppTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractBasicsysinfoService implements IBasicsysinfoService {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected BasicsysinfoMapper basicsysinfoMapper;

	@Autowired
	protected MemberMapper memberMapper;

	protected final String MAINTAIN_INFO_TABLE = "sys_tables_maintain_info";
	protected final String MAINTAIN_DETAIL_TABLE = "sys_tables_maintain_detail";

	/* get sql */
	protected String getSQL(String tableName, String sqlColName) {
		String sql = null;
		try {
			// 首先，从sys_tables_maintain_info表取得sql
			sql = (String) jdbcTemplate.queryForObject(
					"SELECT " + sqlColName + " FROM " + MAINTAIN_INFO_TABLE + "\n" + "WHERE tablename = ? ",
					new Object[] { tableName }, String.class);
			if (sql == null) {
				System.out.println("The " + sqlColName + " of " + tableName + " in " + MAINTAIN_INFO_TABLE
						+ "table is null or error.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}

	protected String getSelectSql(String tableName) {
		String select_sql = null;
		try {
			// 首先，从sys_tables_maintain_info表取得sql
			select_sql = getSQL(tableName, "select_sql");
			// 如果sys_tables_maintain_info表中select_sql值为空（或出错），程序生成sql
			// sys_tables_maintain_info表中isquerycol指定为1的columnname可被查询
			if (select_sql == null) {
				List<String> list = jdbcTemplate.queryForList("SELECT columnname\n" + "FROM " + MAINTAIN_DETAIL_TABLE
						+ "\n" + "WHERE tablename = '" + tableName + "' AND isquerycol='1'", String.class);
				String colList = list.toString();
				colList = colList.substring(1, colList.length() - 1);
				select_sql = "select " + colList + " " + "from " + tableName;
			}
			if (select_sql.endsWith(";")) { // 去掉末尾";"
				select_sql.substring(0, select_sql.length() - 1);
			}
		} catch (org.springframework.dao.DataAccessException dae) {
			System.out.println("SQL执行错误\n" + dae.getMessage());
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			select_sql = "select * " + "from " + tableName;
		}
		return select_sql;
	}

	/* get data count */
	@Override
	public int getTableDataCount(String tableName) {
		return jdbcTemplate.queryForObject("select COUNT(*) " + "from " + tableName, Integer.class);
	}

	/**
	 * get data 要求数据库必须支持Limit SQL 语法 （目前Mysql支持Limit，Oracle、SQL Server不支持）
	 */

	protected List<Map<String, Object>> getTableDataList(String tableName, int start, int count) {
		return jdbcTemplate.queryForList("select * " + "from " + tableName + " \nLIMIT " + start + "," + count + " ;");
	}

	/**
	 * query 获取维护目标表的表参数
	 * 
	 */
	@Override
	public List<Map<String, Object>> queryTableInfoList(String tableName) {
		return jdbcTemplate.queryForList("select * " + "from sys_tables_maintain_info " + "where delflag='0' "
				+ (AppTool.isNullStr(tableName) ? "" : "and tablename='" + tableName + "'") + "order by ordercol");
	}

	/**
	 * query 获取维护目标表的列参数
	 * 
	 */
	protected List<Map<String, Object>> queryTableDetailList(String tableName) {
		return jdbcTemplate.queryForList("SELECT std.* " + "FROM sys_tables_maintain_detail std,"
				+ "sys_tables_maintain_info sti " + "WHERE std.tablename = sti.tablename " + "AND std.delflag = '0' "
				+ "AND sti.delflag = '0' " + "AND sti.tablename = '" + tableName + "' " + "ORDER BY std.ordercol");
	}

	protected void Delete(String tableName, int id) {
		jdbcTemplate.execute("DELETE FROM " + tableName + " " + "WHERE id = " + id + " ");
	}

	protected void Delete(String tableName, String id) {
		jdbcTemplate.execute("DELETE FROM " + tableName + " " + "WHERE id = '" + id + "' ");
	}

}
