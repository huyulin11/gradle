package com.kaifantech.component.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.init.sys.SystemInitTables;
import com.kaifantech.util.constant.taskexe.cangzhou.CangzhouTaskexeStep;
import com.ytgrading.util.AppTool;

@Service
public class ControlInfoDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getControlInfo() {
		return jdbcTemplate.queryForList("SELECT * FROM " + SystemInitTables.CONTROL_INFO);
	}

	public Integer getMaxZId() {
		return getValueByType("MAX_Z_ID");
	}

	public Integer getAgvsPI() {
		return getValueByType("AGVS_OPEN_PI");
	}

	public int updateAgvsPI(Integer v1) {
		return updateControlInfo(v1, null, "AGVS_OPEN_PI");
	}

	public Integer getSayGoToRobaticArmStep() {
		return getValueByType("SAY_GO_TO_ROBATICARM_STEP");
	}

	public Integer getMaxPointNumInPathInfo() {
		return getValueByType("MAX_POINT_NUM_IN_PATH_INFO");
	}

	public Integer getValueByType(String type) {
		try {
			return jdbcTemplate.queryForObject(
					"SELECT value FROM " + SystemInitTables.CONTROL_INFO + " where type='" + type + "' limit 0,1",
					Integer.class);
		} catch (Exception e) {
			return null;
		}
	}

	public Integer getNextValueByType(String type) {
		updateControlInfoAddOne(type);
		return getValueByType(type);
	}

	public String getPrefixByType(String type) {
		try {
			return jdbcTemplate.queryForObject(
					"SELECT prefix FROM " + SystemInitTables.CONTROL_INFO + " where type='" + type + "' limit 0,1",
					String.class);
		} catch (Exception e) {
			return null;
		}
	}

	public int updateCurrentTaskexeStatusToV1FromV2(Integer v1, Integer v2) {
		return updateControlInfo(v1, v2, "CURRENT_TASKEXE_STATUS");
	}

	public int updateCurrentTaskexeStatusToInit() {
		return updateControlInfo(CangzhouTaskexeStep.INIT_OR_OVER_SGZ, null, "CURRENT_TASKEXE_STATUS");
	}

	public int updateCurrentEnvironment(Integer v1) {
		return updateControlInfo(v1, null, "CURRENT_ENVIRONMENT_ID");
	}

	public int updateCurrentSku(Integer v1) {
		return updateControlInfo(v1, null, "CURRENT_SKUID");
	}

	public int updateControlInfo(Integer v1, Integer v2, String type) {
		return jdbcTemplate.update("update " + SystemInitTables.CONTROL_INFO + " set value= " + v1 + " where type='" + type
				+ "'" + (AppTool.isNull(v2) ? "" : " and value=" + v2));
	}

	public int updateControlInfoAddOne(String type) {
		return jdbcTemplate
				.update("update " + SystemInitTables.CONTROL_INFO + " set value= value+1 where type='" + type + "'");
	}

}
