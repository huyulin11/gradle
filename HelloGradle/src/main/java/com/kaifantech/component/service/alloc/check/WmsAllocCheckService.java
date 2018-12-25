package com.kaifantech.component.service.alloc.check;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.service.alloc.info.IAllocInfoService;
import com.kaifantech.component.service.singletask.group.SingletaskGroupService;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;
import com.kaifantech.component.service.taskexe.check.ITaskexeCheckService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.SystemInitiator;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.init.sys.qualifier.WmsSystemQualifier;
import com.kaifantech.util.constant.taskexe.alloc.AllocationStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service(WmsSystemQualifier.ALLOC_CHECK_SERVICE)
public class WmsAllocCheckService implements IAllocCheckService {

	@Autowired
	private TaskexeInfoService taskInfoService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXECHECK_SERVICE)
	private ITaskexeCheckService taskexeCheckService;

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	@Autowired
	private IAllocInfoService allocService;

	@Autowired
	private AllocItemDao allocDao;

	@Autowired
	private SingletaskGroupService singletaskGroupService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Override
	public AppMsg checkLatestTaskexe(Integer agvId) {
		return taskexeCheckService.getCheckInfo(agvId);
	}

	public AppMsg checkTaskGroup(SingletaskBean singletaskBean) {
		List<TaskexeBean> latestTaskList = taskInfoService.getNotOverList();
		if (latestTaskList != null && latestTaskList.size() > 0) {
			for (TaskexeBean taskexeBean : latestTaskList) {
				SingletaskBean tmpSingletaskBean = singleTaskInfoService.getSingletask(taskexeBean.getTaskid());
				if (AgvTaskType.ZUHE_RENWU.equals(singletaskBean.getAllocOpType())
						&& !singletaskGroupService.inTheSameGroupWith(tmpSingletaskBean, singletaskBean)) {
					return new AppMsg(-1, "正在执行的子任务与已执行的子任务不属于同一组！");
				} else if (tmpSingletaskBean.getId().equals(singletaskBean.getId())) {
					return new AppMsg(-1, "正在执行的子任务已经处于执行状态！");
				}
			}
		}
		return new AppMsg(0, "任务可以下达！");
	}

	public AppMsg checkTaskinfo(SingletaskBean singletaskBean) {
		if (AppTool.isNull(singletaskBean.getId()) || singletaskBean.getAllocid() <= 0) {
			return new AppMsg(-1, "任务基础信息有误！");
		}
		AllocItemInfoBean allocationInfoBean = allocService.getByTaskid(singletaskBean.getId());
		AppMsg msg = checkAllocInfo(allocationInfoBean, singletaskBean.getAllocOpType());
		if (msg.getCode() < 0) {
			return msg;
		}
		msg = checkAllocLogic(allocationInfoBean, singletaskBean.getAllocOpType());
		if (msg.getCode() < 0) {
			return msg;
		}
		return new AppMsg(0, "任务可以下达！");
	}

	public AppMsg checkAllocInfo(AllocItemInfoBean allocationInfoBean, String taskOpType) {
		try {
			if (SystemInitiator.alwaysTrue) {
				return new AppMsg(0, "任务可以下达！");
			}
			if (AppTool.isNull(allocationInfoBean)) {
				return new AppMsg(-1, "无法找到任务对应的货位信息为空！");
			}
			if (AgvTaskType.RECEIPT.equals(taskOpType)) {
				if (AllocationStatus.YOUHUO.equals(allocationInfoBean.getStatus())) {
					return new AppMsg(-1, "任务对应货位有货，新上货任务无法下达！" + "(" + allocationInfoBean + ")");
				}
			} else if (AgvTaskType.SHIPMENT.equals(taskOpType)) {
				if (AllocationStatus.KONGWEI.equals(allocationInfoBean.getStatus())) {
					return new AppMsg(-1, "任务对应货位没有货品，新下货任务无法下达！" + "(" + allocationInfoBean + ")");
				}
			}
			if (!AgvTaskType.RECEIPT.equals(taskOpType)) {
				return new AppMsg(0, "任务可以下达！");
			}
			if (AllocationStatus.SUODING.equals(allocationInfoBean.getStatus())) {
				return new AppMsg(-1, "任务对应货位处于锁定状态，新任务无法下达！" + "(" + allocationInfoBean + ")");
			}
		} catch (Exception e) {
			return new AppMsg(-1, "校验逻辑条件时出错，请咨询技术人员！");
		}
		return new AppMsg(0, "任务可以下达！");
	}

	public AppMsg checkAllocLogic(AllocItemInfoBean allocationInfoBean, String taskOpType) {
		try {
			if (allocDao.getAllAllocationInfoBean(allocationInfoBean.getAreaId()).stream()
					.filter((bean) -> bean.getColId().equals(allocationInfoBean.getColId())
							&& bean.getRowId().compareTo(allocationInfoBean.getRowId()) > 0
							&& !AllocationStatus.KONGWEI.equals(bean.getStatus()))
					.count() > 0) {
				return new AppMsg(-1, "同列下方货位状态为有货或者锁定，影响通行，新任务无法下达！" + "(" + allocationInfoBean + ")");
			}
			if (allocDao.getAllAllocationInfoBean(allocationInfoBean.getAreaId()).stream()
					.filter((bean) -> bean.getColId().equals(allocationInfoBean.getColId())
							&& bean.getRowId().equals(allocationInfoBean.getRowId())
							&& bean.getZId().compareTo(allocationInfoBean.getZId()) > 0
							&& !AllocationStatus.KONGWEI.equals(bean.getStatus()))
					.count() > 0) {
				return new AppMsg(-1, "同一货位上方位有货或者处于锁定状态，新任务无法下达！" + "(" + allocationInfoBean + ")");
			}
		} catch (Exception e) {
			return new AppMsg(-1, "校验逻辑条件时出错，请咨询技术人员！");
		}
		return new AppMsg(0, "任务可以下达！");
	}
}
