package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.RequestLogistics;
import com.ytgrading.dto.RequestLogisticsExample;

public interface RequestLogisticsMapper {
    int countByExample(RequestLogisticsExample example);

    int deleteByExample(RequestLogisticsExample example);

    int deleteByPrimaryKey(String id);

    int insert(RequestLogistics record);

    int insertSelective(RequestLogistics record);

    List<RequestLogistics> selectByExample(RequestLogisticsExample example);

//    RequestLogistics selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RequestLogistics record, @Param("example") RequestLogisticsExample example);

    int updateByExample(@Param("record") RequestLogistics record, @Param("example") RequestLogisticsExample example);

    int updateByPrimaryKeySelective(RequestLogistics record);

    int updateByPrimaryKey(RequestLogistics record);
    /**
     * 获取物流记录列表
     * @param requestcode
     * @param logisticsno
     * @param company
     * @param createby
     * @param timestart
     * @param timeend
     * @param page
     * @param pagesize
     * @return
     */
    List<RequestLogistics> getLogisticsList(@Param("requestcode") String requestcode,@Param("logisticsno") String logisticsno,@Param("company") String company,@Param("name")String name,
			@Param("timestart") String timestart,@Param("timeend") String timeend,@Param("page") int page,@Param("pagesize") int pagesize);
    /**
     * 获取物流总记录数
     * @param requestcode
     * @param logisticsno
     * @param company
     * @param name
     * @param timestart
     * @param timeend
     * @return
     */
    int getLogisticsListCount (@Param("requestcode") String requestcode,@Param("logisticsno") String logisticsno,@Param("company") String company,@Param("name")String name,
			@Param("timestart") String timestart,@Param("timeend") String timeend);
//   
}