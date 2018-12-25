package com.kaifantech.component.business.taskexe.dealer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.business.task.deal.ITaskexeDealModule;
import com.kaifantech.component.cache.stock.AgvStockCacheService;
import com.kaifantech.component.comm.worker.client.agv.IAgvClientWorker;
import com.kaifantech.component.dao.agv.info.AgvOpInitDao;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.params.SystemLock;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.mappings.taskexe.TaskexeDetailMapper;
import com.kaifantech.mappings.taskexe.TaskexeDetailWorksMapper;
import com.kaifantech.util.constant.taskexe.WmsDetailOpFlag;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

/***
 * 描述任务从用户下达到发送AGV执行前的逻辑
 ***/
@Service(CsySystemQualifier.TASKEXE_DEALER_MODULE)
public class CsyTaskexeDealModule implements ITaskexeDealModule {

	@Autowired
	private CsyTaskexeDealer taskexeDealer;

	@Autowired
	private AgvStockCacheService agvStockCacheService;

	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	private AgvOpInitDao agvOpInitDao;

	@Autowired
	private TaskexeOpDao taskexeTaskDao;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_CLIENT_WORKER)
	private IAgvClientWorker agvClientMgr;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private CsyTaskexeCacheDealer csyTaskexeCacheDealer;

	@Autowired
	private TaskexeDetailMapper taskexeDetailMapper;

	@Autowired
	private TaskexeDetailWorksMapper taskexeDetailWorksMapper;

	private Map<Integer, Boolean> isRunning = new HashMap<>();

	public void startControl() {
		for (IotClientBean agvBean : iotClientService.getAgvCacheList()) {
			startControl(agvBean.getId());
		}
	}

	private void startControl(Integer agvId) {
		Boolean flag = isRunning.get(agvId);
		if (AppTool.isNull(flag) || !flag) {
			ThreadTool.run(() -> {
				Thread.currentThread().setName("任务处理定时器(AGV:" + agvId + ")" + "衍生进程" + ThreadID.number++);
				isRunning.put(agvId, true);
				while (true) {
					try {
						ThreadTool.sleepOneSecond();
						doDeal(agvId);
					} catch (Exception e) {
						System.err.println(agvId + "号AGV解析任务时发生错误：" + e.getMessage());
						continue;
					}
				}
			});
		}
	}

	public void doDeal(Integer agvId) throws Exception {
		TaskexeBean taskexeBean = taskexeInfoService.getNextOne(agvId);
		if (taskexeBean == null) {
			return;
		}
		deal(taskexeBean);
	}

	private void deal(TaskexeBean taskexeBean) throws Exception {
		synchronized (SystemLock.charge(taskexeBean.getAgvId())) {
			if (AgvTaskType.match(taskexeBean.getTasktype())) {
				boolean isShutdown = SystemParameters.isShutdown(taskexeBean.getTaskid());
				if (!isShutdown) {
					taskexeDealer.dealTaskexe(taskexeBean);
				} else {
					cancel(taskexeBean, SystemParameters.isShutdownThenToInit());
				}
				return;
			}
			System.out.println("无法识别当前任务类型！");
		}
	}

	public void cancel(TaskexeBean taskexeBean, boolean flag) throws Exception {
		Integer agvId = taskexeBean.getAgvId();
		SystemParameters.setTaskstop(agvId, false);
		csyTaskexeCacheDealer.cacheClear(agvId);
		agvOpInitDao.pauseErr(agvId);
		agvOpInitDao.workOverForce(agvId);
		agvStockCacheService.clearStocks(agvId);
		taskexeTaskDao.overATask(taskexeBean);
		taskexeDetailMapper.updateAllOpflag(taskexeBean.setOpflag(WmsDetailOpFlag.OVER));
		taskexeDetailWorksMapper.updateAllOpflag(taskexeBean.setOpflag(WmsDetailOpFlag.OVER));
		if (flag) {
			ThreadTool.sleep(5000);
			agvOpInitDao.commandToInit(agvId);
		}
		CsyAppFileLogger.error(agvId + "号AGV任务" + taskexeBean.getTaskid() + "被中止，等待人工干预，将其手动拖到初始位置！");
	}
}
