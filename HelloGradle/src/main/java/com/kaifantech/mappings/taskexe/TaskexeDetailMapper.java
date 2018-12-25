package com.kaifantech.mappings.taskexe;

import java.util.List;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.mappings.base.BaseMapper;

public interface TaskexeDetailMapper extends BaseMapper<Object> {

	public List<TaskexeDetailBean> find(TaskexeDetailBean taskexeDetail);

	public int add(TaskexeDetailBean taskexeDetail);

	public int updateOpflag(TaskexeDetailBean taskexeDetail);

	public int updateAllOpflag(TaskexeBean taskexe);

	public int updatAddedinfo(TaskexeDetailBean taskexeDetail);

}
