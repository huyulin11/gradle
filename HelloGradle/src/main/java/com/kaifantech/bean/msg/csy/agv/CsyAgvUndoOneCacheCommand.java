package com.kaifantech.bean.msg.csy.agv;

import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.ytgrading.util.AppArraysUtil;

public class CsyAgvUndoOneCacheCommand extends CsyAgvCommand {
	public CsyAgvUndoOneCacheCommand(Integer agvId, Integer tasksite, String... cmds) {
		super(agvId, tasksite, AppArraysUtil.addInFirst(cmds, AgvCmdConstant.CMD_TASK_DELETE_ONE_CACHE,
				CsyAgvCmdBean.getSitecode(tasksite)));
	}

	public String toString() {
		return "agvId:" + getAgvId() + "tasksite:" + getTasksite() + "cmds" + getCmds();
	}
}
