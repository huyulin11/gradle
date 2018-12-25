package com.kaifantech.component.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemInitTables;

@Service
public class LapDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getLapList() {
		return jdbcTemplate.queryForList("SELECT a.* FROM " + SystemInitTables.LAP_INFO + " a  WHERE a.delflag=0  ");
	}

	public int updateLap(Integer lapId, boolean flag) {
		return jdbcTemplate
				.update("update " + SystemInitTables.LAP_INFO + " set inUesd= " + (flag ? 1 : 0) + " where id=" + lapId);
	}

	public int updateLap(Integer lapId, Integer skuId) {
		return jdbcTemplate.update("update " + SystemInitTables.LAP_INFO + " set skuId= " + skuId + " where id=" + lapId);
	}

	public int setLapInUesd(Integer lapId) {
		return updateLap(lapId, true);
	}

	public int setLapNotInUesd(Integer lapId) {
		return updateLap(lapId, false);
	}

}
