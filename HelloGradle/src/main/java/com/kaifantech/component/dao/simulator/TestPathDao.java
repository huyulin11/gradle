package com.kaifantech.component.dao.simulator;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.msg.agv.TaskPathInfoPointBean;
import com.kaifantech.init.sys.SystemTestTables;
import com.ytgrading.util.AppTool;

@Service
public class TestPathDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getNextMsg(int c, Integer agvId) {
		return jdbcTemplate.queryForObject(
				"SELECT a.msg FROM " + getTableName(agvId) + " a limit " + (c % getCount(agvId)) + ",1 ", String.class);
	}

	public Integer getCount(Integer agvId) {
		return jdbcTemplate.queryForObject("SELECT count(1) FROM " + getTableName(agvId) + " a  ", Integer.class);
	}

	public List<TaskPathInfoPointBean> selectPath(Integer taskid) {
		return (List<TaskPathInfoPointBean>) jdbcTemplate.query(
				"select `uuid`,agvId,taskid,x,y,angle,secondToStart,taskStep from "
						+ SystemTestTables.TASK_PATH_INFO_DATASOURCE + " where taskid=" + taskid
						+ "  ORDER BY secondToStart ",
				new BeanPropertyRowMapper<TaskPathInfoPointBean>(TaskPathInfoPointBean.class));
	}

	private String getTableName(Integer agvId) {
		String tableName = agvId.equals(1) ? SystemTestTables.TEST_PATH1
				: (agvId.equals(2) ? SystemTestTables.TEST_PATH2 : SystemTestTables.TEST_PATH3);
		return tableName;
	}

	public static String sql = "SELECT msg FROM " + SystemTestTables.TEST_DATA_SRC + " "
			+ "WHERE msg LIKE '%task=AAAAAAAAAA%' and msg like '%task_isfinished=0;%' and msg like '%pause_stat=0;%'";

	public static String sql_yufeng = "SELECT msg FROM " + SystemTestTables.TEST_DATA_YUFENG + " order by time ";

	public List<Map<String, Object>> getNextMsgFromSQL(Integer agvId) {
		if (agvId.equals(3)) {
			return getNextMsgFromSQL("2-D-4-1-2-114.xml");
		}
		return getNextMsgFromSQL("");
	}

	public List<Map<String, Object>> getYufengTestData() {
		return jdbcTemplate.queryForList(sql_yufeng);
	}

	public List<Map<String, Object>> getNextMsgFromSQL() {
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getNextMsgFromSQL(String taskName) {
		if (!AppTool.isNull(taskName)) {
			return jdbcTemplate.queryForList(sql.replace("AAAAAAAAAA", taskName));
		}
		return jdbcTemplate.queryForList(sql.replace("AAAAAAAAAA", "2-D-4-1-1-114.xml"));
	}

	public Integer getCountFromSQL() {
		return jdbcTemplate.queryForObject("SELECT count(1) FROM (" + sql + ") a  ", Integer.class);
	}

}
