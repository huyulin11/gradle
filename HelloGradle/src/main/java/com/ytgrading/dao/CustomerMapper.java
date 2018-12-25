package com.ytgrading.dao;


import com.ytgrading.dto.Users;
import com.ytgrading.dto.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

	
	/**
	 * 获得关键字查询所得到的用户总数
	 * 
	 * @param s_Mobile
	 * @param s_Mail
	 * @param s_UserCode
	 * @param s_Name
	 * @return
	 */
	int countUsersByKeywords(@Param("s_Mobile") String s_Mobile,
			@Param("s_Mail") String s_Mail,
			@Param("s_UserCode") int s_UserCode,
			@Param("s_Name") String s_Name);
	/**
	 * 通过关键字查询用户
	 * 
	 * @param s_Mobile
	 * @param s_Mail
	 * @param s_UserCode
	 * @param s_Name
	 * @return
	 */
	List<Users> searchLimitedUsersByKeywords(@Param("s_Mobile") String s_Mobile,
			@Param("s_Mail") String s_Mail,
			@Param("s_UserCode") int s_UserCode,
			@Param("s_Name") String s_Name, @Param("pagenum") int pagenum,
			@Param("pageSize") int pageSize);
	
	List<Users> searchUsersByKeywords(@Param("s_Mobile") String s_Mobile,
			@Param("s_Mail") String s_Mail,
			@Param("s_UserCode") int s_UserCode,
			@Param("s_Name") String s_Name);

	String getUsercodeById(String id);
	
	String getRegDateById(String id);
	
	String getUserDefaultMobileById(String id);
	
	String getUserDefaultMailById(String id);
	
	Users getUserById(String id);
	
	/**
	 * 修改用户基本信息
	 */
	int updatePersonInfo(@Param("id") String id, @Param("name") String name,
			@Param("gender") String gender, @Param("birthday") String birthday,
			@Param("documenttype") String documenttype,
			@Param("documentcode") String documentcode,
			@Param("title") String title, @Param("remark") String remark);
			
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UserExample example);

    Users selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UserExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    /**
     *获取用户信息
     * @param user
     * @return
     */
    List<Users> getUserList(@Param("name")String name,@Param("usercode")String usercode,@Param("loginname")String loginname);
    /**
     * 根据用户编号查询用户信息
     */
    Users getByUserno(Integer usercode);
    Users getByUserid(String userid);
}