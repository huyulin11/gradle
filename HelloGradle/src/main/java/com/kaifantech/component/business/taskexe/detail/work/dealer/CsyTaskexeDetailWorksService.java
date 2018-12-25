package com.kaifantech.component.business.taskexe.detail.work.dealer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.taskexe.TaskexeDetailWorksBean;
import com.kaifantech.init.sys.SystemInitiator;
import com.kaifantech.mappings.taskexe.TaskexeDetailWorksMapper;
import com.ytgrading.util.AppTool;

@Service
public class CsyTaskexeDetailWorksService {
	@Autowired
	private TaskexeDetailWorksMapper taskexeDetailWorksMapper;

	public List<TaskexeDetailWorksBean> getTaskexeDetailWorksFrom(TaskexeDetailBean taskexeDetail) {
		try {
			return doGetTaskexeDetailWorksFrom(taskexeDetail);
		} catch (Exception e) {
			return null;
		}
	}

	public List<TaskexeDetailWorksBean> doGetTaskexeDetailWorksFrom(TaskexeDetailBean taskexeDetail) {
		String addedInfo = taskexeDetail.getAddedinfo();
		if (AppTool.isNull(addedInfo)) {
			return null;
		}
		List<TaskexeDetailWorksBean> list = taskexeDetailWorksMapper.find(new TaskexeDetailWorksBean(taskexeDetail));
		if (list == null || list.size() == 0) {
			String[] infos = addedInfo.split(SystemInitiator.SPLIT_REG);
			int worksequence = 1;
			for (String info : infos) {
				TaskexeDetailWorksBean taskexeDetailWorksBean = new TaskexeDetailWorksBean(taskexeDetail);
				taskexeDetailWorksBean.setWorksequence(worksequence++).setAddedinfo(info);
				list.add(taskexeDetailWorksBean);
				taskexeDetailWorksMapper.add(taskexeDetailWorksBean);
			}
		}
		return list;
	}

}
