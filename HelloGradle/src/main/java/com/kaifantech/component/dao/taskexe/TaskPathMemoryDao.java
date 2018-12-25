package com.kaifantech.component.dao.taskexe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.msg.agv.AGVMsgBean;
import com.kaifantech.bean.msg.agv.TaskPathInfoPointBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.util.DateFactory;

@Service
public class TaskPathMemoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addAPoint(Integer agvId, String taskid, double x, double y, Long startMoveSecond, Float angle,
			Integer taskStep) {
		jdbcTemplate.execute("insert into " + SystemInitTables.TASK_PATH_MEMORY
				+ " (`uuid`,agvId,taskid,x,y,angle,secondToStart,taskStep ) " + "values(uuid()," + agvId
				+ ",'" + taskid + "','" + x + "','" + y + "'," + angle + ","
				+ (DateFactory.getCurrentUnixTime() - startMoveSecond) + "," + taskStep + ")");
	}

	public void addAPoint(AGVMsgBean msg, Long startMoveSecond) {
		addAPoint(msg.getAGVId(), msg.getTaskid(), msg.getX(), msg.getY(), startMoveSecond, msg.getAngle(),
				msg.getTaskStep());
	}

	public void clearMemory(Integer agvId, String taskid) {
		jdbcTemplate.execute("delete from " + SystemInitTables.TASK_PATH_MEMORY + "  WHERE agvId=" + agvId
				+ " AND taskid=" + taskid + " ");
	}

	public void transToInfo(Integer agvId, String taskid) {
		jdbcTemplate.execute("insert into " + SystemInitTables.TASK_PATH_INFO
				+ " (`uuid`,agvId,taskid,x,y,angle,secondToStart,taskStep) "
				+ " SELECT `uuid`,agvId,taskid,x,y,angle,secondToStart,taskStep FROM  "
				+ SystemInitTables.TASK_PATH_MEMORY + "  WHERE agvId=" + agvId + " AND taskid=" + taskid + " ");
	}

	public Integer getPointCount(Integer agvId, String taskid) {
		return jdbcTemplate.queryForObject("select count(*) from " + SystemInitTables.TASK_PATH_MEMORY
				+ " where agvId=" + agvId + " and taskid=" + taskid, Integer.class);
	}

	public List<TaskPathInfoPointBean> selectPath(Integer agvId, String taskid) {
		return (List<TaskPathInfoPointBean>) jdbcTemplate.query(
				"select `uuid`,agvId,taskid,x,y,angle,secondToStart,taskStep from "
						+ SystemInitTables.TASK_PATH_MEMORY + " where agvId=" + agvId + " and taskid=" + taskid,
				new BeanPropertyRowMapper<TaskPathInfoPointBean>(TaskPathInfoPointBean.class));
	}

}
