package com.kaifantech.component.controller.base;

import java.lang.reflect.ParameterizedType;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.util.Common;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.AppTool;

public interface IBaseController<TT extends FormMap<String, Object>> {

	@SuppressWarnings("unchecked")
	default Class<TT> getTClass() {
		return (Class<TT>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	default TT getFormMap() {
		return getFormMap(getTClass());
	}

	public PageView getPageView();

	default TT toFormMap(TT t, String pageNow, String pageSize) {
		FormMap<String, Object> formMap = (FormMap<String, Object>) t;
		formMap.put("paging", getPageView(pageNow, pageSize));
		return t;
	}

	default TT toFormMap(TT t) {
		FormMap<String, Object> formMap = (FormMap<String, Object>) t;
		formMap.put("paging", getPageView("1", "10"));
		return t;
	}

	default String getParaValue(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request.getParameter(key);
	}

	public PageView getPageView(String pageNow, String pageSize);

	default String getParam(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request.getParameter(key);
	}

	default String[] getParaValues(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request.getParameterValues(key);
	}

	@SuppressWarnings("unchecked")
	default <T> T getFormMap(Class<T> clazz) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Enumeration<String> en = request.getParameterNames();
		T tParent = null;
		try {
			tParent = clazz.newInstance();
			FormMap<String, Object> mapParent = (FormMap<String, Object>) tParent;
			while (en.hasMoreElements()) {
				String nms = en.nextElement().toString();
				String mname = tParent.getClass().getSimpleName().toUpperCase();
				if (nms.toUpperCase().startsWith(mname)) {
					if (nms.endsWith("[]")) {
						String[] as = request.getParameterValues(nms);
						nms = nms.substring(mname.length() + 1);
						mapParent.put(nms, as);
					} else if (isArrayParam(nms)) {
						String num = nms.substring(nms.lastIndexOf('[') + 1, nms.lastIndexOf(']'));
						Map<String, T> sonMap = (Map<String, T>) mapParent.get("list");
						if (AppTool.isNull(sonMap)) {
							sonMap = new HashMap<String, T>();
						}
						T tSon = sonMap.get(num);
						if (AppTool.isNull(tSon)) {
							tSon = clazz.newInstance();
						}
						FormMap<String, Object> mapSon = (FormMap<String, Object>) tSon;
						String as = request.getParameter(nms);
						nms = nms.substring(mname.length() + 1, nms.lastIndexOf('['));
						mapSon.set(nms, as);
						sonMap.put(num, tSon);
						mapParent.put("list", sonMap);
					} else {
						String as = request.getParameter(nms);
						nms = nms.substring(mname.length() + 1);
						if (!Common.isEmpty(as)) {
							mapParent.put(nms, as);
						}
					}
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return tParent;
	}

	default boolean isArrayParam(String param) {
		Pattern pattern = Pattern.compile("[\\w|.]*\\[[0-9]*\\]");
		Matcher matcher = pattern.matcher(param);
		return matcher.matches();
	}

}