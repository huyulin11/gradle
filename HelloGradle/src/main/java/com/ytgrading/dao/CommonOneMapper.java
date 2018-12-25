package com.ytgrading.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.CoinInfo;
import com.ytgrading.bean.HandRecord;
import com.ytgrading.bean.RequestSearch;
import com.ytgrading.bean.Statement;
import com.ytgrading.bean.TransferGoods;
import com.ytgrading.bean.UserMobileSel;
import com.ytgrading.bean.UserTelSel;
import com.ytgrading.bean.ReqForPay;
import com.ytgrading.dto.LogisticsPack;
import com.ytgrading.dto.LogisticsTransfer;
import com.ytgrading.dto.Ratingreason;
import com.ytgrading.dto.Request;
import com.ytgrading.bean.RequestCoinBean;
import com.ytgrading.dto.RequestCoinScore;
import com.ytgrading.dto.RequestReasonData;
import com.ytgrading.dto.Searchrecord;
import com.ytgrading.dto.StockOut;
import com.ytgrading.dto.SysI18nData;
import com.ytgrading.dto.Users;
import com.ytgrading.dto.UserMobile;
import com.ytgrading.dto.UserTel;

public interface CommonOneMapper {
	/*
	 * System
	 * default------------------------------------------------------------
	 * --------start
	 */
	/**
	 * 根据用户id查询该用户对象
	 * 
	 * @param id
	 * @return
	 */
	Users selectUserById(String id);

	/**
	 * 新添一条手机记录
	 * 
	 * @param record
	 * @return
	 */
	int insertMobile(UserMobile record);

	/**
	 * 新添一条固话记录
	 * 
	 * @param record
	 * @return
	 */
	int insertTel(UserTel record);

	/*
	 * System
	 * default------------------------------------------------------------
	 * ----------end
	 */

	/*
	 * UserMobile----------------------------------------------------------------
	 * --------start
	 */

	/**
	 * 获取手机号码总数
	 * 
	 * @return
	 */
	int userMobileCount(UserMobile usermobile);

	/**
	 * 查询所有的用户电话列表
	 * 
	 * @param userid
	 * @return
	 */
	List<UserMobile> selectUserMobileList(UserMobileSel usermobilesel);

	/**
	 * 删除选中行记录
	 * 
	 * @param scope
	 * @return
	 */
	int delSelectedMobile(@Param("scope") String[] scope);

	/**
	 * 更新当前所选记录的isdefault和user表中defaultmobile
	 * 
	 * @param userTelId
	 * @return
	 */
	int mUpdateCurDefaultAndUserTab(@Param("userMobileId") String userMobileId,
			@Param("userid") String userid);

	/**
	 * 设置原来默认的号码为非默认
	 * 
	 * @param userTelId
	 * @return
	 */
	int mUpdateOldDefault(@Param("userMobileId") String userMobileId,
			@Param("userid") String userid);

	/**
	 * 更新原来为默认的号码默认状态为0，同时更新user表中默认号码 用于新建一个设为默认的手机号码
	 * 
	 * @param userMobileId
	 * @return
	 */
	int mUpdateOldDefaultAndUserTab(@Param("userMobileId") String userMobileId,
			@Param("userid") String userid);

	/**
	 * 查询有效的(未被删除的)默认号码总数 数量为1，则user表defaultmobile存在，若为0，需清除defaultmobile
	 * 
	 * @return
	 */
	int validDefaultMobileCount(@Param("userid") String userid);

	/**
	 * 去除user表中的默认手机号码(当删除手机号码为默认号码时调用)
	 * 
	 * @return
	 */
	int removeDefaultMobile(@Param("userid") String userid);

	int updateMobileApprove(@Param("userid") String userid,
			@Param("no") String no);

	/**
	 * 检查该用户是否已经添加过该条手机号码记录
	 * 
	 * @param userid
	 * @param telephone
	 * @return
	 */
	int checkMobile(@Param("userid") String userid,
			@Param("telephone") String telephone);

	/*
	 * UserMobile----------------------------------------------------------------
	 * ----------end
	 */

	/*
	 * UserTel--------------------------------------------------------------------
	 * -------start
	 */

	/**
	 * 获取固话号码总数
	 * 
	 * @return
	 */
	int userTelCount(UserTel usertel);

	/**
	 * 查询所有的用户固话列表
	 * 
	 * @param userid
	 * @return
	 */
	List<UserTel> selectUserTelList(UserTelSel usertelsel);

	/**
	 * 删除选中行记录
	 * 
	 * @param scope
	 * @return
	 */
	int delSelectedTel(@Param("scope") String[] scope);

	/**
	 * 查询有效的(未被删除的)默认固话总数 数量为1，则user表defaulttel存在，若为0，需清除defaulttel
	 * 
	 * @return
	 */
	int validDefaultTelCount(@Param("userid") String userid);

	/**
	 * 去除user表中的默认固话号码(当删除固话号码为默认号码时调用)
	 * 
	 * @return
	 */
	int removeDefaultTel(@Param("userid") String userid);

	/**
	 * 更新当前所选记录的isdefault和user表中defaulttel
	 * 
	 * @param userTelId
	 * @return
	 */
	int tUpdateCurDefaultAndUserTab(@Param("userTelId") String userTelId,
			@Param("userid") String userid);

	/**
	 * 设置原来默认的固话号码为非默认
	 * 
	 * @param userTelId
	 * @return
	 */
	int tUpdateOldDefault(@Param("userTelId") String userTelId,
			@Param("userid") String userid);

	/**
	 * 更新原来为默认的号码默认状态为0，同时更新user表中默认号码 用于新建一个设为默认的固话号码
	 * 
	 * @param userTelId
	 * @return
	 */
	int tUpdateOldDefaultAndUserTab(@Param("userTelId") String userTelId,
			@Param("userid") String userid);

	/*
	 * UserTel--------------------------------------------------------------------
	 * ---------end
	 */
	/*
	 * personalinfo--------------------------------------------------------------
	 * ------start
	 */
	/**
	 * 修改用户基本信息
	 * 
	 * @param id
	 * @param name
	 * @param gender
	 * @param birthday
	 * @param documenttype
	 * @param documentcode
	 * @param nickname
	 *            (title)
	 * @param remark
	 * @return
	 */
	int updatePersonInfo(@Param("id") String id, @Param("name") String name,
			@Param("gender") String gender, @Param("birthday") String birthday,
			@Param("documenttype") String documenttype,
			@Param("documentcode") String documentcode,
			@Param("title") String title, @Param("remark") String remark);

	/**
	 * 检查该用户是否已经添加过该条固话记录
	 * 
	 * @param userid
	 * @param telephone
	 * @return
	 */
	int checkTel(@Param("userid") String userid,
			@Param("telephone") String telephone);

	/*
	 * personalinfo--------------------------------------------------------------
	 * ---------end
	 */
	/*
	 * coindetail----------------------------------------------------------------
	 * -------start
	 */
	/**
	 * 通过关键字查询钱币信息列表
	 * 
	 * @param keyWord
	 * @return
	 */
	List<RequestCoinBean> getRequestCoinList(@Param("keyWord") String keyWord);

	List<RequestCoinBean> getOneRequestCoin(@Param("coincode") String coincode);

	/**
	 * 通过关键字查询钱币信息列表
	 * 
	 * @param keyWord
	 * @return
	 */
	List<RequestCoinBean> getRequestCoinList(@Param("keyWord") String keyWord,
			@Param("page") int page, @Param("pagesize") int pagesize);

	/**
	 * 通过关键字查询钱币记录总数
	 * 
	 * @param keyWord
	 * @return
	 */
	int getRequestCoinCount(@Param("keyWord") String keyWord);

	/**
	 * 通过关键字查询钱币信息列表
	 * 
	 * @param keyWord
	 * @return
	 */
	List<RequestCoinBean> CoinList(@Param("keyWordArr") String[] keyWordArr,
			@Param("page") int page, @Param("pagesize") int pagesize);

	/**
	 * 通过关键字查询钱币记录总数
	 * 
	 * @param keyWord
	 * @return
	 */
	int CoinCount(@Param("keyWordArr") String[] keyWordArr);

	/*
	 * coindetail----------------------------------------------------------------
	 * ----------end
	 */
	/*
	 * usermanage----------------------------------------------------------------
	 * --------start
	 */
	/**
	 * 通过手机号码查询用户id
	 */
	String getIdByMobile(@Param("mobile") String mobile);

	/*
	 * usermanage----------------------------------------------------------------
	 * ----------end
	 */
	/**
	 * 通过关键字查询用户
	 * 
	 * @param s_Mobile
	 * @param s_Mail
	 * @param s_UserCode
	 * @param s_Name
	 * @return
	 */
	public List<Users> searchUserByKeyWord(@Param("s_Mobile") String s_Mobile,
			@Param("s_Mail") String s_Mail,
			@Param("s_UserCode") int s_UserCode,
			@Param("s_Name") String s_Name, @Param("pagenum") int pagenum,
			@Param("pageSize") int pageSize);
	
	public List<Users> searchUserOp(@Param("s_Mobile") String s_Mobile,
			@Param("s_Mail") String s_Mail,
			@Param("s_UserCode") int s_UserCode,
			@Param("s_Name") String s_Name);

	/**
	 * 获得关键字查询所得到的用户总数
	 * 
	 * @param s_Mobile
	 * @param s_Mail
	 * @param s_UserCode
	 * @param s_Name
	 * @return
	 */
	int userCountByKeyWord(@Param("s_Mobile") String s_Mobile,
			@Param("s_Mail") String s_Mail,
			@Param("s_UserCode") int s_UserCode, @Param("s_Name") String s_Name);

	/**
	 * 插入一条搜索记录
	 * 
	 * @param searchrecord
	 * @return
	 */
	int insertSearchRecord(Searchrecord searchrecord);

	/**
	 * 通过物流编号查找申请单（申请单可多个），用于提取用户编号和申请单号
	 * 
	 * @param packcode
	 * @return
	 */
	List<Request> getRequestListByPackCode(@Param("packcode") String packcode);

	/**
	 * 通过已经认证的手机号码获取用户
	 * 
	 * @return
	 */
	Users getUserByApprovedTel(@Param("tel") String tel);

	/**
	 * 插入一条包裹信息登记记录
	 * 
	 * @param record
	 * @return
	 */
	int insertPackageInfo(LogisticsPack logisticspack);

	/**
	 * 通过id获取包裹编号
	 * 
	 * @param id
	 * @return
	 */
	int getPackNoById(@Param("id") String id);

	/**
	 * 通过包裹编号查询包裹信息
	 * 
	 * @return
	 */
	public List<TransferGoods> getPackByNo(@Param("packno") int packno);

	/**
	 * 通过申请单号查询申请单信息
	 * 
	 * @param requestcode
	 * @return
	 */
	public List<TransferGoods> getRequestByNo(
			@Param("requestcode") int requestcode);

	/**
	 * 改变包裹（未拆分）持有人
	 * 
	 * @param packno
	 * @param ownid
	 * @return
	 */
	int changePackOwner(@Param("packno") int packno,
			@Param("ownid") String ownid);
	/**
	 * 查询搜索币种的数量
	 * 
	 * @param entityType
	 * @return
	 */
	
	String getSearchCoinNum(@Param("requestCode") String requestCode);
	
	String getSearchEntityType(@Param("requestCode") String requestCode);
	
	/**
	 * 查询币种的数量
	 * 
	 * @param entityType
	 * @return
	 */
	String getCoinNum(@Param("entityType") String entityType);
	
	String getCoinServiceNum(@Param("entityType") String entityType);
	
	String getCoinCommonNum(@Param("entityType") String entityType,
			@Param("status1") String status1,
			@Param("status2") String status2);
	String getCoinRareNum(@Param("entityType") String entityType,
			@Param("status1") String status1,
			@Param("status2") String status2,
			@Param("status3") String status3);
	String CoinInternalstatesNum(@Param("internalstates") String internalstates);

	/**
	 * 更改申请单所属人
	 * 
	 * @param requestcode
	 * @param ownid
	 * @return
	 */
	int changeRequestOwner(@Param("requestcode") int requestcode,
			@Param("ownid") String ownid);

	/**
	 * 新添一条交接记录
	 * 
	 * @param logisticstransfer
	 * @return
	 */
	int addTransferRecord(LogisticsTransfer logisticstransfer);

	/**
	 * 查询交接物品信息列表（客服人员）
	 * 
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsListInService(
			@Param("page") int page, @Param("pagesize") int pagesize);
	
	public List<TransferGoods> getTransferGoodsTypeInService(
			@Param("page") int page, @Param("pagesize") int pagesize, @Param("entityType") String entityType);
	
	public List<TransferGoods> getCheckTransferGoodsListInService(
			@Param("page") int page, @Param("pagesize") int pagesize, @Param("entityType") String entityType);

	/**
	 * 查询交接物品总数（客服人员）
	 * 
	 * @return
	 */
	int getTransferGoodsCountInService();
	
	int getTransferGoodsCountTypeInService(@Param("entityType") String entityType);
	
	int getCheckTransferGoodsCountInService(@Param("entityType") String entityType);

	/**
	 * 查询交接物品信息列表（制图、评审、打盒）
	 * 
	 * @param status1
	 * @param status2
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsListInCommon(
			@Param("page") int page, @Param("pagesize") int pagesize, @Param("status1") String status1,
			@Param("status2") String status2);
	
	public List<TransferGoods> getTransferGoodsTypeInCommon(
			@Param("page") int page, @Param("pagesize") int pagesize,
			@Param("status1") String status1,
			@Param("status2") String status2,@Param("entityType") String entityType);
	
	public List<TransferGoods> getCheckTransferGoodsListInCommon(
			@Param("page") int page, @Param("pagesize") int pagesize,
			@Param("status1") String status1,
			@Param("status2") String status2,@Param("entityType") String entityType);
	
	/**
	 * 查询交接物品信息列表（打盒制图）
	 * 
	 * @param status1
	 * @param status2
	 * @param status3
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsListInRare(
			@Param("page") int page, @Param("pagesize") int pagesize, @Param("status1") String status1,
			@Param("status2") String status2,@Param("status3") String status3);
	
	public List<TransferGoods> getTransferGoodsTypeInRare(
			@Param("page") int page, @Param("pagesize") int pagesize,
			@Param("status1") String status1,
			@Param("status2") String status2,
			@Param("status3") String status3,
			@Param("entityType") String entityType);
	
	public List<TransferGoods> getCheckTransferGoodsListInRare(
			@Param("page") int page, @Param("pagesize") int pagesize,
			@Param("status1") String status1,
			@Param("status2") String status2,
			@Param("status3") String status3,
			@Param("entityType") String entityType);
	
	/**
	 * 根据内部状态查询交接物品信息列表
	 * 
	 * @param status1
	 * @param status2
	 * @param status3
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsInternalstatesList(
			@Param("page") int page, @Param("pagesize") int pagesize, @Param("internalstates") String internalstates);

	/**
	 * 获取交接物品总数（制图、评审、打盒）
	 * 
	 * @param status1
	 * @param status2
	 * @return
	 */
	int getTransferGoodsCountInCommon(
			@Param("status1") String status1, @Param("status2") String status2);
	
	int getTransferGoodsCountTypeInCommon(@Param("status1") String status1,
			@Param("status2") String status2,@Param("entityType") String entityType);
	
	int getCheckTransferGoodsCountInCommon(@Param("status1") String status1,
			@Param("status2") String status2,@Param("entityType") String entityType);
	int getCheckTransferGoodsCountInInternalstates(@Param("internalstates") String internalstates);
	
	/**
	 * 获取交接物品总数（打盒制图）
	 * 
	 * @param status1
	 * @param status2
	 * @param status3
	 * @return
	 */
	int getTransferGoodsCountInRare(
			@Param("status1") String status1, @Param("status2") String status2, @Param("status3") String status3);
	
	int getTransferGoodsCountTypeInRare(@Param("status1") String status1,
			@Param("status2") String status2, @Param("status3") String status3,@Param("entityType") String entityType);
	
	int getCheckTransferGoodsCountInRare(@Param("status1") String status1,
			@Param("status2") String status2, @Param("status3") String status3,@Param("entityType") String entityType);
	
	/**
	 * 获取内部状态查询交接物品总数
	 * 
	 * @param status1
	 * @param status2
	 * @param status3
	 * @return
	 */
	int getTransferGoodsInternalstatesCount(@Param("internalstates") String internalstates);

	/**
	 * 查询交接物品信息列表（受理人员）
	 * 
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsListInHandling(
			@Param("page") int page, @Param("pagesize") int pagesize);

	public List<TransferGoods> getTransferGoodsTypeInHandling(
			@Param("page") int page, @Param("pagesize") int pagesize, @Param("entityType") String entityType);
	
	public List<TransferGoods> getCheckTransferGoodsListInHandling(
			@Param("page") int page, @Param("pagesize") int pagesize, @Param("entityType") String entityType);
	/**
	 * 查询交接物品信息列表总数（受理人员）
	 * 
	 * @return
	 */
	int getTransferGoodsCountInHandling();
	
	int getTransferGoodsCountTypeInHandling(@Param("entityType") String entityType);
	
	int getCheckTransferGoodsCountInHandling(@Param("entityType") String entityType);

	/**
	 * 插入一条出库申请记录
	 * 
	 * @return
	 */
	int insertStockOutRequestRecord(StockOut stockout);
	/**
	 * 批量插入多条出库申请记录
	 * 
	 * @return
	 */
	int insertBatchStockOutRequestRecord(List<StockOut> stockout);

	/**
	 * 通过客户编号查询客户id
	 * 
	 * @return
	 */
	public String getUserIdByCode(@Param("usercode") int usercode);

	/**
	 * 通过客户code查询用户姓名
	 * 
	 * @param customercode
	 * @return
	 */
	public String getCustomerNameByCode(@Param("customercode") int customercode);

	/**
	 * 绑定申请单号
	 * 
	 * @param packno
	 * @param requestcodes
	 * @return
	 */
	int bindRequestByPackNo(@Param("packno") int packno,
			@Param("requestcodes") String requestcodes,
			@Param("customername") String customername,
			@Param("remark") String remark);

	/**
	 * 通过包裹编号获取申请单号
	 * 
	 * @return
	 */
	public String getRequestcodesByPackNo(@Param("packno") int packno);

	/**
	 * 拆包后对包裹表的更新，包括：拆包时间、拆包状态
	 * 
	 * @param logisticspack
	 * @return
	 */
	int updatePackAfterUnpack(@Param("packno") int packno,
			@Param("cuttime") Date cuttime, @Param("cutstatus") String cutstatus);

	/**
	 * 拆包后对申请单表的更新，包括：updatetime(更新时间)、requesttime(受理时间)、requeststatus(外面状态)、
	 * internalstates(内部状态)
	 * 
	 * @return
	 */
	int updateRequestAfterUnpack(@Param("requestcode") int requestcode,
			@Param("updatetime") Date updatetime,
			@Param("requesttime") Date requesttime,
			@Param("requeststatus") String requeststatus,
			@Param("internalstates") String internalstates,
			@Param("ownid") String ownid);

	/**
	 * 通过包裹编号获取包裹信息
	 * 
	 * @return
	 */
	LogisticsPack getPackInfoByNo(@Param("packno") int packno);

	/**
	 * 通过硬币编号查询硬币信息
	 * 
	 * @param coindcode
	 * @return
	 */
	List<CoinInfo> getCoinInfoListByCode(@Param("coincode") String coincode);

	CoinInfo getCoinInfoByCode(@Param("coincode") String coincode);

	List<RequestCoinScore> getReqCoinScore(@Param("coincode") String coincode,
			@Param("level") String level, @Param("employeeid") int employeeid);

	/**
	 * 判断该评审员是否已经评分
	 * 
	 * @param employeeid
	 * @param requestcoinid
	 * @return
	 */
	int selScoreById(@Param("employeeid") int employeeid,
			@Param("requestcoinid") String requestcoinid,
			@Param("level") String level);

	/**
	 * 单据未评级完成项目个数
	 * 
	 * @param employeeid
	 * @param requestcoinid
	 * @return
	 */
	int selScoreByRequestIdNotScore(@Param("employeeid") int employeeid,
			@Param("requestid") String requestid,
			@Param("level") String level);
	
	int checkOnly(@Param("requestcoinid") String requestcoinid);
	
	int updateSecondCoinScore(@Param("requestcoinid") String requestcoinid,
			@Param("score") BigDecimal score,@Param("scores") String scores, @Param("remark") String remark,
			@Param("scoreby") int scoreby, @Param("scoretime") Date scoretime,
			@Param("ratingreasondis") String ratingreasondis);

	/**
	 * 更新评分记录
	 * 
	 * @param requestcoinid
	 * @param score
	 * @param remark
	 * @param scoreby
	 * @param scoretime
	 * @return
	 */
	int updateCoinScore(@Param("requestcoinid") String requestcoinid,
			@Param("score") BigDecimal score,@Param("scores") String scores, @Param("remark") String remark,
			@Param("scoreby") int scoreby, @Param("scoretime") Date scoretime,
			@Param("level") String level,
			@Param("ratingreasondis") String ratingreasondis);

	/**
	 * 插入一条评分记录
	 * 
	 * @param requestcoinscore
	 * @return
	 */
	int insertRequestCoinScore(RequestCoinScore requestcoinscore);

	/**
	 * 更新硬币备注
	 * 
	 * @param requestcoinid
	 * @param remark
	 * @return
	 */
	int updateRequestCoinRemark(@Param("requestcoinid") String requestcoinid,
			@Param("remark") String remark,
			@Param("difversion") String difversion);
	int updateRequestCoinAddremarks(@Param("requestcoinid") String requestcoinid,@Param("addremarks") String addremarks);

	int updateRequestCoinScore(@Param("requestcoinid") String requestcoinid,
			@Param("score") BigDecimal score,@Param("scores") String scores,
			@Param("ratingreasondis") String ratingreasondis);

	int updateBillblockNum(@Param("requestcoinid") String requestcoinid,
			@Param("blockNum") String blockNum); // 修改冠字号

	/**
	 * 修改user表中默认的mobile
	 * 
	 * @param number
	 * @param userid
	 * @return
	 */
	int updateUserDefauletMobile(@Param("number") String number,
			@Param("userid") String userid);

	/**
	 * 修改user表中默认的tel
	 * 
	 * @param number
	 * @param userid
	 * @return
	 */
	int updateUserDefauletTel(@Param("number") String number,
			@Param("userid") String userid);

	/**
	 * 通过申请单号获取对账单列表信息
	 * 
	 * @param requestcode
	 * @return
	 */
	public List<Statement> getStatementListByReqCode(
			@Param("requestcode") int requestcode);

	public List<RequestCoinBean> getReqBillCoinByReqId(
			@Param("requestid") String requestid);

	/**
	 * 查询此人对于此物品的申请出库记录
	 * 
	 * @param outby
	 * @param goodsid
	 * @param type
	 * @param status
	 * @return
	 */
	public StockOut getStockOut(@Param("outby") int outby,
			@Param("goodsid") int goodsid, @Param("type") String type,
			@Param("status") String status);

	/**
	 * 检查该用户是否已经添加过该条邮箱记录
	 * 
	 * @param userid
	 * @param mail
	 * @return
	 */
	int checkMail(@Param("userid") String userid, @Param("mail") String mail);

	List<UserMobile> checkMobileApprove(@Param("phoneno") String phoneno);

	/**
	 * 获取交接记录列表(通过姓名)
	 * 
	 * @param goodstype
	 * @param goodsid
	 * @param participant
	 * @param timestart
	 * @param timeend
	 * @param page
	 * @param pagesize
	 * @return
	 */
	List<HandRecord> getTransferList(@Param("goodstype") String goodstype,
			@Param("goodsid") int goodsid,
			@Param("participant") String participant,
			@Param("timestart") String timestart,
			@Param("timeend") String timeend, @Param("page") int page,
			@Param("pagesize") int pagesize);

	/**
	 * 获取交接记录总数
	 * 
	 * @param goodstype
	 * @param goodsid
	 * @param participant
	 * @param timestart
	 * @param timeend
	 * @return
	 */
	int getTransferListCount(@Param("goodstype") String goodstype,
			@Param("goodsid") int goodsid,
			@Param("participant") String participant,
			@Param("timestart") String timestart,
			@Param("timeend") String timeend);

	/**
	 * 获取交接记录列表(通过id)
	 * 
	 * @param goodstype
	 * @param goodsid
	 * @param participant
	 * @param timestart
	 * @param timeend
	 * @param page
	 * @param pagesize
	 * @return
	 */
	List<HandRecord> getTransferListById(@Param("goodstype") String goodstype,
			@Param("goodsid") int goodsid,
			@Param("participant") int participant,
			@Param("timestart") String timestart,
			@Param("timeend") String timeend, @Param("page") int page,
			@Param("pagesize") int pagesize);

	/**
	 * 获取交接记录总数
	 * 
	 * @param goodstype
	 * @param goodsid
	 * @param participant
	 * @param timestart
	 * @param timeend
	 * @return
	 */
	int getTransferListCountById(@Param("goodstype") String goodstype,
			@Param("goodsid") int goodsid,
			@Param("participant") int participant,
			@Param("timestart") String timestart,
			@Param("timeend") String timeend);

	/**
	 * 通过物流单号获取物流包对象
	 */
	LogisticsPack getLPBylpNo(@Param("logisticsno") String logisticsNo);

	/**
	 * 查询申请单
	 * 
	 * @param reqsearch
	 * @return
	 */
	public List<RequestSearch> searchRequestList(
			@Param("reqsearch") RequestSearch reqsearch);

	/**
	 * 查询入库人id
	 * 
	 * @param type
	 * @param stockno
	 * @return
	 */
	public String getSendid(@Param("type") String type,
			@Param("stockno") String stockno);

	/**
	 * 获取雇员所拥有的角色集
	 * 
	 * @param employeeid
	 * @return
	 */
	public String getEmployeeRoles(@Param("employeeid") String employeeid);

	public List<TransferGoods> getTransferGoodsInService_pack(
			@Param("goodno") String goodno, @Param("page") int page,
			@Param("pagesize") int pagesize);

	/**
	 * 交接处，受理查询包裹
	 * 
	 * @param goodno
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsInHandling_pack(
			@Param("goodno") String goodno, @Param("page") int page,
			@Param("pagesize") int pagesize);

	/**
	 * 交接处，客服搜索申请单
	 * 
	 * @param goodno
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsInService_req(
			@Param("goodno") String goodno, @Param("page") int page,
			@Param("pagesize") int pagesize);

	/**
	 * 交接处，受理搜索申请单
	 * 
	 * @param goodno
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsInHandling_req(
			@Param("goodno") String goodno, @Param("page") int page,
			@Param("pagesize") int pagesize);

	/**
	 * 交接处，制图、评审、打盒、搜索申请单
	 * 
	 * @param goodno
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsInCommon_req(
			@Param("goodno") String goodno, @Param("page") int page,
			@Param("pagesize") int pagesize, 
			@Param("status1") String status1, @Param("status2") String status2);
	
	/**
	 * 交接处，打盒制图搜索申请单
	 * 
	 * @param goodno
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<TransferGoods> getTransferGoodsInRare_req(
			@Param("goodno") String goodno, @Param("page") int page,
			@Param("pagesize") int pagesize, 
			@Param("status1") String status1, @Param("status2") String status2, @Param("status3") String status3);

	int delLogin(@Param("no") String no, @Param("userid") String userid);

	List<StockOut> getAll(@Param("id") int id);

	UserMobile selectUserMobileByuserid(@Param("userid") String userid);

	/**
	 * 通过用户ID获取用户编号
	 * 
	 * @param id
	 * @return
	 */
	String getUsercodeById(@Param("id") String id);
	
	/**
	 * 通过用户ID获取用户姓名
	 * 
	 * @param id
	 * @return
	 */
	String getUsernameById(@Param("id") String id);
	/**
	 * 通过用户ID获取用户注册时间
	 * 
	 * @param id
	 * @return
	 */
	String getUserdateById(@Param("id") String id);
	
	String getUsermobileById(@Param("id") String id);
	
	String getUsermailById(@Param("id") String id);


	/**
	 * 查询某人未支付的申请单总数及总费用
	 * 
	 * @param userid
	 * @return
	 */
	ReqForPay getReqForPay(@Param("userid") String userid);

	/*
	 * 判断后台手机快速注册是否已激活
	 */
	UserMobile selectUsermobibleByname(@Param("telephone") String telephone,
			@Param("userid") String userid, @Param("delflag") String delflag);

	int updataMobibleStatus(@Param("id") String id,
			@Param("status") String status);

	int updateBillInfo(@Param("requestcoinid") String requestcoinid,
			@Param("blockNum") String blockNum,
			@Param("customSize") String guestWRSize,
			@Param("whetherSample") String whetherSample,
			@Param("difversioncode") Integer difversioncode);

	int updateAncientCoinInfo(@Param("requestcoinid") String requestcoinid,
			@Param("guestWRWeight") String guestWRWeight,
			@Param("guestWRSize") String guestWRSize,
			@Param("guestWRGrade") String guestWRGrade);

	int updateStampInfo(@Param("requestcoinid") String requestcoinid,
			@Param("coinspecialtype") String coinspecialtype,
			@Param("coinprintingpaper") String coinprintingpaper,
			@Param("customsize") String customsize,
			@Param("coinmotto") String coinmotto,
			@Param("coinseriesnum") String coinseriesnum,
			@Param("coincover") String coincover,
			@Param("coincovernewold") String coincovernewold,
			@Param("coinpostmark") String coinpostmark,
			@Param("coinplatemode") String coinplatemode,
			@Param("coinissuingquantity") String coinissuingquantity,
			@Param("coinsummary") String coinsummary,
			@Param("coinhole") String coinhole,
			@Param("coinstampjointype") String coinstampjointype,
			@Param("coinfullsubject") String coinfullsubject,
			@Param("coinfeatures") String coinfeatures,
			@Param("ratingreasondis") String ratingreasondis);
	int updateStampInfoAll(@Param("requestcoinid") String requestcoinid,
			@Param("coincovernewold") String coincovernewold,
			@Param("coinstampjointype") String coinstampjointype,
			@Param("coinfullsubject") String coinfullsubject);
	int updateMechanismCoinInfo(@Param("requestcoinid") String requestcoinid,
			@Param("guestWRWeight") String guestWRWeight,
			@Param("guestWRSize") String guestWRSize);

	int updatetagindex(@Param("requestcoinid") String requestcoinid,
			@Param("tagindex") String tagindex);

	SysI18nData checkVersion(@Param("version") String version,
			@Param("type") String type);
	
	String SearchCoinByCode(@Param("coincode")String coincode);
	
	Ratingreason getRatRes(@Param("reasonname") String reasonname,
			@Param("reasontype") String reasontype,
			@Param("reasonBelongType") String reasonBelongType);

	int addReqResDate(@Param("requestid") String requestid,
			@Param("requestcoinid") String requestcoinid,
			@Param("netreasoncode") Integer netreasoncode);
	
	int delReqResDate(String requestcoinid);

	RequestReasonData getReasonData(@Param("requestid") String requestid,
			@Param("requestcoinid") String requestcoinid,
			@Param("netreasoncode") Integer netreasoncode);
	
	String selScores(@Param("employeeid") int employeeid,
			@Param("requestcoinid") String requestcoinid,
			@Param("level") String level);
	
	BigDecimal selScore(@Param("employeeid") int employeeid,
			@Param("requestcoinid") String requestcoinid,
			@Param("level") String level);
}
