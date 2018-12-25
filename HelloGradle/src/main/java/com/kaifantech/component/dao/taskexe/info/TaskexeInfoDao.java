package com.kaifantech.component.dao.taskexe.info;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.SystemInitTables;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.ytgrading.util.AppTool;

@Service
public class TaskexeInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getCurrentOne(Integer agvId) {
		return jdbcTemplate.queryForList(" (SELECT  t.`taskid`,  t.`opflag`,  s.* " + "FROM  "
				+ SystemInitTables.TASKEXE_S2C_TASK + " t,  " + SystemInitTables.SINGLETASK_INFO + " s "
				+ "WHERE t.`taskid` = s.`id`   " + "AND (t.`opflag` = '" + TaskexeOpFlag.NEW + "' or t.`opflag` = '"
				+ TaskexeOpFlag.SEND + "') AND t.agvId =  " + agvId + " ORDER BY TIME LIMIT 0, 10) " + "UNION ALL "
				+ "(SELECT   t.`taskid`,  t.`opflag`,  s.* " + "FROM   " + SystemInitTables.TASKEXE_S2C_TASK + " t,   "
				+ SystemInitTables.SINGLETASK_INFO + " s  " + "WHERE t.`taskid` = s.`id`  " + "AND t.`opflag` = '"
				+ TaskexeOpFlag.OVER + "'  AND t.agvId =  " + agvId + " ORDER BY TIME DESC LIMIT 0, 1) ");
	}

	public List<TaskexeBean> getList(String addedSql, String orderBySql, Integer limitRows) {
		return (List<TaskexeBean>) jdbcTemplate.query(
				"select uuid,time,taskid,tasktype,agvId,lapId,addedinfo,addeddesc,tasksequence," + "opflag from "
						+ SystemInitTables.TASKEXE_S2C_TASK + (AppTool.isNullStr(addedSql) ? "" : addedSql)
						+ (AppTool.isNullStr(orderBySql) ? "" : orderBySql)
						+ (AppTool.isNull(limitRows) || limitRows == 0 ? "" : "LIMIT 0," + limitRows),
				new BeanPropertyRowMapper<TaskexeBean>(TaskexeBean.class));
	}

	public List<TaskexeBean> getList(String addedSql, String orderBySql) {
		return getList(addedSql, orderBySql, 0);
	}

	public List<TaskexeBean> getList(String orderBySql, Integer limitRows, String... opflags) {
		StringBuffer sb = new StringBuffer();
		for (String opflag : opflags) {
			if (!AppTool.isNull(sb)) {
				sb.append(" or ");
			}
			sb.append(" opflag='" + opflag + "' ");
		}
		return getList(" where ( " + sb + ") ", orderBySql, limitRows);
	}

	public List<TaskexeBean> getRevList(String orderBySql, Integer limitRows, String... opflags) {
		StringBuffer sb = new StringBuffer();
		for (String opflag : opflags) {
			if (!AppTool.isNull(sb)) {
				sb.append(" and ");
			}
			sb.append(" opflag!='" + opflag + "' ");
		}
		return getList(" where ( " + sb + ") ", orderBySql, limitRows);
	}

	/** 这里只处理需要发送到AGV的任务 */
	public List<TaskexeBean> getNotOverList() {
		return getRevList(" ORDER BY opflag DESC,`time` ", 10, TaskexeOpFlag.OVER);
	}

	public List<TaskexeBean> getNotOverList(String taskid) {
		return getList(" where (opflag='" + TaskexeOpFlag.NEW + "' or opflag='" + TaskexeOpFlag.SEND
				+ "') AND taskid= '" + taskid + "' ", " ORDER BY opflag DESC,`time` ", 10);
	}

	public List<TaskexeBean> getOverList(String taskid) {
		return getList(" where (opflag='" + TaskexeOpFlag.OVER + "') AND taskid= '" + taskid + "' ",
				" ORDER BY opflag DESC,`time` ", 10);
	}

	public List<TaskexeBean> getAllList(String taskid) {
		return getList(" where taskid= '" + taskid + "' ", " ORDER BY tasksequence ");
	}

	public List<TaskexeBean> getNotOverListByF(Integer agvId) {
		return getList(" where (opflag='" + TaskexeOpFlag.NEW + "' or opflag='" + TaskexeOpFlag.SEND + "') AND agvId= "
				+ agvId, " ORDER BY opflag DESC,`time` ", 10);
	}

	public List<TaskexeBean> getNotOverListByF(List<Integer> agvs) {
		return getList(" where (opflag='" + TaskexeOpFlag.NEW + "' or opflag='" + TaskexeOpFlag.SEND
				+ "') AND agvId in( " + AppTool.listToString(agvs, ',') + ")", " ORDER BY opflag DESC,`time` ", 10);
	}

	/** 这里只处理需要发送到AGV的任务 */
	public List<TaskexeBean> getToSendList(Integer agvId) {
		String sql = " where agvId=" + agvId + " and (opflag!='" + TaskexeOpFlag.OVER + "') ";
		if (!SystemClient.CLIENT.equals(SystemClient.Client.CSY)) {
			sql = sql + " and EXISTS (SELECT 1 FROM " + SystemInitTables.SINGLETASK_INFO
					+ " WHERE id=taskid AND isSendToAGV=1) ";
		}
		return getList(sql, " ORDER BY opflag DESC,`time` ", 1);
	}

	public List<TaskexeBean> getNewList() {
		return getList(" ORDER BY opflag DESC,`time` ", 10, TaskexeOpFlag.NEW);
	}

	public TaskexeBean selectByUuid(String uuid) {
		return getList(" where `uuid`= '" + uuid + "'", null, 1).get(0);
	}

}
