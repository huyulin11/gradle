package com.kaifantech.component.dao.singletask;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskGroupBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.util.AppTool;

@Service
public class SingletaskGroupDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getSingletaskGroupList(String whereStr) {
		return jdbcTemplate.queryForList("SELECT * FROM " + SystemInitTables.SINGLETASK_GROUP + " where 1=1 "
				+ (AppTool.isNullStr(whereStr) ? "" : whereStr));
	}

	public List<Map<String, Object>> getSingletaskGroupListByTask(String taskid) {
		return getSingletaskGroupList(" and taskid =" + taskid + " ");
	}

	public List<SingletaskGroupBean> getsingletaskGroupList() {
		return (List<SingletaskGroupBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.SINGLETASK_GROUP + " a  WHERE a.delflag=0  ",
				new BeanPropertyRowMapper<SingletaskGroupBean>(SingletaskGroupBean.class));
	}

}
