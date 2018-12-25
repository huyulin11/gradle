package com.kaifantech.component.service.singletask.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.component.dao.singletask.SingletaskDao;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.erp.util.SessionUtil;
import com.ytgrading.util.AppTool;

@Service
public class SingleTaskInfoService {

	@Autowired
	private SingletaskDao singletaskDao;

	private Map<Object, List<SingletaskBean>> singletaskBeanListMap = new HashMap<Object, List<SingletaskBean>>();

	private List<SingletaskBean> singletaskBeanList = new ArrayList<SingletaskBean>();

	private void setSingletaskForCurrentUser() {
		singletaskBeanListMap.put(SessionUtil.getUserId(), singletaskDao.getSingletaskForCurrentUser(null));
	}

	public void init() {
		this.singletaskBeanListMap.clear();
		this.singletaskBeanList.clear();
	}

	private void setSingletaskBeanList() {
		singletaskBeanList = singletaskDao.getSingletaskBeanList();
	}

	public List<SingletaskBean> getAllSingletask() {
		if (AppTool.isNull(singletaskBeanList) || singletaskBeanList.size() <= 0) {
			setSingletaskBeanList();
		}
		return singletaskBeanList;
	}

	public List<SingletaskBean> getAllSingletaskForCurrentUser(Integer agvId) {
		return singletaskDao.getSingletaskForCurrentUser(agvId);
	}

	public List<SingletaskBean> getAllSingletaskForCurrentUser2() {
		List<SingletaskBean> list = singletaskBeanListMap.get(SessionUtil.getUserId());
		if (AppTool.isNull(list)) {
			setSingletaskForCurrentUser();
		}
		return list;
	}

	public SingletaskBean getSingletask(String taskid) {
		try {
			return getAllSingletask().stream().filter((bean) -> taskid.equals(bean.getId())).iterator().next();
		} catch (Exception e) {
			return null;
		}
	}

	public SingletaskBean getSingletaskByTaskName(String taskName) {
		if (AppTool.isNull(taskName)) {
			return null;
		}
		try {
			return getAllSingletask().stream().filter((bean) -> taskName.equals(bean.getTaskName())).iterator().next();
		} catch (Exception e) {
			return null;
		}
	}

	public List<SingletaskBean> getSingletaskByAllocId(Integer allocId) {
		try {
			List<SingletaskBean> sl = new ArrayList<SingletaskBean>();
			for (SingletaskBean bean : getAllSingletask()) {
				if (!AppTool.isNull(bean.getAllocid()) && bean.getAllocid().equals(allocId)
						&& !AppTool.isNull(bean.getAllocOpType())
						&& (AgvTaskType.RECEIPT.equals(bean.getAllocOpType())
								|| AgvTaskType.SHIPMENT.equals(bean.getAllocOpType()))) {
					sl.add(bean);
				}
			}
			return sl;
		} catch (Exception e) {
			return null;
		}
	}

	public SingletaskBean getSingletaskBy(Integer allocId, Integer agvId, Integer lapId) {
		try {
			List<SingletaskBean> sl = new ArrayList<SingletaskBean>();
			for (SingletaskBean bean : getAllSingletask()) {
				if (!AppTool.isNull(bean.getAllocid()) && bean.getAllocid().equals(allocId)
						&& !AppTool.isNull(bean.getAllocOpType())
						&& AgvTaskType.RECEIPT.equals(bean.getAllocOpType())
						&& lapId.equals(bean.getLapId()) && (agvId.equals(bean.getAGVId()))) {
					sl.add(bean);
				}
			}
			return sl == null || sl.size() >= 2 || sl.size() == 0 ? null : sl.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	public List<SingletaskBean> getSingletaskBy(Integer allocId) {
		try {
			List<SingletaskBean> sl = new ArrayList<SingletaskBean>();
			getAllSingletask().stream()
					.filter((bean) -> (!AppTool.isNull(bean.getAllocid()) && bean.getAllocid().equals(allocId)
							&& !AppTool.isNull(bean.getAllocOpType())
							&& AgvTaskType.RECEIPT.equals(bean.getAllocOpType())))
					.forEach(sl::add);
			return sl;
		} catch (Exception e) {
			return null;
		}
	}

	public long getSingletaskCountBy(Integer allocId) {
		try {
			return getAllSingletask().stream()
					.filter((bean) -> (!AppTool.isNull(bean.getAllocid()) && bean.getAllocid().equals(allocId)
							&& !AppTool.isNull(bean.getAllocOpType())
							&& AgvTaskType.RECEIPT.equals(bean.getAllocOpType())))
					.count();
		} catch (Exception e) {
			return 0;
		}
	}

}
