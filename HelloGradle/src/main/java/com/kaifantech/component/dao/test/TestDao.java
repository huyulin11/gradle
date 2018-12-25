package com.kaifantech.component.dao.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemTestTables;

@Service
public class TestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getDataFrom(String tableName) {
		return jdbcTemplate.queryForList("SELECT * FROM " + tableName + "  ");
	}

	public List<Map<String, Object>> getDataFromCsyWms() {
		return getDataFrom(SystemTestTables.WMS_ARCHIVES_COORDINATE);
	}

}
