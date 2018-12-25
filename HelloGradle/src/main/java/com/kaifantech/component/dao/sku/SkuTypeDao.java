package com.kaifantech.component.dao.sku;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.sku.SkuTypeBean;
import com.kaifantech.init.sys.SystemInitTables;

@Service
public class SkuTypeDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<SkuTypeBean> getAllList() {
		return (List<SkuTypeBean>) jdbcTemplate.query(
				"SELECT * FROM " + SystemInitTables.SKU_TYPE + " where delflag=0 ",
				new BeanPropertyRowMapper<SkuTypeBean>(SkuTypeBean.class));
	}

}
