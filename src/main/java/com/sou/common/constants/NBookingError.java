package com.sou.common.constants;

/**
 * 
 * @author 
 *
 */
public enum NBookingError {

	 SUCCESS(113423, "成功"),
	 SYSTEM_BLACK(113424, "系统异常"),
	 AGENCY_BILL_QUERY_LIST_ERROR(113425, "对账单列表失败"),
	 AGENCY_ACCOUNT_ACCOUNT_ERROR(113426, "新增账号变更信息失败"),
	 AGENCY_ACCOUNT_USER_ERROR(113427, "新增财务对接人变更信息失败"),
	 AGENCY_ACCOUNT_LIST_ERROR(113428, "查询申请表详情失败"),
	 AGENCY_ACCOUNT_DETAIL_ERROR(113429, "查看变更记录失败"),
	 AGENCY_ACCOUNT_ACCOUNT_LIST_ERROR(113430, "获取供应商账户信息失败"),
	 AGENCY_ACCOUNT_CONTACT_LIST_ERROR(113431, "获取供应商联系人信息失败"),
	 AGENCY_ACCOUNT_FILE_ERROR(113432, "获取供应商的账户证明函失败"),
	 AGENCY_DETAIL_INDEMNITY_LIST_ERROR(113433, "赔款单列表失败"),
	 AGENCY_DETAIL_INDEMNITY_CONFIRM_ERROR(113434, "赔款单明细确认失败"),
	 AGENCY_DETAIL_ADVANCE_LIST_ERROR(113435, "预付款列表失败"),
	 AGENCY_DETAIL_ADVANCE_CONFIRM_ERROR(113436, "预付款单明细确认失败"),
	 AGENCY_DETAIL_BILL_LIST_ERROR(113437, "应开发票列表失败"),
	 AGENCY_DETAIL_RELBILL_LIST_ERROR(113437, "实际发票列表失败"),
	 AGENCY_DETAIL_BILL_CONFIRM_ERROR(113438, "实开发票确认失败"),
	 AGENCY_DETAIL_PAY_LIST_ERROR(113439, "付款单列表失败"),
	 AGENCY_BILL_QUERY_COUNT_ERROR(113440, "对账单待确认、已确认数量失败"),
	 AGENCY_BILL_QUERY_DETAIL_ERROR(113441, "对账单待确认、已确认数量失败"),
	 AGENCY_BILL_REVERT_ERROR(113442, "确认操作失败"),
	 AGENCY_BILL_DOWNLOAD_ERROR(113443, "文件下载失败"),	   
	 FINANCE_ACCOUNT_CHECK_ACCOUNT_LIST_ERROR(113444, "获取对账单列表失败"),
	 FINANCE_ACCOUNT_CHECK_ACCOUNT_DETAIL_ERROR(113445, "获取对账单明细失败"),
	 FINANCE_ACCOUNT_PURCHASE_ORDER_LIST_ERROR(113446, "获取结算单列表失败"),
	 FINANCE_ACCOUNT_CONFIRM_PURCHASE_ORDER_DETAIL_ERROR(113447, "结算单明细确认失败"),
	 FINANCE_ACCOUNT_CALCULATE_PAY_ADVANCE_ERROR(113448, "计算提前付款收益失败"),
	 FINANCE_ACCOUNT_APPLY_PAY_ADVANCE_ERROR(113449, "申请提前付款失败"),
	 FINANCE_ACCOUNT_BILL_CONFIRM_INFO_ERROR(113450, "查询供应商已出账单是否确认的条数失败"),
	 FINANCE_ACCOUNT_EXPORT_PURCHASE_LIST_ERROR(113451, "导出结算单列表失败"),
	 FINANCE_ACCOUNT_IS_INVOICEEDIT_ERROR(113452, "判断是否可以进行发票确认失败"),
	 AGENCY_DELETE_ERROR(113453, "删除账号失败"),
	 AGENCY_OPEN_ERROR(113454, "开启账号失败"),
	 AGENCY_CLOSE_ERROR(113455, "关闭账号失败"),
	 AGENCY_DELETE_NO_AUTHORITY_ERROR(113456, "该账号存在子账号，请先删除子账号后，再删除该账号"),
	 FOREIGN_CURRENCY_ERROR(113457,"外币种类查询失败"),
	 SELL_BILL_CONFIRM_ERROR(113458,"零售平台账单确认失败"),
	 ONE_CLICK_CONFIRM_ERROR(113459,"账单一键确认失败"),
	 ABNORMAL_BILL_LAUNCH_ABNORMAL_ERROR(113460, "异常单沟通信息新增失败"),
    ABNORMAL_BILL_ADD_ABNORMAL_ERROR(113461, "异常单沟通信息追加失败"),
    ABNORMAL_BILL_READ_ABNORMAL_ERROR(113462, "异常单沟通信息已读标记更新失败"),
    ABNORMAL_BILL_FINISH_ABNORMAL_ERROR(113463, "异常单沟通办结更新失败"),
    ABNORMAL_BILL_ABNORMAL_LIST_ERROR(113464, "获取异常单沟通记录查询列表失败"),
    ABNORMAL_BILL_ABNORMAL_DETAIL_ERROR(113465, "获取异常单沟通详细信息失败");
	
    private Integer errorCode;
    private String message;

    /**
     * 
     * @param id
     * @param message
     */
    NBookingError(Integer id, String message) {
        this.errorCode = id;
        this.message = message;
    }

    /**
     * @return the id
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}

