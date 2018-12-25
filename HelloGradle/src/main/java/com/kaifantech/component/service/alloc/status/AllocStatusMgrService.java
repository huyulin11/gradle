package com.kaifantech.component.service.alloc.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.SkuInfoBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.service.sku.SkuInfoService;
import com.kaifantech.util.constant.taskexe.alloc.AllocationStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.msg.AppMsg;

@Service
public class AllocStatusMgrService implements IAllocStatusMgrService {

	@Autowired
	private AllocItemDao allocDao;

	@Autowired
	private SkuInfoService skuInfoService;

	@Override
	public AppMsg transferUpDone(AllocItemInfoBean bean) {
		int num = allocDao.update(bean.getId(), AllocationStatus.SUODING, AllocationStatus.YOUHUO);
		if (num == 1) {
			return new AppMsg(0, "上架成功！");
		}
		return new AppMsg(-1, "上架失败！");
	}

	@Override
	public int clearAllocByColId(Integer areaId, Integer colId, Integer minRowId, Integer minZId) {
		int i = 0;
		for (AllocItemInfoBean bean : allocDao.getAllocationInfoBeanListByColId(areaId, colId)) {
			if (bean.getRowId() > minRowId || (bean.getRowId().equals(minRowId) && bean.getZId() >= minZId)) {
				i += allocDao.update(bean.getId(), AllocationStatus.YOUHUO, AllocationStatus.KONGWEI);
			}
		}
		return i;
	}

	@Override
	public AppMsg transferDownDone(AllocItemInfoBean bean) {
		int num = allocDao.update(bean.getId(), AllocationStatus.SUODING, AllocationStatus.KONGWEI);
		if (num == 1) {
			return new AppMsg(0, "下架成功！");
		}
		return new AppMsg(-1, "下架失败！");
	}

	private AppMsg lockTheAllocationWhenUp(AllocItemInfoBean bean, Integer skuId) {
		SkuInfoBean skuInfoBean = skuInfoService.getSkuInfoBeanById(skuId);
		int num = allocDao.updateWithSku(bean.getId(), AllocationStatus.KONGWEI, AllocationStatus.SUODING, skuId,
				skuInfoBean.getNumInPallet());
		return num == 1 ? (new AppMsg(0, "上架前锁定货位状态成功！")) : (new AppMsg(-1, "上架前锁定货位状态失败！"));
	}

	private AppMsg lockTheAllocationWhenDown(AllocItemInfoBean bean, Integer skuId) {
		int num = allocDao.updateWithSku(bean.getId(), AllocationStatus.YOUHUO, AllocationStatus.SUODING, skuId, 0);
		return num == 1 ? (new AppMsg(0, "下架前锁定货位状态成功！")) : (new AppMsg(-1, "下架前锁定货位状态失败！"));
	}

	@Override
	public AppMsg lockTheAllocation(AllocItemInfoBean bean, Integer skuId, String taskType) {
		return AgvTaskType.RECEIPT.equals(taskType) ? lockTheAllocationWhenUp(bean, skuId)
				: (AgvTaskType.SHIPMENT.equals(taskType) ? lockTheAllocationWhenDown(bean, skuId)
						: new AppMsg(0, "无需锁定"));
	}

}
