package com.ytgrading.dao;

import com.ytgrading.dto.UserLogin;
import com.ytgrading.dto.UserLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginUserMapper {
    int countByExample(UserLoginExample example);

    int deleteByExample(UserLoginExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    List<UserLogin> selectByExample(UserLoginExample example);

    UserLogin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserLogin record, @Param("example") UserLoginExample example);

    int updateByExample(@Param("record") UserLogin record, @Param("example") UserLoginExample example);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
    //登录验证
    UserLogin selectUser(String str);
    //验证码
    int updateByFailures(String str);
    //
    int updateByFailuresSucc(String str);
    //检查用户名是否存在
    int checkUsername(String str);
    //修改密码
    int updatepassword(UserLogin record);
    
    
}