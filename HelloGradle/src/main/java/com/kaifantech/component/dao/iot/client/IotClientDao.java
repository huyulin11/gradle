package com.kaifantech.component.dao.iot.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.init.sys.SystemInitTables;

@Service
public class IotClientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<IotClientBean> getList() {
		return (List<IotClientBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.IOT_CLIENT_INFO + " a  WHERE a.delflag=0  ",
				new BeanPropertyRowMapper<IotClientBean>(IotClientBean.class));
	}

	public IotClientBean getBean(Integer iotClientId) {
		List<IotClientBean> fl = (List<IotClientBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.IOT_CLIENT_INFO + " a  WHERE a.delflag=0 AND id= " + iotClientId,
				new BeanPropertyRowMapper<IotClientBean>(IotClientBean.class));
		return (fl == null || fl.size() > 1) ? null : fl.get(0);
	}

	public int gotoCharge(Integer iotClientId) {
		return charge(iotClientId, 1);
	}

	public int backFromCharge(Integer iotClientId) {
		return charge(iotClientId, 0);
	}

	private int charge(Integer iotClientId, int oneForChargeAnd0ForLeave) {
		return jdbcTemplate.update("update " + SystemInitTables.IOT_CLIENT_INFO + " set inCharge= "
				+ oneForChargeAnd0ForLeave + " where id=" + iotClientId);
	}

	public void gotIt(int iotClientId) {
		jdbcTemplate.execute("update " + SystemInitTables.IOT_CLIENT_INFO + " set " + " gotIt = '" + 1 + "'" + " where "
				+ " id= '" + iotClientId + "' " + " and gotIt = '" + 0 + "'");
	}

	public void changeNextXaxis(int iotClientId, int nextXaxis, int nextLocation) {
		jdbcTemplate.execute("update " + SystemInitTables.IOT_CLIENT_INFO + " set " + " nextXaxis = '" + nextXaxis + "'"
				+ "," + " nextLocation = '" + nextLocation + "'" + " where " + " id= '" + iotClientId + "' ");
	}

	public void changeCurrentXaxis(int iotClientId, int currentXaxis, int currentLocation) {
		jdbcTemplate.execute("update " + SystemInitTables.IOT_CLIENT_INFO + " set " + "inCurrentXaxis=1" + " where "
				+ " id= '" + iotClientId + "' " + " and currentXaxis=" + currentXaxis + " and inCurrentXaxis!=1");
		jdbcTemplate.execute("update " + SystemInitTables.IOT_CLIENT_INFO + " set " + " lastXaxis = currentXaxis"
				+ " where " + " id= '" + iotClientId + "' " + " and currentXaxis!=" + currentXaxis);
		jdbcTemplate.execute("update " + SystemInitTables.IOT_CLIENT_INFO + " set " + " currentXaxis = '" + currentXaxis
				+ "'" + "," + " currentLocation = '" + currentLocation + "'" + "," + "inCurrentXaxis=1" + " where "
				+ " id= '" + iotClientId + "' " + " and currentXaxis!=" + currentXaxis);
	}

	public void leaveCurrentXaxis(int iotClientId) {
		jdbcTemplate.execute("update " + SystemInitTables.IOT_CLIENT_INFO + " set " + "inCurrentXaxis=0" + " where "
				+ " id= '" + iotClientId + "' " + " and inCurrentXaxis!=0");
	}

	public void takeIt(int iotClientId) {
		jdbcTemplate.execute("update " + SystemInitTables.IOT_CLIENT_INFO + " set " + " gotIt = '" + 2 + "'" + " where "
				+ " id= '" + iotClientId + "' " + " and gotIt = '" + 1 + "'");
	}

}
