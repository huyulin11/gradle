package com.kaifantech.component.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemInitTables;

@Service
public class LapAGVDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getLapAGVList() {
		return jdbcTemplate.queryForList(
				"SELECT a.* FROM " + SystemInitTables.LAP_FORKLIFT_INFO + " a  WHERE a.delflag=0 order by lapId,sortBy ");
	}

}
