package com.kaifantech.component.service.pi.ctrl.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.util.agv.msg.PreventImpactCommand;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.log.AppFileLogger;
import com.ytgrading.util.AppTool;

@Component
public class CsyPiCtrlDealer {
	@Autowired
	private CsyPiClashAreaDealer piClashAreaDealer;

	@Autowired
	private CsyPiInLineDealer piInLineDealer;

	@Autowired
	private CsyPiInfoService csyPiInfoService;

	@Autowired
	private CsyPiInSpecialDealer csyPiInSpecialDealer;

	public PreventImpactCommand check2Agvs(AgvBean agvOne, AgvBean agvAnother) throws Exception {
		PreventImpactCommand command;
		TaskexeBean piOne = csyPiInfoService.get(agvOne.getId());
		TaskexeBean piAnother = csyPiInfoService.get(agvAnother.getId());
		if (AppTool.isAnyNull(piOne, piAnother)) {
			return null;
		}

		{
			command = csyPiInSpecialDealer.doCheck2Agvs(piOne, piAnother);
			if (!AppTool.isNull(command)) {
				if (!AppTool.isAllNull(command.getDangerIds(), command.getSafeIds())) {
					AppFileLogger.piError("交管--特殊点控制--" + "停车：" + command.getDangerIds() + ",启动：" + command.getSafeIds()
							+ command.getPiInfo());
				}
				return command;
			}
		}

		{
			command = piInLineDealer.doCheck2Agvs(piOne, piAnother);
			if (!AppTool.isNull(command)) {
				if (!AppTool.isAllNull(command.getDangerIds(), command.getSafeIds())) {
					AppFileLogger.piError("交管--直线控制--" + "停车：" + command.getDangerIds() + ",启动：" + command.getSafeIds()
							+ command.getPiInfo());
				}
				return command;
			}
		}

		CsyAgvMsgBean msgOne = piOne.msg;
		CsyAgvMsgBean msgAnother = piAnother.msg;
		if (AppTool.isAnyNull(msgOne.currentSite(), msgAnother.currentSite())) {
			return null;
		}
		if (AppTool.isAnyNull(piOne, piAnother)) {
			return null;
		}
		if (AppTool.isAnyNull(piOne.detailList, piAnother.detailList)) {
			return null;
		}

		{
			command = piClashAreaDealer.doCheck2Agvs(agvOne, agvAnother, piOne, piAnother);
			if (!AppTool.isNull(command)) {
				if (!AppTool.isAllNull(command.getDangerIds(), command.getSafeIds())) {
					if (command.getDangerIds().size() == 1 && command.getSafeIds().size() == 1) {
						TaskexeBean piDanger = csyPiInfoService.getCache(command.getDangerIds().get(0));
						TaskexeBean piSafe = csyPiInfoService.getCache(command.getSafeIds().get(0));
						if (inWorking(piSafe, piDanger)) {
							PreventImpactCommand tmpCommand = new PreventImpactCommand();
							tmpCommand.safe(piDanger.getAgvId());
							tmpCommand.dangerous(piSafe.getAgvId());
							AppFileLogger.piError("交管--交汇区域控制--工作情况--" + "停车：" + tmpCommand.getDangerIds() + ",启动："
									+ tmpCommand.getSafeIds() + tmpCommand.getPiInfo());
							return tmpCommand;
						}
					}
					AppFileLogger.piError("交管--交汇区域控制--" + "停车：" + command.getDangerIds() + ",启动："
							+ command.getSafeIds() + command.getPiInfo());
				}
				return command;
			}
		}

		return null;
	}

	public boolean inWorking(TaskexeBean piOne, TaskexeBean piAnother) {
		if ((ArrivedAct.ALLOC_STOCK.equals(piOne.currentDetail.getArrivedact())
				|| ArrivedAct.ALLOC_GET.equals(piOne.currentDetail.getArrivedact())
				|| ArrivedAct.ALLOC_SCAN.equals(piOne.currentDetail.getArrivedact()))
				&& !piOne.currentDetail.isOver()) {
			if (!piAnother.nextSite.isAllocSite() || (piAnother.nextSite.isAllocSite()
					&& !piAnother.nextSite.getLine().equals(piOne.currentSite.getLine()))) {
				return true;
			}
		}
		return false;
	}

}
