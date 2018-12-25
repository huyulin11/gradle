package com.kaifantech.component.service.pi.ctrl.work;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.service.pi.ctrl.work.CsyPiClashAreaInfoService.ClashInfo;
import com.kaifantech.util.agv.msg.PreventImpactCommand;
import com.ytgrading.util.AppTool;

@Component
public class CsyPiClashAreaDealer {
	public PreventImpactCommand doCheck2Agvs(AgvBean agvOne, AgvBean agvAnother, TaskexeBean piOne,
			TaskexeBean piAnother) throws Exception {
		ClashInfo clashInfo = piClashAreaInfoService.getClashArea(agvOne, agvAnother, piOne.detailList,
				piAnother.detailList);
		if (AppTool.isNull(clashInfo)) {
			return null;
		}
		Map<AgvBean, Double> dis = clashInfo.getDistanceToClashSites();
		Map<AgvBean, Integer> seq = clashInfo.getSequenceToClashSites();
		if (AppTool.isAnyNull(dis, seq)) {
			return null;
		}
		if (AppTool.ifOr(dis.size() == 0, seq.size() == 0)) {
			return null;
		}
		double disOne = dis.get(agvOne);
		double disAnother = dis.get(agvAnother);
		int seqOne = seq.get(agvOne);
		int seqAnother = seq.get(agvAnother);

		PreventImpactCommand command = new PreventImpactCommand();
		if ((disOne == 0 && disAnother == 0) || (seqOne == 0 && seqAnother == 0)) {
			command.dangerous(agvOne);
			command.dangerous(agvAnother);
			return command;
		}
		if (disOne == 0 && disAnother != 0) {
			command.safe(agvOne);
			if (disAnother > SAFE_DISTANCE) {
				command.safe(agvAnother);
			}
			if (disAnother <= DANGER_DISTANCE) {
				command.dangerous(agvAnother);
			}
		} else if (disOne != 0 && disAnother == 0) {
			command.safe(agvAnother);
			if (disAnother > SAFE_DISTANCE) {
				command.safe(agvOne);
			}
			if (disAnother < DANGER_DISTANCE) {
				command.dangerous(agvOne);
			}
		} else if (disOne != 0 && disAnother != 0) {
			if (disOne >= SAFE_DISTANCE || disAnother >= SAFE_DISTANCE) {
				command.safe(agvOne);
				command.safe(agvAnother);
			}
			if (AppTool.ifOr(
					disOne > DANGER_DISTANCE && disOne <= SAFE_DISTANCE && disAnother > DANGER_DISTANCE
							&& disAnother <= SAFE_DISTANCE,
					disOne <= DANGER_DISTANCE && disAnother <= DANGER_DISTANCE,
					disOne <= DANGER_DISTANCE && disAnother > DANGER_DISTANCE && disAnother <= SAFE_DISTANCE,
					disOne > DANGER_DISTANCE && disOne <= SAFE_DISTANCE && disAnother <= DANGER_DISTANCE)) {
				command.safe(disOne < disAnother ? agvOne : agvAnother);
				command.dangerous(disOne < disAnother ? agvAnother : agvOne);
				command.setPiInfo("距离间隔判断");
				return command;
			}
		}

		if (AppTool.ifOr(seqOne <= DANGER_INTERAL_SEQ && seqAnother <= DANGER_INTERAL_SEQ,
				seqOne <= DANGER_INTERAL_SEQ && seqAnother > DANGER_INTERAL_SEQ && seqAnother <= SAFE_INTERAL_SEQ,
				seqAnother <= DANGER_INTERAL_SEQ && seqOne > DANGER_INTERAL_SEQ && seqOne <= SAFE_INTERAL_SEQ,
				seqAnother > DANGER_INTERAL_SEQ && seqAnother <= SAFE_INTERAL_SEQ && seqOne > DANGER_INTERAL_SEQ
						&& seqOne <= SAFE_INTERAL_SEQ)) {
			command.safe(seqOne < seqAnother ? agvOne : agvAnother);
			command.dangerous(seqOne < seqAnother ? agvAnother : agvOne);
			command.setPiInfo("站点间隔判断");
			return command;
		}
		if (seqAnother <= DANGER_INTERAL_SEQ && seqAnother <= DANGER_INTERAL_SEQ) {
		}
		command.setPiInfo(command.getPiInfo() + "-" + clashInfo);
		return command;
	}

	public static final double SAFE_DISTANCE = 15;
	public static final double DANGER_DISTANCE = 8;
	public static final int SAFE_INTERAL_SEQ = 4;
	public static final int DANGER_INTERAL_SEQ = 2;

	@Autowired
	private CsyPiClashAreaInfoService piClashAreaInfoService;

}
