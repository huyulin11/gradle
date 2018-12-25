package com.ytgrading.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.PostInfo;
import com.ytgrading.bean.StockOutSel;
import com.ytgrading.bean.StockSel;
import com.ytgrading.bean.wms.de.IShipmentConfim;
import com.ytgrading.dto.Employee;
import com.ytgrading.dto.EmployeeMenu;
import com.ytgrading.dto.EmployeeRole;
import com.ytgrading.dto.LogisticsPack;
import com.ytgrading.dto.LogisticsTransfer;
import com.ytgrading.dto.PayRequestReceive;
import com.ytgrading.dto.Request;
import com.ytgrading.dto.RequestLogistics;
import com.ytgrading.dto.Stock;
import com.ytgrading.dto.StockOut;
import com.ytgrading.dto.Users;

public interface ThisEmployeeMapper {

	// ------Employee-----------------
	public Employee selectEmployee(@Param("employeeId") int employeeId);

	public Employee selectEmployeeByuserid(@Param("userid") int userid);

	public List<Integer> getEmpAuthorization(@Param("roleArr") String[] roleArr);

	public List<EmployeeMenu> getEmployeeMenu(
			@Param("empAuthList") List<Integer> empAuthList);

	public void updatepassword(@Param("employeeId") int employeeId,
			@Param("password") String password);

	List<EmployeeRole> getEmployeeRole();

	int insert(Employee record);

	List<Employee> selectAllEmployee(@Param("page") int page,
			@Param("pagesize") int pageSize);

	int countEmployee();

	int SearchDelflag(@Param("id") int id);

	int UpdateDelflag(@Param("id") String id, @Param("delflag") String delflag);

	// ---------Stcok-----------------入库
	public int getStockListCount(Stock stock);

	public List<StockSel> selectStockSelList(StockSel stockSel);// 满位

	public List<StockSel> selectStockList(StockSel stockSel);// 空位

	public int updateSendtimes(@Param("stockno") String stockno);

	public String getInternalstates(@Param("requestcode") String rquestcode);

	public int updateStock(Stock stock);

	// 入库系统库位
	public int insertStock(Stock stock);

	// 查询入库人：根据requestcode
	public Request getAcceptidRequest(@Param("requestcode") String requestcode);

	// 批量查询入库人：根据requestcode
	public List<Request> getAcceptidRequests(
			@Param("requestcode") String[] requestcode);

	public int updateRequestOwnid(@Param("requestcode") String Istockno,
			@Param("ownid") String ownid);

	// 根据requestcode获取paystatus
	public String getpaystatusByreqcode(@Param("requestcode") String requestcode);

	// 如果申请单request的internalstates字段为15制图结束，则改为16入库
	public int updateRequestStates(@Param("requestcode") String requestcode,
			@Param("beforeInteStates") String beforeInteStates,
			@Param("afterInteStates") String afterInteStates);

	public int updateReqstaBypaystatus(
			@Param("requestcode") String requestcode,
			@Param("paystatus") String paystatus,
			@Param("reqstatus") String reqstatus);

	// 查询入库人：根据requestcode
	public LogisticsPack getAcceptidPack(@Param("packno") String packno);

	// 申请单入库后，logistics_pack中ownid置0
	public int updatePackOwnid(@Param("packno") String packno,
			@Param("ownid") String ownid);

	// 入库/出库时，需要往货物转换记录表中插入条记录
	public int insertLogTransfer(LogisticsTransfer logTransfer);

	// --------------Stock_Out---------出库
	public int getStockOutListCount(StockOut stockOut);

	public List<StockOut> selectStockOutList(StockOutSel stockOutSel);

	public int insertStockOut(StockOut stockOut);

	public int confirmStockOut(StockOut stockOut);// 确认出库
	// 出库时，仓库表stock除了id，库位postion,其他置空

	public int confirmStock(@Param("stockno") Integer stockno,
			@Param("type") String type);

	// 得到stock的库位
	public String getpostion(@Param("stockno") Integer stockno,
			@Param("type") String type);

	// 当库位为system时，出库删除该仓库记录
	public int deleStockbyStockno(@Param("stockno") Integer stockno,
			@Param("type") String type);

	public StockOut getStockOutById(@Param("id") String id);

	// 财务后台待支付各项费用统计
	public List<Request> getCostbyRequestids(
			@Param("requestIdArr") String[] requestIdArr,
			@Param("requeststatus") String requeststatus);

	public List<PayRequestReceive> getPayReceiveList(
			@Param("requestIdArr") String[] requestIdArr);

	// 财务确认支付PayRequestReceive增加款项 status更新为1已执行
	public int financialReceiveStatus(
			@Param("requestIdArr") String[] requestIdArr);

	/**
	 * 根据当前requeststatus，requestcode来修改requeststatus
	 * 
	 * @param beforeStatus
	 *            当前requeststatus值
	 * @param afterStatus
	 *            要修改成requeststatus值
	 * @param requestcode
	 *            关键字申请单号
	 * @return
	 */
	public int updateRequestStatus(@Param("beforeStatus") String beforeStatus,
			@Param("afterStatus") String afterStatus,
			@Param("requestcode") String requestcode);

	public Stock getStockbystockno(@Param("stockno") String stockno);

	// ----------Requestlogistic-----回邮
	public RequestLogistics getRequestLogistics(
			@Param("requestcode") String requestcode);

	public int updateRequestlogistic(RequestLogistics requestlogistic);

	public int insertRequestlogistic(RequestLogistics requestlogistic);

	public int insertRequestlogistics(List<RequestLogistics> requestlogistic);

	public Users gerUser(@Param("userid") String userid);

	/**
	 * 清除有关此物品的其他出库申请
	 * 
	 * @param goodsid
	 * @param type
	 * @param status
	 * @return
	 */
	public int delOthersStockOut(@Param("goodsid") String goodsid,
			@Param("type") String type, @Param("status") String status);

	/**
	 * 通过申请单号获取回邮单信息
	 * 
	 * @param requestcode
	 * @return
	 */
	public PostInfo getPostInfoByReqCode(
			@Param("requestcode") String requestcode,
			@Param("employeeid") String employeeid);

	// 获取申请单当前的状态
	public String getReqCurStatus(@Param("requestcode") String requestcode);

	public List<EmployeeRole> selectAllEmployeeRole();
	
	public IShipmentConfim getWmsLogistics(
			@Param("requestcode") String requestcode);

}