package com.kaifantech.component.dao.alloc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.kaifantech.init.sys.SystemClient;
import com.ytgrading.util.AppTool;

@Service
public class AllocItemDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private String FROM_SQL = SystemInitTables.ALLOCATION_ITEM_INFO + " i WHERE 1=1 "
			+ (!SystemClient.CLIENT.equals(SystemClient.Client.CSY)
					? "," + SystemInitTables.ALLOCATION_AREA_INFO + " a," + SystemInitTables.ALLOCATION_COLUMN_INFO
							+ " c " + " AND i.`columnId` = c.`columnId` AND i.`areaId` = a.`areaId` "
							+ " AND a.`delflag` = 0 AND c.`delflag` = 0  "
					: "")
			+ " AND i.`delflag` = 0 ";

	private String ORDERBY_SQL = " order by "
			+ (!SystemClient.CLIENT.equals(SystemClient.Client.CSY) ? "i.areaId,i.colId,i.rowId,i.zId " : " i.id ");

	private String ORDERBY_SQL_SHOW = " order by "
			+ (!SystemClient.CLIENT.equals(SystemClient.Client.CSY) ? "areaId,colid desc,rowid,zid desc " : " id ");

	private List<AllocItemInfoBean> getList(String whereSQL, String orderBySQL) {
		return (List<AllocItemInfoBean>) jdbcTemplate.query(
				"SELECT i.* FROM " + FROM_SQL + (AppTool.isNullStr(whereSQL) ? "" : whereSQL) + orderBySQL,
				new BeanPropertyRowMapper<AllocItemInfoBean>(AllocItemInfoBean.class));
	}

	private List<AllocItemInfoBean> getList(String whereSQL) {
		return getList(whereSQL, ORDERBY_SQL);
	}

	private Integer getCount(String whereSQL) {
		return jdbcTemplate.queryForObject(
				"SELECT count(*) FROM " + FROM_SQL + (AppTool.isNullStr(whereSQL) ? "" : whereSQL) + ORDERBY_SQL,
				Integer.class);
	}

	public List<AllocItemInfoBean> getAll() {
		return getList(null);
	}

	public List<AllocItemInfoBean> getAllAllocationInfoBean(Integer areaId) {
		return getList(" and i.areaId= " + areaId);
	}

	public Integer getAllAllocationInfoBeanCount(Integer areaId) {
		return getCount(" and i.areaId= " + areaId);
	}

	public Integer getAllAllocationInfoBeanCount(Integer areaId, Integer rowId, Integer colId, Integer zId) {
		return getCount(" and i.areaId= " + areaId + " and i.colId= " + colId + " and i.rowId= " + rowId
				+ " and i.zId= " + zId);
	}

	public List<AllocItemInfoBean> getAllAllocationInfoBean(Integer areaId, Integer colId) {
		return getList(" and i.areaId= " + areaId + " and i.colId= " + colId);
	}

	public List<AllocItemInfoBean> getAllocationInfoBeanListByColId(Integer areaId, Integer colId) {
		return getList(" and i.areaId=" + areaId + " and i.colId= " + colId);
	}

	public List<AllocItemInfoBean> getAllAllocationInfoToShow(Integer areaId) {
		return getList("and i.areaId= " + areaId, ORDERBY_SQL_SHOW);

	}

	public AllocItemInfoBean getAllocationInfoBean(Integer id) {
		List<AllocItemInfoBean> allocationInfoBeanList = getList(" and id = " + id);
		if (allocationInfoBeanList == null || allocationInfoBeanList.size() <= 0) {
			return null;
		}
		return allocationInfoBeanList.get(0);
	}

	public AllocItemInfoBean getAllocationInfoBean(String allocItemName) {
		List<AllocItemInfoBean> allocationInfoBeanList = getList(" and i.text = '" + allocItemName + "'");
		if (allocationInfoBeanList == null || allocationInfoBeanList.size() <= 0 || allocationInfoBeanList.size() > 1) {
			return null;
		}
		return allocationInfoBeanList.get(0);
	}

	public AllocItemInfoBean getAllocationInfoBean(Integer areaId, Integer rowId, Integer colId, Integer zId) {
		List<AllocItemInfoBean> allocationInfoBeanList = getList(" and i.areaId = " + areaId + " and  i.rowId = "
				+ rowId + " and  i.colId = " + colId + " and  i.zId = " + zId);
		if (allocationInfoBeanList == null || allocationInfoBeanList.size() <= 0) {
			return null;
		}
		return allocationInfoBeanList.get(0);
	}

	public int updateWithSku(Integer id, String beforeStatus, String afterstatus, Integer skuId, Integer num) {
		return jdbcTemplate.update("update " + SystemInitTables.ALLOCATION_ITEM_INFO + " set `status`=" + afterstatus
				+ ", skuId= " + skuId + " ,num= " + num + " where `status`=" + beforeStatus + " and id= " + id);
	}

	public int updateSku(Integer id, Integer skuId) {
		return jdbcTemplate.update(
				"update " + SystemInitTables.ALLOCATION_ITEM_INFO + " set skuId= " + skuId + " where id= " + id);
	}

	public int updateNum(Integer id, String beforeStatus, String afterstatus, Integer num) {
		return updateNum(id, beforeStatus, afterstatus, null, num);
	}

	public int updateNum(Integer id, String beforeStatus, String afterstatus, Integer skuId, Integer num) {
		return jdbcTemplate.update("update " + SystemInitTables.ALLOCATION_ITEM_INFO + " set `status`=" + afterstatus
				+ " ,num= " + num + (AppTool.isNull(skuId) ? "" : (" ,skuId= " + skuId)) + " where `status`="
				+ beforeStatus + " and id= " + id);
	}

	public int updateNum(Integer id, Integer skuId, Integer num) {
		return jdbcTemplate.update("update " + SystemInitTables.ALLOCATION_ITEM_INFO + " set num= " + num
				+ (AppTool.isNull(skuId) ? "" : (" ,skuId= " + skuId)) + " where id= " + id);
	}

	public int updateNum(Integer id, Integer num) {
		return updateNum(id, null, num);
	}

	public int update(Integer id, String beforeStatus, String afterstatus) {
		return jdbcTemplate.update("update " + SystemInitTables.ALLOCATION_ITEM_INFO + " set `status`=" + afterstatus
				+ " where `status`=" + beforeStatus + " and id= " + id);
	}

	public int updateText(Integer id, String text) {
		return jdbcTemplate.update(
				"update " + SystemInitTables.ALLOCATION_ITEM_INFO + " set `text`='" + text + "'" + " where id= " + id);
	}

	public int updateSite(Integer id, Integer siteid) {
		return jdbcTemplate.update("update " + SystemInitTables.ALLOCATION_ITEM_INFO + " set `siteid`='" + siteid + "'"
				+ " where id= " + id);
	}

	public int updateSite() {
		return jdbcTemplate.update("UPDATE kf_csy_daj_wms.allocation_item_info t1 "
				+ "JOIN (SELECT t.`id`, 0+ SUBSTR(t.`text`,1,2) pai,0+ SUBSTR(t.`text`,4,2) ceng "
				+ "FROM kf_csy_daj_wms.allocation_item_info t) t2 " + "ON t1.id=t2.id "
				+ "SET siteid=(CASE WHEN pai=1 THEN 41+ceng*2 ELSE 70+23*(FLOOR((pai-2)/2))+ceng*2 END)");
	}

	public int updateColumnId(Integer id, Integer columnId) {
		return jdbcTemplate.update(
				"update " + SystemInitTables.ALLOCATION_ITEM_INFO + " set `columnId`=" + columnId + " where id= " + id);
	}

	public int insert(Integer areaId, Integer rowId, Integer colId, Integer zId, Integer columnId, String text,
			Integer environment) {
		return jdbcTemplate.update("insert into  " + SystemInitTables.ALLOCATION_ITEM_INFO
				+ " ( `environment`, `areaId`,  `rowId`,  `colId`,  `zId`, columnId,  `text`) VALUES  (" + "'"
				+ environment + "'," + "'" + areaId + "'" + "," + "'" + rowId + "'" + "," + "'" + colId + "'" + ","
				+ "'" + zId + "'" + "," + "'" + columnId + "'" + "," + "'" + text + "'" + ")");
	}

	public int insert(String text) {
		return jdbcTemplate.update("insert into  " + SystemInitTables.ALLOCATION_ITEM_INFO + " (  `text`) VALUES  ("
				+ "'" + text + "'" + ")");
	}

	public void insert(List<Map<String, Object>> list) {
		int j = 1;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append("(" + "'" + list.get(i).get("name") + "'" + "),");
			if (i <= j * 1000 && i < list.size() - 1) {
			} else {
				if (sb.length() > 1) {
					jdbcTemplate.update("insert into  " + SystemInitTables.ALLOCATION_ITEM_INFO + " (  `text`) VALUES  "
							+ sb.toString().substring(0, sb.length() - 1));
					sb.setLength(0);
					j++;
				}
			}
		}
	}

	public void truncate() {
		jdbcTemplate.update("truncate table " + SystemInitTables.ALLOCATION_ITEM_INFO);
	}
}
