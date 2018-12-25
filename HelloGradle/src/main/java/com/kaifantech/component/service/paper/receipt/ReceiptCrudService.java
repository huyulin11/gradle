package com.kaifantech.component.service.paper.receipt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.receipt.ReceiptDetailBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptMainBean;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.service.alloc.check.CsyAllocCheckService;
import com.kaifantech.entity.ReceiptDetailFormMap;
import com.kaifantech.entity.ReceiptMainFormMap;
import com.kaifantech.mappings.receipt.ReceiptDetailMapper;
import com.kaifantech.mappings.receipt.ReceiptMainMapper;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Service
public class ReceiptCrudService {
	@Inject
	private ReceiptDetailMapper detailMapper;

	@Inject
	private ReceiptMainMapper mainMapper;

	@Inject
	private ReceiptMainService mainService;

	@Inject
	private ControlInfoDao controlInfoDao;

	@Inject
	private CsyAllocCheckService csyAllocCheckService;

	public AppMsg doAddEntity(FormMap<?, ?> formMap) throws Exception {
		String paperid = getPaperId();
		return doAddEntity(formMap, paperid);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AppMsg doAddEntity(FormMap<?, ?> formMap, String paperid) throws Exception {
		ReceiptDetailFormMap detailFormMap = new ReceiptDetailFormMap();
		ReceiptMainFormMap mainFormMap = new ReceiptMainFormMap();
		Object targetPlace = formMap.get("targetPlace");
		detailFormMap.set("paperid", paperid);
		mainFormMap.set("paperid", paperid);
		mainFormMap.set("name", targetPlace);

		Map<String, FormMap> allocItemList = (Map<String, FormMap>) formMap.get("list");

		Collection<FormMap> valueCollection = allocItemList.values();
		List<FormMap> valueList = new ArrayList<FormMap>(valueCollection);
		try {
			valueList.sort((a1, a2) -> {
				return a1.get("allocItem").toString().compareTo(a2.get("allocItem").toString());
			});
		} catch (Exception e) {
			System.out.println("接口数据排序失败，沿用老的排序规则");
		}

		for (FormMap allocItem : valueList) {
			AppMsg msg = csyAllocCheckService.checkAllocName(allocItem.get("allocItem").toString(),
					AgvTaskType.RECEIPT);
			if (msg.getCode() < 0) {
				return msg;
			}
		}

		mainFormMap.set("totallines", allocItemList.size());
		doAddEntity(mainFormMap);
		int seq = 1;
		for (FormMap allocItem : valueList) {
			detailFormMap.set("userdef1", allocItem.get("allocItem"));
			detailFormMap.set("sequence", seq++);
			doAddEntity(detailFormMap);
		}
		return new AppMsg(0, "");
	}

	public AppMsg checkBeforeExecute(String id) {
		ReceiptMainBean bean = mainService.findById(id, true);
		for (ReceiptDetailBean detail : bean.getDetailList()) {
			AppMsg msg = csyAllocCheckService.checkAllocName(detail.getUserdef1(), AgvTaskType.RECEIPT);
			if (msg.getCode() < 0) {
				return msg;
			}
		}
		return new AppMsg(0, "");
	}

	private String getPaperId() {
		String paperid = controlInfoDao.getPrefixByType("WMS_RECEIPT_SID")
				+ String.format("%08d", controlInfoDao.getNextValueByType("WMS_RECEIPT_SID"));
		return paperid;
	}

	private void doAddEntity(ReceiptMainFormMap formMap) throws Exception {
		initFormMap(formMap);
		mainMapper.add(formMap);// 新增后返回新增信息
	}

	private void initFormMap(ReceiptMainFormMap formMap) {
		formMap.set("company", "JINANDANGANJU");
		formMap.set("warehouse", "1");
		formMap.set("totalqty", "1");
		formMap.set("receipttype", "AGV");
		formMap.set("orderdate", null);
		formMap.set("status", "1");
	}

	private void doAddEntity(ReceiptDetailFormMap formMap) throws Exception {
		initFormMap(formMap);
		try {
			detailMapper.add(formMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initFormMap(ReceiptDetailFormMap formMap) {
		formMap.set("item", "1");
		formMap.set("itemname", "1");
		formMap.set("itemcount", "1");
		formMap.set("sprice", "1");
		formMap.set("inventorysts", "1");
		formMap.set("expirationdate", null);
		formMap.set("lot", "1");
		formMap.set("remark", "1");
		formMap.set("userdef2", "1");
		formMap.set("userdef3", "1");
		formMap.set("userdef4", "1");
		formMap.set("status", "1");
	}
}