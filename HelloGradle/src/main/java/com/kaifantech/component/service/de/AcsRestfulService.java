package com.kaifantech.component.service.de;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptMainBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.component.service.paper.inventory.InventoryMainService;
import com.kaifantech.component.service.paper.receipt.ReceiptMainService;
import com.kaifantech.component.service.paper.shipment.ShipmentMainService;
import com.kaifantech.component.service.status.agv.AgvsCtrlInfoService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.ytgrading.util.AppTool;

@Service
public class AcsRestfulService {

	@Autowired
	private AgvsCtrlInfoService agvsCtrlInfoService;

	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	protected ReceiptMainService receiptMainService;

	@Autowired
	protected ShipmentMainService shipmentMainService;

	@Autowired
	protected InventoryMainService inventoryMainService;

	private static int flag = 0;

	public List<Map<String, Object>> getAgvStatus() {
		return null;
	}

	public List<Map<String, Object>> getAgvStatusTest() {
		List<Integer> agvStatusCode = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<String> agvStatusName = Arrays.asList("空闲", "执行入库", "执行出库", "执行盘点", "正在充电", "备用");
		List<String> agvBattery = Arrays.asList("54%", "35%", "23%", "88%");
		List<Map<String, Object>> allAgv = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Map<String, Object> singleAgv = new HashMap<>();
			singleAgv.put("id", i + 1);
			singleAgv.put("statusCode", agvStatusCode.get(flag % agvStatusCode.size()));
			singleAgv.put("statusName", agvStatusName.get(flag % agvStatusName.size()));
			singleAgv.put("battery", agvBattery.get(i));
			flag++;
			allAgv.add(singleAgv);
		}
		return allAgv;
	}

	public Object getPapersStatus(String paperid) {
		ReceiptMainBean rtnR = receiptMainService.findByPaperid(paperid, false);
		if (!AppTool.isNull(rtnR)) {
			return rtnR;
		}
		ShipmentMainBean rtnS = shipmentMainService.findByPaperid(paperid, false);
		if (!AppTool.isNull(rtnS)) {
			return rtnS;
		}
		InventoryMainBean rtnI = inventoryMainService.findByPaperid(paperid, false);
		if (!AppTool.isNull(rtnI)) {
			return rtnI;
		}
		return null;
	}

}
