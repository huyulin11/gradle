package com.ytgrading.dao;

import java.util.List;

import com.ytgrading.dto.RequestMainOpLogBean;

public interface RequestMainOpLogMapper {

	int insert(RequestMainOpLogBean requestMainOpLog);

	List<RequestMainOpLogBean> select(RequestMainOpLogBean requestMainOpLog);
}