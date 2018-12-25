package com.kaifantech.mappings.base;

import java.util.List;

import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.ytgrading.util.FormMap;

public interface WmsPaperMainMapper<TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>, TF extends FormMap<String, Object>>
		extends BaseMapper<FormMap<String, Object>> {

	public List<TF> findPage(TF formMap);

	public int add(TF formMap);

	public List<TM> find(TM bean);

	public List<TM> findAllToIFS();

}
