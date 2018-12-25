package com.kaifantech.component.dao.taskexe;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemInitTables;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvMoveStatus;
import com.ytgrading.util.AppTool;

@Service
public class AgvStatusDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String selectFromStr = "SELECT taskid,msg,agvId FROM " + SystemInitTables.AGV_STATUS_LOG;

	public List<Map<String, Object>> getLastestAgvStatus(Integer agvId) {
		return getAgvStatus("(taskid='" + AgvMoveStatus.PAUSE_USER + "' OR taskid='" + AgvMoveStatus.PAUSE_SYS
				+ "' OR taskid='" + AgvMoveStatus.CONTINUE + "')", agvId);
	}

	public List<Map<String, Object>> getLastestAgvStatus() {
		String sql = "" + "	SELECT agvId, taskid, MAX(TIME) octime " + " FROM " + SystemInitTables.AGV_STATUS_LOG
				+ " WHERE taskid != '" + AgvCtrlType.WARNING + "' AND taskid != 'sysInfo' "
				+ " GROUP BY agvId, taskid ORDER BY agvId, octime DESC ";
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getLastestAgvStatusInfo(Integer agvId) {
		return getAgvStatus("(taskid='" + AgvCtrlType.INFO + "')", agvId);
	}

	public List<Map<String, Object>> getLastestAgvStatusWarning(Integer agvId) {
		return getAgvStatus("(taskid='" + AgvCtrlType.WARNING + "')", agvId);
	}

	public void deleteOUTOfDateSOPMsg() {
		jdbcTemplate
				.execute("DELETE FROM " + SystemInitTables.AGV_STATUS_LOG + " WHERE TO_DAYS(`time`) < TO_DAYS(NOW()) ");
		jdbcTemplate.execute(" DELETE FROM  " + SystemInitTables.AGV_STATUS_LOG + " WHERE taskid!='"
				+ AgvMoveStatus.PAUSE_USER + "' AND taskid!='" + AgvMoveStatus.PAUSE_SYS + "' AND taskid!='"
				+ AgvMoveStatus.CONTINUE + "' ");
	}

	private void addAgvStatus(String taskid, String msg, Integer agvId, int autoflag) {
		jdbcTemplate.execute(
				"insert into " + SystemInitTables.AGV_STATUS_LOG + " (`uuid`,taskid,msg,opflag,agvId,autoflag) "
						+ "values(uuid(),'" + taskid + "'" + "," + "'" + (AppTool.isNullStr(msg) ? "" : msg) + "'" + ","
						+ "'" + TaskexeOpFlag.NEW + "'" + "," + agvId + "," + autoflag + ")");
	}

	public void addAgvStatus(String taskid, Integer agvId, int autoflag) {
		addAgvStatus(taskid, null, agvId, autoflag);
	}

	public void addASystemError(String msg, Integer agvId) {
		addAgvStatus(AgvCtrlType.ERROR, msg, agvId, 1);
	}

	public void addASystemWarning(String msg, Integer agvId) {
		addAgvStatus(AgvCtrlType.WARNING, msg, agvId, 1);
	}

	public void addASystemInfo(String msg, Integer agvId) {
		addAgvStatus(AgvCtrlType.INFO, msg, agvId, 1);
	}

	private List<Map<String, Object>> getAgvStatus(String whereStr, Integer agvId) {
		return jdbcTemplate
				.queryForList(selectFromStr + " where 1=1 and " + (AppTool.isNullStr(whereStr) ? "" : whereStr)
						+ (agvId == null ? "" : " AND agvId=" + agvId + " ") + " ORDER BY TIME DESC LIMIT 0,1");
	}
}
