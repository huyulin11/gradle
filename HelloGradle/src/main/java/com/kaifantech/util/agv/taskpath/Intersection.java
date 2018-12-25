package com.kaifantech.util.agv.taskpath;

import com.kaifantech.bean.msg.agv.IXYBean;

/** 存储两条路径可能发生碰撞的交集部分 */
public class Intersection {
	private TaskPathInfoMap mapA;
	private TaskPathInfoMap mapB;

	public TaskPathInfoMap getMapA() {
		return mapA;
	}

	public void setMapA(TaskPathInfoMap mapA) {
		this.mapA = mapA;
	}

	public TaskPathInfoMap getMapB() {
		return mapB;
	}

	public void setMapB(TaskPathInfoMap mapB) {
		this.mapB = mapB;
	}

	public boolean same(IXYBean msg, IXYBean msg2) {
		return inSame(msg, msg2) || inSame(msg2, msg);
	}

	private boolean inSame(IXYBean msg, IXYBean msg2) {
		if (this.getMapA().getAGVId().equals(msg.getAGVId())
				&& this.getMapA().getTaskid().equals(msg.getTaskid())
				&& this.getMapB().getAGVId().equals(msg2.getAGVId())
				&& this.getMapB().getTaskid().equals(msg2.getTaskid())) {
			return true;
		}
		return false;
	}
}
