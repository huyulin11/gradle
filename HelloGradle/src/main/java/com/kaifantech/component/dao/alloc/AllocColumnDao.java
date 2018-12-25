package com.kaifantech.component.dao.alloc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.alloc.AllocColumnInfoBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.util.AppTool;

@Service
public class AllocColumnDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private List<AllocColumnInfoBean> getAllocationColumnInfoBeanList(String whereSQL) {
		return (List<AllocColumnInfoBean>) jdbcTemplate.query(
				"SELECT * FROM " + SystemInitTables.ALLOCATION_COLUMN_INFO
						+ " where delflag=0 and areaId in (SELECT areaId FROM " + SystemInitTables.ALLOCATION_AREA_INFO
						+ " WHERE delflag=0) " + (AppTool.isNullStr(whereSQL) ? "" : whereSQL),
				new BeanPropertyRowMapper<AllocColumnInfoBean>(AllocColumnInfoBean.class));
	}

	private Integer getCount(String whereSQL) {
		return jdbcTemplate.queryForObject("SELECT count(*) FROM " + SystemInitTables.ALLOCATION_COLUMN_INFO
				+ " where delflag=0 and areaId in (SELECT areaId FROM " + SystemInitTables.ALLOCATION_AREA_INFO
				+ " WHERE delflag=0) " + (AppTool.isNullStr(whereSQL) ? "" : whereSQL), Integer.class);
	}

	public List<AllocColumnInfoBean> getAllAllocationColumnInfoBean() {
		return getAllocationColumnInfoBeanList(null);
	}

	public Integer getAllAllocationColumnInfoBeanCount(Integer areaId, Integer colId) {
		return getCount(" and areaId= " + areaId + " and colId= " + colId);
	}

	public AllocColumnInfoBean getAllocationColumnInfoBeanBy(Integer areaId, Integer colId) {
		List<AllocColumnInfoBean> columnBeanList = getAllocationColumnInfoBeanList(
				" and areaId= " + areaId + " and colId= " + colId);
		return (columnBeanList == null || columnBeanList.size() == 0) ? null : columnBeanList.get(0);
	}

	public List<AllocColumnInfoBean> getAllAllocationInfoBean(Integer colId) {
		return getAllocationColumnInfoBeanList(" where colId= " + colId);
	}

	public int insert(Integer areaId, Integer colId, Integer environment, Integer allowedSkuId) {
		return jdbcTemplate.update("insert into  " + SystemInitTables.ALLOCATION_COLUMN_INFO
				+ " (  `areaId`,  `colId`, `environment`, `allowedSkuId`) VALUES  (" + "'" + areaId + "'" + "," + "'"
				+ colId + "'" + "," + "'" + environment + "'" + "," + allowedSkuId + ")");
	}
}
