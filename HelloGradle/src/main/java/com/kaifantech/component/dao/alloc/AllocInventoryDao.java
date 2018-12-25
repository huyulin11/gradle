package com.kaifantech.component.dao.alloc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.alloc.AllocInventoryInfoBean;
import com.kaifantech.init.sys.SystemInitTables;

@Service
public class AllocInventoryDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private String FROM_SQL = SystemInitTables.ALLOCATION_INVENTORY_INFO + " i WHERE 1=1 ";

	public List<AllocInventoryInfoBean> getList() {
		return (List<AllocInventoryInfoBean>) jdbcTemplate.query("SELECT i.* FROM " + FROM_SQL,
				new BeanPropertyRowMapper<AllocInventoryInfoBean>(AllocInventoryInfoBean.class));
	}
}
