package com.kaifantech.util.constant.taskexe;

public interface CsyTaskexeOpFlag extends TaskexeOpFlag {
	/** AGV到达缓存柜对应站点后状态变为 */
	public static final String ARRIVED = "ARRIVED";
	/** 入库时先到缓存柜取货，取到后状态变化为 */
	public static final String FETCHED = "FETCHED";
	/** 出库时最后将档案放到缓存柜，放完后状态变化为 */
	public static final String SHIPPED = "SHIPPED";
	/** 执行存放货时所处的状态 */
	public static final String WORKING = "WORKING";
}
