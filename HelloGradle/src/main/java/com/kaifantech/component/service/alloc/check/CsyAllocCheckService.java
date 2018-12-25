package com.kaifantech.component.service.alloc.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptMainBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.component.service.alloc.info.IAllocInfoService;
import com.kaifantech.init.sys.SystemInitiator;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.msg.AppMsg;

@Service(CsySystemQualifier.ALLOC_CHECK_SERVICE)
public class CsyAllocCheckService extends WmsAllocCheckService {

	@Autowired
	private IAllocInfoService allocService;

	public <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> AppMsg checkAlloc(TM obj, Integer agvId) {
		if (SystemInitiator.alwaysTrue) {
			return new AppMsg(0, "任务可以下达！");
		}

		AppMsg msg = checkLatestTaskexe(agvId);
		if (msg.getCode() < 0) {
			return msg;
		}

		String taskType;
		if (obj instanceof ReceiptMainBean) {
			taskType = AgvTaskType.RECEIPT;
		} else if (obj instanceof ShipmentMainBean) {
			taskType = AgvTaskType.SHIPMENT;
		} else {
			return new AppMsg(-1, "未找到匹配的业务模式或该业务模式不需要校验");
		}

		for (TD detailBean : obj.getDetailList()) {
			msg = checkAllocName(detailBean.getUserdef1(), taskType);
			if (msg.getCode() < 0) {
				return msg;
			}
		}
		return new AppMsg(0, "任务可以下达！");
	}

	public AppMsg checkAllocName(String allocName, String type) {
		AppMsg msg;

		AllocItemInfoBean allocationInfoBean = allocService.getByNameFromDB(allocName);
		msg = checkAllocInfo(allocationInfoBean, type);
		if (msg.getCode() < 0) {
			msg.setMsg(msg.getMsg() + ",货位名称：" + allocName);
			return msg;
		}
		return new AppMsg(0, "任务可以下达！");
	}

}
