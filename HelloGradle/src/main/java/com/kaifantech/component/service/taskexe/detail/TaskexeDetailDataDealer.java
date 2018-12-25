
package com.kaifantech.component.service.taskexe.detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.bean.wms.alloc.AllocInventoryInfoBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.service.alloc.info.AllocInventoryInfoService;
import com.kaifantech.component.service.alloc.info.IAllocInfoService;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.init.sys.SystemInitiator;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.kaifantech.util.msg.window.WindowMsgGetter;
import com.ytgrading.util.AppTool;

/***
 * 描述任务从用户下达到发送AGV执行前的逻辑
 ***/
@Service
public class TaskexeDetailDataDealer {

	@Autowired
	private TaskSiteInfoService taskSiteService;

	@Autowired
	private WmsPaperService wmsPaperService;

	@Autowired
	private IAllocInfoService allocInfoService;

	@Autowired
	private AllocInventoryInfoService allocInventoryInfoService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	public List<TaskexeDetailBean> getList(WmsPaperMainBean<?> wmsPaperBean, TaskexeBean taskexeBean) throws Exception {
		List<TaskexeDetailBean> tmpTaskexeDetailList;
		if (AgvTaskType.GOTO_INIT.equals(taskexeBean.getTasktype())) {
			tmpTaskexeDetailList = getInitDetailsGotoInit(taskexeBean);
		} else if (AgvTaskType.GOTO_CHARGE.equals(taskexeBean.getTasktype())) {
			tmpTaskexeDetailList = getInitDetailsGotoCharge(taskexeBean);
		} else if (AgvTaskType.BACK_CHARGE.equals(taskexeBean.getTasktype())) {
			tmpTaskexeDetailList = getInitDetailsBackFromCharge(taskexeBean);
		} else if (AgvTaskType.CHANGE_CHARGE.equals(taskexeBean.getTasktype())) {
			tmpTaskexeDetailList = getInitDetailsChangeCharge(taskexeBean);
		} else {
			tmpTaskexeDetailList = getInitDetails(wmsPaperBean, taskexeBean);
		}
		return tmpTaskexeDetailList;
	}

	public List<TaskexeDetailBean> getInitDetailsChangeCharge(TaskexeBean taskexeBean) {
		List<TaskexeDetailBean> tmpTaskexeDetailList = new ArrayList<>();
		TaskSiteInfoBean tasksiteBean;
		TaskexeDetailBean taskexeDetail;
		{
			tasksiteBean = taskSiteService.getChargeSite(13);
			taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.START);
			tmpTaskexeDetailList.add(taskexeDetail);
		}
		{
			tasksiteBean = taskSiteService.getChargeSite(14);
			taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.CHARGE);
			tmpTaskexeDetailList.add(taskexeDetail);
		}
		return tmpTaskexeDetailList;
	}

	public List<TaskexeDetailBean> getInitDetailsBackFromCharge(TaskexeBean taskexeBean) {
		List<TaskexeDetailBean> tmpTaskexeDetailList = new ArrayList<>();
		TaskSiteInfoBean tasksiteBean;
		TaskexeDetailBean taskexeDetail;
		{
			tasksiteBean = taskSiteService.getChargeSite(agvInfoDao.getChargeId(taskexeBean.getAgvId()));
			taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.START);
			tmpTaskexeDetailList.add(taskexeDetail);
		}
		{
			tasksiteBean = taskSiteService.getInitSite(taskexeBean.getAgvId());
			taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.STOP);
			tmpTaskexeDetailList.add(taskexeDetail);
		}
		return tmpTaskexeDetailList;
	}

	public List<TaskexeDetailBean> getInitDetailsGotoCharge(TaskexeBean taskexeBean) {
		List<TaskexeDetailBean> tmpTaskexeDetailList = new ArrayList<>();
		TaskSiteInfoBean tasksiteBean;
		TaskexeDetailBean taskexeDetail;
		{
			tasksiteBean = taskSiteService.getInitSite(taskexeBean.getAgvId());
			taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.START);
			tmpTaskexeDetailList.add(taskexeDetail);
		}
		{
			tasksiteBean = taskSiteService.getChargeSite(agvInfoDao.getChargeId(taskexeBean.getAgvId()));
			taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.CHARGE);
			tmpTaskexeDetailList.add(taskexeDetail);
		}
		return tmpTaskexeDetailList;
	}

	public List<TaskexeDetailBean> getInitDetailsGotoInit(TaskexeBean taskexeBean) {
		CsyAgvMsgBean msg = AgvMsgGetter.one().getAgvMsgBean(taskexeBean.getAgvId());
		if (AppTool.isNull(msg) || !msg.isValid()) {
			return null;
		}
		Integer currentSiteId = msg.currentSite();
		List<TaskexeDetailBean> tmpTaskexeDetailList = new ArrayList<>();
		TaskSiteInfoBean currentSite = taskSiteService.getBean(currentSiteId);
		TaskexeDetailBean currentDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), currentSite);
		currentDetail.setArrivedact(ArrivedAct.START);
		tmpTaskexeDetailList.add(currentDetail);
		TaskSiteInfoBean initSite = taskSiteService.getInitSite(taskexeBean.getAgvId());
		if (!currentSite.equals(initSite)) {
			TaskexeDetailBean initDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), initSite);
			initDetail.setArrivedact(ArrivedAct.STOP);
			tmpTaskexeDetailList.add(initDetail);
		}
		return tmpTaskexeDetailList;
	}

	public List<TaskexeDetailBean> getInitDetails(WmsPaperMainBean<?> wmsPaperBean, TaskexeBean taskexeBean)
			throws Exception {
		wmsPaperBean.getDetailList().sort(WmsPaperDetailBean.comparator);
		List<TaskexeDetailBean> tmpTaskexeDetailList = new ArrayList<>();

		{
			TaskSiteInfoBean tasksiteBean = taskSiteService.getInitSite(taskexeBean.getAgvId());
			TaskexeDetailBean taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.START);
			tmpTaskexeDetailList.add(taskexeDetail);
		}

		if (AgvTaskType.RECEIPT.equals(taskexeBean.getTasktype())) {
			TaskSiteInfoBean tasksiteBean = taskSiteService.getWindowSite(wmsPaperBean.getName());
			TaskexeDetailBean taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			List<String> windowLayers = WindowMsgGetter.one().getLayersList(wmsPaperBean.getName());
			if (windowLayers.size() < wmsPaperBean.getDetailList().size()) {
				throw new Exception("窗口入库数量小于入库单数量，入库单无法下达到AGV！");
			}
			taskexeDetail.setArrivedact(ArrivedAct.WINDOW_GET);
			taskexeDetail.setAddedinfo(String.join(SystemInitiator.SPLIT, windowLayers));
			taskexeDetail.setAddeddesc("入库时货物所在窗口的层数");
			tmpTaskexeDetailList.add(taskexeDetail);
		}

		if (AgvTaskType.RECEIPT.equals(taskexeBean.getTasktype())
				|| AgvTaskType.SHIPMENT.equals(taskexeBean.getTasktype())) {
			List<TaskexeDetailBean> list = new ArrayList<>();
			for (WmsPaperDetailBean detailBean : wmsPaperBean.getDetailList()) {
				AllocItemInfoBean allocItem = allocInfoService.getByNameFromCache(detailBean.getUserdef1());
				TaskSiteInfoBean tasksiteBean = taskSiteService.getBean(allocItem.getSiteid());
				TaskexeDetailBean taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
				taskexeDetail.setArrivedact(wmsPaperService.getArrivedActType(taskexeBean));
				taskexeDetail.setAddedinfo(detailBean.getUserdef1());
				taskexeDetail.setAddeddesc("入库时货物所在窗口的层数");
				list.add(taskexeDetail);
			}
			list.sort((a1, a2) -> {
				TaskSiteInfoBean site1 = taskSiteService.getBean(a1.getSiteid());
				TaskSiteInfoBean site2 = taskSiteService.getBean(a2.getSiteid());
				if (site2.getLine().equals(site1.getLine())) {
					return a1.getSiteid() - a2.getSiteid();
				}
				return site2.getLine() - site1.getLine();
			});
			tmpTaskexeDetailList.addAll(list);
		}

		if (AgvTaskType.INVENTORY.equals(taskexeBean.getTasktype())) {
			doInitInventoryWork(wmsPaperBean, taskexeBean, tmpTaskexeDetailList);
		}

		if (AgvTaskType.SHIPMENT.equals(taskexeBean.getTasktype())) {
			TaskSiteInfoBean tasksiteBean = taskSiteService.getWindowSite(wmsPaperBean.getName());
			TaskexeDetailBean taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.WINDOW_STOCK);
			taskexeDetail.setAddedinfo("" + wmsPaperBean.getDetailsAlloc());
			taskexeDetail.setAddeddesc("出库到窗口时所需操作货物的具体货位名称");
			tmpTaskexeDetailList.add(taskexeDetail);
		}

		{
			TaskSiteInfoBean tasksiteBean = taskSiteService.getInitSite(taskexeBean.getAgvId());
			TaskexeDetailBean taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
			taskexeDetail.setArrivedact(ArrivedAct.STOP);
			tmpTaskexeDetailList.add(taskexeDetail);
		}
		return tmpTaskexeDetailList;
	}

	private void doInitInventoryWork(WmsPaperMainBean<?> wmsPaperBean, TaskexeBean taskexeBean,
			List<TaskexeDetailBean> tmpTaskexeDetailList) throws Exception {
		InventoryMainBean mainBean = (InventoryMainBean) wmsPaperBean;
		String inventorytype = mainBean.getInventorytype();
		if (InventoryMainBean.TYPE_COLUMN.equals(inventorytype)) {
			Map<Integer, String> columnSites = new TreeMap<>();
			for (WmsPaperDetailBean detailBean : wmsPaperBean.getDetailList()) {
				AllocInventoryInfoBean allocInventoryInfoBean = new AllocInventoryInfoBean(detailBean.getUserdef1());
				List<AllocInventoryInfoBean> list = allocInventoryInfoService.getList(allocInventoryInfoBean);
				for (AllocInventoryInfoBean bean : list) {
					String story = columnSites.get(bean.getSiteid());
					columnSites.put(bean.getSiteid(),
							(AppTool.isNull(story) ? "" : (story + SystemInitiator.SPLIT)) + JSONObject.toJSON(bean));
				}
			}
			for (Integer siteid : columnSites.keySet()) {
				TaskSiteInfoBean tasksiteBean = taskSiteService.getBean(siteid);
				TaskexeDetailBean taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
				taskexeDetail.setArrivedact(wmsPaperService.getArrivedActType(taskexeBean));
				taskexeDetail.setAddedinfo(columnSites.get(siteid));
				taskexeDetail.setAddeddesc("盘库明细任务每纵拆分为四个子任务");
				tmpTaskexeDetailList.add(taskexeDetail);
			}
		} else if (InventoryMainBean.TYPE_LINE.equals(inventorytype)
				|| InventoryMainBean.TYPE_FULL.equals(inventorytype)) {
			String addedinfo = taskexeBean.getAddedinfo();
			if (AppTool.isNull(addedinfo)) {
				throw new Exception("盘点任务关键数据addedinfo为空");
			}
			Map<Integer, String> columnSites = new HashMap<>();
			List<Integer> sites = new ArrayList<>();
			List<AllocInventoryInfoBean> list = allocInventoryInfoService.getList(Integer.parseInt(addedinfo));
			if (!AppTool.isNull(list)) {
				list.sort((a1, a2) -> {
					if (AppTool.equals(a1.getGrid(), 1, 2) && AppTool.equals(a2.getGrid(), 1, 2)
							|| (AppTool.equals(a1.getGrid(), 3, 4) && AppTool.equals(a2.getGrid(), 3, 4))) {
						return a2.getLine() - a1.getLine();
					}
					return a1.getGrid() - a2.getGrid();
				});
			}
			for (AllocInventoryInfoBean allocInventoryInfoBean : list) {
				if (!sites.contains(allocInventoryInfoBean.getSiteid())) {
					sites.add(allocInventoryInfoBean.getSiteid());
				}
				String story = columnSites.get(allocInventoryInfoBean.getSiteid());
				columnSites.put(allocInventoryInfoBean.getSiteid(),
						(AppTool.isNull(story) ? "" : (story + SystemInitiator.SPLIT))
								+ JSONObject.toJSON(allocInventoryInfoBean));
			}
			sites.sort((s1, s2) -> {
				return s1 - s2;
			});
			for (Integer siteid : sites) {
				TaskSiteInfoBean tasksiteBean = taskSiteService.getBean(siteid);
				TaskexeDetailBean taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), tasksiteBean);
				taskexeDetail.setArrivedact(wmsPaperService.getArrivedActType(taskexeBean));
				taskexeDetail.setAddedinfo(columnSites.get(siteid));
				taskexeDetail.setAddeddesc("盘库明细任务每纵拆分为四个子任务");
				tmpTaskexeDetailList.add(taskexeDetail);
			}
		}
	}
}
