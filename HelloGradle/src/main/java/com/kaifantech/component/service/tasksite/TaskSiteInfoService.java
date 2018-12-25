package com.kaifantech.component.service.tasksite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.bean.tasksite.TaskSiteLogicBean;
import com.kaifantech.entity.TaskSiteFormMap;
import com.kaifantech.mappings.TaskSiteInfoMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.kaifantech.util.constant.taskexe.TurnSide;
import com.ytgrading.component.service.erp.system.IBaseService;
import com.ytgrading.util.AppTool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-shiro.xml", "classpath:spring-application.xml",
		"classpath:spring-mvc-scan.xml" })
@Service
public class TaskSiteInfoService implements IBaseService<TaskSiteFormMap> {
	public Map<Integer, Integer> getInitSite() {
		initData();
		return initSite;
	}

	public Map<Integer, Integer> getWindowSite() {
		initData();
		return windowSite;
	}

	public Map<Integer, Integer> getChargeSite() {
		initData();
		return chargeSite;
	}

	public TaskSiteInfoBean containsRtn(List<TaskSiteInfoBean> nextSites, Integer targetsiteid) {
		for (TaskSiteInfoBean nextSite : nextSites) {
			if (targetsiteid.equals(nextSite.getId())) {
				return nextSite;
			}
		}
		return null;
	}

	public synchronized List<TaskSiteInfoBean> getCacheList() {
		if (cacheList == null || cacheList.size() == 0) {
			cacheList = mapper.findAll(null);
			for (TaskSiteInfoBean site : cacheList) {
				List<TaskSiteLogicBean> logics = taskSiteLogicService.getNextSites(site.getId());
				if (!AppTool.isNull(logics) && logics.size() > 0) {
					for (TaskSiteLogicBean logic : logics) {
						TaskSiteInfoBean next = cacheList.stream().filter((bean) -> {
							return bean.getId().equals(logic.getNextid());
						}).findFirst().get();
						if (logic.getSide().equals(TurnSide.LEFT)) {
							site.setLeft(next);
							site.setDistanceToLeft(logic.getDistance());
						}
						if (logic.getSide().equals(TurnSide.RIGHT)) {
							site.setRight(next);
							site.setDistanceToRight(logic.getDistance());
						}
					}
				}
			}
		}
		return cacheList;
	}

	public TaskSiteInfoBean getBean(Integer siteid) {
		return getCacheList().stream().filter((bean) -> siteid.equals(bean.getId())).iterator().next();
	}

	public TaskSiteInfoBean getBean(TaskexeDetailBean taskexeDetailBean) {
		return getBean(taskexeDetailBean.getSiteid());
	}

	public TaskSiteInfoBean getInitSite(Integer agvId) {
		try {
			Integer siteid = getInitSite().get(agvId);
			return getBean(siteid);
		} catch (Exception e) {
			System.out.println("未能获取到" + agvId + "号AGV对应的起始站点的具体信息！");
			return null;
		}
	}

	public TaskSiteInfoBean getWindowSite(Integer windowId) {
		try {
			Integer siteid = getWindowSite().get(windowId);
			return getBean(siteid);
		} catch (Exception e) {
			System.out.println("未能获取到" + windowId + "号窗口对应的站点的具体信息！");
			return null;
		}
	}

	public String getWindowNumFromSite(Integer siteId) {
		try {
			return "" + (getWindowIdFromSite(siteId) - 14);
		} catch (Exception e) {
			System.out.println("未能获取到" + siteId + "号站点对应的窗口具体信息！");
			return null;
		}
	}

	public Integer getWindowIdFromSite(Integer siteId) {
		try {
			Integer windowId = null;
			for (Integer key : getWindowSite().keySet()) {
				if (siteId.equals(getWindowSite().get(key))) {
					windowId = key;
				}
			}
			return windowId;
		} catch (Exception e) {
			System.out.println("未能获取到" + siteId + "号站点对应的窗口具体信息！");
			return null;
		}
	}

	public TaskSiteInfoBean getChargeSite(Integer chargeId) {
		try {
			Integer siteid = getChargeSite().get(chargeId);
			return getBean(siteid);
		} catch (Exception e) {
			System.out.println("未能获取到" + chargeId + "号充电站对应的站点的具体信息！");
			return null;
		}
	}

	public TaskSiteInfoBean getWindowSite(String windowId) {
		return getWindowSite(Integer.parseInt(windowId));
	}

	@Override
	public BaseMapper<TaskSiteFormMap> getMapper() {
		return mapper;
	}

	@Inject
	private TaskSiteInfoMapper mapper;
	private List<TaskSiteInfoBean> cacheList = null;
	@Inject
	private TaskSiteLogicService taskSiteLogicService;

	private Map<Integer, Integer> initSite = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> windowSite = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> chargeSite = new HashMap<Integer, Integer>();

	@Test
	public void test() {
		getCacheList();
	}

	private synchronized void initData() {
		if (initSite.size() > 0 && windowSite.size() > 0 && chargeSite.size() > 0) {
			return;
		}
		Iterator<TaskSiteInfoBean> filter = getCacheList().stream().filter((bean) -> {
			return !bean.isAllocSite();
		}).iterator();
		while (filter.hasNext()) {
			TaskSiteInfoBean bean = filter.next();
			if (bean.isInitSite()) {
				initSite.put(bean.getKeyId(), bean.getId());
			} else if (bean.isWindowSite()) {
				windowSite.put(bean.getKeyId(), bean.getId());
			} else if (bean.isChargeSite()) {
				chargeSite.put(bean.getKeyId(), bean.getId());
			}
		}
	}
}