package com.kaifantech.component.dao.de;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaifantech.bean.de.AllRequestBean;
import com.kaifantech.init.sys.SystemInitTables;
import com.kaifantech.util.constants.de.DeStatus;
import com.ytgrading.util.AppTool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-shiro.xml", "classpath:spring-application.xml" })
@Service
public class DeWmsRequestDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private String FROM_SQL = SystemInitTables.I_ALL_REQUEST + " i WHERE 1=1 " + " AND i.`exstatus` = " + DeStatus.NEW
			+ " ";

	private String ORDERBY_SQL = " order by createtime";

	private List<AllRequestBean> getList(String whereSQL, String orderBySQL) {
		return (List<AllRequestBean>) jdbcTemplate.query(
				"SELECT i.* FROM " + FROM_SQL + (AppTool.isNullStr(whereSQL) ? "" : whereSQL) + orderBySQL,
				new BeanPropertyRowMapper<AllRequestBean>(AllRequestBean.class));
	}

	private List<AllRequestBean> getList(String whereSQL) {
		return getList(whereSQL, ORDERBY_SQL);
	}

	@Test
	public void test() {
		List<AllRequestBean> i = getAll();
		System.out.println(i);
	}

	public List<AllRequestBean> getAll() {
		return getList(null);
	}

	public AllRequestBean getOne(String sid) {
		List<AllRequestBean> list = getList(" and sid=" + sid + " ");
		return (AppTool.isNull(list) || list.size() > 1) ? null : list.get(0);
	}

	public int updateExstatus(String sid, Integer exstatus) {
		return jdbcTemplate.update(
				"update " + SystemInitTables.I_ALL_REQUEST + " set " + " exstatus= " + exstatus + " where sid= " + sid);
	}

	public int updateErrinfo(String sid, String errinfo) {
		return jdbcTemplate.update(
				"update " + SystemInitTables.I_ALL_REQUEST + " set " + " errinfo= '" + errinfo + "' where sid= " + sid);
	}

	public int updateExtimes(String sid) {
		return jdbcTemplate.update(
				"update " + SystemInitTables.I_ALL_REQUEST + " set " + " extimes=extimes+1 " + " where sid= " + sid);
	}

	public int add(String ip, String interfacename, Object msg) {
		if (AppTool.isNull(msg)) {
			return 0;
		}
		return jdbcTemplate.update("insert into " + SystemInitTables.I_ALL_REQUEST + " (`ip`,interfacename,msg) "
				+ "values(" + "'" + ip + "'" + "," + "'" + interfacename + "'" + ",'" + msg + "')");
	}

}
