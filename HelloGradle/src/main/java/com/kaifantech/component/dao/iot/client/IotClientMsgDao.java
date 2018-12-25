package com.kaifantech.component.dao.iot.client;

import java.nio.ByteBuffer;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemInitTables;

@Service
public class IotClientMsgDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void deleteOUTOfDateMsgFromAGV() {
		jdbcTemplate.execute(
				"DELETE FROM " + SystemInitTables.CONNECT_ROBOTICARM_MSG + " WHERE TO_DAYS(`time`) < TO_DAYS(NOW()) ");
	}

	public Map<String, Object> getLatestMsg(Integer lapId) {
		return jdbcTemplate.queryForMap(" SELECT msg,`time`,`lapId` FROM " + SystemInitTables.CONNECT_ROBOTICARM_MSG
				+ "  WHERE flag='Receive' AND lapId=" + lapId + " ORDER BY `time` DESC limit 0,1 ");
	}

	public void addAMsg(String msg, String flag, Integer lapId) {
		jdbcTemplate.execute("insert into " + SystemInitTables.CONNECT_ROBOTICARM_MSG + "  (`uuid`,lapId,msg,flag) "
				+ "values(uuid()," + lapId + ",'" + msg + "','" + flag + "')");
	}

	public void addAReceiveMsg(String msg) {
		addAMsg(msg, "Receive", 1);
	}

	public void addAReceiveMsg(String msg, Integer lapId) {
		addAMsg(msg, "Receive", lapId);
	}

	public void addAReceiveMsg(ByteBuffer msg, Integer lapId) {
		addAMsg(msg.toString(), "Receive", lapId);
	}

}
