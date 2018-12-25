package com.kaifantech.component.dao.agv.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemInitTables;

@Service
public class AgvAxisDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void gotIt(int agvId) {
		jdbcTemplate.execute("update " + SystemInitTables.AGV_INFO + " set " + " gotIt = '" + 1 + "'" + " where "
				+ " id= '" + agvId + "' " + " and gotIt = '" + 0 + "'");
	}

	public void changeNextXaxis(int agvId, int nextXaxis, int nextLocation) {
		jdbcTemplate.execute("update " + SystemInitTables.AGV_INFO + " set " + " nextXaxis = '" + nextXaxis + "'" + ","
				+ " nextLocation = '" + nextLocation + "'" + " where " + " id= '" + agvId + "' ");
	}

	public void changeCurrentXaxis(int agvId, int currentXaxis, int currentLocation) {
		jdbcTemplate.execute("update " + SystemInitTables.AGV_INFO + " set " + "inCurrentXaxis=1" + " where " + " id= '"
				+ agvId + "' " + " and currentXaxis=" + currentXaxis + " and inCurrentXaxis!=1");
		jdbcTemplate.execute("update " + SystemInitTables.AGV_INFO + " set " + " lastXaxis = currentXaxis" + " where "
				+ " id= '" + agvId + "' " + " and currentXaxis!=" + currentXaxis);
		jdbcTemplate.execute("update " + SystemInitTables.AGV_INFO + " set " + " currentXaxis = '" + currentXaxis + "'"
				+ "," + " currentLocation = '" + currentLocation + "'" + "," + "inCurrentXaxis=1" + " where " + " id= '"
				+ agvId + "' " + " and currentXaxis!=" + currentXaxis);
	}

	public void leaveCurrentXaxis(int agvId) {
		jdbcTemplate.execute("update " + SystemInitTables.AGV_INFO + " set " + "inCurrentXaxis=0" + " where " + " id= '"
				+ agvId + "' " + " and inCurrentXaxis!=0");
	}

	public void takeIt(int agvId) {
		jdbcTemplate.execute("update " + SystemInitTables.AGV_INFO + " set " + " gotIt = '" + 2 + "'" + " where "
				+ " id= '" + agvId + "' " + " and gotIt = '" + 1 + "'");
	}

}
