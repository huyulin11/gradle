package com.kaifantech.init.sys;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kaifantech.component.cache.worker.StaticBeanFactory;
import com.ytgrading.util.AppTool;

public class SystemDBDao {

	private static JdbcTemplate jdbcTemplate;

	public static JdbcTemplate getJdbcTemplate() {
		if (AppTool.isNull(jdbcTemplate)) {
			jdbcTemplate = (JdbcTemplate) StaticBeanFactory.getBean(JdbcTemplate.class);
		}
		return jdbcTemplate;
	}

	public static void validateOrCreate(String dbName, String tableName) {
		validateOrCreate(dbName);
		if (!SystemDBDao.validateTableNameExist(dbName, tableName)) {
			SystemDBDao.createCacheTable(dbName, tableName);
		}
	}

	public static void validateOrCreate(String dbName) {
		if (!SystemDBDao.validateDBNameExist(dbName)) {
			SystemDBDao.createDB(dbName);
		}
	}

	public static boolean validateTableNameExist(String dbName, String tableName) {
		int tableNum = getJdbcTemplate()
				.queryForObject("SELECT COUNT(*) FROM information_schema.`TABLES` WHERE table_schema='" + dbName
						+ "' AND TABLE_NAME='" + tableName + "'", Integer.class);
		if (tableNum > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void createCacheTable(String dbName, String cacheTableName) {
		String sql = "CREATE TABLE " + dbName + "." + cacheTableName + " (" + "`key` VARCHAR(100) NOT NULL,"
				+ "`value` VARCHAR(500) NOT NULL" + ","
				+ " `updatetime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, "
				+ "PRIMARY KEY (`key`)" + ")" + "COLLATE='utf8_general_ci'" + "ENGINE=MEMORY;";
		getJdbcTemplate().execute(sql);
	}

	public static boolean validateDBNameExist(String dbName) {
		int tableNum = getJdbcTemplate().queryForObject(
				"SELECT COUNT(*) FROM information_schema.`SCHEMATA` WHERE SCHEMA_NAME='" + dbName + "' ",
				Integer.class);
		if (tableNum > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void createDB(String dbName) {
		String sql = "CREATE DATABASE `" + dbName + "`;";
		getJdbcTemplate().execute(sql);
	}

	public static void truncate(String cacheTableName) {
		String sql = "truncate " + cacheTableName;
		getJdbcTemplate().execute(sql);
	}

	public static void truncate(String dbName, String cacheTableName) {
		String sql = "truncate " + dbName + "." + cacheTableName;
		getJdbcTemplate().execute(sql);
	}
}
