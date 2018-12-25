package com.kaifantech.component.service.lap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.component.dao.LapDao;
import com.kaifantech.component.dao.LapAGVDao;

@Service
public class LapInfoService {

	@Autowired
	private LapDao lapDao;

	@Autowired
	private LapAGVDao lapAGVDao;

	private List<Map<String, Object>> lapAGVList = null;

	public int updateLapSku(Map<Integer, Integer> skuIds) {
		int num = 0;
		for (Map<String, Object> lap : getAllLapList()) {
			num = lapDao.updateLap((Integer) lap.get("id"), skuIds.get((Integer) lap.get("id")));
		}
		return num;
	}

	public int setLapInUsed(Integer lapId, Boolean flag) {
		return flag ? lapDao.setLapInUesd(lapId) : lapDao.setLapNotInUesd(lapId);
	}

	public Boolean getLapInUsed(Integer lapId) {
		List<Map<String, Object>> tmpLapList = lapDao.getLapList();

		for (Map<String, Object> lap : tmpLapList) {
			if (lapId.equals((Integer) lap.get("id"))) {
				return lap.get("inUesd").toString().equals("1");
			}
		}
		return false;
	}

	public void init() {
	}

	public List<Map<String, Object>> getAllLapList() {
		List<Map<String, Object>> lapList = lapDao.getLapList();
		for (Map<String, Object> lap : lapList) {
			List<Map<String, Object>> tmpLapAGVList = getAllAGVListBy((Integer) lap.get("id"));
			StringBuffer sb = new StringBuffer();
			for (Map<String, Object> lapAGV : tmpLapAGVList) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(lapAGV.get("agvId"));
			}
			lap.put("agvIds", sb.toString());
		}
		return lapList;
	}

	public List<Map<String, Object>> getAllLapAGVList() {
		if (lapAGVList == null || lapAGVList.size() == 0) {
			lapAGVList = lapAGVDao.getLapAGVList();
		}
		return lapAGVList;
	}

	public List<Map<String, Object>> getAllAGVListBy(Integer lapId) {
		List<Map<String, Object>> tmpLapAGVList = new ArrayList<Map<String, Object>>();
		getAllLapAGVList().stream().filter((bean) -> (lapId.equals(bean.get("lapId")))).forEach(tmpLapAGVList::add);

		return tmpLapAGVList;
	}

	public Map<String, Object> getLap(Integer lapId) {
		for (Map<String, Object> lap : getAllLapList()) {
			if (lapId.equals((Integer) lap.get("id"))) {
				return lap;
			}
		}
		return null;
	}

	public List<Map<String, Object>> getAllLapListBy(Integer agvId) {
		List<Map<String, Object>> tmpLapAGVList = new ArrayList<Map<String, Object>>();
		getAllLapAGVList().stream().filter((bean) -> (agvId.equals(bean.get("agvId")))).forEach(tmpLapAGVList::add);

		return tmpLapAGVList;
	}

}
