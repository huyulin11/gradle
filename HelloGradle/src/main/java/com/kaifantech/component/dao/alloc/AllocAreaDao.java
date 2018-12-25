package com.kaifantech.component.dao.alloc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.alloc.AllocationAreaInfoBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.util.AppTool;

@Service
public class AllocAreaDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private List<AllocationAreaInfoBean> getAllocationAreaInfoBeanList(String whereSQL) {
		return (List<AllocationAreaInfoBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.ALLOCATION_AREA_INFO + " a where a.delflag=0 "
						+ " and exists (select 1 from " + SystemInitTables.ALLOC_ITEM_RELATION
						+ " i where i.delflag=0 and a.areaid=i.areaid) " + (AppTool.isNullStr(whereSQL) ? "" : whereSQL)
						+ " order by areaId ",
				new BeanPropertyRowMapper<AllocationAreaInfoBean>(AllocationAreaInfoBean.class));
	}

	public List<AllocationAreaInfoBean> getAllAllocationAreaInfoBean() {
		return getAllocationAreaInfoBeanList(null);
	}

	public List<Map<String, Object>> getAreaStorageInfo() {
		String sql = "SELECT `environment`, areaId,	" + "GROUP_CONCAT(DISTINCT `inSkuNames`) inSkuNames,"
				+ "GROUP_CONCAT(DISTINCT `skuName`) allowedSkuNames,"
				+ " GROUP_CONCAT(DISTINCT `allowedSkuTypeNames`) allowedSkuTypeNames FROM (" + ""
				+ "SELECT   ppp.`environment`, ppp.areaId,  si.`skuName`,"
				+ "  CONCAT(siin.`skuName`, '-', SUM(ppp.num)) inSkuNames,  "
				+ "  GROUP_CONCAT(DISTINCT sti.`skuTypeName`) allowedSkuTypeNames "
				+ " FROM  (SELECT t.`environment`, a.areaId, a.`text`, t.`columnId`, t.`allowedSkuId`,t.`allowedSkuType`,item.`skuId`, item.`num` "
				+ " FROM " + SystemInitTables.ALLOCATION_AREA_INFO
				+ " a,(SELECT  c.`environment`, c.`areaId`,  c.`columnId`,  c.`allowedSkuId`,  c.`allowedSkuType`"
				+ "   FROM   " + SystemInitTables.ALLOCATION_COLUMN_INFO
				+ "  c) t left join  (SELECT  i.`areaId`,  i.`columnId`,  i.`skuId`,i.`num` " + "   FROM   "
				+ SystemInitTables.ALLOC_ITEM_INFO_WITH_RELATION
				+ "  i WHERE (num IS NOT NULL AND num > 0 AND status > 1)  AND delflag = 0) item "
				+ "   ON t.`areaId` = item.areaId AND t.columnId = item.columnId "
				+ " WHERE a.`areaId` = t.areaId  ) ppp  LEFT JOIN  " + SystemInitTables.SKU_INFO
				+ " si ON ppp.allowedskuid = si.skuid" + "  LEFT JOIN " + SystemInitTables.SKU_INFO
				+ " siin ON ppp.skuid = siin.skuid" + "  LEFT JOIN " + SystemInitTables.SKU_TYPE
				+ " sti ON ppp.allowedskutype = sti.skutypeid"
				+ " GROUP BY ppp.`environment`, ppp.areaId,si.`skuName` ,siin.`skuName` "
				+ ") summ GROUP BY `environment`, areaId ";
		System.out.println(sql);
		return jdbcTemplate.queryForList(sql);
	}

	public List<AllocationAreaInfoBean> getAllAllocationInfoBean(Integer areaId) {
		return getAllocationAreaInfoBeanList(" where areaId= " + areaId);
	}

}
