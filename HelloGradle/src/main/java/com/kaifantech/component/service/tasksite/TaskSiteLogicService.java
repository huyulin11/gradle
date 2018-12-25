package com.kaifantech.component.service.tasksite;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.tasksite.TaskSiteLogicBean;
import com.kaifantech.entity.TaskSiteLogicFormMap;
import com.kaifantech.mappings.TaskSiteLogicMapper;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Service
public class TaskSiteLogicService {
	@Inject
	private TaskSiteLogicMapper mapper;

	private List<TaskSiteLogicBean> list = null;

	public List<TaskSiteLogicBean> getCachedList() {
		if (list == null || list.size() == 0) {
			list = mapper.findAll(null);
		}
		return list;
	}

	public List<TaskSiteLogicBean> getNextSites(Integer siteid) {
		return getCachedList().stream().filter((bean) -> siteid.equals(bean.getSiteid())).collect(Collectors.toList());
	}

	public TaskSiteLogicBean get(Integer siteid, Integer nextid) {
		return getCachedList().stream().filter((bean) -> {
			return siteid.equals(bean.getSiteid()) && nextid.equals(bean.getNextid());
		}).iterator().next();
	}

	public TaskSiteLogicBean containsRtn(List<TaskSiteLogicBean> nextSites, Integer targetsiteid) {
		for (TaskSiteLogicBean nextSite : nextSites) {
			if (targetsiteid.equals(nextSite.getNextid())) {
				return nextSite;
			}
		}
		return null;
	}

	public void doAddEntity(TaskSiteLogicFormMap formMap) throws Exception {
		mapper.add(formMap);
	}

	public Integer getCatchSite() {
		return -1;
	}

}