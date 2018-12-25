
package com.kaifantech.component.business.ctrl.deal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.component.comm.manager.agv.AgvManager;
import com.kaifantech.component.comm.worker.client.agv.IAgvClientWorker;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.mappings.taskexe.TaskexeDetailMapper;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvMoveStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

/***
 * 描述任务从用户下达到发送AGV执行前的逻辑
 ***/
@Service(CsySystemQualifier.CTRL_DEALER_MODULE)
public class CsyCtrlDealModule implements ICtrlDealModule {

	@Autowired
	private AgvManager agvManager;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_CLIENT_WORKER)
	private IAgvClientWorker agvClientMgr;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	private TaskexeDetailMapper taskexeDetailMapper;

	private Map<Integer, Boolean> isRunning = new HashMap<>();

	public void startControl() {
		keepAlive();
		for (IotClientBean agvBean : iotClientService.getAgvCacheList()) {
			if (agvBean.getId().equals(1)) {
				if (!agvBean.getId().equals(1)) {
					System.out.println("逻辑断点");
				}
			}
			CsyAgvMsgBean agvMsgBean = AgvMsgGetter.one().getAgvMsgBean(agvBean.getId());
			if (AppTool.isNull(agvMsgBean) || !agvMsgBean.isValid()) {
				continue;
			}
			Boolean flag = isRunning.get(agvBean.getId());
			try {
				if (AppTool.isNull(flag) || !flag) {
					isRunning.put(agvBean.getId(), true);
					control(agvMsgBean, agvBean);
					isRunning.put(agvBean.getId(), false);
				}
			} catch (Exception e) {
				isRunning.put(agvBean.getId(), false);
				e.printStackTrace();
			}
		}
	}

	private void control(CsyAgvMsgBean agvMsgBean, IotClientBean agvBean) {
		TaskexeBean taskexeBean = taskexeInfoService.getNextOne(agvBean.getId());
		if (AppTool.isNull(taskexeBean) || !AgvMoveStatus.CONTINUE.equals(agvInfoDao.getMoveStatus(agvBean.getId()))) {
			pause(agvMsgBean);
		} else {
			if (!agvMsgBean.isAgvDriving()) {
				ThreadTool.sleep(2000);
				startup(agvBean.getId());
			}
		}
	}

	public void pause(CsyAgvMsgBean agvMsgBean) {
		if (agvMsgBean.isAgvDriving()) {
			agvManager.pause(agvMsgBean.agvId());
		}
	}

	public void pause(Integer agvId) {
		CsyAgvMsgBean agvMsgBean = AgvMsgGetter.one().getAgvMsgBean(agvId);
		if (AppTool.isNull(agvMsgBean) || !agvMsgBean.isValid() || agvMsgBean.isAgvDriving()) {
			agvManager.pause(agvId);
		}
	}

	public void startup(Integer agvId) {
		AgvBean agvInfo = agvInfoDao.get(agvId);
		if (!AgvMoveStatus.CONTINUE.equals(agvInfo.getMovestatus())) {
			return;
		}
		if (!AgvSiteStatus.MOVING.equals(agvInfo.getSitestatus()) || AgvTaskType.FREE.equals(agvInfo.getTaskstatus())) {
			return;
		}
		TaskexeBean taskexeBean = taskexeInfoService.getNextOne(agvInfo.getId());
		if (AppTool.isNull(taskexeBean) || !TaskexeOpFlag.SEND.equals(taskexeBean.getOpflag())) {
			return;
		}
		List<TaskexeDetailBean> taskexeDetailList = taskexeDetailMapper
				.find(new TaskexeDetailBean(taskexeBean.getTaskid(), taskexeBean.getTasksequence()));
		if (AppTool.isNull(taskexeDetailList)) {
			return;
		}
		TaskexeDetailBean nextTaskexeDetail = taskexeDetailList.stream().filter((tmpTaskexeDetail) -> {
			return !TaskexeOpFlag.OVER.equals(tmpTaskexeDetail.getOpflag());
		}).iterator().next();
		boolean isNextTaskexeDetailNeedToStart = TaskexeOpFlag.NEW.equals(nextTaskexeDetail.getOpflag());
		if (!isNextTaskexeDetailNeedToStart) {
			return;
		}
		Boolean taskstop = SystemParameters.getTaskstop(agvId);
		if (!taskstop) {
			agvManager.startup(agvId);
		}
	}

	private boolean isKeepAlive = false;

	private void keepAlive() {
		if (!isKeepAlive) {
			isKeepAlive = true;
			for (IotClientBean agvBean : iotClientService.getAgvCacheList()) {
				ThreadTool.run(() -> {
					while (true) {
						try {
							agvManager.generalSearch(agvBean.getId());
							ThreadTool.sleep(500);
						} catch (Exception e) {
						}
					}
				});
			}
		}
	}
}
