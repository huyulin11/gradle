package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.entity.TaskSiteFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface TaskSiteInfoMapper extends BaseMapper<TaskSiteFormMap> {

	public List<TaskSiteFormMap> find(TaskSiteFormMap formMap);

	public List<TaskSiteFormMap> findFuzzy(TaskSiteFormMap formMap);

	public List<TaskSiteInfoBean> findAll(TaskSiteInfoBean taskSiteBean);

	public int addBean(TaskSiteInfoBean taskSiteBean);
}
