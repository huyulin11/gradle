package com.kaifantech.component.service.pi.ctrl.work;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.taskexe.oper.ITaskexeAddService;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.agv.msg.PreventImpactCommand;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvMoveStatus;
import com.ytgrading.util.AppTool;

@Service(CsySystemQualifier.PI_WORK_SERVICE)
public class CsyPiWorkService implements IPiWorkService {

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Autowired
	private CsyPiCtrlDealer piCtrlService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXE_ADD_SERVICE)
	private ITaskexeAddService taskexeService;

	@Autowired
	private IotClientService iotClientService;

	private List<Integer> toStop = new ArrayList<Integer>();
	private List<Integer> toWarning = new ArrayList<Integer>();
	private List<Integer> toContinue = new ArrayList<Integer>();

	public void doControl() {
		List<IotClientBean> agvs = iotClientService.getAgvCacheList();
		for (int i = 0; i < agvs.size(); i++) {
			IotClientBean one = agvs.get(i);
			AgvBean agvBeanOne = agvInfoDao.get(one.getId());
			for (int j = i + 1; j < agvs.size(); j++) {
				IotClientBean another = agvs.get(j);
				AgvBean agvBeanAnother = agvInfoDao.get(another.getId());
				control2Agvs(agvBeanOne, agvBeanAnother);
			}
		}
	}

	public void control2Agvs(AgvBean agvBeanOne, AgvBean agvBeanAnother) {
		if (agvBeanOne.getEnvironment() != agvBeanAnother.getEnvironment()) {
			return;
		}
		PreventImpactCommand command = null;
		try {
			command = piCtrlService.check2Agvs(agvBeanOne, agvBeanAnother);
		} catch (Exception e) {
			System.out.println(
					"对" + agvBeanOne.getId() + "号agv和" + agvBeanAnother.getId() + "号agv进行交管时发生错误：" + e.getMessage());
			return;
		}
		if (AppTool.isNull(command)) {
			return;
		}
		List<Integer> dangerMsgs = command.getDangerIds();
		List<Integer> safeMsgs = command.getSafeIds();
		for (Integer id : dangerMsgs) {
			addToStop(id);
		}
		for (Integer id : safeMsgs) {
			if (!dangerMsgs.contains(id)) {
				addToContinue(id);
			}
		}
	}

	public void doneControl() {
		for (Integer agvId : toStop) {
			if (AgvMoveStatus.CONTINUE.equals(agvInfoDao.getMoveStatus(agvId))) {
				agvInfoDao.pauseAuto(agvId);
			}
		}

		for (Integer agvId : toContinue) {
			if (!toWarning.contains(agvId) && !toStop.contains(agvId)) {
				if (AgvMoveStatus.PAUSE_SYS.equals(agvInfoDao.getMoveStatus(agvId))) {
					agvInfoDao.startup(agvId);
				}
			}
		}

		if (toStop.size() == 0 && toWarning.size() == 0 && toContinue.size() == 0) {
			for (AgvBean agvBean : agvInfoDao.getList()) {
				if (AgvMoveStatus.PAUSE_SYS.equals(agvInfoDao.getMoveStatus(agvBean.getId()))) {
					agvInfoDao.startup(agvBean.getId());
				}
			}
		}

		toStop.clear();
		toWarning.clear();
		toContinue.clear();
	}

	public void addToStop(Integer forkliFtId) {
		if (!toStop.contains(forkliFtId)) {
			toStop.add(forkliFtId);
		}
	}

	public void addToContinue(Integer forkliFtId) {
		if (!toContinue.contains(forkliFtId)) {
			toContinue.add(forkliFtId);
		}
	}

}
