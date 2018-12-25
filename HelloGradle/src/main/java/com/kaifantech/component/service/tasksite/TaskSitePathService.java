package com.kaifantech.component.service.tasksite;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.bean.tasksite.TaskSiteLogicBean;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.ytgrading.util.AppTool;

@Service
public class TaskSitePathService {
	@Inject
	private TaskSiteInfoService taskSiteInfoService;
	@Inject
	private TaskSitePathDetailService taskSitePathDetailService;

	public synchronized List<TaskSiteInfoBean> getPath(Integer startsiteid, Integer targetsiteid) throws Exception {
		if (AppTool.isNull(startsiteid) || AppTool.isNull(targetsiteid) || startsiteid.equals(targetsiteid)) {
			return null;
		}
		TaskSiteInfoBean startSite = taskSiteInfoService.getBean(startsiteid);
		TaskSiteInfoBean targetSite = taskSiteInfoService.getBean(targetsiteid);
		TaskSiteInfoBean key = doFindKey(startSite, targetSite);
		if (AppTool.isNull(key)) {
			CsyAppFileLogger.error("路径计算出现严重错误:" + startsiteid + "->" + targetsiteid);
			return null;
		}
		List<TaskSiteInfoBean> path = new ArrayList<>();
		TaskSiteInfoBean pathBean = (TaskSiteInfoBean) key.clone();
		path.add(pathBean);
		TaskSiteInfoBean pre = pathBean.getPre();
		while (!AppTool.isNull(pre)) {
			pathBean = (TaskSiteInfoBean) pre.clone();
			if (startsiteid.equals(pathBean.getId())) {
				break;
			}
			path.add(pathBean);
			pre = pathBean.getPre();
		}
		return path;
	}

	public synchronized TaskSiteInfoBean doFindKey(TaskSiteInfoBean startSite, TaskSiteInfoBean targetSite)
			throws Exception {
		TaskSiteInfoBean key = null;

		boolean mayNeedLoop = (startSite.isAllocSite() || startSite.isWindowSite())
				&& (targetSite.isAllocSite() || targetSite.isWindowSite());

		List<TaskSiteInfoBean> sitesForSearch = new ArrayList<>();
		sitesForSearch.add(startSite);

		List<TaskSiteInfoBean> overedAllocRoadStartPoints = new ArrayList<>();

		boolean flag = true;
		while (flag) {
			List<TaskSiteInfoBean> choosedSiteList = new ArrayList<>();
			for (TaskSiteInfoBean currentSite : sitesForSearch) {
				List<TaskSiteInfoBean> nextSiteList = currentSite.getNexts();
				if (AppTool.isNull(nextSiteList)) {
					continue;
				}

				for (TaskSiteInfoBean nextSite : nextSiteList) {
					if (targetSite.getId().equals(nextSite.getId())) {
						key = nextSite;
						flag = false;
						break;
					}
				}

				for (TaskSiteInfoBean nextSite : nextSiteList) {
					if (nextSite.getId().equals(68)) {
						if (!nextSite.getId().equals(68)) {
							System.out.println("条件DEBUG");
						}
					}
					if (taskSitePathDetailService.whenPassAllocRoadStartPoint(currentSite, nextSite)) {
						overedAllocRoadStartPoints.add(nextSite);
					}
					if (taskSitePathDetailService.whenChargeBreak(startSite, targetSite, currentSite, nextSite)) {
						continue;
					}
					if (taskSitePathDetailService.whenInitBreak(startSite, targetSite, currentSite, nextSite,
							overedAllocRoadStartPoints)) {
						continue;
					}
					if (taskSitePathDetailService.whenWindowBreak(startSite, targetSite, currentSite, nextSite)) {
						continue;
					}
					if (targetSite.isAllocSite()) {
						if (overedAllocRoadStartPoints.contains(nextSite)
								&& (taskSitePathDetailService.whenPassAllocRoadStartPoint(currentSite, nextSite))
								&& (targetSite.getLine() > nextSite.getLine())) {
							continue;
						}
						if (nextSite.isAllocSite() && (!startSite.getLine().equals(nextSite.getLine()))) {
							choosedSiteList.clear();
							nextSite.setPre(currentSite);
							choosedSiteList.add(nextSite);
							break;
						}
					}
					if (nextSite.getId().equals(startSite.getId())) {
						continue;
					}
					if (mayNeedLoop) {
						if (taskSitePathDetailService.notPass(currentSite, nextSite, TaskSiteLogicBean.path(65, 68),
								TaskSiteLogicBean.path(68, 481), TaskSiteLogicBean.path(481, 479),
								TaskSiteLogicBean.path(479, 480), TaskSiteLogicBean.path(480, 482),
								TaskSiteLogicBean.path(482, 20))) {
							continue;
						}
					}
					nextSite.setPre(currentSite);
					choosedSiteList.add(nextSite);
				}
			}
			sitesForSearch.clear();
			sitesForSearch.addAll(choosedSiteList);
			if (sitesForSearch.size() == 0) {
				break;
			}
		}
		return key;
	}
}