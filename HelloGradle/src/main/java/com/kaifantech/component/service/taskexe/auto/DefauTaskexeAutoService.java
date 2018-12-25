package com.kaifantech.component.service.taskexe.auto;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.bean.taskexe.SkuInfoBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.wms.alloc.AllocColumnInfoBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.dao.iot.client.IotClientMsgDao;
import com.kaifantech.component.service.alloc.column.IAllocColumnService;
import com.kaifantech.component.service.lap.LapInfoService;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;
import com.kaifantech.component.service.sku.SkuInfoService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.component.service.taskexe.oper.ITaskexeAddService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.alloc.AllocationStatus;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service("defauTaskexeAutoService")
public class DefauTaskexeAutoService implements ITaskexeAutoService {

	@Autowired
	private AllocItemDao allocDao;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXE_ADD_SERVICE)
	private ITaskexeAddService taskexeService;

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	@Autowired
	private TaskexeInfoService taskInfoService;

	@Autowired
	private LapInfoService lapInfoService;

	@Autowired
	private IAllocColumnService allocColumnService;

	@Autowired
	private SkuInfoService skuInfoService;

	@Autowired
	private IotClientMsgDao connectMsgRoboticArmDao;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public AppMsg addTask(Integer lapId, int autoflag) {
		if (AppTool.isNull(lapId) || lapId.equals(0)) {
			return new AppMsg(-1, "无法找到正确的取货点！");
		}

		Map<String, Object> lap = lapInfoService.getLap(lapId);

		Integer currentSkuId = (Integer) lap.get("skuId");
		Integer environment = (Integer) lap.get("environment");

		if (AppTool.isNull(currentSkuId)) {
			return new AppMsg(-1, "系统无法找到合适的货位！" + "对应机械手位定义当前生产产品类型");
		}

		SkuInfoBean currentSku = skuInfoService.getSkuInfoBeanById(currentSkuId);
		if (AppTool.isNull(currentSku)) {
			return new AppMsg(-1, "无法找到编号" + currentSkuId + "对应的SKU信息！");
		}

		String tips = "当前操作货品编号为：" + currentSkuId;

		List<TaskexeBean> latestTaskList = taskInfoService.getNotOverList();

		List<Map<String, Object>> agvList = lapInfoService.getAllAGVListBy(lapId);
		Integer agvId = null;
		for (Map<String, Object> agv : agvList) {
			Integer tmpAGVId = (Integer) agv.get("agvId");
			AgvBean agvBean = agvInfoDao.get(tmpAGVId);
			if (AppTool.isNull(agvBean)) {
				continue;
			}
			if (latestTaskList.stream().filter((taskexe) -> taskexe.getAgvId().equals(tmpAGVId)).count() > 0
					|| agvBean.getEnvironment() != Integer.parseInt(lap.get("environment").toString())) {
				agvId = null;
				continue;
			} else {
				AgvBean tmpAGVBean = agvInfoDao.get(tmpAGVId);
				if (tmpAGVBean.isCharging()) {
					tips += "，" + tmpAGVId + "号车正在充电！";
					continue;
				}
				agvId = tmpAGVId;
				break;
			}
		}
		if (AppTool.isNull(agvId)) {
			return new AppMsg(-1, "未找到对应AGV，或对应的agv处于非空闲状态，请稍后再试！（" + tips + "）");
		}

		int flag = 1;
		while (true) {
			List<AllocColumnInfoBean> columnList = null;
			if (flag == 1) {
				columnList = allocColumnService.getListBySkuId(environment, currentSkuId);
			} else if (flag == 2) {
				columnList = allocColumnService.getListBySkuType(environment, currentSku.getType());
			} else if (flag == 3) {
				columnList = allocColumnService.getListNotNeedAllow(environment);
			} else {
				break;
			}

			for (AllocColumnInfoBean column : columnList) {
				Integer maxZId = column.getAllowedLayerHeight();
				for (AllocItemInfoBean bean : allocDao.getAllAllocationInfoBean(column.getAreaId(),
						column.getColId())) {

					if (bean.getZId() > maxZId || bean.getZId() > currentSku.getLayerHeight()) {
						continue;
					}

					// if (AllocationStatus.SUODING.equals(bean.getStatus())) {
					// break;
					// }

					if (!AllocationStatus.KONGWEI.equals(bean.getStatus())) {
						if (AppTool.isNull(bean.getSkuId()) || bean.getSkuId().equals(currentSkuId)) {
							continue;
						} else {
							break;
						}
					}

					SingletaskBean singletask = singleTaskInfoService.getSingletaskBy(bean.getId(), agvId, lapId);
					if (singletask == null) {
						continue;
					}
					AppMsg msg = taskexeService.addTask(
							new TaskexeBean(singletask.getId(), bean.getId(), agvId, lapId, currentSkuId, autoflag));
					if (msg != null && msg.getCode() >= 0) {
						connectMsgRoboticArmDao.addAReceiveMsg("执行自动任务", lapId);
						return msg;
					}
				}
			}
			flag++;
		}

		return new AppMsg(-1, "系统无法找到合适的货位！" + (AppTool.isNull(tips) ? "" : "（" + tips + "）"));
	}
}
