package com.ytgrading.dao;

import com.ytgrading.dto.LogisticsTransfer;
import com.ytgrading.dto.LogisticsTransferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogisticsTransferMapper {
    int countByExample(LogisticsTransferExample example);

    int deleteByExample(LogisticsTransferExample example);

    int deleteByPrimaryKey(String id);

    int insert(LogisticsTransfer record);

    int insertSelective(LogisticsTransfer record);

    List<LogisticsTransfer> selectByExample(LogisticsTransferExample example);

    LogisticsTransfer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LogisticsTransfer record, @Param("example") LogisticsTransferExample example);
    int updateByExample(@Param("record") LogisticsTransfer record, @Param("example") LogisticsTransferExample example);

    int updateByPrimaryKeySelective(LogisticsTransfer record);

    int updateByPrimaryKey(LogisticsTransfer record);
    
    List<LogisticsTransfer> getTransferRecords(@Param("requestcode")int requestcode,@Param("operater")int operater);
}