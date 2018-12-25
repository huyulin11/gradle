package com.kaifantech.component.service.paper.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryDetailBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptDetailBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptMainBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentDetailBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.component.service.paper.inventory.InventoryDetailService;
import com.kaifantech.component.service.paper.inventory.InventoryMainService;
import com.kaifantech.component.service.paper.receipt.ReceiptDetailService;
import com.kaifantech.component.service.paper.receipt.ReceiptMainService;
import com.kaifantech.component.service.paper.shipment.ShipmentDetailService;
import com.kaifantech.component.service.paper.shipment.ShipmentMainService;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;

@Service
public class WmsPaperService {
	@Autowired
	protected ReceiptMainService receiptMainService;

	@Autowired
	protected ShipmentMainService shipmentMainService;

	@Autowired
	protected InventoryMainService inventoryMainService;

	@Autowired
	protected ReceiptDetailService receiptDetailService;

	@Autowired
	protected ShipmentDetailService shipmentDetailService;

	@Autowired
	protected InventoryDetailService inventoryDetailService;

	public String getArrivedActType(TaskexeBean taskexeBean) {
		if (AgvTaskType.RECEIPT.equals(taskexeBean.getTasktype())) {
			return ArrivedAct.ALLOC_STOCK;
		} else if (AgvTaskType.SHIPMENT.equals(taskexeBean.getTasktype())) {
			return ArrivedAct.ALLOC_GET;
		} else if (AgvTaskType.INVENTORY.equals(taskexeBean.getTasktype())) {
			return ArrivedAct.ALLOC_SCAN;
		}
		return null;
	}

	public AbstractWmsPaperMainService<?, ?, ?> getMainService(TaskexeBean taskexeBean) {
		if (AgvTaskType.RECEIPT.equals(taskexeBean.getTasktype())) {
			return receiptMainService;
		} else if (AgvTaskType.SHIPMENT.equals(taskexeBean.getTasktype())) {
			return shipmentMainService;
		} else if (AgvTaskType.INVENTORY.equals(taskexeBean.getTasktype())) {
			return inventoryMainService;
		}
		return null;
	}

	public AbstractWmsPaperDetailService<?, ?, ?> getDetailService(TaskexeBean taskexeBean) {
		if (AgvTaskType.RECEIPT.equals(taskexeBean.getTasktype())) {
			return receiptDetailService;
		} else if (AgvTaskType.SHIPMENT.equals(taskexeBean.getTasktype())) {
			return shipmentDetailService;
		} else if (AgvTaskType.INVENTORY.equals(taskexeBean.getTasktype())) {
			return inventoryDetailService;
		}
		return null;
	}

	public <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> AbstractWmsPaperMainService<?, ?, ?> getMainService(
			TM tmBean) {
		if (tmBean instanceof ReceiptMainBean) {
			return receiptMainService;
		} else if (tmBean instanceof ShipmentMainBean) {
			return shipmentMainService;
		} else if (tmBean instanceof InventoryMainBean) {
			return inventoryMainService;
		}
		return null;
	}

	public <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> String getTaskType(TM tmBean) {
		if (tmBean instanceof ReceiptMainBean) {
			return AgvTaskType.RECEIPT;
		} else if (tmBean instanceof ShipmentMainBean) {
			return AgvTaskType.SHIPMENT;
		} else if (tmBean instanceof InventoryMainBean) {
			return AgvTaskType.INVENTORY;
		}
		return null;
	}

	public <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> AbstractWmsPaperDetailService<?, ?, ?> getDetailService(
			TM tmBean) {
		if (tmBean instanceof ReceiptMainBean) {
			return receiptDetailService;
		} else if (tmBean instanceof ShipmentMainBean) {
			return shipmentDetailService;
		} else if (tmBean instanceof InventoryMainBean) {
			return inventoryDetailService;
		}
		return null;
	}

	public <TD extends WmsPaperDetailBean> AbstractWmsPaperMainService<?, ?, ?> getMainService(TD tmBean) {
		if (tmBean instanceof ReceiptDetailBean) {
			return receiptMainService;
		} else if (tmBean instanceof ShipmentDetailBean) {
			return shipmentMainService;
		} else if (tmBean instanceof InventoryDetailBean) {
			return inventoryMainService;
		}
		return null;
	}

	public <TD extends WmsPaperDetailBean> AbstractWmsPaperDetailService<?, ?, ?> getDetailService(TD tmBean) {
		if (tmBean instanceof ReceiptDetailBean) {
			return receiptDetailService;
		} else if (tmBean instanceof ShipmentDetailBean) {
			return shipmentDetailService;
		} else if (tmBean instanceof InventoryDetailBean) {
			return inventoryDetailService;
		}
		return null;
	}

	public AbstractWmsPaperMainService<?, ?, ?> getMainService(Class<?> clazz, boolean isMain) {
		if (isMain) {
			if (clazz.getClass().equals(ReceiptMainBean.class)) {
				return receiptMainService;
			} else if (clazz.getClass().equals(ReceiptMainBean.class)) {
				return shipmentMainService;
			} else if (clazz.getClass().equals(ReceiptMainBean.class)) {
				return inventoryMainService;
			}
		} else {
			if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return receiptMainService;
			} else if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return shipmentMainService;
			} else if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return inventoryMainService;
			}
		}
		return null;
	}

	public AbstractWmsPaperDetailService<?, ?, ?> getDetailService(Class<?> clazz, boolean isMain) {
		if (isMain) {
			if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return receiptDetailService;
			} else if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return shipmentDetailService;
			} else if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return inventoryDetailService;
			}
		} else {
			if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return receiptDetailService;
			} else if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return shipmentDetailService;
			} else if (clazz.getClass().equals(ReceiptDetailBean.class)) {
				return inventoryDetailService;
			}
		}
		return null;
	}

}