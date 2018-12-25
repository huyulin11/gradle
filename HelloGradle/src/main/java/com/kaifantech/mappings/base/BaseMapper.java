package com.kaifantech.mappings.base;

import java.util.List;

public interface BaseMapper<T> {
	public List<T> findByPage(T formMap);

	public List<T> findByWhere(T formMap);

	public void editEntity(Object formMap) throws Exception;

	public void deleteByLogic(Object formMap) throws Exception;

	public void updateStatus(Object formMap) throws Exception;

	public List<T> findByNames(T formMap);

	public List<T> findByAttribute(String key, String value, Class<T> clazz);

	public void deleteByAttribute(String key, String value, Class<?> clazz) throws Exception;

	public void addEntity(Object formMap) throws Exception;

	public void batchSave(List<?> formMap) throws Exception;

	public void deleteByNames(Object formMap) throws Exception;

	public T findbyFrist(String key, String value, Class<T> clazz);

	/** 清空表操作，慎用 */
	public void truncate(T formMap);
}
