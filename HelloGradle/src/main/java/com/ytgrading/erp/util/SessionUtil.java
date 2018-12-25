package com.ytgrading.erp.util;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.kaifantech.entity.RoleFormMap;

public class SessionUtil {
	public static Object getUserId() {
		Session session = SecurityUtils.getSubject().getSession();
		Object s = session.getAttribute("userSessionId");
		return s;
	}

	@SuppressWarnings("unchecked")
	public static List<RoleFormMap> getUserRoleList() {
		Session session = SecurityUtils.getSubject().getSession();
		List<RoleFormMap> s = (List<RoleFormMap>) session.getAttribute("userRole");
		return s;
	}

	@SuppressWarnings("unchecked")
	public static String getUserRoles() {
		Session session = SecurityUtils.getSubject().getSession();
		List<RoleFormMap> s = (List<RoleFormMap>) session.getAttribute("userRole");
		StringBuffer rsb = new StringBuffer().append("(");
		for (RoleFormMap r : s) {
			rsb.append(r.get("id") + ",");
		}
		return rsb.append("-1000)").toString();
	}
}
