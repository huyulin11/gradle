package com.kaifantech.component.service.de;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kaifantech.bean.de.AllRequestBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.component.dao.de.DeWmsRequestDao;
import com.kaifantech.component.service.paper.inventory.InventoryCrudService;
import com.kaifantech.component.service.paper.receipt.ReceiptCrudService;
import com.kaifantech.component.service.paper.shipment.ShipmentCrudService;
import com.kaifantech.component.service.rest.WmsRestService;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.constants.de.DeConstant;
import com.kaifantech.util.constants.de.DeStatus;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Service
public class DeWmsDataService {

	@Autowired
	private DeWmsRequestDao deWmsDataDao;

	@Autowired
	private WmsRestService wmsRestService;

	@Autowired
	private ReceiptCrudService receiptCrudService;

	@Autowired
	private ShipmentCrudService shipmentCrudService;

	@Autowired
	private InventoryCrudService inventoryCrudService;

	public synchronized AppMsg resolute(AllRequestBean bean) throws Exception {
		String jsonStr = (String) bean.getMsg();
		String sid = bean.getSid();
		deWmsDataDao.updateExtimes(sid);
		return resolute(sid, jsonStr, true);
	}

	private Integer getWicket(JSONObject jsonMap) {
		Object val = jsonMap.get("Wicket");
		if (AppTool.isNull(val)) {
			return null;
		}
		Integer id = Integer.parseInt(val.toString().replaceAll("ck", "")) + 14;
		return id;
	}

	private void sendToWms(String businessType, String paperid) {
		wmsRestService.sendToWms("{\"Type\":\"" + businessType + "\",\"PaperId\":\"" + paperid
				+ "\",\"Status\":\"1\",\"Description\":\"新建成功！\"}");
	}

	public synchronized AppMsg resolute(String sid, String jsonStr, boolean isUpdate) throws Exception {
		if (DeConstant.NULL.equals(jsonStr)) {
			if (isUpdate) {
				deWmsDataDao.updateExstatus(sid, DeStatus.OVER);
			}
			return new AppMsg(-1, "该接口数据无需解析");
		}
		JSONObject jsonMap = (JSONObject) JSONObject.parse(jsonStr);
		String businessType = jsonMap.getString("Type");
		if (AgvTaskType.RECEIPT.equals(businessType) || AgvTaskType.SHIPMENT.equals(businessType)) {
			return resoluteRecepitOrShipment(sid, jsonMap, isUpdate);
		}

		if (AgvTaskType.INVENTORY.equals(businessType)) {
			return resoluteInventory(sid, jsonMap, isUpdate);
		}
		if (AgvTaskType.TRANSFER.equals(businessType)) {
			String msg = "暂不支持解析移库单";
			if (isUpdate) {
				deWmsDataDao.updateErrinfo(sid, msg);
			}
			return new AppMsg(-1, msg);
		}
		String msg = "未能匹配数据类型";
		if (isUpdate) {
			deWmsDataDao.updateErrinfo(sid, msg);
		}
		return new AppMsg(-1, msg);
	}

	private AppMsg resoluteInventory(String sid, JSONObject jsonMap, boolean isUpdate) throws Exception {
		String businessType = jsonMap.getString("Type");
		String inventorytype = jsonMap.getString("inventorytype");
		final String paperid = jsonMap.getString("PaperId");
		FormMap<String, Object> formMap = new FormMap<>();
		formMap.set("inventorytype", inventorytype);
		if (!InventoryMainBean.TYPE_FULL.equals(inventorytype)) {
			JSONArray itemList = jsonMap.getJSONArray("ItemList");
			Map<String, FormMap<String, String>> allocItemList = new HashMap<>();
			for (Object obj : itemList) {
				JSONObject json = (JSONObject) obj;
				String columnName;
				if (InventoryMainBean.TYPE_LINE.equals(inventorytype)) {
					columnName = "" + json.getInteger("line");
				} else {
					columnName = json.getString("line") + "-" + json.getString("frame") + "-"
							+ json.getString("column");
				}
				FormMap<String, String> allocFormMap = new FormMap<>();
				allocFormMap.put("allocItem", columnName);
				allocItemList.put(columnName, allocFormMap);
			}
			formMap.set("list", allocItemList);
		}
		AppMsg msg = inventoryCrudService.doAddEntity(formMap, paperid);
		if (msg.getCode() >= 0) {
			ThreadTool.run(() -> {
				sendToWms(businessType, paperid);
			});
			if (isUpdate) {
				deWmsDataDao.updateExstatus(sid, DeStatus.OVER);
			}
		}
		if (isUpdate) {
			deWmsDataDao.updateErrinfo(sid, msg.getMsg());
		}
		return msg;
	}

	private AppMsg resoluteRecepitOrShipment(String sid, JSONObject jsonMap, boolean isUpdate) throws Exception {
		JSONArray itemList = (JSONArray) jsonMap.getJSONArray("ItemList");
		String businessType = jsonMap.getString("Type");
		Integer wicket = null;
		final String paperid = (String) jsonMap.getString("PaperId");
		FormMap<String, Object> formMap = new FormMap<>();
		wicket = getWicket(jsonMap);
		if (AppTool.isNull(wicket)) {
			return new AppMsg(-1, "入库或出库时，窗口信息不能为空");
		}
		if (AppTool.isNull(paperid)) {
			String msg = "未找到主单号";
			if (isUpdate) {
				deWmsDataDao.updateErrinfo(sid, msg);
			}
			return new AppMsg(-1, msg);
		}
		if (AppTool.isNull(itemList)) {
			String msg = "未找到有效明细数据";
			if (isUpdate) {
				deWmsDataDao.updateErrinfo(sid, msg);
			}
			return new AppMsg(-1, msg);
		}

		formMap.set("paperid", paperid);
		formMap.set("targetPlace", wicket);
		Map<String, FormMap<String, String>> allocItemList = new HashMap<>();
		for (Object obj : itemList) {
			JSONObject json = (JSONObject) obj;
			String AllocName = json.getString("AllocId");
			FormMap<String, String> allocFormMap = new FormMap<>();
			allocFormMap.put("allocItem", AllocName);
			allocItemList.put(AllocName, allocFormMap);
		}
		formMap.set("list", allocItemList);
		if (AgvTaskType.RECEIPT.equals(businessType)) {
			AppMsg msg = receiptCrudService.doAddEntity(formMap, paperid);
			if (msg.getCode() >= 0) {
				ThreadTool.run(() -> {
					sendToWms(businessType, paperid);
				});
				if (isUpdate) {
					deWmsDataDao.updateExstatus(sid, DeStatus.OVER);
				}
			}
			return msg;
		} else {
			AppMsg msg = shipmentCrudService.doAddEntity(formMap, paperid);
			if (msg.getCode() >= 0) {
				ThreadTool.run(() -> {
					sendToWms(businessType, paperid);
				});
				if (isUpdate) {
					deWmsDataDao.updateExstatus(sid, DeStatus.OVER);
				}
			}
			if (isUpdate) {
				deWmsDataDao.updateErrinfo(sid, msg.getMsg());
			}
			return msg;
		}
	}
}
