package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.SingletaskFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface SingletaskMapper extends BaseMapper<SingletaskFormMap> {

	public List<SingletaskFormMap> findPage(SingletaskFormMap formMap);

	public int addTaskMgr(SingletaskFormMap billFormMap);

}
