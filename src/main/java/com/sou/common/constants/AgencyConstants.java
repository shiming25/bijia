/**
 * 项目名：agencySys
 * 包名：com.tuniu.agencySys.constants	
 * 文件名：AgencyConstants.java *
 * 日期：2011-6-21 上午09:00:00
 * Copyright 途牛科技有限公司 2011
 * 版权所有
 */
package com.sou.common.constants;

/**
 * 供应商系统常量类
 * 
 * @author weiweiqin
 * 
 */
public interface AgencyConstants {

	/**
	 * 批量确认单类别枚举值
	 */
	int BATCH_CONFIRM_TYPE = 0;
	/**
	 * 订单确认单类别枚举值
	 */
	int ORDER_CONFIRM_TYPE = 1;

	/**
	 * 自助团确认单类别枚举值
	 */
	int GROUP_SELF_CONFIRM_TYPE = 2;
	
	/**
	 * 机票确认单类别枚举值
	 */
	int FLIGHT_ORDER_CONFIRM_TYPE = 4;
	
	/**
	 * 自助游确认单类别枚举值
	 */
	int INDEPENDENT_TRAVEL_ORDER_CONFIRM_TYPE = 5;

	/**
	 * 出团通知附件类型
	 */
	int NTC_ATTACH_TYPE = 99;

	/**
	 * 资源确认单类型
	 */
	int CFM_RES_TYPE = 3;

	/**
	 * 确认单待处理状态
	 */
	int ORDER_CONFIRM_STATUS_WAITING = 0;

	/**
	 * 确认单处理中状态(也是给驳回状态)
	 */
	int ORDER_CONFIRM_STATUS_PROCESSING = -1;

	/**
	 * 确认单已经处理状态
	 */
	int ORDER_CONFIRM_STATUS_PROCESSED = 1;

	/**
	 * 询位咨询单待处理状态
	 */
	int ORDER_CONSULT_STATUS_WAITING = 0;
	/**
	 * 询位咨询单已处理状态
	 */
	int ORDER_CONSULT_STATUS_PROCESSED = 1;
	/**
	 * 核损待处理状态
	 */
	int ORDER_DAMAGE_STATUS_WAITUIN = 0;
	/**
	 * 核损已处理状态
	 */
	int ORDER_DAMAGE_STATUS_PROCESSED = 1;
	
    /**
     * 资源询位单已处理（已反馈）状态
     */
    int RES_INQUIRY_ORDER_STATUS_PROCESSED = 1;

    /**
     *  资源询位单待处理状态
     */
    int RES_INQUIRY_ORDER_STATUS_WAITING = 0;
    
    /**
     * 机票确认单待处理状态
     */
    int FLIGHT_CONFITM_STATUS_WATING = 3;
    
    /**
	 * 机票确认单驳回状态
	 */
	int FLIGHT_CONFITM_STATUS_REJECTED= 4;

	/**
	 * 机票确认单已经处理状态
	 */
	int FLIGHT_CONFITM_STATUS_PROCESSED = 5;
    
	/**
	 * 批量确认单jsp url地址
	 */
	String BATCH_CONFIRM_JSP_URL = "/bizConfirm/bizConfirm/batchConfirm.jsp";

	/**
	 * 订单确认单jsp url地址
	 */
	String ORDER_CONFIRM_JSP_URL = "/bizConfirm/bizConfirm/orderConfirm.jsp";

	/**
	 * 自组团确认单jsp url地址
	 */
	String GROUP_SELF_CONFIRM_JSP_URL = "/bizConfirm/bizConfirm/groupSelfConfirm.jsp";

	/**
	 * 资源确认单jsp url地址
	 */
	String CFM_RES_JSP_USL = "/bizConfirm/bizConfirm/cfmRes.jsp";

	/**
	 * 空值字符串
	 */
	String EMPTY_STRING = "";

	/**
	 * http协议地址头
	 */
	String HTTP_HEAD = "http://";

	/**
	 * 失败标识
	 */
	String FAIL = "fail";
	/**
	 * 成功标识
	 */
	String SUCCESS = "success";
	/**
	 * mark的默认值
	 */
	int MARK_DEFAULT_VALUE = 0;

	/**
	 * 订单确认单的tab号为4
	 */
	int CONFIRM_DEFAULT_TABLE = 4;

	/**
	 * 标记已经删除
	 */
	int IS_DEL_FLAG = -1;

	/**
	 * 标记未被删除
	 */
	int NOT_DEL_FLAG = 1;

	/**
	 * 申请时间由远到近
	 */
	int SORT_TIME_TYPE_APPLY_TIME_ASC = 0;
	/**
	 * 出发时间由远到近
	 */
	int SORT_TIME_TYPE_START_TIME_ASC = 1;
	/**
	 * 确认时间由远到近
	 */
	int SORT_TIME_TYPE_REVERT_TIME_ASC = 2;
	/**
	 * 申请时间由近到远
	 */
	int SORT_TIME_TYPE_APPLY_TIME_DESC = 3;
	/**
	 * 出发时间由近到远
	 */
	int SORT_TIME_TYPE_START_TIME_DESC = 4;
	/**
	 * 确认时间由近到远
	 */
	int SORT_TIME_TYPE__REVERT_TIME_DESC = 5;

	/**
	 * 未找到对应的资源
	 */
	String NOT_FOUND_RES = "notFoundRes";

	/**
	 * 新增操作
	 */
	int ADD_OPER = 1;

	/**
	 * 修改操作
	 */
	int MODIFY_OPER = 2;

	/**
	 * 删除操作
	 */
	int DEL_OPER = 3;

	/**
	 * 查询操作
	 */
	int QUERY_OPER = 4;

	/**
	 * 系统公告类型
	 */
	int ANNOUNCEMENT_TYPE = 1;

	/**
	 * 系统通知类型
	 */
	int NOTICE_TYPE = 2;

	/**
	 * 管理员账号
	 */
	int SUPER_ACCOUNT = 4333;
	/**
	 *表名
	 */
	String NTC_PRODUCT_TABLE_NAME = "ntc_product_info";
	/**
	 *表名
	 */
	String NTC_TEMPLATE_TABLE_NAME = "ntc_template_info";

	/**
	 * 周边分类id
	 */
	int categoryId = 7;
	
	/**
	 * 用于登陆功能常量类
	 * 
	 * @author weiweiqin
	 * 
	 */

	interface LoginConstants {
		/**
		 * 验证码错误
		 */
		int IDENTIFY_ERROR = 1;
		/**
		 * 用户名错误
		 */
		int USERNAME_ERROR = 2;
		/**
		 * 密码错误
		 */
		int PASSWORD_ERROR = 3;
		/**
		 * 验证通过
		 */
		int VALIDATE_SUCCESS = 4;

		/**
		 * 修改密码成功
		 */
		int MODIFY_PASSWORD_SUCCESS = 4;

		/**
		 * 当前密码不正确
		 */
		int OLD_PASSWORD_ERROR = 1;

		/**
		 * 其他错误
		 */
		int OTHER_ERROR = 5;

	}

	interface FileUpload {
		/**
		 * 文件大小最大为5M
		 */
		long FILE_MAX_SIZE = 5242880;

		/**
		 * 文件超出大小错误码
		 */
		int FILE_OUT_MAX_SIZE_ERROR = 498;
	}

	interface ReplayCheckDamage {
		/**
		 * boss订单需要证明枚举值
		 */
		int REQUIRE_PROVIDE = 1;
		/**
		 * boss订不需要证明枚举值
		 */
		int NOT_REQUIRE_PROVIDE = 2;

		/**
		 * 供应商不能提供证明枚举值
		 */
		int NOT_CAN_PROVIDE = 1;

		/**
		 * 供应商能提供证明枚举值
		 */

		int CAN_PROVIDE = 2;

	}

	interface Restful {

		/**
		 * 接口成功标识
		 */
		int SUCCESS_FLAG = 1;
		/**
		 * 接口失败标识
		 */
		int ERROR_FLAG = 0;
	}

	interface CfmRes {

		/**
		 * 可以撤销标识
		 */
		int CAN_REVOCATION = 0;

		/**
		 * 不能撤销标识
		 */
		int NOT_CAN_REVOCATION = 1;

		/**
		 * 搜索列表中出发时间类型枚举值
		 */
		int TIME_TYPE_START_DATE = 0;

		/**
		 * 搜索列表中归来时间类型枚举值
		 */
		int TIME_TYPE_END_DATE = 1;

		/**
		 * 搜索列表中申请时间类型枚举值
		 */
		int TIME_TYPE_APPLY_DATE = 2;

		/**
		 * 待处理状态
		 */
		int WAIT_PROCESS_STATE = 0;

		/**
		 * 已退回状态
		 */
		int BACK_PROCESS_STATE = -1;

		/**
		 * 已处理状态
		 */
		int IS_PROCESSED_STATE = 1;

		/**
		 * 分页默认显示条数
		 */
		int DEFAULT_PAGE_SIZE = 20;

		/**
		 * 导出动作
		 */
		int ACTION_TYPE_EXPORT = 2;

		/**
		 * 搜索动作
		 */
		int ACTION_TYPE_SEARCH = 1;

	}

	interface HomePicture {
		/**
		 * 设置首页图片展示最大张数
		 */
		int MAX_HOME_PICTURE_COUNT = 4;
	}
	
	interface AgencyType {
		/**
		 * 登录名为空
		 */
		String EMPTY = "-1";
		/**
		 * 父账号
		 */
		String PARENT = "1";
		/**
		 * 子账号
		 */
		String CHILD = "2";
	}
	
	/**
	 * UI改造后，菜单id
	 * 
	 * com.tuniu.agencySys.restful.server.webwork.todotask.ToDoTaskController中右下角弹框提醒
	 * 根据下面boss配置的权限是否包含下面的id来显示弹框提醒的条目
	 * 
	 * AgencyPurviewFilter过滤器中看供应商的链接是否有权限访问，在AgencyPurviews配置需要验证的一些链接配置
	 * 
	 */
	int NENU_ROUTE_PRODECT = 20;//线路产品
	int NENU_HOTEL_RESOURCE = 21;//自助游酒店资源
	int NENU_FLIGHT_RESOURCE = 22;//自助游机票资源
	int NENU_PACKAGE_RESOURCE = 23;//自助游打包资源
	int NENU_ORDER_CONFIRM = 30;//订单确认单
	int NENU_GROUP_CONFIRM = 31;//自组团确认单
	int NENU_TICKET_CONFIRM = 32;//门票确认
	int NENU_NTC = 33;//出团通知
	int NENU_FLIGHT_CONFIRM = 34;//机票确认单
    int NENU_ORDER_ASK = 35; //订单nb现询
    int NENU_SELF_TOUR = 36; //自助游查询
    int NENU_ENTITY_TICKET = 37; //实体票
    int NENU_SIGN_ORDER = 38; //签约收款
    int NENU_HOTEL_ORDER = 39; //酒店确认
	int NENU_TOURIST_STATISTIC = 40;//收客统计new
    int NENU_AGENCY_PRODUCT_INDEX_REPORT = 41; //产品报表
    int NENU_AGENCY_BILL = 50; //系统对账
    int NENU_WELCOME_GUEST= 60; //招客宝
    
	// 功能提醒超时时间（分钟）
	int NENU_TIME_LIMIT = 3;
	String[] BLACK_LIST = {};
	
    /**
     * 手工提醒范围类型
     */
    int MESSAGE_ALL_AGENCY = 0;//所有供应商
    int MESSAGE_APPOINT_AGENCY = 1;//指定供应商
    int MESSAGE_MENU_AGENCY = 2;//具有某种权限的供应商
}
