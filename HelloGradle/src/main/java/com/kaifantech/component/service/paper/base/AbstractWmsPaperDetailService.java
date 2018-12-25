package com.kaifantech.component.service.paper.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.mappings.base.WmsPaperDetailMapper;
import com.ytgrading.annotation.FormMapTableName;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.AppTool;

public abstract class AbstractWmsPaperDetailService<TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>, TF extends FormMap<String, Object>> {

	public abstract WmsPaperDetailMapper<TD, TM, TF> getMapper();

	public List<TD> find(TD bean) {
		return getMapper().find(bean);
	}

	public abstract TD createDetailObj();

	public abstract FormMap<String, Object> createFormMap();

	public List<TD> findByPaperid(String paperid) {
		if (AppTool.isNull(paperid)) {
			return null;
		}
		TD bean = createDetailObj();
		bean.setPaperid(paperid);
		List<TD> list = getMapper().find(bean);
		return list == null ? null : list;
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TD> findById(String id) {
		if (AppTool.isNull(id)) {
			return null;
		}
		TD bean = createDetailObj();
		bean.setId(id);
		List<TD> list = find(bean);
		return list == null ? null : list;
	}

	public <TT extends WmsPaperDetailBean> int updateSequence(List<TT> list) {
		int i = 0;
		for (TT bean : list) {
			i += jdbcTemplate.update("update " + getTableName() + " set Sequence= " + bean.getSequence() + " where id='"
					+ bean.getId() + "'");
		}
		return i;
	}

	public <TT extends WmsPaperDetailBean> int updateOpFlagTo(List<TT> list, String opFlag) {
		int i = 0;
		for (TT bean : list) {
			i += updateTo(bean, opFlag);
		}
		return i;
	}

	public <TT extends WmsPaperDetailBean> int updateOpFlagTo(TT bean, String opFlag) {
		int i = 0;
		i += updateTo(bean, opFlag);
		return i;
	}

	private <TT extends WmsPaperDetailBean> int updateTo(TT bean, String targetFlag) {
		return jdbcTemplate.update(
				"update " + getTableName() + " set opflag= '" + targetFlag + "' where id='" + bean.getId() + "'");
	}

	private String getTableName() {
		String tableName = "";
		try {
			String name = createFormMap().getClass().getName();
			Class<?> clazz;
			clazz = Class.forName(name);
			boolean flag = clazz.isAnnotationPresent(FormMapTableName.class);
			if (flag) {
				FormMapTableName table = (FormMapTableName) clazz.getAnnotation(FormMapTableName.class);
				tableName = table.value();
			} else {
				throw new NullPointerException("在" + name + " 没有找到数据库表对应该的注解!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tableName;
	}
}