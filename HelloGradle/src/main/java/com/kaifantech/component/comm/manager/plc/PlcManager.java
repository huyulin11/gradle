package com.kaifantech.component.comm.manager.plc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.kaifantech.component.comm.cmd.sender.plc.PlcCmdSender;
import com.kaifantech.util.beanmap.AppBeanMapUtil;
import com.kaifantech.util.constants.plc.PlcConstant;
import com.kaifantech.util.constants.plc.PlcConstant.Allow;
import com.kaifantech.util.constants.plc.PlcConstant.Type;
import com.kaifantech.util.constants.plc.PlcParamBean;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.msg.plc.PlcMsgGetter;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service
public class PlcManager {
	@Autowired
	private PlcCmdSender plcCmdSender;

	public Map<String, String> fromStr(String jsonStr) {
		Map<String, String> jsonMap = JSONObject.parseObject(jsonStr, new TypeReference<Map<String, String>>() {
		});
		return jsonMap;
	}

	public AppMsg work(Integer agvId, PlcParamBean plcParamBean) throws Exception {
		return work(agvId, AppBeanMapUtil.bean2Map(plcParamBean));
	}

	public AppMsg work(Integer agvId, Map<String, Object> params) throws Exception {
		Object allow = params.get("allow");
		if (AppTool.isNull(allow)) {
			throw new Exception("allow字段不能为空！");
		}
		return work(agvId, params, allow.toString(), !"3".equals(allow));
	}

	private Map<Integer, Integer> seqMap = new HashMap<>();

	private AppMsg work(Integer agvId, Map<String, Object> params, String allow, boolean fillZero) throws Exception {
		StringBuffer finalCmd = new StringBuffer();
		finalCmd.append(AppByteUtil.int2Str4Reverse(Integer.parseInt(allow)));
		for (int i = 0; i < PlcConstant.keyVal.length; i++) {
			Object value = params.get(PlcConstant.keyVal[i]);
			if (!AppTool.isNull(value)) {
				finalCmd.append(AppByteUtil.int2Str4Reverse(Integer.parseInt(value.toString())));
			} else {
				finalCmd.append("0000");
			}
		}
		if (fillZero) {
			while (finalCmd.length() < 36) {
				finalCmd.append("0000");
			}
		}
		Integer seq = seqMap.get(agvId);
		if ("0007".equals(finalCmd.subSequence(4, 8))) {
			if (AppTool.isNull(seq) || seq > 9 || seq.equals(0)) {
				seq = 1;
			}
			seqMap.put(agvId, seq + 1);
			finalCmd.append(AppByteUtil.int2Str4Reverse(seq));
		} else {
			seqMap.put(agvId, 0);
			finalCmd.append("0000");
		}
		if (finalCmd.toString().startsWith("0003")) {
			return send(agvId, finalCmd.toString());
		}
		return sendNeedRtn(agvId, finalCmd.toString());
	}

	public AppMsg sendNeedRtn(Integer agvId, String cmd) {
		int times = 0;
		AppMsg plcMsg = AppMsg.fail();
		int repeatTimes = 2;
		while (true) {
			if (!PlcMsgGetter.one().isTaskSend(agvId, cmd)) {
				plcMsg = send(agvId, cmd);
			} else {
				break;
			}
			ThreadTool.sleep(repeatTimes * 1000);
			String info = "向" + (agvId) + "号AGV的PLC下达" + "指令(" + cmd + ")！";
			if (plcMsg.isSuccess() && PlcMsgGetter.one().isTaskSend(agvId, cmd)) {
				AppFileLogger.warning(info + "成功收到反馈！");
				break;
			} else {
				CsyAppFileLogger.error(info + "失败，未收到反馈，稍后重试！(times=" + times++ + ")");
				ThreadTool.sleep(repeatTimes * 1000);
			}
		}
		return AppMsg.success();
	}

	private AppMsg send(Integer agvId, String finalCmd) {
		plcCmdSender.send(agvId, finalCmd);
		return AppMsg.success();
	}

	public AppMsg errorDeal(Integer agvId) throws Exception {
		return work(agvId, PlcConstant.ERROR_DEAL);
	}

	public AppMsg forbidAct(Integer agvId) throws Exception {
		return work(agvId, PlcConstant.FORBIT_ACT);
	}

	public AppMsg readyForCharge(Integer agvId) throws Exception {
		return work(agvId, PlcConstant.READY_FOR_CHARGE);
	}

	public AppMsg robotScan(Integer agvId, String robotSide, String forkSide, String frameNum) throws Exception {
		return work(agvId, new PlcParamBean(Allow.YES).setType(Type.ROBOT_SCAN).setRobot(robotSide).setFork(forkSide)
				.setFrame(frameNum));
	}

	public AppMsg robotScanWindow(Integer agvId, String window) throws Exception {
		return work(agvId, new PlcParamBean(Allow.YES).setType(Type.ROBOT_SCAN_WINDOW).setWindow(window));
	}

	public AppMsg windowToAgv(Integer agvId, String agvLayer, String window, String windowLayer) throws Exception {
		return work(agvId, new PlcParamBean(Allow.YES).setType(Type.WINDOW_TO_AGV).setAgvLayer(agvLayer)
				.setWindow(window).setWindowLayer(windowLayer));
	}

	public AppMsg agvToAlloc(Integer agvId, String agvLayer, String robotSide, String forkSide, String frameNum,
			String pieceNum) throws Exception {
		return work(agvId, new PlcParamBean(Allow.YES).setType(Type.AGV_TO_ALLOC).setAgvLayer(agvLayer)
				.setRobot(robotSide).setFork(forkSide).setFrame(frameNum).setPiece(pieceNum));
	}

	public AppMsg allocToAgv(Integer agvId, String agvLayer, String robotSide, String forkSide, String frameNum,
			String pieceNum) throws Exception {
		return work(agvId, new PlcParamBean(Allow.YES).setType(Type.ALLOC_TO_AGV).setAgvLayer(agvLayer)
				.setRobot(robotSide).setFork(forkSide).setFrame(frameNum).setPiece(pieceNum));
	}

	public AppMsg agvToWindow(Integer agvId, String agvLayer, String window, String windowLayer) throws Exception {
		return work(agvId, new PlcParamBean(Allow.YES).setType(Type.AGV_TO_WINDOW).setAgvLayer(agvLayer)
				.setWindow(window).setWindowLayer(windowLayer));
	}
}
