
package com.kaifantech.component.service.taskexe.detail;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.bean.tasksite.TaskSiteLogicBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.component.service.tasksite.TaskSiteLogicService;
import com.kaifantech.component.service.tasksite.TaskSitePathService;
import com.kaifantech.init.sys.SystemInitiator;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.mappings.taskexe.TaskexeDetailMapper;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.constants.Delflag;
import com.ytgrading.util.AppTool;

/***
 * 描述任务从用户下达到发送AGV执行前的逻辑
 ***/
@Service
public class TaskexeDetailInfoService {

	@Autowired
	private TaskexeDetailMapper taskexeDetailMapper;

	@Autowired
	private TaskexeDetailDataDealer taskexeDetailDataDealer;

	@Autowired
	private TaskSitePathService taskSitePathService;

	@Autowired
	private WmsPaperService wmsPaperService;

	@Autowired
	private TaskSiteLogicService taskSiteLogicService;

	@Autowired
	private TaskSiteInfoService taskSiteInfoService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	public List<TaskexeDetailBean> getList(TaskexeBean taskexeBean) throws Exception {
		List<TaskexeDetailBean> taskexeDetailList;
		if (AgvTaskType.chargeOrInit(taskexeBean.getTasktype())) {
			taskexeDetailList = getTodoList(taskexeBean);
		} else {
			String wmsId = taskexeBean.getTaskid();
			WmsPaperMainBean<?> wmsPaperBean = null;
			wmsPaperBean = wmsPaperService.getMainService(taskexeBean).findByPaperid(wmsId, true);
			if (AppTool.isNull(wmsPaperBean)) {
				System.out.println("未找到对应单据信息！" + "(" + wmsId + ")");
				return null;
			}
			taskexeDetailList = getTodoList(wmsPaperBean, taskexeBean);
		}
		return taskexeDetailList;
	}

	public List<TaskexeDetailBean> getTodoList(TaskexeBean taskexeBean) throws Exception {
		return getTodoList(null, taskexeBean);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public synchronized List<TaskexeDetailBean> getTodoList(WmsPaperMainBean<?> wmsPaperBean, TaskexeBean taskexeBean)
			throws Exception {
		List<TaskexeDetailBean> taskexeDetailList = find(taskexeBean);
		if (!(taskexeDetailList != null && taskexeDetailList.size() > 0)) {
			if (!(AppTool.isNull(wmsPaperBean) || AppTool.isNull(wmsPaperBean.getDetailList())
					|| wmsPaperBean.getDetailList().size() == 0)) {
				wmsPaperBean.getDetailList().sort((h1, h2) -> {
					if (AppTool.isAnyNull(h1.getUserdef1(), h2.getUserdef1())) {
						return 0;
					}
					return h1.getUserdef1().compareTo(h2.getUserdef1());
				});
			}

			List<TaskexeDetailBean> jobList = taskexeDetailDataDealer.getList(wmsPaperBean, taskexeBean);

			for (int m = 0; m < jobList.size(); m++) {
				TaskexeDetailBean beanM = jobList.get(m);
				if (Delflag.DELETED.equals(beanM.getDelflag())) {
					continue;
				}

				taskexeDetailList.add(beanM);
				for (int n = m + 1; n < jobList.size(); n++) {
					TaskexeDetailBean beanN = jobList.get(n);
					if (beanM.sameSite(beanN)) {
						beanM.setAddedinfo(beanM.getAddedinfo() + SystemInitiator.SPLIT + beanN.getAddedinfo());
						beanM.setAddeddesc("相同站点货位操作合并");
						beanN.setDelflag(Delflag.DELETED);
						continue;
					}
					List<TaskSiteInfoBean> sites = taskSitePathService.getPath(beanM.getSiteid(), beanN.getSiteid());
					if (!AppTool.isNull(sites)) {
						Collections.reverse(sites);
						for (int k = 0; k < sites.size(); k++) {
							TaskSiteInfoBean site = sites.get(k);
							TaskSiteInfoBean next = null;
							if (k < sites.size() - 1) {
								next = sites.get(k + 1);
							}
							if (!AppTool.isNull(next)) {
								TaskexeDetailBean taskexeDetail = new TaskexeDetailBean(taskexeBean.getTaskid(), site);
								String nextSide = ((!AppTool.isNull(site.getRight()) && !AppTool.isNull(next)
										&& (site.getRight().getId()).equals(next.getId())) ? ArrivedAct.TURN_RIGHT
												: ArrivedAct.TURN_LEFT);
								taskexeDetail.setArrivedact(nextSide);
								taskexeDetail.setAddedinfo("路过型站点");
								taskexeDetail.setAddeddesc("经过不做停留");
								taskexeDetailList.add(taskexeDetail);
							}
						}
					}
					break;
				}
			}
			int seq = 1;

			double distancetozero = 0;
			for (int i = 0; i < taskexeDetailList.size() - 1; i++) {
				TaskexeDetailBean pre = taskexeDetailList.get(i);
				if (i == 0) {
				}
				TaskexeDetailBean next = taskexeDetailList.get(i + 1);
				TaskSiteLogicBean logic = taskSiteLogicService.get(pre.getSiteid(), next.getSiteid());
				distancetozero += logic.getDistance();
				next.setDistancetozero(distancetozero);
			}
			for (TaskexeDetailBean b : taskexeDetailList) {
				int i = 0;
				while (i == 0) {
					i = taskexeDetailMapper
							.add(b.setTasksequence(taskexeBean.getTasksequence()).setDetailsequence(seq++));
				}
			}
		}
		for (int i = 0; i < taskexeDetailList.size(); i++) {
			TaskexeDetailBean b = taskexeDetailList.get(i);
			if (i > 0) {
				b.setPast(taskexeDetailList.get(i - 1));
			}
			if (i < taskexeDetailList.size() - 1) {
				b.setNext(taskexeDetailList.get(i + 1));
			}
		}
		return find(taskexeBean);
	}

	public List<TaskexeDetailBean> find(TaskexeBean taskexeBean) {
		return taskexeDetailMapper.find(new TaskexeDetailBean(taskexeBean.getTaskid(), taskexeBean.getTasksequence()));
	}

	public List<TaskexeDetailBean> logic(List<TaskexeDetailBean> list) {
		if (AppTool.isNull(list)) {
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			TaskexeDetailBean current = list.get(i);
			TaskSiteInfoBean siteInfo = taskSiteInfoService.getBean(current.getSiteid());
			current.setSiteInfo(siteInfo);
			if (i > 0) {
				TaskexeDetailBean past = list.get(i - 1);
				current.setPast(past);
			}
			if (i < list.size() - 1) {
				TaskexeDetailBean next = list.get(i + 1);
				current.setNext(next);
			}
		}
		return list;
	}

}
