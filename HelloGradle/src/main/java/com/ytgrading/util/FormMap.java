package com.ytgrading.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import com.ytgrading.annotation.FormMapTableName;

public class FormMap<K, V> extends HashMap<K, V> implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public <C extends FormMap<K, V>> C setRtn(K key, V value) {
		set(key, value);
		return (C) this;
	}

	public void set(K key, V value) {
		this.put(key, value);
	}

	public String getStr(String attr) {
		return (String) this.get(attr);
	}

	public Integer getInt(String attr) {
		return (Integer) this.get(attr);
	}

	public Long getLong(String attr) {
		return (Long) this.get(attr);
	}

	public java.math.BigInteger getBigInteger(String attr) {
		return (java.math.BigInteger) this.get(attr);
	}

	public java.util.Date getDate(String attr) {
		return (java.util.Date) this.get(attr);
	}

	public java.sql.Time getTime(String attr) {
		return (java.sql.Time) this.get(attr);
	}

	public java.sql.Timestamp getTimestamp(String attr) {
		return (java.sql.Timestamp) this.get(attr);
	}

	public Double getDouble(String attr) {
		return (Double) this.get(attr);
	}

	public Float getFloat(String attr) {
		return (Float) this.get(attr);
	}

	public Boolean getBoolean(String attr) {
		return (Boolean) this.get(attr);
	}

	public java.math.BigDecimal getBigDecimal(String attr) {
		return (java.math.BigDecimal) this.get(attr);
	}

	public byte[] getBytes(String attr) {
		return (byte[]) this.get(attr);
	}

	public Number getNumber(String attr) {
		return (Number) this.get(attr);
	}

	public String[] getAttrNames() {
		Set<K> attrNameSet = this.keySet();
		return attrNameSet.toArray(new String[attrNameSet.size()]);
	}

	public Object[] getAttrValues() {
		Collection<V> attrValueCollection = values();
		return attrValueCollection.toArray(new Object[attrValueCollection.size()]);
	}

	@SuppressWarnings("unchecked")
	public static FormMap<String, Object> toHashMap(Object parameterObject) {
		FormMap<String, Object> froMmap = (FormMap<String, Object>) parameterObject;
		try {
			String name = parameterObject.getClass().getName();
			Class<?> clazz = Class.forName(name);
			boolean flag = clazz.isAnnotationPresent(FormMapTableName.class);
			if (flag) {
				FormMapTableName table = (FormMapTableName) clazz.getAnnotation(FormMapTableName.class);
				froMmap.put("ly_table", table.value());
			} else {
				throw new NullPointerException("在" + name + " 没有找到数据库表对应该的注解!");
			}
			return froMmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return froMmap;
	}
}
