package com.kaifantech.component.service.ctrl.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.component.dao.AGVConnectMsgDao;
import com.kaifantech.component.dao.taskexe.AgvStatusDao;
import com.ytgrading.util.msg.AppMsg;

@Service
public class CacheCleanService {

	@Autowired
	private AgvStatusDao agvStatusDao;

	@Autowired
	private AGVConnectMsgDao connectMsgDao;

	public AppMsg deleteOUTOfDateData() {
		try {
			connectMsgDao.deleteOUTOfDateMsgFromAGV();
			agvStatusDao.deleteOUTOfDateSOPMsg();
		} catch (Exception e) {
			return new AppMsg(-1, "");
		}
		return new AppMsg(0, "");
	}

}
