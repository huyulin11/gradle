package com.kaifantech.component.service.buss.wms.paper.supervisor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptMainBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.dao.agv.info.AgvOpChargeDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.paper.inventory.InventoryMainService;
import com.kaifantech.component.service.paper.receipt.ReceiptMainService;
import com.kaifantech.component.service.paper.shipment.ShipmentMainService;
import com.kaifantech.component.service.status.iot.AgvChargeDealer;
import com.kaifantech.component.service.status.iot.AgvToInitDealer;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.constant.wms.WmsPaperStatus;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.kaifantech.util.msg.charge.ChargeMsgGetter;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Component
@Lazy(false)
public class BussSupervisorExecutor {
	@Autowired
	private ReceiptMainService receiptMainService;

	@Autowired
	private BussSupervisorWorker bussSupervisorWorker;

	@Autowired
	private ShipmentMainService shipmentMainService;

	@Autowired
	private InventoryMainService inventoryMainService;

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Autowired
	private AgvChargeDealer agvChargeDealer;

	@Autowired
	private AgvToInitDealer agvToInitDealer;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private TaskexeInfoService taskInfoService;

	@Autowired
	private AgvOpChargeDao agvOpDao;

	public synchronized void doWork() {
		boolean isOk = isOkInBay();
		if (isOk) {
			charge();
			autoCharge();
			toInit();
		}
		watch();
		if (isOk) {
			arrange();
			news();
			exes();
		}
	}

	private void autoCharge() {
		if (SystemParameters.isAutoCharge()) {
			List<AgvBean> list = agvInfoDao.getList();
			for (AgvBean agv : list) {
				if (AgvTaskType.GOTO_CHARGE.equals(agv.getTaskstatus())
						&& AgvSiteStatus.CHARGING.equals(agv.getSitestatus())) {
					if (ChargeMsgGetter.one().getChargeStatus(agv.getChargeid()).getCode().equals(0)) {
						AppFileLogger.warning(agv.getId() + "号AGV充电完成，系统自动安排其回归初始位置！");
						agvOpDao.commandBackCharge(agv.getId());
						return;
					}
				}
				if (AgvTaskType.FREE.equals(agv.getTaskstatus()) && AgvSiteStatus.INIT.equals(agv.getSitestatus())) {
					if (AgvBean.NEED_CHARGE.equals(agv.getBattery())) {
						AppFileLogger.warning(agv.getId() + "号AGV电量过低，系统自动安排其去充电！");
						agvOpDao.commandToCharge(agv.getId());
					}
				}
			}
		}
	}

	private synchronized void charge() {
		List<AgvBean> list = agvInfoDao.getChargedList();
		AppMsg msg = AppMsg.fail();
		for (AgvBean agv : list) {
			if ((AgvSiteStatus.INIT.equals(agv.getSitestatus()) && AgvTaskType.GOTO_CHARGE.equals(agv.getTaskstatus()))
					|| (AgvSiteStatus.CHARGING.equals(agv.getSitestatus())
							&& AgvTaskType.BACK_CHARGE.equals(agv.getTaskstatus()))) {
				msg = agvChargeDealer.newTask(agv, agv.getTaskstatus());
				break;
			} else {
				msg = agvChargeDealer.watchTask(agv);
			}
		}
		if (!AppTool.isNull(msg.getMsg())) {
			CsyAppFileLogger.error(msg.getMsg());
		}
		if (isOkInCharge2()) {
			agvChargeDealer.chargeMgr();
		}
	}

	private synchronized void toInit() {
		List<AgvBean> list = agvInfoDao.getToInitList();
		AppMsg msg = AppMsg.fail();
		for (AgvBean agv : list) {
			if (AgvSiteStatus.INIT.equals(agv.getSitestatus()) && AgvTaskType.GOTO_INIT.equals(agv.getTaskstatus())) {
				msg = agvToInitDealer.newTask(agv, agv.getTaskstatus());
				break;
			} else {
				msg = agvToInitDealer.watchTask(agv);
			}
		}
		if (!AppTool.isNull(msg.getMsg())) {
			CsyAppFileLogger.error(msg.getMsg());
		}
	}

	private void watch() {
		{
			List<ShipmentMainBean> list;
			list = shipmentMainService.findByStatus(WmsPaperStatus.EXECUTING, false);
			for (ShipmentMainBean bean : list) {
				bussSupervisorWorker.watchTask(bean);
			}
		}

		{
			List<ReceiptMainBean> list;
			list = receiptMainService.findByStatus(WmsPaperStatus.EXECUTING, false);
			for (ReceiptMainBean bean : list) {
				bussSupervisorWorker.watchTask(bean);
			}
		}

		{
			List<InventoryMainBean> list;
			list = inventoryMainService.findByStatus(WmsPaperStatus.EXECUTING, false);
			for (InventoryMainBean bean : list) {
				bussSupervisorWorker.watchInventoryTask(bean);
			}
		}
	}

	private void arrange() {
		{
			List<InventoryMainBean> list;
			list = inventoryMainService.findByStatus(WmsPaperStatus.EXECUTING, false);
			for (InventoryMainBean bean : list) {
				bussSupervisorWorker.arrangeInventoryTask(bean);
			}
		}
	}

	private void news() {
		{
			List<ShipmentMainBean> list;
			list = shipmentMainService.findByStatus(WmsPaperStatus.TOSEND, true);
			for (ShipmentMainBean bean : list) {
				bussSupervisorWorker.newTask(bean);
			}
		}
		{
			List<ReceiptMainBean> list;
			list = receiptMainService.findByStatus(WmsPaperStatus.TOSEND, true);
			for (ReceiptMainBean bean : list) {
				bussSupervisorWorker.newTask(bean);
			}
		}
		{
			List<InventoryMainBean> list;
			list = inventoryMainService.findByStatus(WmsPaperStatus.TOSEND, true);
			for (InventoryMainBean bean : list) {
				bussSupervisorWorker.newTask(bean);
			}
		}
	}

	private boolean isOkInCharge2() {
		for (IotClientBean agv : iotClientService.getAgvCacheList()) {
			CsyAgvMsgBean msg = AgvMsgGetter.one().getAgvMsgBean(agv.getId());
			if (AppTool.isNull(msg) || !msg.isValid()) {
				continue;
			}
			if (AppTool.equals(msg.currentSite(), 16, 17, 18)) {
				return false;
			}
		}
		return true;
	}

	private boolean isOkInBay() {
		List<TaskexeBean> latestTaskList = taskInfoService.getNotOverList();
		for (IotClientBean agv : iotClientService.getAgvCacheList()) {
			CsyAgvMsgBean msg = AgvMsgGetter.one().getAgvMsgBean(agv.getId());
			if (AppTool.isNull(msg) || !msg.isValid()) {
				continue;
			}
			if (latestTaskList.stream().filter((taskexe) -> {
				return !AppTool.isNull(taskexe.getAgvId()) && taskexe.getAgvId().equals(agv.getId());
			}).count() > 0 && (AppTool.equals(msg.currentSite(), 2, 7, 8, 9, 11, 12, 19)
					|| AppTool.equals(msg.currentSite(), 478, 65, 68, 481, 479, 480, 482, 20)
					|| AppTool.equals(msg.currentSite(), 13, 14, 15, 16, 17, 18))) {
				return false;
			}
		}
		return true;
	}

	private void exes() {
		if (SystemParameters.isAutoTask()) {
			{
				List<ShipmentMainBean> list;
				list = shipmentMainService.findByStatus(WmsPaperStatus.NEW, true);
				for (ShipmentMainBean bean : list) {
					shipmentMainService.updateToFrom(bean.getId(), WmsPaperStatus.TOSEND, WmsPaperStatus.NEW);
					return;
				}
			}
			{
				List<ReceiptMainBean> list;
				list = receiptMainService.findByStatus(WmsPaperStatus.NEW, true);
				for (ReceiptMainBean bean : list) {
					receiptMainService.updateToFrom(bean.getId(), WmsPaperStatus.TOSEND, WmsPaperStatus.NEW);
					return;
				}
			}
			{
				List<InventoryMainBean> list;
				list = inventoryMainService.findByStatus(WmsPaperStatus.NEW, true);
				for (InventoryMainBean bean : list) {
					inventoryMainService.updateToFrom(bean.getId(), WmsPaperStatus.TOSEND, WmsPaperStatus.NEW);
					return;
				}
			}
		}
	}
}
