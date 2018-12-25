package com.ytgrading.dao;

import com.ytgrading.bean.UserMailSel;
import com.ytgrading.dto.UserMail;
import com.ytgrading.dto.UserMailExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThisUserMailMapper {
    int insertUserMail(UserMail record);
    /**
     * 获取手机号码总数
     * @return
     */
    int userMailCount (UserMail userMail);
    /**
     * 查询所有的用户电话列表
     * @param userid
     * @return
     */
    List<UserMail> selectUserMailList (UserMailSel userMailsel);
    /**
     * 删除选中行记录
     * @param scope
     * @return
     */
    int delSelectedUserMail (@Param("scope") String[] scope);
    /**
     * 更新当前所选记录的isdefault和user表中defaultmobile
     * @param userTelId
     * @return
     */
    int mUpdateCurDefaultUserMail (@Param("userMailId") String userMailId,@Param("userid") String userid);
    /**
     * 设置原来默认的号码为非默认
     * @param userTelId
     * @return
     */
    int mUpdateOldDefault(@Param("userMailId") String userMailId,@Param("userid") String userid);
    /**
     * 更新原来为默认的号码默认状态为0，同时更新user表中默认号码
     * 用于新建一个设为默认的手机号码
     * @param userMobileId
     * @return
     */
    int mUpdateOldDefaultUserMail(@Param("userMailId") String userMailId,@Param("userid")String userid);
    /**
     * 查询有效的(未被删除的)默认号码总数
     * 数量为1，则user表defaultmobile存在，若为0，需清除defaultmobile
     * @return
     */
    int validDefaultUserMailCount(@Param("userid") String userid);
    /**
     * 去除user表中的默认手机号码(当删除手机号码为默认号码时调用)
     * @return
     */
    int removeDefaultUserMail(@Param("userid") String userid);
    
    int updatemailApprove(@Param("userid") String userid ,@Param("no") String no);
    int updateUserDefaultMail(@Param("mail")String mail,@Param("userid") String userid);
    List<UserMail> checkMailApprove(@Param("mailadr") String mailadr);
    
    UserMail selectMailByUserid(@Param("userid") String userid);
}