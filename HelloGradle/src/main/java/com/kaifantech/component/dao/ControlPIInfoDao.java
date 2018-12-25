package com.kaifantech.component.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemInitTables;

@Service
public class ControlPIInfoDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public Integer getValueBy(String type, String key) {
		return jdbcTemplate.queryForObject("SELECT value FROM " + SystemInitTables.CONTROL_PI_INFO + " where "
				+ " `type`='" + type + "'" + " and " + " `key`='" + key + "'" + " limit 0,1", Integer.class);
	}

}
