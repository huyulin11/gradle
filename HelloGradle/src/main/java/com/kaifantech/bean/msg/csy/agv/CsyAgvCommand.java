package com.kaifantech.bean.msg.csy.agv;

public class CsyAgvCommand implements Comparable<CsyAgvCommand> {
	private Integer agvId;
	private Integer tasksite;
	private String[] cmds;

	public Integer getAgvId() {
		return agvId;
	}

	public CsyAgvCommand setAgvId(Integer agvId) {
		this.agvId = agvId;
		return this;
	}

	public Integer getTasksite() {
		return tasksite;
	}

	public void setTasksite(Integer tasksite) {
		this.tasksite = tasksite;
	}

	public String[] getCmds() {
		return cmds;
	}

	public void setCmds(String[] cmds) {
		this.cmds = cmds;
	}

	public CsyAgvCommand(Integer agvId, Integer tasksite, String... cmds) {
		this.agvId = agvId;
		this.tasksite = tasksite;
		this.cmds = cmds;
	}

	public CsyAgvCommand(Integer agvId, String... cmds) {
		this.agvId = agvId;
		this.cmds = cmds;
	}

	@Override
	public int compareTo(CsyAgvCommand o) {
		try {
			if (agvId.equals(o.agvId) && tasksite.equals(o.tasksite) && cmds.equals(o.cmds)) {
				return 0;
			}
		} catch (Exception e) {
		}
		return -1;
	}

}
