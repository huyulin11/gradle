package com.kaifantech.component.worker.data.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.entity.TaskSiteFormMap;
import com.kaifantech.entity.TaskSiteLogicFormMap;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.mappings.TaskSiteInfoMapper;
import com.kaifantech.mappings.TaskSiteLogicMapper;
import com.kaifantech.util.constant.taskexe.TurnSide;
import com.ytgrading.util.AppTool;

@Service(CsySystemQualifier.CSY_TASK_SITE_LOGIC_INIT_WORKER)
public class CsyTaskSiteLogicInitWorker implements IDataInitWorker {
	public void doInit() {
		TaskSiteLogicFormMap taskSiteLogicFormMap = new TaskSiteLogicFormMap();
		taskSiteLogicMapper.truncate(taskSiteLogicFormMap);
		for (int i = 1; i < 500; i++) {
			taskSiteLogicFormMap.set("siteid", i);
			taskSiteLogicFormMap.set("nextid", i + 1);
			taskSiteLogicFormMap.set("side", TurnSide.LEFT);
			taskSiteLogicMapper.add(taskSiteLogicFormMap);
		}
	}

	public void doInitBak() {
		List<TaskSiteFormMap> allocStieList1 = taskSiteMapper.find(new TaskSiteFormMap().setRtn("sitetype", 1));
		List<TaskSiteFormMap> allocStieList2 = taskSiteMapper.find(new TaskSiteFormMap().setRtn("sitetype", 2));
		List<TaskSiteFormMap> allocStieList3 = taskSiteMapper.find(new TaskSiteFormMap().setRtn("sitetype", 3));
		TaskSiteFormMap allocStie5 = taskSiteMapper.find(new TaskSiteFormMap().setRtn("sitetype", 5)).get(0);
		TaskSiteFormMap allocStie6 = taskSiteMapper.find(new TaskSiteFormMap().setRtn("sitetype", 6)).get(0);

		for (TaskSiteFormMap initSite : allocStieList2) {
			for (TaskSiteFormMap windowSite : allocStieList3) {
				TaskSiteLogicFormMap taskSiteLogicFormMap = new TaskSiteLogicFormMap();
				taskSiteLogicFormMap.set("siteid", initSite.get("id"));
				taskSiteLogicFormMap.set("nextid", windowSite.get("id"));
				taskSiteLogicFormMap.set("side", TurnSide.LEFT);
				taskSiteLogicMapper.add(taskSiteLogicFormMap);
			}
		}

		for (TaskSiteFormMap initSite : allocStieList2) {
			TaskSiteLogicFormMap taskSiteLogicFormMap = new TaskSiteLogicFormMap();
			taskSiteLogicFormMap.set("siteid", allocStie6.get("id"));
			taskSiteLogicFormMap.set("nextid", initSite.get("id"));
			taskSiteLogicFormMap.set("side", TurnSide.LEFT);
			taskSiteLogicMapper.add(taskSiteLogicFormMap);
		}
		for (TaskSiteFormMap windowSite : allocStieList3) {
			TaskSiteLogicFormMap taskSiteLogicFormMap = new TaskSiteLogicFormMap();
			taskSiteLogicFormMap.set("siteid", allocStie5.get("id"));
			taskSiteLogicFormMap.set("nextid", windowSite.get("id"));
			taskSiteLogicFormMap.set("side", TurnSide.LEFT);
			taskSiteLogicMapper.add(taskSiteLogicFormMap);
		}

		String flagSitePrefix = "";
		TaskSiteFormMap lastAllocSite = null;
		for (TaskSiteFormMap allocSite : allocStieList1) {
			String tmpSitePrefix = allocSite.getStr("sitename").substring(0, 3);

			if (flagSitePrefix.equals(tmpSitePrefix)) {
				TaskSiteLogicFormMap taskSiteLogicFormMap = new TaskSiteLogicFormMap();
				taskSiteLogicFormMap.set("siteid", lastAllocSite.get("id"));
				taskSiteLogicFormMap.set("nextid", allocSite.get("id"));
				taskSiteLogicFormMap.set("side", TurnSide.RIGHT);
				taskSiteLogicMapper.add(taskSiteLogicFormMap);
			} else {
				for (TaskSiteFormMap initSite : allocStieList2) {
					TaskSiteLogicFormMap taskSiteLogicFormMap = new TaskSiteLogicFormMap();
					taskSiteLogicFormMap.set("siteid", initSite.get("id"));
					taskSiteLogicFormMap.set("nextid", allocSite.get("id"));
					taskSiteLogicFormMap.set("side", TurnSide.LEFT);
					taskSiteLogicMapper.add(taskSiteLogicFormMap);
				}
				for (TaskSiteFormMap windowSite : allocStieList3) {
					TaskSiteLogicFormMap taskSiteLogicFormMap = new TaskSiteLogicFormMap();
					taskSiteLogicFormMap.set("siteid", windowSite.get("id"));
					taskSiteLogicFormMap.set("nextid", allocSite.get("id"));
					taskSiteLogicFormMap.set("side", TurnSide.LEFT);
					taskSiteLogicMapper.add(taskSiteLogicFormMap);
				}

				if (!AppTool.isNull(lastAllocSite)) {
					taskSiteLogicMapper.add(new TaskSiteLogicFormMap().setRtn("siteid", lastAllocSite.get("id"))
							.setRtn("nextid", allocStie5.get("id")).setRtn("side", TurnSide.LEFT));
					taskSiteLogicMapper.add(new TaskSiteLogicFormMap().setRtn("siteid", lastAllocSite.get("id"))
							.setRtn("nextid", allocStie6.get("id")).setRtn("side", TurnSide.RIGHT));
				}
			}
			lastAllocSite = allocSite;
			flagSitePrefix = tmpSitePrefix;
		}
	}

	@Autowired
	private TaskSiteInfoMapper taskSiteMapper;

	@Autowired
	private TaskSiteLogicMapper taskSiteLogicMapper;

}
