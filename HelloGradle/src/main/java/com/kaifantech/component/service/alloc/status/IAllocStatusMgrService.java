package com.kaifantech.component.service.alloc.status;

import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.ytgrading.util.msg.AppMsg;

public interface IAllocStatusMgrService {
	int clearAllocByColId(Integer areaId, Integer colId, Integer minRowId, Integer minZId);

	public AppMsg transferUpDone(AllocItemInfoBean bean);

	public AppMsg transferDownDone(AllocItemInfoBean bean);

	public AppMsg lockTheAllocation(AllocItemInfoBean bean, Integer skuId, String taskType);

}
