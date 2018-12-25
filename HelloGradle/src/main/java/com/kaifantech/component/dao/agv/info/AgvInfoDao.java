package com.kaifantech.component.dao.agv.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.info.agv.AGVBeanWithLocation;
import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.msg.csy.plc.CsyPlcMsgBean;
import com.kaifantech.component.business.ctrl.deal.CsyCtrlDealModule;
import com.kaifantech.init.sys.SystemInitTables;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvMoveStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.iot.CsyAgvStatus;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.kaifantech.util.msg.plc.PlcMsgGetter;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Service(SystemQualifier.DEFAULT_AGV_INFO_DAO)
public class AgvInfoDao {

	@Autowired
	private CsyCtrlDealModule csyCtrlDealModule;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final String AND = "and";

	public void pauseByUser(Integer agvId) {
		update(agvId, " movestatus='" + AgvMoveStatus.PAUSE_USER + "'");
		csyCtrlDealModule.pause(agvId);
	}

	public void pauseAuto(Integer agvId) {
		update(agvId, " movestatus='" + AgvMoveStatus.PAUSE_SYS + "'");
		csyCtrlDealModule.pause(agvId);
	}

	public void pauseErr(Integer agvId) {
		update(agvId, " movestatus='" + AgvMoveStatus.PAUSE_ERR + "'");
		ThreadTool.run(() -> {
			csyCtrlDealModule.pause(agvId);
		});
	}

	public void workOverForce(Integer agvId) {
		update(agvId, " sitestatus='" + AgvSiteStatus.INIT + "'", " taskstatus='" + AgvTaskType.FREE + "'",
				" taskid=''");
	}

	public void startup(Integer agvId) {
		update(agvId, " movestatus='" + AgvMoveStatus.CONTINUE + "'");
	}

	public void startupFromErr(Integer agvId) {
		update(agvId, " movestatus='" + AgvMoveStatus.CONTINUE + "'",
				AND + " movestatus='" + AgvMoveStatus.PAUSE_ERR + "'");
	}

	public List<AgvBean> getList() {
		return (List<AgvBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.AGV_INFO + " a  WHERE a.delflag=0  ",
				new BeanPropertyRowMapper<AgvBean>(AgvBean.class));
	}

	public List<AgvBean> getChargedList() {
		return (List<AgvBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.AGV_INFO + " a  WHERE a.delflag=0 " + " and ( a.taskstatus='"
						+ AgvTaskType.GOTO_CHARGE + "'" + " or a.taskstatus='" + AgvTaskType.BACK_CHARGE + "' " + ")",
				new BeanPropertyRowMapper<AgvBean>(AgvBean.class));
	}

	public List<AgvBean> getToInitList() {
		return (List<AgvBean>) jdbcTemplate.query("SELECT a.* FROM " + SystemInitTables.AGV_INFO
				+ " a  WHERE a.delflag=0 " + " and ( a.taskstatus='" + AgvTaskType.GOTO_INIT + "'" + ")",
				new BeanPropertyRowMapper<AgvBean>(AgvBean.class));
	}

	private AgvBean getBean(Integer agvId) {
		List<AgvBean> fl = (List<AgvBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.AGV_INFO + " a  WHERE a.delflag=0 AND id= " + agvId,
				new BeanPropertyRowMapper<AgvBean>(AgvBean.class));
		return (fl == null || fl.size() > 1 || fl.size() == 0) ? null : fl.get(0);
	}

	public AgvBean get(Integer agvId) {
		AgvBean bean = getBean(agvId);
		if (bean == null) {
			newOne(agvId);
			bean = getBean(agvId);
		}
		return bean;
	}

	public String getMoveStatus(Integer agvId) {
		AgvBean bean = get(agvId);
		return bean.getMovestatus();
	}

	public Integer getChargeId(Integer agvId) {
		AgvBean bean = get(agvId);
		return bean.getChargeid();
	}

	public String getSiteStatus(Integer agvId) {
		AgvBean bean = get(agvId);
		return bean.getSitestatus();
	}

	public String getTaskStatus(Integer agvId) {
		AgvBean bean = get(agvId);
		return bean.getTaskstatus();
	}

	public AGVBeanWithLocation getAGVBeanWithLocation(Integer agvId) {
		List<AGVBeanWithLocation> fl = (List<AGVBeanWithLocation>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.AGV_INFO + " a  WHERE a.delflag=0 AND id= " + agvId,
				new BeanPropertyRowMapper<AGVBeanWithLocation>(AGVBeanWithLocation.class));
		return (fl == null || fl.size() > 1) ? null : fl.get(0);
	}

	public synchronized int newOne(Integer agvId) {
		return jdbcTemplate.update("REPLACE into  " + SystemInitTables.AGV_INFO + " (id) VALUE (  " + agvId + ")");
	}

	protected synchronized int update(Integer agvId, String... addedSqls) {
		List<String> sets = new ArrayList<>();
		List<String> conditions = new ArrayList<>();
		conditions.add(" where id=" + agvId + " ");
		if (!AppTool.isNull(addedSqls)) {
			for (String addedSql : addedSqls) {
				if (addedSql.startsWith(AND)) {
					conditions.add(addedSql);
				} else {
					sets.add(addedSql + " ");
				}
			}
		}
		if (sets.size() == 0) {
			return -1;
		}
		return jdbcTemplate.update("update " + SystemInitTables.AGV_INFO + " set "
				+ StringUtils.join(sets.toArray(), ",") + StringUtils.join(conditions.toArray(), " "));
	}

	public int update(Integer agvId) {
		AgvBean agv = get(agvId);
		CsyAgvMsgBean csyAgvMsgBean = AgvMsgGetter.one().getAgvMsgBean(agvId);
		List<String> sqlList = new ArrayList<>();
		CsyPlcMsgBean plcMsg = PlcMsgGetter.one().getMsgBean(agvId);
		if (!AppTool.isNull(plcMsg)) {
			boolean robotErr = plcMsg.isRobotErr();
			if (robotErr) {
				sqlList.add("plcstatus= '" + AgvBean.ROBOT_FAIL + "'");
			} else {
				sqlList.add("plcstatus= ''");
			}
		} else {
			sqlList.add("plcstatus= '" + AgvBean.PLC_FAIL + "'");
		}
		if (AppTool.isNull(csyAgvMsgBean) || !csyAgvMsgBean.isValid()) {
			sqlList.add("agvstatus= '" + AgvBean.CONNECT_FAIL + "'");
		} else {
			Integer currentSite = csyAgvMsgBean.currentSite();
			if (!AppTool.isNull(currentSite)) {
				sqlList.add("currentsite= '" + currentSite + "'");
			}
			String agvstatus = csyAgvMsgBean.getStatus();
			if (!AppTool.isNull(agvstatus)) {
				sqlList.add("agvstatus= '" + CsyAgvStatus.getStatusName(agvstatus) + "'");
			}
			double batteryInt = csyAgvMsgBean.getCurrentBattery();
			String battery = "" + batteryInt;
			if (!AppTool.isNull(battery)) {
				if (!(AgvTaskType.GOTO_CHARGE.equals(agv.getTaskstatus())
						|| AgvTaskType.BACK_CHARGE.equals(agv.getTaskstatus()))) {
					if (!AgvBean.NEED_CHARGE.equals(agv.getBattery())) {
						if (batteryInt <= 24.7) {
							sqlList.add("battery= '" + AgvBean.NEED_CHARGE + "'");
						} else {
							sqlList.add("battery= '" + battery + "'");
						}
					}
				} else {
					sqlList.add("battery= '" + battery + "'");
				}
			}
			String speed = "" + AppByteUtil.hexStringToInt(csyAgvMsgBean.getCurrentSpeed());
			if (!AppTool.isNull(speed)) {
				sqlList.add("speed= '" + speed + "'");
			}
		}
		return jdbcTemplate.update("update " + SystemInitTables.AGV_INFO + " set "
				+ StringUtils.join(sqlList.toArray(), ",") + " where id= " + agvId);
	}

}
