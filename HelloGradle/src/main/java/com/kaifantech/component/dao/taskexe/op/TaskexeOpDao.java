package com.kaifantech.component.dao.taskexe.op;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;

@Service
public class TaskexeOpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void overASendTask(String uuid) {
		jdbcTemplate.execute("update " + SystemInitTables.TASKEXE_S2C_TASK + " set opflag = '" + "" + TaskexeOpFlag.OVER
				+ "'" + " where " + " uuid= '" + uuid + "' " + " and opflag= '" + TaskexeOpFlag.SEND + "' ");
	}

	public void overATask(String uuid) {
		jdbcTemplate.execute("update " + SystemInitTables.TASKEXE_S2C_TASK + " set opflag = '" + "" + TaskexeOpFlag.OVER
				+ "'" + " where " + " uuid= '" + uuid + "' ");
	}

	public void overANormalTask(String uuid) {
		jdbcTemplate.execute("update " + SystemInitTables.TASKEXE_S2C_TASK + " set opflag = '" + "" + TaskexeOpFlag.OVER
				+ "'" + " where " + " uuid= '" + uuid + "' " + " and opflag= '" + TaskexeOpFlag.NEW + "' ");
	}

	public void overASendTask(TaskexeBean taskexeBean) {
		overASendTask(taskexeBean.getUuid());
	}

	public void overANormalTask(TaskexeBean taskexeBean) {
		overANormalTask(taskexeBean.getUuid());
	}

	public void overATask(TaskexeBean taskexeBean) {
		overATask(taskexeBean.getUuid());
	}

	public void sendATask(TaskexeBean taskexeBean) {
		sendATask(taskexeBean.getUuid());
	}

	public void assignT2Agv(TaskexeBean taskexeBean, Integer agvId) {
		assignT2Agv(taskexeBean.getTaskid(), taskexeBean.getTasksequence(), agvId);
	}

	public void assignT2Agv(String taskid, Integer tasksequence, Integer agvId) {
		jdbcTemplate.execute("update " + SystemInitTables.TASKEXE_S2C_TASK + " set agvId = " + agvId + " where taskid='"
				+ taskid + "'" + " AND tasksequence=" + tasksequence);
	}

	public void sendATask(String uuid) {
		jdbcTemplate.execute("update " + SystemInitTables.TASKEXE_S2C_TASK + " set opflag = '" + "" + TaskexeOpFlag.SEND
				+ "'" + " where uuid='" + uuid + "'");
	}

	public void addATask(String taskid, Integer agvId, Integer lapId, Integer autoflag) {
		jdbcTemplate.execute("insert into " + SystemInitTables.TASKEXE_S2C_TASK
				+ " (`uuid`,taskid,opflag,agvId,lapId,autoflag) " + "values(uuid(),'" + taskid + "','"
				+ TaskexeOpFlag.NEW + "'," + agvId + "," + lapId + "," + autoflag + ")");
	}

	public void addATask(TaskexeBean taskexeBean) {
		addATask(taskexeBean.getTaskid(), taskexeBean.getAgvId(), taskexeBean.getLapId(), taskexeBean.getAutoFlag());
	}

	public void addATask(String taskid, Integer agvId, Integer lapId, String taskType, Integer autoflag) {
		jdbcTemplate.execute("insert into " + SystemInitTables.TASKEXE_S2C_TASK
				+ " (`uuid`,taskid,opflag,agvId,lapId,taskType,autoflag) " + "values(uuid(),'" + taskid + "','"
				+ TaskexeOpFlag.NEW + "'," + agvId + "," + lapId + ",'" + taskType + "'," + autoflag + ")");
	}

	public void addATask(String taskid, Integer lapId, String taskType, String addedinfo, String addeddesc,
			Integer tasksequence, Integer autoflag) {
		jdbcTemplate.execute("insert into " + SystemInitTables.TASKEXE_S2C_TASK
				+ " (`uuid`,taskid,opflag,lapId,taskType,addedinfo,addeddesc,tasksequence,autoflag) "
				+ "values(uuid(),'" + taskid + "','" + TaskexeOpFlag.NEW + "'," + lapId + "," + "'" + taskType + "'"
				+ "," + "'" + addedinfo + "'" + "," + "'" + addeddesc + "'" + "," + tasksequence + "," + autoflag
				+ ")");
	}
}
