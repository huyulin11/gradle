package com.kaifantech.component.service.data.init.csy;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.dao.test.TestDao;
import com.kaifantech.component.worker.data.init.IDataInitWorker;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;

@Service
public class CsyDataInitService {

	@Autowired
	private AllocItemDao allocItemDao;

	@Autowired
	private TestDao testDao;

	@Autowired
	@Qualifier(CsySystemQualifier.CSY_TASK_SITE_INFO_INIT_WORKER)
	private IDataInitWorker taskSiteInfoInitWorker;

	@Autowired
	@Qualifier(CsySystemQualifier.CSY_TASK_SITE_LOGIC_INIT_WORKER)
	private IDataInitWorker taskSiteLogicInitWorker;

	public void initData() {
		initTaskSiteInfo();
		initTaskSiteLogic();
		initAlloc();
	}

	private void initAlloc() {
		if (!SystemParameters.isInitAllocInfo()) {
			return;
		}
		doInitAlloc();
		SystemParameters.setInitAllocInfo(false);
	}

	private void doInitAlloc() {
		allocItemDao.truncate();
		List<Map<String, Object>> wmsData = testDao.getDataFromCsyWms();
		allocItemDao.insert(wmsData);
	}

	private void initTaskSiteInfo() {
		if (!SystemParameters.isInitTaskSiteInfo()) {
			return;
		}
		taskSiteInfoInitWorker.doInit();
		SystemParameters.setInitTaskSiteInfo(false);
		System.out.println("站点基础数据初始化结束！");
	}

	private void initTaskSiteLogic() {
		if (!SystemParameters.isInitTaskSiteLogic()) {
			return;
		}
		taskSiteLogicInitWorker.doInit();
		SystemParameters.setInitTaskSiteLogic(false);
		System.out.println("站点地图数据初始化结束！");
	}
}
