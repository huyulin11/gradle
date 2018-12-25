package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.bean.dic.SysDic;
import com.kaifantech.entity.SysDicFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface SysDicMapper extends BaseMapper<SysDicFormMap> {

	public List<SysDicFormMap> findPage(SysDicFormMap formMap);

	public int add(SysDicFormMap formMap);

	List<SysDic> getSysDictionaries(SysDic sysDictionary);

	List<SysDic> getAllSysDictionaries();
}
