package com.ytgrading.dao;

import com.ytgrading.bean.UserBankSel;
import com.ytgrading.dto.SysBank;
import com.ytgrading.dto.UserBank;
import com.ytgrading.dto.UserBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThisUserBankMapper{
    
    List<UserBank>	selectUserBankList(UserBankSel userBankSel);
    
    List<UserBank> selectUserBankListByUserid(String userid);   
    int getUserBankCount(UserBank userBank);    
    int delSelectedRow(@Param("scope") String[] scope);
    int updateCurDefaultUserBank(@Param("userBankId") String userBankId);
    int updateOldDefault(@Param("userBankId")String userBankId,@Param("userid")String userid);
    int updateDefaultUserBank(@Param("userid")String userid);
    int removeDefaultUserBank(@Param("userid") String userid);
    int checkBankNum(@Param("id") String id,@Param("num") String num);
    int checkInterBankNum(@Param("id") String id,@Param("num") String num);
    List<SysBank> getAllBank();
    
    public String getCNBankname(@Param("bankname")String bankname);
}