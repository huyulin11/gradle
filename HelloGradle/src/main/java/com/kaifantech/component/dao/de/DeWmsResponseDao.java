package com.kaifantech.component.dao.de;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaifantech.init.sys.SystemInitTables;
import com.ytgrading.util.AppTool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-shiro.xml", "classpath:spring-application.xml" })
@Service
public class DeWmsResponseDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public int updateExstatus(String sid, Integer exstatus) {
		return jdbcTemplate.update("update " + SystemInitTables.O_ALL_RESPONSE + " set " + " exstatus= " + exstatus
				+ " where sid= " + sid);
	}

	public int updateErrinfo(String sid, String errinfo) {
		return jdbcTemplate.update("update " + SystemInitTables.O_ALL_RESPONSE + " set " + " errinfo= '" + errinfo
				+ "' where sid= " + sid);
	}

	public int updateExtimes(String sid) {
		return jdbcTemplate.update(
				"update " + SystemInitTables.O_ALL_RESPONSE + " set " + " extimes=extimes+1 " + " where sid= " + sid);
	}

	public int add(String request, Object response) {
		if (AppTool.isNull(request)) {
			return 0;
		}
		return jdbcTemplate.update("insert into " + SystemInitTables.O_ALL_RESPONSE + " (request,response) " + "values("
				+ "'" + request + "'" + ",'" + response + "')");
	}

}
