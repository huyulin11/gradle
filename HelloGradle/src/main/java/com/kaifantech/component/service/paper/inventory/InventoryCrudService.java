package com.kaifantech.component.service.paper.inventory;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.entity.InventoryDetailFormMap;
import com.kaifantech.entity.InventoryMainFormMap;
import com.kaifantech.mappings.inventory.InventoryDetailMapper;
import com.kaifantech.mappings.inventory.InventoryMainMapper;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Service
public class InventoryCrudService {
	@Inject
	private ControlInfoDao controlInfoDao;

	@Inject
	private InventoryMainMapper mainMapper;

	@Inject
	private InventoryDetailMapper detailMapper;

	public void doAddEntity(InventoryDetailFormMap formMap) throws Exception {
		initFormMap(formMap);
		try {
			detailMapper.add(formMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doAddEntity(List<InventoryDetailFormMap> formMapList) throws Exception {
		for (InventoryDetailFormMap formMap : formMapList) {
			doAddEntity(formMap);
		}
	}

	private void initFormMap(InventoryDetailFormMap formMap) {
		formMap.set("item", "1");
		formMap.set("itemname", "1");
		formMap.set("itemcount", "1");
		formMap.set("sprice", "1");
		formMap.set("inventorysts", "1");
		formMap.set("expirationdate", null);
		formMap.set("sequence", "1");
		formMap.set("lot", "1");
		formMap.set("remark", "1");
		formMap.set("userdef2", "1");
		formMap.set("userdef3", "1");
		formMap.set("userdef4", "1");
		formMap.set("status", "1");
	}

	public AppMsg doAddEntity(FormMap<?, ?> formMap) throws Exception {
		String paperid = getPaperid();
		return doAddEntity(formMap, paperid);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AppMsg doAddEntity(FormMap<?, ?> formMap, String paperid) throws Exception {
		InventoryDetailFormMap detailFormMap = new InventoryDetailFormMap();
		InventoryMainFormMap mainFormMap = new InventoryMainFormMap();
		String targetPlace = formMap.getStr("targetPlace");
		String inventorytype = formMap.getStr("inventorytype");
		detailFormMap.set("paperid", paperid);
		mainFormMap.set("paperid", paperid);
		mainFormMap.set("inventorytype", inventorytype);
		mainFormMap.set("name", targetPlace);

		mainFormMap.set("totallines", 0);
		if (!InventoryMainBean.TYPE_FULL.equals(inventorytype)) {
			Map<String, FormMap> allocItemList = (Map<String, FormMap>) formMap.get("list");
			mainFormMap.set("totallines", allocItemList.size());
			for (FormMap allocItem : allocItemList.values()) {
				detailFormMap.set("userdef1", allocItem.get("allocItem"));
				doAddEntity(detailFormMap);
			}
		}
		doAddEntity(mainFormMap);
		return AppMsg.success().setMsg("成功保存");
	}

	private String getPaperid() {
		String paperid = controlInfoDao.getPrefixByType("WMS_INVENTORY_SID")
				+ String.format("%08d", controlInfoDao.getNextValueByType("WMS_INVENTORY_SID"));
		return paperid;
	}

	public void doAddEntity(InventoryMainFormMap formMap) throws Exception {
		initFormMap(formMap);
		mainMapper.add(formMap);
	}

	private void initFormMap(InventoryMainFormMap formMap) {
		formMap.set("company", "JINANDANGANJU");
		formMap.set("warehouse", "1");
		formMap.set("totalqty", "1");
		formMap.set("orderdate", null);
		formMap.set("status", "1");
	}

}