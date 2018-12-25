package com.ytgrading.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.Pay_Wallet;
import com.ytgrading.bean.RequestBean;
import com.ytgrading.bean.RequestCoinBean;
import com.ytgrading.bean.RequestDetailBean;
import com.ytgrading.bean.Review;
import com.ytgrading.bean.TaskList;
import com.ytgrading.dto.Employee;
import com.ytgrading.dto.PayJournal;
import com.ytgrading.dto.PayRequestReceive;
import com.ytgrading.dto.Request;
import com.ytgrading.dto.SysCityWithBLOBs;
import com.ytgrading.dto.SysDistrictWithBLOBs;
import com.ytgrading.dto.SysProvinceWithBLOBs;
import com.ytgrading.dto.UserLogin;
import com.ytgrading.dto.UserMail;
import com.ytgrading.dto.UserValidity;
import com.ytgrading.dto.Users;
import com.ytgrading.dto.WalletRefund;
import com.ytgrading.dto.WalletRemit;

public interface AloneMapper {
	// 注册插入user
	int insertuser(Users record);

	// 注册插入user_login
	int insertuser_login(UserLogin record);

	// 登录验证
	UserLogin selectUser(@Param("str") String str);

	UserLogin checkemailaddress(@Param("loginname") String loginname,
			@Param("id") String id);

	List<UserLogin> getUserLogin(@Param("userid") String userid);

	UserLogin selectUserLogin(@Param("str") String str);

	// 登录验证
	UserValidity selectByCode(@Param("name") String name);

	// 验证码
	int updateByFailures(@Param("str") String str);

	//
	int updateByFailuresSucc(@Param("str") String str);

	// 检查用户名是否存在
	int checkUsername(@Param("str") String str);

	// 修改密码
	int updatepassword(UserLogin record);

	// 修改密码
	int updateUserpassword(Users record);

	// 邮件插入
	int insertUserValidity(UserValidity record);

	// 快速注册插入邮箱
	int insertFastEmail(UserMail email);

	// 获取验证码次数
	int sendmsgnum(@Param("starttime") String starttime,
			@Param("loginname") String loginname, @Param("type") String type);

	// 检查邮件激活时间是否过期
	UserValidity selectByInfo(@Param("name") String name, @Param("id") String id);

	// 检查邮件激活时间是否过期
	UserValidity selectInfo(@Param("uuid") String uuid);

	// 取user对象
	Users getUser(@Param("id") String id);

	// 删除邮件插入
	int deleteByPrimaryKey(String id);

	// 插入一条退款记录
	int insertWallet_refund(WalletRefund record);

	// 插入一条汇款记录
	int insertWallet_remit(WalletRemit record);

	// 查找支付金额
	List<PayRequestReceive> selectAmount(@Param("id") String[] id);

	// 修改pay_request_receive状态
	int updateReceive(@Param("id") String[] id);

	// 查询request
	List<Request> selectByid(@Param("id") String[] id);

	// 查询request（包裹）
	List<TaskList> selectPackageByOwnid(@Param("ownid") int ownid,
			@Param("page") int page, @Param("pagesize") int pagesize,
			@Param("billnumber") int billnumber, @Param("flag") String flag,
			@Param("entityType") int entityType);

	// 查询request
	List<TaskList> selectByOwnid(@Param("ownid") int ownid,
			@Param("page") int page, @Param("pagesize") int pagesize,
			@Param("billnumber") int billnumber, @Param("flag") String flag,
			@Param("entityType") int entityType);

	// 查询request
	List<TaskList> selectByOwnid1(@Param("ownid") int ownid,
			@Param("page") int page, @Param("pagesize") int pagesize);

	// 查询request size（包裹）
	int selectPackageAll(@Param("ownid") int ownid,
			@Param("billnumber") int billnumber, @Param("flag") String flag,
			@Param("entityType") int entityType);

	// 查询request size
	int selectAll(@Param("ownid") int ownid,
			@Param("billnumber") int billnumber, @Param("flag") String flag,
			@Param("entityType") int entityType);

	int selectAll1(@Param("ownid") int ownid);

	// 查询request对象
	Request selectByRequest(@Param("id") String id);

	// 查询city
	SysCityWithBLOBs city(@Param("id") int id);

	// 查询province
	SysProvinceWithBLOBs province(@Param("id") int id);

	// 查询district
	SysDistrictWithBLOBs district(@Param("id") int id);

	// 查询金银币request_detail
	List<Review> selectDetail(@Param("id") String id);

	// 修改request的备注字段
	int updateRequestRemark(RequestBean rb);

	// 修改request的confirmstatus字段
	int updateRequestStatus(@Param("id") String id);

	int updateRequestDetail(@Param("id") String id, @Param("num") int num,
			@Param("evaluate") BigDecimal evaluate);

	// RequestCoin查找数据
	RequestCoinBean selectRequestCoin(@Param("coincode") String coincode);

	// RequestCoin查找数据
	List<RequestCoinBean> selectRequestdetail(
			@Param("requestdetailid") String requestdetailid);

	// RequestCoin插入数据
	int insertRequestCoin(@Param("list") List<RequestCoinBean> list,
			@Param("entitytype") Integer entitytype);

	// RequestCoin删除数据
	int deleteRequestCoin(@Param("requestid") String requestid);

	// RequestCoin取得coincode
	String selectMaxRequestcode(String requestid);

	// 检查Requestdetail中是否含有index
	List<RequestDetailBean> selectRequestDindex(
			@Param("numindex") int numindex, @Param("id") String id);

	// 检查RequestCoin中是否含有requestdetailid
	List<RequestCoinBean> selectRequestCoinid(String requestdetailid);

	// 更改状态
	int updateSucc(String requestid);

	// 更新Detail
	int updateRDetail(@Param("id") String id, @Param("amount") int amount,
			@Param("totalreqcost") BigDecimal totalreqcost,
			@Param("totalevaluate") BigDecimal totalevaluate);

	// 查找Detail
	RequestDetailBean selectByPrimaryKey(@Param("id") String id);

	// 查找Employee
	Employee selectEmployee(@Param("id") int id);

	// 付款记录
	int insertSelective(PayJournal record);

	PayJournal selectPayJournal(String payid);

	int updatePayJournal(@Param("id") String id);

	int updatePayJournalZero(@Param("id") String id);

	List<Pay_Wallet> checkPayMent(@Param("id") String id);

	Date getUpdateTime(@Param("requestcode") String requestcode);

	/**
	 * 获取当前申请单的内部状态
	 * 
	 * @param requestcode
	 * @return
	 */
	String selReqInterStatus(@Param("requestcode") String requestcode);

	int reqInvalid(String requestcode);

	/**
	 * 获取当前申请单的外部状态
	 * 
	 * @param requestcode
	 * @return
	 */
	String getReqStatus(@Param("requestcode") String requestcode);

	int updateUserValidity(@Param("id") String id);

	int updateUserValidityStruts(@Param("id") String id);

	List<UserValidity> selectUserValidity(@Param("loginname") String loginname,
			@Param("struts") String struts);

	/*
	 * 钱币的具体状态查询
	 */
	List<TaskList> findreqcoinbycode(@Param("coincode") String coincode);

	// 获取最后一条数据
	Users geLasttUser(@Param("prepixUsercode") String prepixUsercode);
}
