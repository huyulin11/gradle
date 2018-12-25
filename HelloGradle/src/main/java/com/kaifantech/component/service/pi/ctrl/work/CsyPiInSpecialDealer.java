package com.kaifantech.component.service.pi.ctrl.work;

import org.springframework.stereotype.Component;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.util.agv.msg.PreventImpactCommand;
import com.ytgrading.util.AppTool;

@Component
public class CsyPiInSpecialDealer {
	private boolean specialInBay(TaskexeBean piOne, TaskexeBean piAnother) {
		if (AppTool.equals(piOne.msg.currentSite(), 476, 477, 478, 65, 67, 68, 69)
				&& (AppTool.equals(piAnother.msg.currentSite(), 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 19)
						|| AppTool.equals(piAnother.msg.currentSite(), 13, 14, 15, 16, 17, 18)
						|| AppTool.equals(piAnother.msg.currentSite(), 481, 479, 480, 482, 20))) {
			return true;
		}
		return false;
	}

	private boolean specialInWindow3(TaskexeBean piOne, TaskexeBean piAnother) {
		if (AppTool.isNull(piAnother.nextSite)) {
			return false;
		}
		if (AppTool.equals(piOne.msg.currentSite(), 23)) {
			if (!AppTool.isNull(piAnother.nextSite)) {
				int nextStopLine = piAnother.nextSite.getLine();
				if ((nextStopLine == 2 || nextStopLine == 3)
						&& AppTool.equals(piAnother.msg.currentSite(), 482, 20, 21, 22)) {
					return true;
				}
			}
			if (AppTool.equals(piAnother.msg.currentSite(), 18, 19, 20, 21)) {
				return true;
			}
		}
		return false;
	}

	public PreventImpactCommand doCheck2Agvs(TaskexeBean piOne, TaskexeBean piAnother) throws Exception {
		PreventImpactCommand command = new PreventImpactCommand();
		if (specialInBay(piAnother, piOne) || specialInBay(piOne, piAnother)) {
			if (specialInBay(piOne, piAnother)) {
				command.dangerous(piOne.getAgvId());
				command.safe(piAnother.getAgvId());
				command.setPiInfo(piOne.getAgvId() + "," + piAnother.getAgvId() + "两车港湾控制，停港湾入口处车：" + piOne.getAgvId());
			} else if (specialInBay(piAnother, piOne)) {
				command.dangerous(piAnother.getAgvId());
				command.safe(piOne.getAgvId());
				command.setPiInfo(
						piAnother.getAgvId() + "," + piOne.getAgvId() + "两车港湾控制，停港湾入口处车：" + piAnother.getAgvId());
			}
			return command;
		} else if (specialInWindow3(piOne, piAnother) || specialInWindow3(piAnother, piOne)) {
			if (specialInWindow3(piOne, piAnother)) {
				command.dangerous(piAnother.getAgvId());
				command.safe(piOne.getAgvId());
				command.setPiInfo(
						piOne.getAgvId() + "车在3号窗口，挡住" + piAnother.getAgvId() + "车拐弯路线，停车：" + piAnother.getAgvId());
			} else if (specialInWindow3(piAnother, piOne)) {
				command.dangerous(piOne.getAgvId());
				command.safe(piAnother.getAgvId());
				command.setPiInfo(
						piAnother.getAgvId() + "车在3号窗口，挡住" + piOne.getAgvId() + "车拐弯路线，停车：" + piOne.getAgvId());
			}
			return command;
		}
		return null;
	}
}
