
package com.kaifantech.component.service.taskexe.detail;

import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCacheCommand;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.util.beanmap.AppBeanMapUtil;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.ytgrading.util.AppTool;

@Service
public class TaskexeDetailCacheService {

	public static final String ACT = "1-ACT";
	public static final String TURN = "2-TURN";
	public static final String SPEED = "3-SPEED";
	public static final String CHANNEL = "4-CHANNEL";

	private TreeMap<Integer, TreeMap<String, TreeMap<String, String>>> map = new TreeMap<>();

	public void undoCacheCommand(Integer agvId) {
		map.remove(agvId);
	}

	public CsyAgvCacheCommand getCacheCommand(Integer agvId, TaskexeDetailBean thisDetail) throws Exception {
		List<String> list = AppBeanMapUtil.valuesToList(getCache(agvId, thisDetail));
		String[] cmds = new String[list.size()];
		list.toArray(cmds);
		return new CsyAgvCacheCommand(agvId, thisDetail.getSiteid(), cmds);
	}

	public synchronized TreeMap<String, String> getCache(Integer agvId, TaskexeDetailBean thisDetail) throws Exception {
		TreeMap<String, TreeMap<String, String>> mapOfTask = map.get(agvId);
		if (mapOfTask == null) {
			mapOfTask = new TreeMap<>();
			map.put(agvId, mapOfTask);
		}
		TreeMap<String, String> mapOfDetail = mapOfTask
				.get(thisDetail.getTaskid() + "-" + thisDetail.getDetailsequence());
		if (AppTool.isNull(mapOfDetail)) {
			mapOfDetail = getFirstCache(thisDetail);
			addByNext(agvId, thisDetail, mapOfDetail);
			addByPoints(agvId, thisDetail, mapOfDetail);
			addByPast(agvId, thisDetail, mapOfDetail);
			mapOfTask.put(thisDetail.getTaskid() + "-" + thisDetail.getDetailsequence(), mapOfDetail);
		}
		return mapOfDetail;
	}

	public TreeMap<String, String> getFirstCache(TaskexeDetailBean thisDetail) throws Exception {
		TreeMap<String, String> cache = new TreeMap<>();
		if (ArrivedAct.ALLOC_STOCK.equals(thisDetail.getArrivedact())) {
			cache.put(ACT, AgvCmdConstant.CMD_TASK_CACHE_STOP);
		} else if (ArrivedAct.ALLOC_GET.equals(thisDetail.getArrivedact())) {
			cache.put(ACT, AgvCmdConstant.CMD_TASK_CACHE_STOP);
		} else if (ArrivedAct.ALLOC_SCAN.equals(thisDetail.getArrivedact())) {
			cache.put(ACT, AgvCmdConstant.CMD_TASK_CACHE_STOP);
		} else if (ArrivedAct.CHARGE.equals(thisDetail.getArrivedact())) {
			cache.put(ACT, AgvCmdConstant.CMD_TASK_CACHE_STOP);
		} else if (ArrivedAct.WINDOW_STOCK.equals(thisDetail.getArrivedact())) {
			cache.put(ACT, AgvCmdConstant.CMD_TASK_CACHE_STOP);
		} else if (ArrivedAct.WINDOW_GET.equals(thisDetail.getArrivedact())) {
			cache.put(ACT, AgvCmdConstant.CMD_TASK_CACHE_STOP);
		} else if (ArrivedAct.TURN_LEFT.equals(thisDetail.getArrivedact())) {
			cache.put(TURN, AgvCmdConstant.CMD_TASK_CACHE_TURN_LEFT);
		} else if (ArrivedAct.TURN_RIGHT.equals(thisDetail.getArrivedact())) {
			cache.put(TURN, AgvCmdConstant.CMD_TASK_CACHE_TURN_RIGHT);
		} else if (ArrivedAct.STOP.equals(thisDetail.getArrivedact())) {
			cache.put(ACT, AgvCmdConstant.CMD_TASK_CACHE_STOP);
		} else if (ArrivedAct.CHANGE_SPEED.equals(thisDetail.getArrivedact())) {
			System.out.println("缓存变速指令到AGV");
			throw new Exception("暂不支持利用任务缓存机制变速");
		}
		return cache;
	}

	private void addByNext(Integer agvId, TaskexeDetailBean thisDetail, TreeMap<String, String> cache) {
		TaskexeDetailBean next = thisDetail.getNext();
		if (!AppTool.isNull(next)) {
			if (ArrivedAct.isStopAct(next)) {
				cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_10);
			}
			if (AppTool.ifOr(thisDetail.getSiteInfo().isOutOrWindowSite() && next.getSiteInfo().isAllocSite(),
					thisDetail.getSiteInfo().isAllocSite() && next.getSiteInfo().isBackSite())) {
				if (!cache.containsValue(AgvCmdConstant.CMD_TASK_CACHE_SPEED_10)) {
					cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_25);
				}
				cache.put(CHANNEL, AgvCmdConstant.CMD_TASK_CACHE_OBSTACLE_CHANNEL_CORNER);
			}

			TaskexeDetailBean next2 = next.getNext();
			if (!AppTool.isNull(next2)) {
				if (ArrivedAct.isStopAct(next2)) {
					if (!cache.containsValue(AgvCmdConstant.CMD_TASK_CACHE_SPEED_10)) {
						cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_25);
					}
				}
				TaskexeDetailBean next3 = next2.getNext();
				if (!AppTool.isNull(next3)) {
					if (ArrivedAct.isStopAct(next3)) {
						if (!cache.containsKey(SPEED)) {
							if (AppTool.ifOr(next3.getSiteInfo().isOutOrWindowSite(),
									next3.getSiteInfo().isBackSite())) {
								cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_50);
							}
						}
					}
				}
			}
			if (AppTool.ifOr(thisDetail.getSiteInfo().isOutOrWindowSite() && next2.getSiteInfo().isAllocSite(),
					thisDetail.getSiteInfo().isAllocSite() && next2.getSiteInfo().isBackSite())) {
				if (!cache.containsKey(SPEED)) {
					cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_50);
				}
			}
		}
	}

	private void addByPast(Integer agvId, TaskexeDetailBean thisDetail, TreeMap<String, String> cache)
			throws Exception {
		TaskexeDetailBean past = thisDetail.getPast();
		if (!AppTool.isNull(past)) {
			TreeMap<String, String> pastCache = getCache(agvId, past);
			if (!AppTool.isNull(pastCache)
					&& pastCache.containsValue(AgvCmdConstant.CMD_TASK_CACHE_OBSTACLE_CHANNEL_CORNER)
					&& !cache.containsKey(CHANNEL)) {
				cache.put(CHANNEL, AgvCmdConstant.CMD_TASK_CACHE_OBSTACLE_CHANNEL_NORMAL);
			}
			if (!ArrivedAct.isStopAct(thisDetail) && ArrivedAct.isStopAct(past)) {
				if (!cache.containsKey(SPEED)) {
					if (thisDetail.getSiteInfo().isAllocSite()) {
						cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_50);
					} else if (thisDetail.getSiteInfo().isOutOrWindowSite()) {
						cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_80);
					}
				}
			}
			TaskexeDetailBean pastOfPast = past.getPast();
			if (!AppTool.isNull(pastOfPast)) {
				TreeMap<String, String> pastOfPastCache = getCache(agvId, pastOfPast);
				if (!AppTool.isNull(pastOfPastCache)) {
					if (pastOfPastCache.containsValue(AgvCmdConstant.CMD_TASK_CACHE_OBSTACLE_CHANNEL_CORNER)
							&& !cache.containsKey(CHANNEL)) {
						cache.put(CHANNEL, AgvCmdConstant.CMD_TASK_CACHE_OBSTACLE_CHANNEL_NORMAL);
					}
				}
			}

			if (past.getSiteInfo().isOutOrWindowSite() && thisDetail.getSiteInfo().isAllocSite()) {
				if (!cache.containsKey(SPEED)) {
					cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_50);
				}
			}
		}
	}

	private void addByPoints(Integer agvId, TaskexeDetailBean thisDetail, TreeMap<String, String> cache) {
		if (AppTool.equals(thisDetail.getSiteid(), 478)) {
			cache.clear();
			cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_25);
		}
		if (AppTool.equals(thisDetail.getSiteid(), 477)) {
			cache.clear();
			cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_50);
		}
		if (AppTool.equals(thisDetail.getSiteid(), 18, 19, 20, 67)) {
			cache.clear();
			cache.put(SPEED, AgvCmdConstant.CMD_TASK_CACHE_SPEED_25);
			cache.put(CHANNEL, AgvCmdConstant.CMD_TASK_CACHE_OBSTACLE_CHANNEL_CORNER);
		}
		if (AppTool.equals(thisDetail.getSiteid(), 11)) {
			cache.put(TURN, AgvCmdConstant.CMD_TASK_CACHE_TURN_RIGHT);
		}
		if (AppTool.equals(thisDetail.getSiteid(), 20)) {
			cache.put(TURN, AgvCmdConstant.CMD_TASK_CACHE_TURN_RIGHT);
		}
		if (AppTool.equals(thisDetail.getSiteid(), 21)) {
			cache.put(CHANNEL, AgvCmdConstant.CMD_TASK_CACHE_OBSTACLE_CHANNEL_CORNER);
		}
	}

}
