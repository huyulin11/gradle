package com.kaifantech.component.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.dic.SysDicBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.util.AppTool;

@Service
public class SysDicDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<SysDicBean> getSysDicBeanList(String whereSQL) {
		return (List<SysDicBean>) jdbcTemplate.query(
				"SELECT * FROM " + SystemInitTables.SYS_DICTIONARY_INFO + " where 1=1 and delflag=0 "
						+ (AppTool.isNullStr(whereSQL) ? "" : whereSQL),
				new BeanPropertyRowMapper<SysDicBean>(SysDicBean.class));
	}

	public List<SysDicBean> getAllSysDicBean() {
		return getSysDicBeanList(null);
	}

}
