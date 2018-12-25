package com.kaifantech.component.dao.sku;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.SkuInfoBean;
import com.kaifantech.init.sys.SystemInitTables;

@Service
public class SkuInfoDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<SkuInfoBean> getAllList() {
		return (List<SkuInfoBean>) jdbcTemplate.query(
				"SELECT * FROM " + SystemInitTables.SKU_INFO + " where delflag=0 ",
				new BeanPropertyRowMapper<SkuInfoBean>(SkuInfoBean.class));
	}

}
