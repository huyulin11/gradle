package com.kaifantech.component.service.alloc.item;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.entity.AllocItemFormMap;
import com.kaifantech.mappings.AllocItemMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.component.service.erp.system.IBaseService;

@Service
public class AllocItemService implements IBaseService<AllocItemFormMap> {
	@Inject
	private AllocItemMapper mapper;

	@SuppressWarnings("unchecked")
	public void doAddEntity(AllocItemFormMap formMap) throws Exception {
		Map<String, AllocItemFormMap> list = (Map<String, AllocItemFormMap>) formMap.get("list");
		initFormMap(formMap);
		for (AllocItemFormMap allocItem : list.values()) {
			formMap.set("text", allocItem.get("allocItem"));
			mapper.add(formMap);
		}
	}

	public void doAddEntity(List<AllocItemFormMap> formMapList) throws Exception {
		for (AllocItemFormMap formMap : formMapList) {
			doAddEntity(formMap);
		}
	}

	private void initFormMap(AllocItemFormMap formMap) {
		formMap.set("environment", "1");
		formMap.set("areaId", "0");
		formMap.set("colId", "0");
		formMap.set("rowId", "0");
		formMap.set("zId", "0");
		formMap.set("columnId", "0");
		formMap.set("status", "1");
		formMap.set("skuId", "0");
		formMap.set("num", "0");
	}

	@Override
	public BaseMapper<AllocItemFormMap> getMapper() {
		return mapper;
	}
}