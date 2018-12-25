package com.kaifantech.component.business.taskexe.dealer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvCacheCommand;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.component.comm.manager.agv.AgvManager;
import com.kaifantech.component.dao.agv.info.AgvOpWmsDao;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.taskexe.detail.TaskexeDetailCacheService;
import com.kaifantech.component.service.taskexe.detail.TaskexeDetailInfoService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.iot.CsyAgvStatus;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service
public class CsyTaskexeCacheDealer implements IMultiCacheWorkerGetter {
	public void startControl() {
		for (IotClientBean agvBean : iotClientService.getAgvCacheList()) {
			startControl(agvBean.getId());
		}
	}

	private void startControl(Integer agvId) {
		Boolean flag = isRunning.get(agvId);
		if (AppTool.isNull(flag) || !flag) {
			ThreadTool.run(() -> {
				Thread.currentThread().setName("任务缓存定时器(AGV:" + agvId + ")" + "衍生进程" + ThreadID.number++);
				isRunning.put(agvId, true);
				while (true) {
					try {
						doDeal(agvId);
					} catch (Exception e) {
						CsyAppFileLogger.error(agvId + "号AGV缓存站点任务时发生错误：" + e.getMessage());
					}
					ThreadTool.sleep(1000);
				}
			});
		}
	}

	public void doDeal(Integer agvId) throws Exception {
		TaskexeBean taskexeBean = taskexeInfoService.getNextOne(agvId);
		if (AppTool.isNull(taskexeBean)) {
			if (getAgvCacheTask(agvId).size() > 0) {
				cacheClear(agvId);
			}
			stopCache(agvId);
			return;
		}
		List<TaskexeDetailBean> taskexeDetailList = taskexeDetailService.find(taskexeBean);
		taskexeDetailService.logic(taskexeDetailList);
		doCacheTask(agvId, taskexeBean.getTaskid(), taskexeDetailList);
	}

	public Map<Integer, TaskexeDetailBean> getAgvCacheTask(Integer agvId) {
		Map<Integer, TaskexeDetailBean> cached = cachedTask.get(agvId);
		if (cached == null) {
			cached = new HashMap<>();
			cachedTask.put(agvId, cached);
		}
		return cachedTask.get(agvId);
	}

	public void cacheClear(Integer agvId) {
		if (!isCancle(agvId)) {
			try {
				doCancle(agvId);
				Map<Integer, TaskexeDetailBean> map = getAgvCacheTask(agvId);
				if (map.size() > 0) {
					map.clear();
					agvManager.undoAllCache(agvId);
				}
				taskexeDetailCacheService.undoCacheCommand(agvId);
				CsyAppFileLogger.error(agvId + "号车清空缓存！");
			} catch (Exception e) {
				CsyAppFileLogger.error(agvId + "号AGV缓存站点任务时发生错误：" + e.getMessage());
			}
			outCancle(agvId);
		}
	}

	public void doCacheTask(Integer agvId, String taskid, List<TaskexeDetailBean> taskexeDetailList) throws Exception {
		if (isCancle(agvId)) {
			return;
		}
		Map<Integer, TaskexeDetailBean> cachedTasks = getAgvCacheTask(agvId);
		CsyAgvMsgBean msg = AgvMsgGetter.one().getAgvMsgBean(agvId);
		if (AppTool.isNull(msg) || !msg.isValid()) {
			return;
		}
		if ((!CsyAgvStatus.DRIVING.get().equals(msg.getStatus()) && !CsyAgvStatus.STOPPING.get().equals(msg.getStatus())
				&& !CsyAgvStatus.OBSTACLE.get().equals(msg.getStatus()))) {
			cacheClear(agvId);
			return;
		}
		if (SystemParameters.isShutdown(taskid)) {
			cacheClear(agvId);
			return;
		}
		for (TaskexeDetailBean thisDetail : taskexeDetailList) {
			if (SystemParameters.isShutdown(taskid)) {
				return;
			}
			if (!"NEW".equals(thisDetail.getOpflag())) {
				TaskexeDetailBean cachedSiteDetail = cachedTasks.get(thisDetail.getSiteid());
				if (!AppTool.isNull(cachedSiteDetail)
						&& cachedSiteDetail.getDetailsequence().equals(thisDetail.getDetailsequence())) {
					cachedTasks.remove(thisDetail.getSiteid());
				}
				continue;
			}
			TaskexeDetailBean cachedSiteDetail = cachedTasks.get(thisDetail.getSiteid());
			if (AppTool.isNull(cachedSiteDetail)) {
				CsyAgvCacheCommand cacheCommand = taskexeDetailCacheService.getCacheCommand(agvId, thisDetail);
				AppMsg appMsg = agvManager.cacheTask(cacheCommand);
				if (!appMsg.isSuccess()) {
					agvOpWmsDao.pauseErr(agvId);
					CsyAppFileLogger.error(agvId + "号车站点缓存逻辑出现问题，系统将暂停改车运行，知道缓存成功！");
					return;
				} else {
					agvOpWmsDao.startupFromErr(agvId);
				}
				cachedTasks.put(thisDetail.getSiteid(), thisDetail);
			} else if (cachedSiteDetail.getDetailsequence().equals(thisDetail.getDetailsequence())) {
				continue;
			} else {
				AppFileLogger.siteCacheInfo(
						agvId + "号AGV:" + cachedSiteDetail.getSiteid() + "号站点已有未执行缓存逻辑，等待该站点执行后再进行后续缓存！");
				break;
			}
		}
	}

	@Autowired
	private AgvManager agvManager;
	@Autowired
	protected WmsPaperService wmsPaperService;
	@Autowired
	protected TaskexeOpDao taskexeTaskDao;
	@Autowired
	private IotClientService iotClientService;
	protected Map<Integer, String> lastTask = new HashMap<>();
	private Map<Integer, Map<Integer, TaskexeDetailBean>> cachedTask = new HashMap<>();
	private Map<Integer, Boolean> isWithTask = new HashMap<>();
	private Map<Integer, Boolean> isRunning = new HashMap<>();
	private Map<Integer, Boolean> isCanceling = new HashMap<>();

	private boolean isCancle(Integer agvId) {
		Boolean flag = isCanceling.get(agvId);
		if (AppTool.isNull(flag)) {
			isCanceling.put(agvId, false);
		}
		return isCanceling.get(agvId);
	}

	private void doCancle(Integer agvId) {
		isCanceling.put(agvId, true);
	}

	private void outCancle(Integer agvId) {
		isCanceling.put(agvId, false);
	}

	private AppMsg cacheError = new AppMsg(0, "");

	public AppMsg getCacheError() {
		return cacheError;
	}

	public void startCache(Integer agvId) {
		isWithTask.put(agvId, true);
	}

	public void stopCache(Integer agvId) {
		isWithTask.put(agvId, false);
	}

	@Autowired
	private TaskexeDetailInfoService taskexeDetailService;

	@Autowired
	private TaskexeDetailCacheService taskexeDetailCacheService;

	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	private AgvOpWmsDao agvOpWmsDao;

}
