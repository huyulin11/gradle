package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.BackRequestCoin;
import com.ytgrading.dto.BackRequestCoinScore;
import com.ytgrading.dto.BackRequestDetail;
import com.ytgrading.dto.BackRequestLogistics;
import com.ytgrading.dto.BackStock;
import com.ytgrading.bean.RequestDetailBean;
import com.ytgrading.dto.RevokeRequest;
import com.ytgrading.dto.Stock;

public interface BackCoinInfoMapper {
    int deleteByPrimaryKey(String id);
    int insertSelective(BackRequestCoin record);
    BackRequestCoin selectByPrimaryKey(String id);
    int updateByPrimaryKeySelective(BackRequestCoin record);
    int updateByPrimaryKeyWithBLOBs(BackRequestCoin record);
    int updateByPrimaryKey(BackRequestCoin record);
    
    List<RequestDetailBean> getRqeustDetails(String requestid);
    int insertBackRequestDetail(BackRequestDetail backRequestDetail);	
    int insertBackRequestCoin(BackRequestCoin backRequestCoin);	
    int insertBackRequestCoinScore(BackRequestCoinScore backRequestCoinScore);	
    int insertBackRevokeReq(RevokeRequest request);
    int updateRquestState(@Param("requestcode")int requestcode,@Param("ownid")String ownid);
    //获取仓库记录
    Stock getStockbystockno(String stockno);
    //备份入库记录
    int insertBackStock(BackStock backStock);
    //删除原记录
    int delReqBackStock(String stockno);
    //备份包裹登记
    int insertBackRequestLogistics(BackRequestLogistics backRequestLogistics);
    //删除原记录
    int delReqlogistics(String stockno);
}