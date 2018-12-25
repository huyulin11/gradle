package com.ytgrading.dao;

import com.ytgrading.dto.LogisticsPack;
import com.ytgrading.dto.LogisticsPackExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LogisticsPackMapper {
    int countByExample(LogisticsPackExample example);

    int deleteByExample(LogisticsPackExample example);

    int deleteByPrimaryKey(String id);

    int insert(LogisticsPack record);

    int insertSelective(LogisticsPack record);

    List<LogisticsPack> selectByExample(LogisticsPackExample example);

    LogisticsPack selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LogisticsPack record, @Param("example") LogisticsPackExample example);

    int updateByExample(@Param("record") LogisticsPack record, @Param("example") LogisticsPackExample example);

    int updateByPrimaryKeySelective(LogisticsPack record);

    int updateByPrimaryKey(LogisticsPack record);
    /**
     *  获取包裹登记记录
     * @param logisticsPack
     * @param page
     * @param pagesize
     * @return
     */
    List<LogisticsPack> getPackList(LogisticsPack logisticsPack);
    /**
     * 获取包裹登记总记录数
     * @param logisticsPack
     * @return
     */
    int getPackCount (LogisticsPack logisticsPack);
    /**
     * 根据包裹编号查询该包裹对象
     * @param packno
     * @return
     */
    LogisticsPack  selectLogisticsPackByPackno(Integer packno);
    
    LogisticsPack getPackageInfo(String requestcode);
    
}