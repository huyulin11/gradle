package com.kaifantech.test.control;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCacheCommand;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.component.business.taskexe.dealer.CsyTaskexeDealModule;
import com.kaifantech.component.comm.manager.agv.AgvManager;
import com.kaifantech.component.comm.manager.plc.PlcManager;
import com.kaifantech.component.comm.worker.client.dev.CsyWindowWorker;
import com.kaifantech.component.comm.worker.server.robot.CsyRobotServerWorker;
import com.kaifantech.component.controller.de.AcsRestfulController;
import com.kaifantech.component.service.de.DeWmsDataService;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.pi.ctrl.work.CsyPiWorkService;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.component.service.tasksite.TaskSitePathService;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.socket.netty.server.csy.CsyRobotNettyServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.msg.AppMsg;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-shiro.xml", "classpath:spring-application.xml",
		"classpath:spring-mvc-scan.xml" })
public class ConTest {
	@Autowired
	private AcsRestfulController controller;

	@Autowired
	private AgvManager ser;

	private MockMvc mockMvc;

	@Autowired
	private CsyPiWorkService piWorkService;

	@Autowired
	private TaskSitePathService taskSitePathService;

	@Autowired
	private PlcManager plcManager;

	@Autowired
	private AgvManager agvManager;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private CsyTaskexeDealModule csyTaskexeDealModule;

	@Autowired
	private DeWmsDataService deWmsDataService;
	@Autowired
	private TaskSiteInfoService taskSiteInfoService;
	@Autowired
	private CsyWindowWorker csyWindowWorker;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	public void Ctest() throws Exception {
		ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/de/acs/wms/addAcsTask").param(
				"{\"Type\":\"2\",\"ShipmentId\":\"A-2-b89732a3434c4972b44179438bfa535e\",\"Wicket\":\"ck2\",\"ItemList\":[{\"AllocId\":\"002-F2-02\"}],\"WarehouseId\":\"B\"}"));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("=====客户端获得反馈数据:" + result);
		// 也可以从response里面取状态码，header,cookies...
		// System.out.println(mvcResult.getResponse().getStatus());
	}

	public void testPathFull() {
		try {
			csyTaskexeDealModule.doDeal(1);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void WindowWork() {
		ThreadTool.sleep(10000);
		Integer windowId = taskSiteInfoService.getWindowIdFromSite(28);
		AbstractSocketClient client = csyWindowWorker.get(windowId);
		client.sendMsg(AppByteUtil.int2Str4Reverse(255));
	}

	public void getFreeChargeId() {
		Integer chargeid = iotClientService.getFreeChargeId();
		System.out.println(chargeid);
		ThreadTool.sleep(5000);
	}

	public void doPI() {
		piWorkService.doControl();
		ThreadTool.sleep(5000);
	}

	public void testObstacle() {
		agvManager.incaseofObstacleNormal(3);
		ThreadTool.sleep(5000);
	}

	@Autowired
	private CsyRobotServerWorker robotServerWorker;

	public void testInventory() {
		CsyRobotNettyServer server = (CsyRobotNettyServer) robotServerWorker.get(1);
		server.setAgvTask(1, AgvTaskType.INVENTORY, "1900");
	}

	public void testDE() {
		String jsonStr = "{\"Wicket\":\"ck2\",\"Type\":\"RECEIPT\",\"PaperId\":\"A-1-e27893a8b6bd4ef6a9d400febc0122e1\",\"ItemList\":[{\"AllocId\":\"20-04-03-16\"},{\"AllocId\":\"22-05-03-15\"},{\"AllocId\":\"20-04-03-16\"},{\"AllocId\":\"23-01-03-30\"},{\"AllocId\":\"22-06-01-30\"},{\"AllocId\":\"22-05-03-15\"}],\"WarehouseId\":\"A\"}";
		try {
			AppMsg msg = deWmsDataService.resolute("0", jsonStr, false);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testPlc() {
		try {
			plcManager.robotScan(3, "1", "1", "2");
			// plcManager.plcReadyForCharge(1);
			// plcManager.forbidAct(1);
			// AppMsg msg = plcManager.windowToAgv(1, "2", "1", "3");
			// plcManager.agvToAlloc(1, "1", "1", "1", "1", "1");
			// System.out.println(msg);
			// System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testPath() {
		try {
			List<TaskSiteInfoBean> path = taskSitePathService.getPath(43, 28);
			Collections.reverse(path);
			System.out.println(path);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCacheSite() {
		try {
			// ser.incaseofObstacleCorner(1);
			// ser.incaseofObstacleNormal(1);
			// for (int i = 500; i >= 1; i--) {
			// ser.cacheTask(new CsyAgvCacheCommand(2, i,
			// AgvCmdConstant.CMD_TASK_CACHE_STOP));
			// }
			AppMsg msg = ser.cacheTask(new CsyAgvCacheCommand(3, 21, AgvCmdConstant.CMD_TASK_CACHE_TURN_RIGHT,
					AgvCmdConstant.CMD_TASK_CACHE_TEST_LOW_SPEED));
			System.out.println(msg.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}