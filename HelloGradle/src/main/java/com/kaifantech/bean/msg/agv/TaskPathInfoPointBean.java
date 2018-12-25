package com.kaifantech.bean.msg.agv;

public class TaskPathInfoPointBean extends AGVMsgBean {
	private String uuid;
	private Long secondToStart;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getSecondToStart() {
		return secondToStart;
	}

	public void setSecondToStart(Long secondToStart) {
		this.secondToStart = secondToStart;
	}

	public boolean equals(Object o) {
		if (o instanceof TaskPathInfoPointBean) {
			TaskPathInfoPointBean bean = ((TaskPathInfoPointBean) o);
			if (this.uuid.equals(bean.getUuid())) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	public String toString() {
		return "x:" + x + "y:" + y + "f:" + agvId + "t:" + taskid;
	}

}
