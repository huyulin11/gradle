package com.kaifantech.component.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.util.AppTool;

@Service
public class AGVConnectMsgDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Map<Integer, String> latestMsgMap = new HashMap<Integer, String>();

	public void deleteOUTOfDateMsgFromAGV() {
		jdbcTemplate.execute(
				"DELETE FROM " + SystemInitTables.CONNECT_MSG_AGV + " WHERE TO_DAYS(`time`) < TO_DAYS(NOW()) ");
	}

	public Map<String, Object> getLatestMsgFromDB(Integer agvid) {
		return jdbcTemplate.queryForMap(" SELECT msg,`time`,`agvId` FROM " + SystemInitTables.CONNECT_MSG_AGV
				+ " WHERE flag='Receive' AND agvid=" + agvid + " ORDER BY `time` DESC limit 0,1 ");
	}

	public String getLatestMsg(Integer agvid) {
		Object msg = latestMsgMap.get(agvid);
		return AppTool.isNull(msg) ? "" : msg.toString();
	}

	public void addAMsg(String msg, String flag, Integer agvid) {
		jdbcTemplate.execute("insert into " + SystemInitTables.CONNECT_MSG_AGV + "  (`uuid`,agvid,msg,flag) "
				+ "values(uuid()," + agvid + ",'" + msg + "','" + flag + "')");
	}

	public void addAReceiveMsg(String msg, Integer agvId) {
		latestMsgMap.put(agvId, msg);
		addAMsg(msg, "Receive", agvId);
	}

}
