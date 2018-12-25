package com.kaifantech.component.service.singletask.group;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.bean.singletask.SingletaskGroupBean;
import com.kaifantech.component.dao.singletask.SingletaskGroupDao;

@Service
public class SingletaskGroupService {

	@Autowired
	private SingletaskGroupDao singletaskGroupDao;

	private static List<SingletaskGroupBean> singletaskGroupList = null;

	public List<SingletaskGroupBean> getSingletaskGroupBeanList() {
		if (singletaskGroupList == null) {
			singletaskGroupList = singletaskGroupDao.getsingletaskGroupList();
		}
		return singletaskGroupList;
	}

	public List<SingletaskGroupBean> getSingletaskGroupListByTask(String taskid) {
		try {
			List<SingletaskGroupBean> list = new ArrayList<SingletaskGroupBean>();
			Iterator<SingletaskGroupBean> i = getSingletaskGroupBeanList().stream()
					.filter((bean) -> taskid.equals(bean.getTaskid())).iterator();
			while (i.hasNext()) {
				list.add(i.next());
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean inTheSameGroupWith(SingletaskBean oneSingletaskBean, SingletaskBean anotherSingletaskBean) {
		try {
			List<SingletaskGroupBean> listOne = new ArrayList<SingletaskGroupBean>();
			List<SingletaskGroupBean> listAnother = new ArrayList<SingletaskGroupBean>();
			for (SingletaskGroupBean ss : getSingletaskGroupBeanList()) {
				if (ss.getTaskid().equals(oneSingletaskBean.getId())) {
					listOne.add(ss);
				}
			}
			for (SingletaskGroupBean ss : getSingletaskGroupBeanList()) {
				if (ss.getTaskid().equals(anotherSingletaskBean.getId())) {
					listAnother.add(ss);
				}
			}

			for (SingletaskGroupBean s : listOne) {
				for (SingletaskGroupBean ss : listAnother) {
					if (s.getParentTaskid().equals(ss.getParentTaskid())) {
						return true;
					}
				}
			}

			return false;
		} catch (Exception e) {
			return false;
		}
	}

}
