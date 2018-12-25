package com.kaifantech.component.business.taskexe.detail.dealer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.taskexe.TaskexeDetailWorksBean;
import com.kaifantech.component.business.taskexe.detail.work.dealer.CsyTaskexeDetailWorksAllocDealer;
import com.kaifantech.component.business.taskexe.detail.work.dealer.CsyTaskexeDetailWorksService;
import com.kaifantech.component.business.taskexe.detail.work.dealer.CsyTaskexeDetailWorksWindowDealer;
import com.kaifantech.component.comm.manager.iot.IotManager;
import com.kaifantech.component.dao.agv.info.AgvOpChargeDao;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.mappings.taskexe.TaskexeDetailMapper;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constant.taskexe.WmsDetailOpFlag;
import com.kaifantech.util.msg.plc.PlcMsgGetter;

@Service
public class CsyTaskexeDetailDealer {

	public boolean dealDetail(TaskexeBean taskexeBean, CsyAgvMsgBean csyAgvMsgBean, TaskexeDetailBean taskexeDetail)
			throws Exception {
		if (ArrivedAct.ALLOC_STOCK.equals(taskexeDetail.getArrivedact())
				|| ArrivedAct.ALLOC_GET.equals(taskexeDetail.getArrivedact())
				|| ArrivedAct.ALLOC_SCAN.equals(taskexeDetail.getArrivedact())
				|| ArrivedAct.CHARGE.equals(taskexeDetail.getArrivedact())
				|| ArrivedAct.WINDOW_STOCK.equals(taskexeDetail.getArrivedact())
				|| ArrivedAct.WINDOW_GET.equals(taskexeDetail.getArrivedact())) {
			List<TaskexeDetailWorksBean> works = csyTaskexeDetailWorksService.getTaskexeDetailWorksFrom(taskexeDetail);
			if (ArrivedAct.ALLOC_STOCK.equals(taskexeDetail.getArrivedact())) {
				csyTaskexeDetailWorksAllocDealer.allocStock(csyAgvMsgBean, taskexeBean, taskexeDetail, works);
				return false;
			} else if (ArrivedAct.ALLOC_GET.equals(taskexeDetail.getArrivedact())) {
				csyTaskexeDetailWorksAllocDealer.allocGet(csyAgvMsgBean, taskexeBean, taskexeDetail, works);
				return false;
			} else if (ArrivedAct.ALLOC_SCAN.equals(taskexeDetail.getArrivedact())) {
				csyTaskexeDetailWorksAllocDealer.allocScan(csyAgvMsgBean, taskexeBean, taskexeDetail, works);
				return false;
			} else if (ArrivedAct.CHARGE.equals(taskexeDetail.getArrivedact())) {
				charge(csyAgvMsgBean, taskexeDetail, works);
				return false;
			} else if (ArrivedAct.WINDOW_STOCK.equals(taskexeDetail.getArrivedact())) {
				csyTaskexeDetailWorksWindowDealer.windowStock(csyAgvMsgBean, taskexeDetail, works);
				return false;
			} else if (ArrivedAct.WINDOW_GET.equals(taskexeDetail.getArrivedact())) {
				csyTaskexeDetailWorksWindowDealer.windowGet(csyAgvMsgBean, taskexeDetail, works);
				return false;
			}
		}

		SystemParameters.setTaskstop(csyAgvMsgBean.agvId(), false);
		if (ArrivedAct.START.equals(taskexeDetail.getArrivedact())) {
			if (taskexeDetail.isSend() && taskexeDetail.matchThisSite(csyAgvMsgBean)) {
				taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.OVER));
			}
			return false;
		} else if (ArrivedAct.TURN_LEFT.equals(taskexeDetail.getArrivedact())) {
			if (taskexeDetail.matchThisSite(csyAgvMsgBean)) {
				taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.OVER));
			}
			return false;
		} else if (ArrivedAct.TURN_RIGHT.equals(taskexeDetail.getArrivedact())) {
			if (taskexeDetail.matchThisSite(csyAgvMsgBean)) {
				taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.OVER));
			}
			return false;
		} else if (ArrivedAct.STOP.equals(taskexeDetail.getArrivedact())) {
			if (taskexeDetail.matchThisSite(csyAgvMsgBean)) {
				taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.OVER));
			}
			return false;
		} else if (ArrivedAct.CHANGE_SPEED.equals(taskexeDetail.getArrivedact())) {
			if (taskexeDetail.matchThisSite(csyAgvMsgBean)) {
				taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.OVER));
			}
			return false;
		}
		return true;
	}

	public void charge(CsyAgvMsgBean csyAgvMsgBean, TaskexeDetailBean taskexeDetail, List<TaskexeDetailWorksBean> works)
			throws Exception {
		if (taskexeDetail.matchThisSite(csyAgvMsgBean)) {
			AgvBean agv = agvOpChargeDao.get(csyAgvMsgBean.agvId());
			if (taskexeDetail.isNew()) {
				taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.SEND));
				iotManager.startCharge(csyAgvMsgBean.agvId(), agv.getChargeid());
				return;
			}
			if (taskexeDetail.isSend()) {
				if (PlcMsgGetter.one().isTaskOver(csyAgvMsgBean.agvId())) {
					taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.OVER));
					agvOpChargeDao.workOverGotoCharge(csyAgvMsgBean.agvId());
				}
				return;
			}
		}
	}

	@Autowired
	private AgvOpChargeDao agvOpChargeDao;

	@Autowired
	private IotManager iotManager;

	@Autowired
	private TaskexeDetailMapper taskexeDetailMapper;

	@Autowired
	private CsyTaskexeDetailWorksAllocDealer csyTaskexeDetailWorksAllocDealer;

	@Autowired
	private CsyTaskexeDetailWorksWindowDealer csyTaskexeDetailWorksWindowDealer;

	@Autowired
	private CsyTaskexeDetailWorksService csyTaskexeDetailWorksService;
}
