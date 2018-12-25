package com.kaifantech.init.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import com.ytgrading.util.AppTool;

public class SystemCacheDao {
	private static SystemCacheDao systemCacheDao;
	public static final String DEFAULT_CACHE_TABLE = "cache_key";

	public static SystemCacheDao one() {
		if (AppTool.isNull(systemCacheDao)) {
			systemCacheDao = new SystemCacheDao();
		}
		return systemCacheDao;
	}

	static {
		SystemDBDao.validateOrCreate(SystemInitDB.CACHE_DB_NAME, DEFAULT_CACHE_TABLE);
		SystemDBDao.validateOrCreate(SystemInitDB.CACHE_SOCKET_DB_NAME);
	}

	private synchronized String getTableDBName(String table) {
		boolean isSocket = table.toUpperCase().indexOf("SOCKET") >= 0;
		if (!isSocket) {
			SystemDBDao.validateOrCreate(SystemInitDB.CACHE_DB_NAME, table);
			return SystemInitDB.CACHE_DB_NAME + "." + table;
		} else {
			SystemDBDao.validateOrCreate(SystemInitDB.CACHE_SOCKET_DB_NAME, table);
			return SystemInitDB.CACHE_SOCKET_DB_NAME + "." + table;
		}
	}

	private synchronized String get(String table, String param) {
		try {
			String value = SystemDBDao.getJdbcTemplate().queryForObject(
					"SELECT `value` FROM " + " " + getTableDBName(table) + " where `key`='" + param + "' limit 0,1",
					String.class);
			return value;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public synchronized String get(String param) {
		return get(DEFAULT_CACHE_TABLE, param);
	}

	public synchronized String getFresh(String table, String param) {
		return getFresh(table, param, 10);
	}

	public synchronized String getFresh(String table, String param, int seconds) {
		try {
			String value = SystemDBDao.getJdbcTemplate().queryForObject(
					"SELECT `value` FROM " + " " + getTableDBName(table) + " where `key`='" + param + "'"
							+ "AND updatetime> SUBDATE(NOW(), INTERVAL " + seconds + " SECOND)" + " limit 0,1",
					String.class);
			return value;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public synchronized String getFresh(String param) {
		return getFresh(DEFAULT_CACHE_TABLE, param);
	}

	public synchronized String getFresh(String param, int seconds) {
		return getFresh(DEFAULT_CACHE_TABLE, param, seconds);
	}

	public synchronized String hget(String param1, String param2) {
		return get(param1, param2);
	}

	public synchronized Map<String, String> hgetAll(String table) {
		List<Map<String, Object>> values = SystemDBDao.getJdbcTemplate()
				.queryForList("SELECT * FROM " + " " + getTableDBName(table));
		Map<String, String> rtnMap = new HashMap<>();
		for (Map<String, Object> map : values) {
			rtnMap.put(map.get("key").toString(), map.get("value").toString());
		}
		return rtnMap;
	}

	public synchronized Map<String, String> hgetAllFresh(String table) {
		List<Map<String, Object>> values = SystemDBDao.getJdbcTemplate().queryForList("SELECT * FROM " + " "
				+ getTableDBName(table) + " WHERE updatetime> SUBDATE(NOW(), INTERVAL 10 SECOND)");
		Map<String, String> rtnMap = new HashMap<>();
		for (Map<String, Object> map : values) {
			rtnMap.put(map.get("key").toString(), map.get("value").toString());
		}
		return rtnMap;
	}

	public synchronized String set(String key, String value) {
		long row = SystemDBDao.getJdbcTemplate().update("replace into " + " " + SystemInitDB.CACHE_DB_NAME + "."
				+ DEFAULT_CACHE_TABLE + "(`key`, `value`)" + " values ('" + key + "' ," + "'" + value + "')");
		return "" + row;
	}

	public synchronized long hset(String table, String key, String value) {
		SystemDBDao.getJdbcTemplate().execute("replace into " + " " + getTableDBName(table) + "(`key`, `value`)"
				+ " values ('" + key + "' ," + "'" + value + "')");
		return 1;
	}

	public synchronized Long del(String key) {
		if (SystemDBDao.validateTableNameExist(SystemInitDB.CACHE_DB_NAME, key)) {
			SystemDBDao.truncate(SystemInitDB.CACHE_DB_NAME, key);
			return (long) 1;
		}
		if (SystemDBDao.validateTableNameExist(SystemInitDB.CACHE_SOCKET_DB_NAME, key)) {
			SystemDBDao.truncate(SystemInitDB.CACHE_SOCKET_DB_NAME, key);
			return (long) 1;
		}
		long i = 0;
		List<Map<String, Object>> values = SystemDBDao.getJdbcTemplate()
				.queryForList("SELECT TABLE_NAME FROM information_schema.`TABLES` WHERE table_schema='"
						+ SystemInitDB.CACHE_DB_NAME + "' AND TABLE_NAME like'" + key + "'");
		for (Map<String, Object> table : values) {
			i = i + del(table.get("TABLE_NAME").toString());
		}
		values = SystemDBDao.getJdbcTemplate()
				.queryForList("SELECT TABLE_NAME FROM information_schema.`TABLES` WHERE table_schema='"
						+ SystemInitDB.CACHE_SOCKET_DB_NAME + "' AND TABLE_NAME like'" + key + "'");
		for (Map<String, Object> table : values) {
			i = i + del(table.get("TABLE_NAME").toString());
		}
		return i;
	}
}