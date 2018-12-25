package com.kaifantech.component.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.kaifantech.component.dao.taskexe.AgvStatusDao;
import com.kaifantech.util.log.AppFileLogger;

@Service
public class AgvStatusDBLogger {
	@Autowired
	private AgvStatusDao agvStatusDao;
	public static final int MSG_LEVEL_INFO = 1;
	public static final int MSG_LEVEL_WARNING = 2;

	@Async
	public void info(String content, Integer agvId) {
		agvStatusDao.addASystemInfo(content, agvId);
	}

	@Async
	public void warning(String content, Integer agvId) {
		agvStatusDao.addASystemWarning(content, agvId);
	}

	@Async
	public void error(String content, Integer agvId) {
		agvStatusDao.addASystemError(content, agvId);
	}

	public void warning(String content, Integer agvId, int msgLevel) {
		warning(content, agvId);
		if (MSG_LEVEL_INFO == msgLevel) {
			AppFileLogger.log(content);
		} else if (MSG_LEVEL_WARNING == msgLevel) {
			AppFileLogger.warning(content);
		}
	}

	public void warning(String content, String content2, Integer agvId, int msgLevel) {
		warning(content + content2, agvId);
		if (MSG_LEVEL_INFO == msgLevel) {
			AppFileLogger.log(content);
			AppFileLogger.log(content2);
		} else if (MSG_LEVEL_WARNING == msgLevel) {
			AppFileLogger.error(content);
			AppFileLogger.error(content2);
		}
	}

}
