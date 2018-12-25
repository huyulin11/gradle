package com.kaifantech.component.service.sysdic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.dic.SysDic;
import com.kaifantech.bean.dic.SysDicBean;
import com.kaifantech.component.dao.SysDicDao;
import com.kaifantech.entity.SysDicFormMap;
import com.kaifantech.mappings.SysDicMapper;

@Service
public class SysDicService {

	@Autowired
	private SysDicDao sysDictionaryInfoDao;

	private List<SysDicBean> sysDictionaryInfoBeanList;

	@Inject
	private SysDicMapper mapper;

	public List<SysDic> getSysDictionaries(SysDic sysDictionary) {
		return mapper.getSysDictionaries(sysDictionary);
	}

	public SysDic getSysDictionary(SysDic sysDictionary) {
		List<SysDic> SysDictionaries = getSysDictionaries(sysDictionary);
		if (SysDictionaries != null && SysDictionaries.size() > 0) {
			return SysDictionaries.get(0);
		}
		return new SysDic();
	}

	public String getDicValue(String dicType, String dicKey) {
		List<SysDic> SysDictionaries = getSysDictionaries(new SysDic(dicType, dicKey));
		if (SysDictionaries != null && SysDictionaries.size() > 0) {
			return SysDictionaries.get(0).getValue();
		}
		return "";
	}

	public String getDicAlias(String dicType, String dicKey) {
		List<SysDic> SysDictionaries = getSysDictionaries(new SysDic(dicType, dicKey));
		if (SysDictionaries != null && SysDictionaries.size() > 0) {
			return SysDictionaries.get(0).getAlias();
		}
		return "";
	}

	public String getDicValue(String dicType, Integer dicKey) {
		return this.getDicValue(dicType, dicKey.toString());
	}

	public String getDicAlias(String dicType, Integer dicKey) {
		return this.getDicAlias(dicType, dicKey.toString());
	}

	public List<SysDic> getAllSysDictionaries() {
		return mapper.getAllSysDictionaries();
	}

	public List<SysDic> getSysDictionaries(String type) {
		return mapper.getSysDictionaries(new SysDic(type, null));
	}

	@SuppressWarnings({ "unchecked" })
	public void doAddEntity(String dictype, SysDicFormMap formMap) throws Exception {
		Map<String, SysDicFormMap> list = (Map<String, SysDicFormMap>) formMap.get("list");
		for (SysDicFormMap value : list.values()) {
			value.set("dictype", dictype);
			value.set("sortflag", "0");
			mapper.add(value);
		}
	}

	private List<SysDicBean> getAllSysDicBean() {
		if (sysDictionaryInfoBeanList == null || sysDictionaryInfoBeanList.size() == 0) {
			sysDictionaryInfoBeanList = sysDictionaryInfoDao.getSysDicBeanList(null);
		}
		return sysDictionaryInfoBeanList;
	}

	public List<SysDicBean> getAllSysDicBeanByTypeCode(String typecode) {
		List<SysDicBean> list = new ArrayList<SysDicBean>();
		getAllSysDicBean().stream().filter((s) -> typecode.equals(s.getTypeCode())).forEach(list::add);
		return list;
	}

	public List<SysDicBean> getAllAreaList() {
		return getAllSysDicBeanByTypeCode("WEIWEI_AREA");
	}
}
