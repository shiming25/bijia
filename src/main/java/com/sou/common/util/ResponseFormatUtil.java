package com.sou.common.util;

import com.sou.common.constants.NBookingError;






/**
 * 获取结果集工具类
 * @author weiweiqin
 *
 */
public abstract class ResponseFormatUtil {

	private static ResponseFormat result = new ResponseFormat();

	/**
	 * 获取错误信息结果集
	 * @param errorCode
	 * @param msg
	 * @return
	 */
	public static ResponseFormat getErrorInfo(Integer errorCode, String msg) {
		ResponseFormat result = new ResponseFormat();
		result.setSuccess(false);
		result.setErrorCode(errorCode);
		result.setMsg(msg);
		return result;
	}

	/**
	 * 获取正确结果集
	 * @param data
	 * @return
	 */
	public static ResponseFormat getSuccessInfo(Object data) {
		result.setData(data);
		return result;
	}
	
	/**
	 * 获取正确结果集
	 * @param data
	 * @return
	 */
	public static ResponseFormat getSuccessInfo() {
		return result;
	}
	
	/**
	 * 获得错误的返回消息
	 * 
	 * @param nbError
	 * @return
	 */
	public static ResponseFormat getErrorInfo(NBookingError nbError) {
		ResponseFormat result = new ResponseFormat();
		result.setSuccess(false);
		result.setErrorCode(nbError.getErrorCode());
		result.setMsg(nbError.getMessage());
		return result;
	}
	
	/**
	 * 获得成功的返回消息
	 * 
	 * @param nbError
	 * @return
	 */
	public static ResponseFormat getSuccessInfo(NBookingError nbError) {
		ResponseFormat result = new ResponseFormat();
		result.setSuccess(true);
		result.setErrorCode(nbError.getErrorCode());
		result.setMsg(nbError.getMessage());
		return result;
	}
}
