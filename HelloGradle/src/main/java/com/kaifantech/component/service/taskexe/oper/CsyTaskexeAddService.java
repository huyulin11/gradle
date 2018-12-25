package com.kaifantech.component.service.taskexe.oper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.component.dao.agv.info.AgvOpWmsDao;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.alloc.check.IAllocCheckService;
import com.kaifantech.component.service.alloc.info.IAllocInfoService;
import com.kaifantech.component.service.alloc.status.IAllocStatusMgrService;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.status.agv.AgvsCtrlInfoService;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service(CsySystemQualifier.TASKEXE_ADD_SERVICE)
public class CsyTaskexeAddService<TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>>
		implements ITaskexeAddService {

	@Autowired
	private AgvsCtrlInfoService agvsCtrlInfoService;

	@Autowired
	private WmsPaperService wmsPaperService;

	@Autowired
	private IAllocInfoService allocInfoService;

	@Autowired
	private TaskexeOpDao taskexeTaskDao;

	@Autowired
	private IAllocStatusMgrService allocStatusMgrService;

	@Autowired
	private AgvOpWmsDao agvOpWmsDao;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_ALLOC_CHECK_SERVICE)
	private IAllocCheckService allocCheckService;

	@SuppressWarnings("unchecked")
	@Override
	public AppMsg addTask(Object obj) {
		Integer agvId = null;
		TM bean = (TM) obj;

		String taskType = wmsPaperService.getTaskType(bean);

		if (AppTool.isNull(taskType)) {
			return new AppMsg(-1, "未找到匹配的业务模式");
		}

		if (!AgvTaskType.INVENTORY.equals(taskType)) {
			agvId = agvsCtrlInfoService.getFreeAgvId();
			if (AppTool.isNull(agvId)) {
				return new AppMsg(-1,
						"未找到空闲AGV执行此任务！" + (AppTool.isNull(bean.getPaperid()) ? "" : "任务编号：" + bean.getPaperid()));
			}
		}

		Integer lapId = bean.getName();
		AppMsg msg = AppMsg.success();
		if (AgvTaskType.INVENTORY.equals(taskType)) {
			addInventoryTask(bean, lapId, taskType);
		} else {
			msg = allocCheckService.checkAlloc(bean, agvId);
			if (msg.getCode() >= 0) {
				addReceiptOrShipmentTask(bean, agvId, lapId, taskType);
			}
		}
		msg.setMsg("任务完成下达！" + "（" + bean + "）");
		msg.setObject(bean.getPaperid());
		return msg;
	}

	@SuppressWarnings("unused")
	private boolean isFace(Integer line1, Integer line2) {
		if (Math.abs(line1 - line2) == 1 && Math.max(line1, line2) % 2 == 1) {
			return true;
		}
		return false;
	}

	private void addInventoryTask(TM bean, Integer lapId, String taskType) {
		String inventorytype = ((InventoryMainBean) bean).getInventorytype();
		int sequence = 1;
		if (InventoryMainBean.TYPE_COLUMN.equals(inventorytype)) {
			taskexeTaskDao.addATask(bean.getPaperid(), lapId, taskType, "", "", sequence++, 2);
		} else if (InventoryMainBean.TYPE_LINE.equals(inventorytype)
				|| InventoryMainBean.TYPE_FULL.equals(inventorytype)) {
			List<Integer> lines = new ArrayList<>();
			if (InventoryMainBean.TYPE_LINE.equals(inventorytype)) {
				for (TD detail : bean.getDetailList()) {
					lines.add(Integer.parseInt(detail.getUserdef1()));
				}
			} else if (InventoryMainBean.TYPE_FULL.equals(inventorytype)) {
				for (int i = 1; i <= 18; i++) {
					lines.add(i);
				}
			}
			lines.sort((l1, l2) -> {
				return l1 - l2;
			});
			for (int k = 0; k < lines.size(); k++) {
				taskexeTaskDao.addATask(bean.getPaperid(), lapId, taskType, "" + lines.get(k), "具体需要盘点的行号", sequence++,
						2);
			}
		}
	}

	private void addReceiptOrShipmentTask(TM bean, Integer agvId, Integer lapId, String taskType) {
		for (TD detailBean : bean.getDetailList()) {
			AllocItemInfoBean allocationInfoBean = allocInfoService.getByNameFromDB(detailBean.getUserdef1());
			allocStatusMgrService.lockTheAllocation(allocationInfoBean, 1, taskType);
		}
		taskexeTaskDao.addATask(bean.getPaperid(), agvId, lapId, taskType, 2);
		agvOpWmsDao.command(agvId, taskType);
		agvOpWmsDao.goWork(agvId, taskType, bean.getPaperid());
	}
}
