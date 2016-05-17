package com.sou.common.constants;

public class OrderErrorCode {
	public static String SYS_ERROR = "1134000";
	
	public static String SYS_MOD_ERROR = "1134001";
	
	/**
	 * rest获取数据异常
	 */
	public static String REST_GETDATA_ERROR = "1134003";
	
	/**
	 * 获取区域错误
	 */
	public static String REST_GETAREA_ERROR = "1134009";
	/**
	 * 产品已下线，产品编号{0}，产品名称{1}
	 */
	public static String PRODUCT_OFFLINE = "1134004";
	
	/**
	 * 报名已停止。
	 */
	public static String PRODUCT_TIME_OFFLINE = "1134005";
	
	/**
	 * 出发日期不能小于当前时间。
	 */
	public static String PRODUCT_TIME_BIGGER = "1134006";
	
	/**
	 * 出发日期已经失效
	 */
	public static String PRODUCT_TIME_DEF = "1134007";
	
	/**
	 * 没有找到团期，不能下单。
	 */
	public static String PRODUCT_TIME_NO = "1134008";
	
}
