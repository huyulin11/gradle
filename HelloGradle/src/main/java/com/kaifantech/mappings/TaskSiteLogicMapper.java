package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.bean.tasksite.TaskSiteLogicBean;
import com.kaifantech.entity.TaskSiteLogicFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface TaskSiteLogicMapper extends BaseMapper<TaskSiteLogicFormMap> {

	public List<TaskSiteLogicFormMap> findPage(TaskSiteLogicFormMap formMap);

	public List<TaskSiteLogicBean> findAll(TaskSiteLogicBean taskSiteBean);

	public int add(TaskSiteLogicFormMap formMap);

}
