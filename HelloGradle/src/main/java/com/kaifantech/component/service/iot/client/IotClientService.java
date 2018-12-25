package com.kaifantech.component.service.iot.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.dao.iot.client.IotClientDao;
import com.kaifantech.entity.IotClientFormMap;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.mappings.IotClientMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.IotDevType;
import com.ytgrading.component.service.erp.system.IBaseService;
import com.ytgrading.util.AppTool;

@Service
public class IotClientService implements IBaseService<IotClientFormMap> {
	@Inject
	private IotClientMapper mapper;

	@Inject
	private IotClientDao iotClientDao;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	private List<IotClientBean> list = null;

	private List<IotClientBean> agvCacheList = null;

	private List<IotClientBean> chargeCacheList = null;

	private List<IotClientBean> windowCacheList = null;

	public synchronized List<IotClientBean> getList() {
		if (AppTool.isNull(list)) {
			list = iotClientDao.getList();

			agvCacheList = new ArrayList<>();
			list.stream().forEach((bean) -> {
				if (bean.getDevtype().equals(IotDevType.AGV)) {
					agvCacheList.add(bean);
				}
			});

			chargeCacheList = new ArrayList<>();
			list.stream().forEach((bean) -> {
				if (bean.getDevtype().equals(IotDevType.CHARGE)) {
					chargeCacheList.add(bean);
				}
			});
			Collections.reverse(chargeCacheList);

			windowCacheList = new ArrayList<>();
			list.stream().forEach((bean) -> {
				if (bean.getDevtype().equals(IotDevType.WINDOW)) {
					windowCacheList.add(bean);
				}
			});
		}
		return list;
	}

	public IotClientBean getBean(Integer id) {
		try {
			return getList().stream().filter((bean) -> id.equals(bean.getId())).iterator().next();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public BaseMapper<IotClientFormMap> getMapper() {
		return mapper;
	}

	@Scheduled(cron = "0 0 0/1 * * ?")
	public void shuffleAgvList() {
		Collections.shuffle(getAgvCacheList());
	}

	public synchronized List<IotClientBean> getAgvCacheList() {
		if (AppTool.isNull(agvCacheList)) {
			getList();
			agvCacheList.sort((a1, a2) -> {
				return a2.getId() - a1.getId();
			});
		}
		return agvCacheList;
	}

	public synchronized List<IotClientBean> getChargeCacheList() {
		if (AppTool.isNull(chargeCacheList)) {
			getList();
		}
		return chargeCacheList;
	}

	public Map<Integer, Boolean> isChargingMap() {
		Map<Integer, Boolean> chargeMap = new HashMap<>();
		for (IotClientBean charge : getChargeCacheList()) {
			long num = agvInfoDao.getChargedList().stream().filter((agvInCharge) -> {
				return agvInCharge.isCharging() && charge.getId().equals(agvInCharge.getChargeid());
			}).count();
			if (num == 0) {
				chargeMap.put(charge.getId(), false);
			} else {
				chargeMap.put(charge.getId(), true);
			}
		}
		return chargeMap;
	}

	public boolean isCharging(Integer chargeId) {
		Boolean isCharging = isChargingMap().get(chargeId);
		return !AppTool.isNull(isCharging) && isCharging;
	}

	public Integer getFreeChargeId() {
		Integer choosedChargeId = null;
		for (IotClientBean charge : getChargeCacheList()) {
			if (!isCharging(charge.getId())) {
				choosedChargeId = charge.getId();
				break;
			}
		}
		return choosedChargeId;
	}

	public synchronized List<IotClientBean> getWindowCacheList() {
		if (AppTool.isNull(windowCacheList)) {
			getList();
		}
		return windowCacheList;
	}

}