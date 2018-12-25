package com.kaifantech.component.service.relation;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.iot.relation.IotRelationBean;
import com.kaifantech.component.dao.relation.IotRelationDao;
import com.kaifantech.entity.IotRelationFormMap;
import com.kaifantech.mappings.IotRelationMapper;
import com.ytgrading.util.FormMap;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Service
public class IotRelationService {
	@Inject
	private IotRelationMapper mapper;

	@Inject
	private IotRelationDao dao;

	private List<IotRelationBean> iotRelationList = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void saveAll(FormMap formMap) throws Exception {
		Map<String, FormMap> list = (Map<String, FormMap>) formMap.get("list");
		for (FormMap item : list.values()) {
			mapper.editEntity(item);
		}

	}

	public void doAddEntity(IotRelationFormMap formMap) throws Exception {
		mapper.add(formMap);
	}

	public List<IotRelationBean> getIotRelationList() {
		if (iotRelationList == null || iotRelationList.size() == 0) {
			iotRelationList = dao.getIotRelationBeanList();
		}
		return iotRelationList;
	}

	public IotRelationBean getIotRelationBean(Integer id) {
		try {
			return getIotRelationList().stream().filter((bean) -> id.equals(bean.getId())).iterator().next();
		} catch (Exception e) {
			return null;
		}
	}

	public IotRelationBean getIotRelationBean(Integer devid, Integer devtype) {
		try {
			return getIotRelationList().stream()
					.filter((bean) -> devid.equals(bean.getDevid()) && devtype.equals(bean.getDevtype())).iterator()
					.next();
		} catch (Exception e) {
			return null;
		}
	}

	public IotRelationBean getIotRelationBean(IotClientBean socketDev) {
		try {
			return getIotRelationList().stream().filter((bean) -> socketDev.getId().equals(bean.getDevid())
					&& socketDev.getDevtype().equals(bean.getDevtype())).iterator().next();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}