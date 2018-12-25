package com.kaifantech.component.worker.data.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.entity.TaskSiteFormMap;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.mappings.TaskSiteInfoMapper;
import com.kaifantech.util.hex.AppByteUtil;

@Service(CsySystemQualifier.CSY_TASK_SITE_INFO_INIT_WORKER)
public class CsyTaskSiteInfoInitWorker implements IDataInitWorker {
	public void doInit() {
		taskSiteInfoMapper.truncate(new TaskSiteFormMap());
		for (int seq = 1; seq <= 500; seq++) {
			TaskSiteInfoBean taskSiteInfoBean = new TaskSiteInfoBean();
			taskSiteInfoBean.setId(seq);
			taskSiteInfoBean.setSitecode(AppByteUtil.int2Str4(seq));
			taskSiteInfoBean.setSitename("" + seq + "号站点");
			taskSiteInfoMapper.addBean(taskSiteInfoBean);
		}
		allocItemDao.updateSite();
		System.out.println(this.getClass().getName() + "结束");
	}

	@Autowired
	private AllocItemDao allocItemDao;

	@Autowired
	private TaskSiteInfoMapper taskSiteInfoMapper;

	public void doInitBak() {
		int i = 1;
		Map<String, Integer> addedSite = new HashMap<>();
		for (AllocItemInfoBean bean : allocItemDao.getAll()) {
			String allocName = bean.getText();
			String newSiteName = allocName.substring(0, 6);
			Integer newSiteId;
			if (!addedSite.containsKey(newSiteName)) {
				TaskSiteFormMap formMap = new TaskSiteFormMap();
				formMap.set("sitename", newSiteName);
				List<TaskSiteFormMap> list = taskSiteInfoMapper.find(formMap);
				if (list != null && list.size() == 1) {
					newSiteId = list.get(0).getInt("id");
					addedSite.put(newSiteName, newSiteId);
				} else {
					String newSiteCode;
					while (true) {
						newSiteCode = AppByteUtil.int2Str4(i++);
						formMap.clear();
						formMap.put("sitecode", newSiteCode);
						list = taskSiteInfoMapper.find(formMap);
						if (list == null || list.size() == 0) {
							TaskSiteInfoBean taskSiteInfoBean = new TaskSiteInfoBean();
							taskSiteInfoBean.setSitecode(newSiteCode);
							taskSiteInfoBean.setSitename(newSiteName);
							taskSiteInfoMapper.addBean(taskSiteInfoBean);
							newSiteId = taskSiteInfoBean.getId();
							addedSite.put(newSiteName, newSiteId);
							break;
						}
					}
				}
			}
			newSiteId = addedSite.get(newSiteName);
			allocItemDao.updateSite(bean.getId(), newSiteId);
		}
	}
}
