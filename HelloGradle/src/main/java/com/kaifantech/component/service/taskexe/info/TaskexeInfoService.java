package com.kaifantech.component.service.taskexe.info;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.dao.taskexe.info.TaskexeInfoDao;
import com.ytgrading.util.AppTool;

@Service
public class TaskexeInfoService {
	@Autowired
	private TaskexeInfoDao taskexeTaskDao;

	private TaskexeBean first(List<TaskexeBean> taskexeBeanList) {
		if (taskexeBeanList == null || taskexeBeanList.size() <= 0) {
			return null;
		}
		TaskexeBean taskexeBean = taskexeBeanList.get(0);
		return taskexeBean;
	}

	public TaskexeBean getNextOne(Integer agvId) {
		List<TaskexeBean> taskexeBeanList = taskexeTaskDao.getToSendList(agvId);
		return first(taskexeBeanList);
	}

	public TaskexeBean getNotOverOne(String taskid) {
		if (AppTool.isNull(taskid)) {
			return null;
		}
		List<TaskexeBean> taskexeBeanList = taskexeTaskDao.getNotOverList(taskid);
		return first(taskexeBeanList);
	}

	public TaskexeBean getOne(String taskid) {
		if (AppTool.isNull(taskid)) {
			return null;
		}
		List<TaskexeBean> taskexeBeanList = taskexeTaskDao.getAllList(taskid);
		return first(taskexeBeanList);
	}

	public TaskexeBean getNotOverOneF(Integer agvID) {
		List<TaskexeBean> taskexeBeanList = taskexeTaskDao.getNotOverListByF(agvID);
		return first(taskexeBeanList);
	}

	public List<TaskexeBean> getNotOverOneFBean(List<AgvBean> agvs) {
		List<Integer> agvIds = new ArrayList<>();
		for (AgvBean bean : agvs) {
			agvIds.add(bean.getId());
		}
		return taskexeTaskDao.getNotOverListByF(agvIds);
	}

	public List<TaskexeBean> getNotOverList() {
		return taskexeTaskDao.getNotOverList();
	}

	public List<TaskexeBean> getAllList(String taskid) {
		return taskexeTaskDao.getAllList(taskid);
	}

	public TaskexeBean getLatestOne(Integer agvId) {
		return first(taskexeTaskDao.getList(" where agvId= " + agvId, " ORDER BY TIME DESC ", 1));
	}

	public List<TaskexeBean> getNewList() {
		List<TaskexeBean> taskexeBeanList = taskexeTaskDao.getNewList();
		if (taskexeBeanList != null && taskexeBeanList.size() > 0) {
			return taskexeBeanList;
		}
		return null;
	}
}
