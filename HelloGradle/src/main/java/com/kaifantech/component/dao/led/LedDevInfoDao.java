package com.kaifantech.component.dao.led;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.led.LedDevInfoBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.util.AppTool;

@Service
public class LedDevInfoDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private List<LedDevInfoBean> ledList = null;

	private List<LedDevInfoBean> getLedDevInfoBeanList(String whereSQL) {
		return (List<LedDevInfoBean>) jdbcTemplate.query(
				"SELECT * FROM " + SystemInitTables.LED_DEV_INFO + " where delflag=0 "
						+ (AppTool.isNullStr(whereSQL) ? "" : whereSQL),
				new BeanPropertyRowMapper<LedDevInfoBean>(LedDevInfoBean.class));
	}

	private Integer getCount(String whereSQL) {
		return jdbcTemplate.queryForObject("SELECT count(*) FROM " + SystemInitTables.LED_DEV_INFO
				+ " where delflag=0 " + (AppTool.isNullStr(whereSQL) ? "" : whereSQL), Integer.class);
	}

	public List<LedDevInfoBean> getAllLedDevInfoBean() {
		if (ledList == null) {
			ledList = getLedDevInfoBeanList(null);
		}
		return ledList;
	}

	public LedDevInfoBean getLedDevInfoBean(Integer columnId) {
		if (getAllLedDevInfoBean() != null && getAllLedDevInfoBean().size() > 0) {
			try {
				return getAllLedDevInfoBean().stream().filter((bean) -> columnId.equals(bean.getColumnId())).iterator()
						.next();
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	public Integer getAllLedDevInfoBeanCount(Integer columnId) {
		return getCount(" and columnId= " + columnId);
	}

	public List<LedDevInfoBean> getAllAllocationInfoBean(Integer columnId) {
		return getLedDevInfoBeanList(" and columnId= " + columnId);
	}

	public int insert(Integer columnId, String ip) {
		return jdbcTemplate.update("insert into  " + SystemInitTables.LED_DEV_INFO + " (  `columnId`,  `ip`) VALUES  ("
				+ "'" + columnId + "',    '" + ip + "')");
	}
}
