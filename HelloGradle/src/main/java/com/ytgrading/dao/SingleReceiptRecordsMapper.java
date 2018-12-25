package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.BackRequest;
import com.ytgrading.dto.Employee;
import com.ytgrading.dto.SingleReceiptRecords;

public interface SingleReceiptRecordsMapper {
	int deleteByPrimaryKey(String id);

	int insert(SingleReceiptRecords record);

	int insertSelective(SingleReceiptRecords record);

	SingleReceiptRecords selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SingleReceiptRecords record);

	int updateByPrimaryKey(SingleReceiptRecords record);

	SingleReceiptRecords getSingleReceiptRecordsByReqcode(int requestcode);

	SingleReceiptRecords getSRRByReqcode(int requestcode);

	SingleReceiptRecords getRevokeSRRByReqcode(int requestcode);

	// 查询回退request信息String guestMobile, String guestName,
	// String guestCode, String dealState, int page, int pageSize
	List<BackRequest> selectBackRequest(
			@Param("requestcode") Integer requestcode,
			@Param("guestMobile") String guestMobile,
			@Param("guestName") String guestName,
			@Param("guestCode") String guestCode,
			@Param("dealState") String dealState, @Param("page") int page,
			@Param("pagesize") int pagesize);

	// int selectAll();
	int selectAll(@Param("requestcode") Integer requestcode,
			@Param("guestMobile") String guestMobile,
			@Param("guestName") String guestName,
			@Param("guestCode") String guestCode,
			@Param("dealState") String dealState);

	int updateBackReqState(@Param("requestcode") int requestcode);

	int updateBackReqowner(@Param("requestcode") int requestcode,
			@Param("operater") int operater);

	int updateSRR(SingleReceiptRecords singleReceiptRecords);

	int notback(SingleReceiptRecords singleReceiptRecords);

	Employee getEmpById(int id);
}