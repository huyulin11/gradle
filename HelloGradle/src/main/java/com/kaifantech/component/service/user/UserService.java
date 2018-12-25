package com.kaifantech.component.service.user;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.entity.UserFormMap;
import com.kaifantech.entity.UserGroupsFormMap;
import com.ytgrading.erp.util.PasswordHelper;
import com.kaifantech.mappings.ErpUserMapper;
import com.ytgrading.util.Common;
import com.ytgrading.util.MD5;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Service
public class UserService {
	@Inject
	private ErpUserMapper userMapper;

	public void doAddEntity(UserFormMap userFormMap, String txtGroupsSelect) throws Exception {
		userFormMap.put("txtGroupsSelect", txtGroupsSelect);
		userFormMap.set("password", userFormMap.get("password").toString());
		userFormMap.set("md5password", new MD5().GetMD5Code(userFormMap.get("password").toString()));
		new PasswordHelper().encryptPassword(userFormMap);
		userMapper.addEntity(userFormMap);// 新增后返回新增信息
		if (!Common.isEmpty(txtGroupsSelect)) {
			String[] txt = txtGroupsSelect.split(",");
			UserGroupsFormMap userGroupsFormMap = new UserGroupsFormMap();
			for (String roleId : txt) {
				userGroupsFormMap.put("userId", userFormMap.get("id"));
				userGroupsFormMap.put("roleId", roleId);
				userMapper.addEntity(userGroupsFormMap);
			}
		}
	}

	public void doAddEntity(String userName, String accountName, String txtGroupsSelect) throws Exception {
		UserFormMap userFormMap = new UserFormMap();
		userFormMap.set("password", "888888");
		userFormMap.set("userName", userName);
		userFormMap.set("accountName", accountName);
		userFormMap.set("locked", 1);
		doAddEntity(userFormMap, txtGroupsSelect);
	}

}