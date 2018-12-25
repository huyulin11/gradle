package com.kaifantech.component.dao.relation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.relation.IotRelationBean;
import com.kaifantech.init.sys.SystemInitTables;

@Service
public class IotRelationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<IotRelationBean> getIotRelationBeanList() {
		return (List<IotRelationBean>) jdbcTemplate.query(
				"SELECT a.* FROM " + SystemInitTables.IOT_RELATION_INFO + " a  WHERE a.delflag=0  ",
				new BeanPropertyRowMapper<IotRelationBean>(IotRelationBean.class));
	}

	public IotRelationBean getIotRelationBean(Integer iotRelationId) {
		List<IotRelationBean> fl = (List<IotRelationBean>) jdbcTemplate.query("SELECT a.* FROM "
				+ SystemInitTables.IOT_RELATION_INFO + " a  WHERE a.delflag=0 AND id= " + iotRelationId,
				new BeanPropertyRowMapper<IotRelationBean>(IotRelationBean.class));
		return (fl == null || fl.size() > 1) ? null : fl.get(0);
	}

}
