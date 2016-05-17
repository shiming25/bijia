package com.sou.common.constants;

import java.util.HashMap;
import java.util.Map;

public class OrderParam {

    /**
     * 零售平台订单号从80,000,000开始
     */
    public static final int ORDER_NUM_START = 80000000;

    /**
     * 订单状态：1-待受理 2-待付款 3- 4-待出游 5- 6-出游中 7-出游归来 8-取消99-无效订单
     */
    public static final int ORDER_STATUS_UNCONFIRM = 1;
    public static final int ORDER_STATUS_UNPAY = 2;
//    public static final int ORDER_STATUS_UNDONE = 3;
//    public static final int ORDER_STATUS_DONE = 4;
    public static final int ORDER_STATUS_UNTOUR = 4;
    public static final int ORDER_STATUS_TOURING = 6;
    public static final int ORDER_STATUS_TOURBACK = 7;
    public static final int ORDER_STATUS_CANCEL = 8;
    public static final int ORDER_STATUS_INEFFECTIVE = 99;
    
    /**
     * 对PGA的订单状态(勿改) ：1-待受理 2-待付款 3- 4-待出游 5- 6-出游中 7-出游归来 8-取消99-无效订单  
     */
    public static final Map<Integer, String> ORDER_STATUS_MAP = new HashMap<Integer, String>();
    static{
    	ORDER_STATUS_MAP.put(ORDER_STATUS_UNCONFIRM, "待受理");
    	ORDER_STATUS_MAP.put(ORDER_STATUS_UNPAY, "待付款");
    	ORDER_STATUS_MAP.put(ORDER_STATUS_UNTOUR, "待出游");
    	ORDER_STATUS_MAP.put(ORDER_STATUS_TOURING, "出游中");
    	ORDER_STATUS_MAP.put(ORDER_STATUS_TOURBACK, "出游归来");
    	ORDER_STATUS_MAP.put(ORDER_STATUS_CANCEL, "取消");
    	ORDER_STATUS_MAP.put(ORDER_STATUS_INEFFECTIVE, "无效订单");
    }
    
    
    /**
     * 订单状态：1-待受理 2-待付款 3- 4-待出游 5- 6-出游中 7-出游归来 8-取消99-无效订单
     */
    public static final Map<Integer, String> EXPORT_ORDER_STATUS_MAP = new HashMap<Integer, String>();
    static{
    	EXPORT_ORDER_STATUS_MAP.put(ORDER_STATUS_UNCONFIRM, "待受理");
    	EXPORT_ORDER_STATUS_MAP.put(ORDER_STATUS_UNPAY, "待付款");
    	EXPORT_ORDER_STATUS_MAP.put(ORDER_STATUS_UNTOUR, "已付款");
    	EXPORT_ORDER_STATUS_MAP.put(ORDER_STATUS_TOURING, "出游中");
    	EXPORT_ORDER_STATUS_MAP.put(ORDER_STATUS_TOURBACK, "出游归来");
    	EXPORT_ORDER_STATUS_MAP.put(ORDER_STATUS_CANCEL, "已取消");
    	EXPORT_ORDER_STATUS_MAP.put(ORDER_STATUS_INEFFECTIVE, "无效订单");
    }

    /**
     * 订单类型，1-即时确认，2-二次确认
     */
    public static final int ORDER_TYPE_ONCE_CONFIRM = 1;
    public static final int ORDER_TYPE_TWICE_CONFIRM = 2;

    /**
     * 订单来源：网站、电话、无线
     */
    public static final int ORDER_SOURCE_WEB = 1;
    public static final int ORDER_SOURCE_TEL = 2;
    public static final int ORDER_SOURCE_WAP = 3;

    /**
     * 产品类型：普通产品、组合产品、附加产品
     */
    public static final int PRODUCT_TYPE_NORMAL = 1;
    public static final int PRODUCT_TYPE_PACKAGE = 2;
    public static final int PRODUCT_TYPE_ATTACH = 3;

    /**
     * 业务类型：1=跟团游，2=自助游，3=酒店，4=机票，5=团队游，6=门票, 7=保险, 8=自驾游, 9=签证, 10=邮轮, 11=火车票
     */
    public static final int BUSINESS_TYPE_GROUP = 1;
    public static final int BUSINESS_TYPE_DIVTOUR = 2;
    public static final int BUSINESS_TYPE_HOTEL = 3;
    public static final int BUSINESS_TYPE_AIR = 4;
    public static final int BUSINESS_TYPE_GROUPTOUR = 5;
    public static final int BUSINESS_TYPE_GATE = 6;
    public static final int BUSINESS_TYPE_INSURANCE = 7;
    public static final int BUSINESS_TYPE_DRIVINGTOUR = 8;
    public static final int BUSINESS_TYPE_VISA = 9;
    public static final int BUSINESS_TYPE_SHIP = 10;
    public static final int BUSINESS_TYPE_TRAIN = 11;

    /**
     * 收款情况：未收款、全部完成、部分完成
     */
    public static final int PAY_FLAG_UNDONE = 0;
    public static final int PAY_FLAG_DONE = 1;
    public static final int PAY_FLAG_PARTDONE = 2;

    /**
     * 删除标记: 正常、删除
     */
    public static final int DELETE_FLAG_NO = 0;
    public static final int DELETE_FLAG_YES = 1;

    /**
     * 联系人类型: 1-会员，2-联系人，3-出游人
     */
    public static final int PERSON_TYPE_MEMBER = 1;
    public static final int PERSON_TYPE_CONTACTER = 2;
    public static final int PERSON_TYPE_TOURIST = 3;

    /**
     * 备注类型，1-订单备注，2-客人留言，3-投诉备注
     */
    public static final int REMARK_TYPE_ORDER = 1;
    public static final int REMARK_TYPE_CUSTOMER = 2;
    public static final int REMARK_TYPE_COMPLAIN = 3;

    /**
     * 附件类型，1-合同，2-健康协议，3-回传退款协议，4-回传变更协议，5-回传终止协议
     */
    public static final int ATTACH_TYPE_CONTRACT = 1;
    public static final int ATTACH_TYPE_HEALTH_AGREEMENT = 2;
    public static final int ATTACH_TYPE_REFUND_AGREEMENT = 3;
    public static final int ATTACH_TYPE_CHANGE_AGREEMENT = 4;
    public static final int ATTACH_TYPE_END_AGREEMENT = 5;

    /**
     * 支付标识：0不可以支付，1可以支付，99不可支付且不可更改
     */
    public static final int ORDER_CANNOT_PAY = 0;
    public static final int ORDER_CAN_PAY = 1;
    public static final int ORDER_CANNOT_PAY_FINAL = 99;

    /**
     * 签约类型：1-线上，2-线下，99-线下签约且不可更改
     */
    public static final int SIGN_TYPE_ONLINE = 1;
    public static final int SIGN_TYPE_OFFLINE = 2;
    public static final int SIGN_TYPE_OFFLINE_FINAL = 99;
    
    /**
     * 签约状态：1已签约，0未签约
     */
    public static final int SIGN_STATUS_YES = 1;
    public static final int SIGN_STATUS_NO = 0;

    /**
     * 0：个人会员【正式】1：公司会员2：临时会员【信息不全】
     */
    public static final int CUST_TYPE_INDIVIDUAL = 0;
    public static final int CUST_TYPE_COMPANY = 1;
    public static final int CUST_TYPE_TEMP = 2;

    /**
	 * 确认单状态：0-未确认，1-已确认，2-已驳回
	 */
    public static final int ORDER_CONFIRM_NO = 0;
    public static final int ORDER_CONFIRM_YES = 1;
    public static final int ORDER_CONFIRM_REJECTED = 2;
    
    /**
     * 确认单对应单据类型：1-收款单，2-退款单，3-促销活动生成
     */
    public static final int ORDER_CONFIRM_TYPE_COLLECTION = 1;
    public static final int ORDER_CONFIRM_TYPE_REFUND = 2;
    public static final int ORDER_CONFIRM_TYPE_PS = 3;

    /**
     * 订单收款来源：1-途牛 2-供应商
     */
    public static final int PAY_SOURCE_TUNIU = 1;
    public static final int PAY_SOURCE_AGENCY = 2;
    
    /**
	 * 0女,1男,9未知 其余为未知
	 */
    public static final int SEX_FEMALE = 0;
    public static final int SEX_MALE = 1;
    public static final int SEX_OTHER = 9;
    
    /**
	 * 称谓:1先生,2女士,3小姐,0未知
	 */
    public static final int APPELLATION_SIR = 1;
    public static final int APPELLATION_LADY = 2;
    public static final int APPELLATION_MISS = 3;
    public static final int APPELLATION_OTHER = 0;
    
    /**
     * 订单投诉单状态：1-待处理，2-已处理
     */
    public static final int COMPLAIN_STATUS_UNHANDLED = 1;
    public static final int COMPLAIN_STATUS_HANDLED = 2;
    
    /**
     * 排序类型：降序、升序
     */
    public static final String ORDER_BY_DESC = "DESC";
    public static final String ORDER_BY_ASC = "ASC";
    
    /**
     * 结算类型/付款记录表金额类型：1-代收款，2-退款
     */
    public static final int CONFIRM_TYPE_COLLECTION = 1;
    public static final int CONFIRM_TYPE_REFUND = 2;
    
    /**
     * 确认单状态：0-未确认，1-已确认
     */
    public static final int CONFIRM_STATUS_NO = 0;
    public static final int CONFIRM_STATUS_YES = 1;
    
    /**
     * operate_error_log错误类型：1-调用外系统，2-外系统调用。具体：11-外系统异常，12-执行失败
     */
    public static final int OPERATERRORLOG_TYPE_CALL = 1;
    public static final int OPERATERRORLOG_TYPE_CALL_EXCEPTION = 11;
    public static final int OPERATERRORLOG_TYPE_CALL_FAILURE = 12;
    public static final int OPERATERRORLOG_TYPE_CALLED = 2;
    
    /**
     * 财务标识，是否零售平台订单：0-不是零售平台订单，1-是
     */
    public static final int FINANCE_IS_RETAIL_YES = 1;
    
    /**
     * 财务标识，是否采购押金：0-不是，1-是押金
     */
    public static final int FINANCE_IS_DEPOSIT_NO = 0;
    
    /**
     * 财务标识，采购单类型（必填）：1-线路，2-门票，3-酒店，...，17-零售平台
     */
    public static final int FINANCE_PURCHASE_PRODUCT_TYPE_RETAIL = 17;
    
    /**
     * 财务标识，采购类型：1-常规，2-控位
     */
    public static final int FINANCE_PURCHASE_PURHASE_TYPE_NORMAL = 1;
    
    /**
     * 财务标识，发票来源：0-其他，1-北旅南分，2-跟0的区分开，便于以后修改
     */
    public static final int FINANCE_PURCHASE_INVOICE_INCOME_RETAIL = 2;
    
    /**
     * 财务标识，同步订单信息type字段：财务基本不用，但是2、8、11会进行限制，约定传21
     */
    public static final int FINANCE_SYNCORDER_TYPE_RETAIL = 21;
    
    /**
     * 财务标识，同步订单信息财务订单类型create_type字段：4-门票、6-酒店、12-老自助游、19-团队、20-零售平台订单
     */
    public static final int FINANCE_SYNCORDER_CREATETYPE_RETAIL = 20;
    
    /**
     * 财务标识，同步订单信息订单签约公司sign_company字段：非自营，没有分公司，由于转凭证需要，约定先传12
     */
    public static final int FINANCE_SYNCORDER_SIGN_COMPANY = 12;
    
    /**
     * 同步订单信息（生成合同信息）：销售人员id（暂时传胡晓雯id）
     */
    public static final int FINANCE_SYNCORDER_SALER_ID_HXW = 2935;
    
    /**
     * 客户类型参数:0未知,1游客,2联系人,3出团通知书接收者
     */
    public static final int CRM_PERSON_TYPE_TOURIST = 1;
    public static final int CRM_PERSON_TYPE_CONTACTER = 2;

    /**
     * 售卖方式（0=现询，1=库存在线预订, 2=free sale）
     */
    public static final int SALE_TYPE_TEL = 0;
    public static final int SALE_TYPE_WEB = 1;
    public static final int SALE_TYPE_FREESALE = 2;
    
    /**
     * fab中证件类别:1=身份证2=护照3=军官证4=港澳通行证6=其他7=台胞证
     */
    public static final int PSPT_TYPE_ID = 1;
    public static final int PSPT_TYPE_PASSPORT = 2;
    public static final int PSPT_TYPE_OFFICER = 3;
    public static final int PSPT_TYPE_HKANDMACAO = 4;
    public static final int PSPT_TYPE_OTHER = 6;
    public static final int PSPT_TYPE_TAIWAN = 7;
    
    /**
     *  1供应商 2途牛员工
     */
    public static final int SUBJECT_TYPE_AGENCY = 1;
    public static final int SUBJECT_TYPE_STAFF = 2;
    
    /**
     * 产品状态（0=下线，1=前后台上线，2=后台上线）
     */
    
    public static final int PRODUCT_STATUS_OFF = 0;
    public static final int PRODUCT_STATUS_ON = 1;
    public static final int PRODUCT_STATUS_BACKON = 2;
    
    /**
     * 审核状态（1=待审核；2=审核通过；-1=退回）
     */
    public static final int PRODUCT_AUDIT_STATUS_NO = 1;
    public static final int PRODUCT_AUDIT_STATUS_YES = 2;
    public static final int PRODUCT_AUDIT_STATUS_BACK = -1;
    
    /**
     * addContract action 0-查询已确认签约文件列表 1-新增合同 2-终止合同 3-线下签约改线上签约
     */
    public static final int ADD_CONTRACT_QUERY = 0;
    public static final int ADD_CONTRACT_ADD = 1;
    public static final int ADD_CONTRACT_END = 2;
    public static final int ADD_CONTRACT_SIGNTYPE = 3;
    
    /**
     * 修改签约类型 action 1-线上  2-线下
     */
    public static final int CHANGE_SIGNTYPE_ONLINE = 1;
    public static final int CHANGE_SIGNTYPE_OFFLINE = 2;
    
    /**
     * 短信发送类型:2100:接单成功后;2200:网上支付功能打开 2300 网上支付完成;2400:在线签约完成,;2500:出游前三天已付款未签约;
     * 2600:运营人员添加备注提醒： 2700:订单取消前提醒（现询产品）; 2800:商家手动取消订单; 
     * 2900:系统自动（已受理未付款）; 3000:系统自动（现询产品&未受理）;3100:投诉; 3200-全部退款自动关闭； 3300-受理完成
     */
    public static final int SMS_SEND_TASK_TYPE_SIGN = 2100;
    public static final int SMS_SEND_TASK_TYPE_PAY_FLAG = 2200;
    public static final int SMS_SEND_TASK_TYPE_PAY_FINISH = 2300;
    public static final int SMS_SEND_TASK_TYPE_SIGN_FINISH= 2400;
    public static final int SMS_SEND_TASK_TYPE_BEFORE_THREEDAY = 2500;
    public static final int SMS_SEND_TASK_TYPE_ADD_REMARK = 2600;
    public static final int SMS_SEND_TASK_TYPE_WARN_CANCEL_ORDER = 2700;
    public static final int SMS_SEND_TASK_TYPE_CANCEL_ORDER = 2800;
    public static final int SMS_SEND_TASK_TYPE_CANCEL_UNPAY_ORDER = 2900;
    public static final int SMS_SEND_TASK_TYPE_CANCEL_UNCONFIRM_ORDER = 3000;
    public static final int SMS_SEND_TASK_TYPE_COMPLAIN = 3100;
    public static final int SMS_SEND_TASK_TYPE_REFUND_ALL = 3200;
    public static final int SMS_SEND_TASK_TYPE_CONFIRM = 3300;

    /**
     * 供应商信息联系人类型优先级
     */
    public static final Integer[] AGENCY_TYPE_PRIORITYS = {6,4,5};
    /**
     * 发送短信 供应商信息联系人类型列表
     */
    public static final Integer[] AGENCY_TYPE_LIST = {0,3,6};
    
    /**
     * 供应商查询详情
     */
    public static final String AGENCY_QUERY_ACTION_DETAIL = "detail";
    
    /**
     * 单房差：0--不需要，1--需要
     */
    public static final int ROOM_GAP_FLAG_NOT = 0;
    public static final int ROOM_GAP_FLAG_NEED = 1;
    
    /**
     * 发送短信的产品类型：0-全部，1-及时确认，2-二次确认
     */
    public static final int SMS_SEND_PRODUCT_TYPE_ALL = 0;
    public static final int SMS_SEND_PRODUCT_TYPE_ONCE = 1;
    public static final int SMS_SEND_PRODUCT_TYPE_TWICE = 2;
    
    /**
     * 发送短信的目标类型：1-用户，2-供应商
     */
    public static final int SMS_SEND_TARGET_TYPE_MEMBER = 1;
    public static final int SMS_SEND_TARGET_TYPE_AGENCY = 2;

    /**
     * 无效订单标志
     */
    public static final String INEFF_FLAG = "1";
    
    /**
     * orderChangeRecord表中的更新人名字
     */
    public static final String DISPLAY_NAME_CUST = "客人";
    public static final String DISPLAY_NAME_EMPLOYEE = "零售平台客服";
    public static final String DISPLAY_NAME_AGENCY = "商家";
    public static final String DISPLAY_NAME_SYSTEM = "系统";
   
    /**
     * 消息类型 10：待受理订单 11：新订单备注 12：新投诉备注 13：待确认订单 20：被退回产品 21：无团期产品
     */
    public static final int INFO_CATEGORY_UNCONFIRM = 10;
    public static final int INFO_CATEGORY_UNDONE = 13;
    public static final int INFO_CATEGORY_ORD_REMARK = 11;
    public static final int INFO_CATEGORY_COMPLAIN_REMARK = 12;
    
    /**
     * 待确认页面
     */
    public static final String UNCONFIRM_PAGE = "/static/order/main.html#static/order/orderList.html?eyJvcmRlclN0YXR1cyI6MX0=";
    public static final String UNDONE_PAGE = "/static/order/main.html#static/order/orderList.html?eyJvcmRlclN0YXR1cyI6M30=";
    
    /**
     * 订单投诉页面
     */
    public static final String ORDER_COMPLAIN_PAGE = "/static/order/main.html#static/order/complain/orderComplainList.html";
    
	/**
	 * 0--成功 ，1.失败 ，2.库存不足
	 */
	public static final int STOCK_SUCCESS = 1;
	public static final int STOCK_ERROR = 0;
	public static final int STOCK_NOT_ENOUGH = 2;
	
	/**
	 * 排序编码：1-降序，2-升序
	 */
	public static final String ORDER_BY_DESC_CODE = "1";
	public static final String ORDER_BY_ASC_CODE = "2";
	
	/**
	 * 整型0
	 */
	public static final int ZERO_INT = 0;
	
	/**
	 * PAG 零售编码
	 */
	public static final int PAG_ORDER_TYPE_ALA = 5;

//	//PGA订单状态：1-待受理 2-待付款 3- 4-待出游 5- 6-出游中 7-出游归来 8-取消99-无效订单	
    public static final String ORDER_STATUS_UNCONFIRM_MSG = "待受理";
    public static final String ORDER_STATUS_UNPAY_MSG  = "待付款";
    public static final String ORDER_STATUS_UNTOUR_MSG  = "待出游";
    public static final String ORDER_STATUS_TOURING_MSG  = "出游中";
    public static final String ORDER_STATUS_TOURBACK_MSG  = "出游归来";
    public static final String ORDER_STATUS_CANCEL_MSG  = "取消";
    public static final String ORDER_STATUS_INEFFECTIVE_MSG  = "无效订单";	
	
    /**
     *  000000001   1	可签约
		000000010	2	可支付
		000000011	3	可签约可支付
		000000100	4	可点评
		000001000	8	酒店可取消
		000010000	16	是否需要补充出游人
     */
    public static final String ORDER_STATUS_DEFAULT_BIN  = "00000000";
    public static final String ORDER_STATUS_UNPAY_BIN = "00000010";
    public static final String ORDER_STATUS_TOURBACK_BIN  = "00000100";
    
    /**
     * 房间类型
     */
    public static final  HashMap<String, String> roomTypeHashMap = new HashMap<String, String>() {
    	{
        	put("1", "标准间");
        	put("2", "豪华套房");
        	put("3", "豪华大床房");
        	put("4", "标准房");
        	put("5", "大床房");
        	put("6", "双床房");
        	put("7", "其他");
    	}
    };
    
    /**
     * 是否有房间资源
     */
    public static final String HAS_ROOM_YES = "1";
    public static final String HAS_ROOM_NO = "2";
    

    /**
     * PGA同步订单错误码 内部使用
     */
    public static final int PGA_ORDER_INFO_ERROR = 9999;
    /**
     * PGA同步订单状态错误码 内部使用
     */
    public static final int PGA_ORDER_STATUS_ERROR = 9998;
    /**
     * PGA批量同步订单状态错误码 内部使用
     */
    public static final int PGA_ORDER_STATUS_BATCH_ERROR = 9997;
    /**
     * PGA接口重试成功
     */
    public static final int PGA_ORDER_SUCCESS = 10000;
    
    /**
	 * PAG产品名称最大值
	 */
	public static final int PGA_PRODUCT_NAME_MAX_LENGTH = 128;
	
	/**
     *  1=周边、2=国内长线、3=出境短线、4=出境长线
     */
    public static final int ROUTE_TYPE_AROUND = 1;
    public static final int ROUTE_TYPE_INLAND_LONG = 2;
    public static final int ROUTE_TYPE_EXIT_SHORT = 3;
    public static final int ROUTE_TYPE_EXIT_LONG = 4;
    
    /**
     * 自动关闭订单，受理时间与出游时间相差天数（国内长线、周边-3，出境短线-5，出境长线-15）
     */
    public static final int CANCEL_INLAND_DAYS = 3;
    public static final int CANCEL_EXIT_SHORT_DAYS = 5;
    public static final int CANCEL_EXIT_LONG_DAYS = 15;
    
    
    /**
     * 取消原因类型： 1-客人原因，2-产品原因，3-公司政策，4-员工问题，5-重复订单，6-重新下单，7-超时未付款，8-超时未受理，9-订单金额完成全部退款
     */
    public static final int CANCEL_TYPE_MEMBER = 1;
    public static final int CANCEL_TYPE_PRODUCT = 2;
    public static final int CANCEL_TYPE_COMPANY = 3;
    public static final int CANCEL_TYPE_EMPLOYEE = 4;
    public static final int CANCEL_TYPE_REPEAT = 5;
    public static final int CANCEL_TYPE_REBOOK = 6;
    public static final int CANCEL_TYPE_PAY_OVERTIME = 7;
    public static final int CANCEL_TYPE_CONFIRM_OVERTIME = 8;
    public static final int CANCEL_TYPE_REFUND = 9;
    
    /**
     * 是否发送短信 ：1是2否
     */
    public static final int IS_SEND_MSG = 1;
    public static final int IS_NOT_SEND_MSG = 2;
    
    /**
     * 自动取消订单操作：1-取消超时未付款订单 2-取消超时未受理订单
     */
    public static final int CANCEL_OPERATE_TYPE_UNPAY = 1;
    public static final int CANCEL_OPERATE_TYPE_UNCONFIRM = 2;

}
