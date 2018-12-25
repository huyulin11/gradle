package com.kaifantech.component.service.paper.base;

import java.util.List;

import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.mappings.base.WmsPaperMainMapper;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.AppTool;

public abstract class AbstractWmsPaperMainService<TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>, TF extends FormMap<String, Object>> {

	public abstract WmsPaperMainMapper<TD, TM, TF> getMapper();

	public abstract FormMap<String, Object> createFormMap();

	public abstract TM createMainObj();

	public void updateToFrom(String id, String toStatus, String fromStatus) {
		FormMap<String, Object> formMap = createFormMap();
		formMap.set("id", id);
		formMap.set("fromStatus", fromStatus);
		formMap.set("toStatus", toStatus);
		try {
			getMapper().updateStatus(formMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<TM> findByStatus(String status, boolean withDetail) {
		if (AppTool.isNull(status)) {
			return null;
		}
		TM bean = createMainObj();
		bean.setStatus(status);
		return find(bean, withDetail);
	}

	public TM findByPaperid(String paperid, boolean withDetail) {
		if (AppTool.isNull(paperid)) {
			return null;
		}
		TM bean = createMainObj();
		bean.setPaperid(paperid);
		List<TM> list = find(bean, withDetail);
		return list == null || list.size() != 1 ? null : list.get(0);
	}

	public List<TM> find(TM bean, boolean withDetail) {
		if (!withDetail) {
			return getMapper().find(bean);
		}
		List<TM> receiptMainList = getMapper().find(bean);
		for (TM receiptMainBean : receiptMainList) {
			List<TD> receiptDetailList = findDetailsByPaperid(receiptMainBean.getPaperid());
			receiptMainBean.setDetailList(receiptDetailList);
		}
		return receiptMainList;
	}

	public List<TM> findAllToIFS() {
		List<TM> mainList = null;
		try {
			mainList = getMapper().findAllToIFS();
			for (TM mainBean : mainList) {
				List<TD> detailList = findDetailsByPaperid(mainBean.getPaperid());
				mainBean.setDetailList(detailList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mainList;
	}

	public TM findById(String id, boolean withDetail) {
		if (AppTool.isNull(id)) {
			return null;
		}
		TM bean = createMainObj();
		bean.setId(id);
		List<TM> list = find(bean, withDetail);
		return list == null || list.size() != 1 ? null : list.get(0);
	}

	// public abstract List<TM> find(TM bean, boolean withDetail);

	public abstract List<TD> findDetailsByPaperid(String paperid);
}