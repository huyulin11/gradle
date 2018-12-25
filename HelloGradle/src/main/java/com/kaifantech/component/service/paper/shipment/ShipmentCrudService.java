package com.kaifantech.component.service.paper.shipment;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.shipment.ShipmentDetailBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.service.alloc.check.CsyAllocCheckService;
import com.kaifantech.entity.ShipmentDetailFormMap;
import com.kaifantech.entity.ShipmentMainFormMap;
import com.kaifantech.mappings.shipment.ShipmentDetailMapper;
import com.kaifantech.mappings.shipment.ShipmentMainMapper;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Service
public class ShipmentCrudService {
	@Inject
	private ShipmentMainMapper mainMapper;

	@Inject
	private ControlInfoDao controlInfoDao;

	@Inject
	private ShipmentDetailMapper detailMapper;

	@Inject
	private ShipmentMainService mainService;

	@Inject
	private CsyAllocCheckService csyAllocCheckService;

	public AppMsg doAddEntity(FormMap<?, ?> formMap) throws Exception {
		String paperid = getPaperid();
		return doAddEntity(formMap, paperid);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AppMsg doAddEntity(FormMap<?, ?> formMap, String paperid) throws Exception {
		ShipmentDetailFormMap detailFormMap = new ShipmentDetailFormMap();
		ShipmentMainFormMap mainFormMap = new ShipmentMainFormMap();
		Object targetPlace = formMap.get("targetPlace");
		detailFormMap.set("paperid", paperid);
		mainFormMap.set("paperid", paperid);
		mainFormMap.set("name", targetPlace);

		Map<String, FormMap> allocItemList = (Map<String, FormMap>) formMap.get("list");

		for (FormMap allocItem : allocItemList.values()) {
			AppMsg msg = csyAllocCheckService.checkAllocName(allocItem.get("allocItem").toString(),
					AgvTaskType.SHIPMENT);
			if (msg.getCode() < 0) {
				return msg;
			}
		}

		mainFormMap.set("totallines", allocItemList.size());
		doAddEntity(mainFormMap);
		int seq = 1;
		for (FormMap allocItem : allocItemList.values()) {
			detailFormMap.set("userdef1", allocItem.get("allocItem"));
			detailFormMap.set("sequence", seq++);
			doAddEntity(detailFormMap);
		}
		return new AppMsg(0, "");
	}

	public AppMsg checkBeforeExecute(String id) {
		ShipmentMainBean bean = mainService.findById(id, true);
		for (ShipmentDetailBean detail : bean.getDetailList()) {
			AppMsg msg = csyAllocCheckService.checkAllocName(detail.getUserdef1(), AgvTaskType.SHIPMENT);
			if (msg.getCode() < 0) {
				return msg;
			}
		}
		return new AppMsg(0, "");
	}

	public void doAddEntity(ShipmentDetailFormMap formMap) throws Exception {
		initFormMap(formMap);
		detailMapper.add(formMap);
	}

	public void doAddEntity(List<ShipmentDetailFormMap> formMapList) throws Exception {
		for (ShipmentDetailFormMap formMap : formMapList) {
			doAddEntity(formMap);
		}
	}

	private void initFormMap(ShipmentDetailFormMap formMap) {
		formMap.set("item", "1");
		formMap.set("itemname", "1");
		formMap.set("itemcount", "1");
		formMap.set("sprice", "1");
		formMap.set("lot", "1");
		formMap.set("inventorysts", "1");
		formMap.set("userdef2", "1");
		formMap.set("userdef3", "1");
		formMap.set("userdef4", "1");
		formMap.set("status", "1");
	}

	private String getPaperid() {
		String paperid = controlInfoDao.getPrefixByType("WMS_SHIPMENT_SID")
				+ String.format("%08d", controlInfoDao.getNextValueByType("WMS_SHIPMENT_SID"));
		return paperid;
	}

	public void doAddEntity(ShipmentMainFormMap formMap) {
		initFormMap(formMap);
		mainMapper.add(formMap);
	}

	private void initFormMap(ShipmentMainFormMap formMap) {
		formMap.set("company", "JINANDANGANJU");
		formMap.set("warehouse", "1");
		formMap.set("totalqty", "1");
		formMap.set("tordercode", "1");
		formMap.set("shipmenttype", "AGV");
		formMap.set("carrier", "AGV");
		formMap.set("cusstomername", "1");
		formMap.set("cusstomerid", "1");
		formMap.set("ordertype", "1");
		formMap.set("itemstatus", "1");
		formMap.set("postcode", "1");
		formMap.set("phone", "1");
		formMap.set("mobile", "1");
		formMap.set("state", "1");
		formMap.set("city", "1");
		formMap.set("district", "1");
		formMap.set("address", "1");
		formMap.set("isfree", "1");
		formMap.set("keepamount", "1");
		formMap.set("area", "1");
		formMap.set("shipdate", null);
		formMap.set("cod", "1");
		formMap.set("codvalue", "1");
		formMap.set("invoice", "1");
		formMap.set("invoiceamount", "1");
		formMap.set("invoicetype", "1");
		formMap.set("invoicename", "1");
		formMap.set("invoicecontent", "1");
		formMap.set("shopname", "1");
		formMap.set("remark", "1");
		formMap.set("status", "1");
	}

}