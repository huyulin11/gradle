package com.kaifantech.component.service.pi.ctrl.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.ytgrading.util.AppTool;

@Component
public class CsyPiClashAreaInfoService {
	@Autowired
	private TaskSiteInfoService taskSiteInfoService;

	public ClashInfo getClashArea(AgvBean agvBeanOne, AgvBean agvBeanAnother,
			List<TaskexeDetailBean> taskexeDetailOneList, List<TaskexeDetailBean> taskexeDetailAnotherList) {
		ClashInfo clashInfo = new ClashInfo();
		List<TaskSiteInfoBean> clashSites = null;
		Map<AgvBean, TaskexeDetailBean> currentSiteMap = new HashMap<>();
		for (TaskexeDetailBean detailOne : taskexeDetailOneList) {
			if (detailOne.isOver()) {
				currentSiteMap.put(agvBeanOne, detailOne);
				continue;
			}
			if (AppTool.isNull(currentSiteMap.get(agvBeanOne))) {
				currentSiteMap.put(agvBeanOne, detailOne);
			}
			int upPointsNum = 10;
			int foreachTimes = 0;
			boolean existNum = false;
			for (TaskexeDetailBean detailAnother : taskexeDetailAnotherList) {
				if (detailAnother.isOver()) {
					currentSiteMap.put(agvBeanAnother, detailAnother);
					continue;
				}
				if (AppTool.isNull(currentSiteMap.get(agvBeanAnother))) {
					currentSiteMap.put(agvBeanAnother, detailAnother);
				}
				if (foreachTimes++ > upPointsNum) {
					break;
				}
				if (detailOne.getSiteid().equals(detailAnother.getSiteid())) {
					if (AppTool.isNull(clashInfo.getDistanceToClashSites().get(agvBeanAnother))) {
						clashInfo.getDistanceToClashSites().put(agvBeanAnother, detailAnother.getDistancetozero()
								- currentSiteMap.get(agvBeanAnother).getDistancetozero());
						clashInfo.getSequenceToClashSites().put(agvBeanAnother, detailAnother.getDetailsequence()
								- currentSiteMap.get(agvBeanAnother).getDetailsequence());
					}
					existNum = true;
					break;
				}
				if (ArrivedAct.isStopAct(detailAnother.getArrivedact())) {
					break;
				}
			}
			if (existNum) {
				if (AppTool.isNull(clashSites)) {
					clashSites = new ArrayList<>();
					clashInfo.getDistanceToClashSites().put(agvBeanOne,
							detailOne.getDistancetozero() - currentSiteMap.get(agvBeanOne).getDistancetozero());
					clashInfo.getSequenceToClashSites().put(agvBeanOne,
							detailOne.getDetailsequence() - currentSiteMap.get(agvBeanOne).getDetailsequence());
				}
				TaskSiteInfoBean site = taskSiteInfoService.getBean(detailOne.getSiteid());
				clashSites.add(site);
			} else {
				if (!AppTool.isNull(clashSites)) {
					break;
				}
			}
			if (ArrivedAct.isStopAct(detailOne.getArrivedact())) {
				break;
			}
		}
		if (!AppTool.isNull(clashSites)) {
			clashInfo.setClashSites(clashSites);
		}
		return clashInfo;
	}

	public class ClashInfo {
		private List<TaskSiteInfoBean> clashSites;
		private Map<AgvBean, Double> distanceToClashSites = new HashMap<>();
		private Map<AgvBean, Integer> sequenceToClashSites = new HashMap<>();

		public List<TaskSiteInfoBean> getClashSites() {
			return clashSites;
		}

		public void setClashSites(List<TaskSiteInfoBean> clashSites) {
			this.clashSites = clashSites;
		}

		public Map<AgvBean, Double> getDistanceToClashSites() {
			return distanceToClashSites;
		}

		public Map<AgvBean, Integer> getSequenceToClashSites() {
			return sequenceToClashSites;
		}

		public String toString() {
			return "clashSites:" + AppTool.v(clashSites) + "distanceToClashSites:" + AppTool.v(distanceToClashSites)
					+ "sequenceToClashSites:" + AppTool.v(sequenceToClashSites);
		}
	}
}
