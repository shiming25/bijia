package com.sou.common.constants;

/**
 * 订单错误码
 * @author xuxiaoting
 *
 */
public enum OrderError {
	
	SUCCESS(113423, "成功"),
	FORMAT_IS_INVALID_ERROR(113422, "解析参数错误(参数没用BASE64编码或是JSON编码 等) "),
	QRY_ORDER_ERROR(113421, "查询订单失败"),
	QRY_ORDER_COUNT_ERROR(113420, "查询订单数量失败"),
	QRY_ORDER_ITEM_ERROR(113419, "查询订单行信息失败"),
	QRY_CONTAINER_ERROR(113418, "查询线路信息失败"),
	QRY_CONTACTER_ERROR(113417, "查询联系人信息失败"),
	QRY_CONTRACT_ERROR(113416, "查询合同/协议信息失败"),
	
	ORDER_NO_AUTHORITY(113415, "没有操作权限"),
	ORDER_CANNOT_EDIT(113414, "订单不能被编辑"),
	SUBMIT_DATA_ERROR(113413, "数据格式错误"),
	CALL_EDITTOURIST_ERROR(113412,"编辑联系人失败"),
	DOWNLOAD_EXCEPTION(113411, "下载失败"),
	ACCEPT_ORDER(113410, "下单"),
	ACCEPT_ORDER_BASE(113411, "创建订单"),
	ACCEPT_ORDER_ITEM_HINT(113413, "保存订单出游需求信息 "),
	ACCEPT_ORDER_ITEM(113412, "下单订单行"),
	DEPART_TIME_ERROR(113409, "团期已过期"),
	DEPART_TIME_IS_NULL(113408, "团期为空"),
	
	QRY_AGENCY_ERROR(113407, "查询供应商信息失败"),
	
	STOCK_OPERATE_ERROR(113406, "库存操作失败"),
	ORDER_OPERATE_ERROR(113405, "订单操作失败"),
	
	TOUR_INFO(113424, "客人"),

	UNKNOWN_ERROR(200100, "未知错误");
	
	
	private Integer errorCode;
    private String message;

    /**
     * 
     * @param id
     * @param message
     */
    OrderError(Integer id, String message) {
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
