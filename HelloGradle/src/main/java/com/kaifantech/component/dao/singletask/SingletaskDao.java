package com.kaifantech.component.dao.singletask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.erp.util.SessionUtil;
import com.ytgrading.util.AppTool;

@Service
public class SingletaskDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<SingletaskBean> getSingletaskBeanList() {
		return (List<SingletaskBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.SINGLETASK_INFO + " a " + ", " + SystemInitTables.AGV_INFO
						+ " agv " + " WHERE a.delflag=0  " + " and a.agvId=agv.id and agv.delflag=0 ",
				new BeanPropertyRowMapper<SingletaskBean>(SingletaskBean.class));
	}

	public SingletaskBean getSingletaskBy(Integer allocId, Integer agvId, Integer lapId) {
		List<SingletaskBean> sl = jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.SINGLETASK_INFO + " a  WHERE a.delflag=0 and allocId=" + allocId
						+ " and agvId=" + agvId + " and lapId=" + lapId + " ",
				new BeanPropertyRowMapper<SingletaskBean>(SingletaskBean.class));
		return sl == null || sl.size() >= 2 || sl.size() == 0 ? null : sl.get(0);
	}

	public SingletaskBean getSingletaskBy(Integer allocId, Integer agvId, Integer lapId, Integer taskType) {
		List<SingletaskBean> sl = jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.SINGLETASK_INFO + " a  WHERE a.delflag=0 and allocId=" + allocId
						+ " and agvId=" + agvId + " and lapId=" + lapId + " and taskType= " + taskType,
				new BeanPropertyRowMapper<SingletaskBean>(SingletaskBean.class));
		return sl == null || sl.size() >= 2 || sl.size() == 0 ? null : sl.get(0);
	}

	public List<SingletaskBean> getSingletaskForCurrentUser(Integer agvId) {
		return (List<SingletaskBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.SINGLETASK_INFO + " a," + SystemInitTables.SINGLETASK_ROLE + " e "
						+ ", " + SystemInitTables.ALLOC_ITEM_INFO_WITH_RELATION + " aii" + ", "
						+ SystemInitTables.ALLOCATION_COLUMN_INFO + " aci" + ", "
						+ SystemInitTables.ALLOCATION_AREA_INFO + " aai " + "WHERE 1=1 "
						+ "and a.`id`=e.taskid AND a.delflag=0  AND e.`delflag`=0 "
						+ (AppTool.isNull(agvId) ? "" : ("AND e.agvId =" + agvId)) + " AND e.`roleid` in  "
						+ SessionUtil.getUserRoles()
						+ "  AND a.`allocid` = aii.`id` AND aii.`colId` = aci.`colId` AND aii.`areaId` = aci.`areaId` AND aii.`areaId` = aai.`areaId`"
						+ " AND aii.`delflag` = 0  AND aci.`delflag` = 0  AND aai.`delflag` = 0"
						+ " order by a.orderby,a.taskText ",
				new BeanPropertyRowMapper<SingletaskBean>(SingletaskBean.class));
	}

	public List<SingletaskBean> getSingletaskBeanListByGroup(String parentTaskid) {
		return (List<SingletaskBean>) jdbcTemplate.query("SELECT a.* FROM " + SystemInitTables.SINGLETASK_INFO
				+ " a  WHERE a.delflag=0 AND id in " + "(select taskid from `" + SystemInitTables.SINGLETASK_GROUP
				+ " where parentTaskid=" + parentTaskid + ")",
				new BeanPropertyRowMapper<SingletaskBean>(SingletaskBean.class));
	}

	public int insert(String taskName, String taskText, Integer allocid, Integer taskType, Integer agvId, Integer lapId,
			Integer environment) {
		return jdbcTemplate.update("insert into  " + SystemInitTables.SINGLETASK_INFO
				+ " (`environment`, `taskName`,  `taskText`,  `allocid`,  `taskType`,  `agvId`,  `lapId`)"
				+ " VALUES  (" + "'" + environment + "'," + "'" + taskName + "'," + "'" + taskText + "'," + "'"
				+ allocid + "'," + "'" + taskType + "'," + "'" + agvId + "'," + "'" + lapId + "')");
	}

	public int update(String taskName, String taskText, String taskid) {
		return jdbcTemplate.update("update  " + SystemInitTables.SINGLETASK_INFO + " set " + " `taskName`='" + taskName
				+ "'," + " `taskText`='" + taskText + "'" + " where " + " `id`=" + " '" + taskid + "'");
	}

}
