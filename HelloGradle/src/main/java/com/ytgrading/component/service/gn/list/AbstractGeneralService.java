package com.ytgrading.component.service.gn.list;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ytgrading.dao.MemberMapper;
import com.ytgrading.util.AppTool;

@Service
public abstract class AbstractGeneralService implements IGeneralService {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected MemberMapper memberMapper;

	protected final String MAINTAIN_INFO_TABLE = "sys_general_maintain_info";
	protected final String MAINTAIN_DETAIL_TABLE = "sys_general_maintain_detail";

	/* get sql */
	protected String getSQL(String keyword, String sqlColName) {
		String sql = null;
		try {
			sql = (String) jdbcTemplate.queryForObject(
					"SELECT " + sqlColName + " FROM " + MAINTAIN_INFO_TABLE + "\n" + "WHERE keyword = ? ",
					new Object[] { keyword }, String.class);
			if (sql == null) {
				System.out.println("The " + sqlColName + " of " + keyword + " in " + MAINTAIN_INFO_TABLE
						+ "table is null or error.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}

	protected String getSelectSql(String keyword) {
		String select_sql = null;
		try {
			select_sql = getSQL(keyword, "select_sql");
			if (select_sql == null) {
				List<String> list = jdbcTemplate.queryForList("SELECT columnname\n" + "FROM " + MAINTAIN_DETAIL_TABLE
						+ "\n" + "WHERE keyword = '" + keyword + "' AND isquerycol='1'", String.class);
				String colList = list.toString();
				colList = colList.substring(1, colList.length() - 1);
				select_sql = "select " + colList + " " + "from " + keyword;
			}
			if (select_sql.endsWith(";")) { // 去掉末尾";"
				select_sql.substring(0, select_sql.length() - 1);
			}
		} catch (org.springframework.dao.DataAccessException dae) {
			System.out.println("SQL执行错误\n" + dae.getMessage());
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			select_sql = "select * " + "from " + keyword;
		}
		return select_sql;
	}

	/* get data count */
	@Override
	public int getTableDataCount(String keyword) {
		return jdbcTemplate.queryForObject("select COUNT(*) " + "from " + keyword, Integer.class);
	}

	/**
	 * get data 要求数据库必须支持Limit SQL 语法 （目前Mysql支持Limit，Oracle、SQL Server不支持）
	 */

	protected List<Map<String, Object>> getTableDataList(String keyword, int start, int count) {
		return jdbcTemplate.queryForList("select * " + "from " + keyword + " \nLIMIT " + start + "," + count + " ;");
	}

	/**
	 * query 获取维护目标表的表参数
	 * 
	 */
	@Override
	public List<Map<String, Object>> queryTableInfoList(String keyword) {
		return jdbcTemplate.queryForList("select * " + "from " + MAINTAIN_INFO_TABLE + " " + "where delflag='0' "
				+ (AppTool.isNullStr(keyword) ? "" : "and keyword='" + keyword + "'") + "order by ordercol");
	}

	/**
	 * query 获取维护目标表的列参数
	 * 
	 */
	protected List<Map<String, Object>> queryTableDetailList(String keyword) {
		return jdbcTemplate.queryForList("SELECT std.* " + "FROM sys_general_maintain_detail std," + MAINTAIN_INFO_TABLE
				+ " sti " + "WHERE std.keyword = sti.keyword " + "AND std.delflag = '0' " + "AND sti.delflag = '0' "
				+ "AND sti.keyword = '" + keyword + "' " + "ORDER BY std.ordercol");
	}

	protected void Delete(String keyword, int id) {
		jdbcTemplate.execute("DELETE FROM " + keyword + " " + "WHERE id = " + id + " ");
	}

	protected void Delete(String keyword, String id) {
		jdbcTemplate.execute("DELETE FROM " + keyword + " " + "WHERE id = '" + id + "' ");
	}

}
