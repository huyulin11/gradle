package com.kaifantech.component.service.pi.ctrl.work;

import com.kaifantech.bean.info.agv.AgvBean;

public interface IPiWorkService {

	default void doWork() {
		doControl();
		doneControl();
	}

	public void doControl();

	public void control2Agvs(AgvBean agvBeanOne, AgvBean agvBeanAnother);

	public void doneControl();

	public void addToStop(Integer forkliFtId);

	public void addToContinue(Integer forkliFtId);

}
