package com.ytgrading.dao;

import com.ytgrading.dto.WalletRemit;
import com.ytgrading.dto.WalletRemitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletRemitMapper {
    int countByExample(WalletRemitExample example);

    int deleteByExample(WalletRemitExample example);

    int deleteByPrimaryKey(String id);

    int insert(WalletRemit record);

    int insertSelective(WalletRemit record);

    List<WalletRemit> selectByExample(WalletRemitExample example);

    WalletRemit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WalletRemit record, @Param("example") WalletRemitExample example);

    int updateByExample(@Param("record") WalletRemit record, @Param("example") WalletRemitExample example);

    int updateByPrimaryKeySelective(WalletRemit record);

    int updateByPrimaryKey(WalletRemit record);
}