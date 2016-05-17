package com.sou.common.exception;

import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.sou.common.util.SpringContextHelper;

/**
 * 异常处理类，统一抛出BaseAppException异常, 统一处理.
 * 
 * @author shiming
 */
public class ExceptionHandler {
	/** 系统错误类型. */
	public static final int SYS_ERROR_TYPE = 1;

	/** 业务错误类型. */
	public static final int BUSI_ERROR_TYPE = 2;

	private static Logger logger = Logger.getLogger(ExceptionHandler.class);

	/** 构造器，私有 */
	private ExceptionHandler() {
	}

	/**
	 * 发布异常,默认错误类型为业务错误.
	 * 
	 * @param errorCode 错误编码
	 * @return BaseAppException
	 * @throws BaseAppException
	 */
	public static BaseAppException publish(String errorCode)
			throws BaseAppException {
		return publish(errorCode, null);
	}

	/**
	 * 发布异常默认错误类型为业务错误.
	 * 
	 * @param errorCode 错误编码
	 * @param msg 错误消息
	 * @return BaseAppException
	 * @throws BaseAppException
	 */
	public static BaseAppException publish(String errorCode, Object[] msg)
			throws BaseAppException {
		return publish(errorCode, BUSI_ERROR_TYPE, null, msg);
	}

	/**
	 * 发布异常默认错误类型为业务错误.
	 * 
	 * @param errorCode 错误编码
	 * @param msg 错误消息
	 * @param t 错误
	 * @return BaseAppException
	 * @throws BaseAppException
	 */
	public static BaseAppException publish(String errorCode, Object[] msg,
			Throwable t) throws BaseAppException {
		return publish(errorCode, BUSI_ERROR_TYPE, t, msg);
	}

	/**
	 * 发布异常
	 * 
	 * @param errorCode 错误代码
	 * @param errorType 错误类型
	 * @param t 错误
	 * @return BaseAppException
	 * @throws BaseAppException
	 */
	public static BaseAppException publish(String errorCode, int errorType,
			Throwable t) throws BaseAppException {
		return publish(errorCode, errorType, t, null);
	}

	/**
	 * 抛出异常
	 * 
	 * @param errorCode
	 * @param errorType
	 * @param t
	 * @param msgParam
	 * @return
	 * @throws BaseAppException
	 */
	public static BaseAppException publish(String errorCode, int errorType,
			Throwable t, Object[]  msgParam) throws BaseAppException {
		StringBuffer errorInfoBuff = new StringBuffer();
		BaseAppException bae = new BaseAppException();
		// 设置错误编码
		bae.setCode(errorCode);
		// 记录错误编码和错误类型
		errorInfoBuff.append("<").append(errorCode).append("> ");
		errorInfoBuff.append(getTypeMsgByTypeCode(errorType));
		String msg = "";
		if (null == msgParam || msgParam.length == 0) {

			msg = getMsgByCode(errorCode,null);// 获取资源文件

		} else {
			msg = getMsgByCode(errorCode,msgParam);; // 获取资源文件，替换参数
		}
		errorInfoBuff.append(msg);
		errorInfoBuff.append(getThrowableTrace(t));
		// 记录错误日志
		logger.error(errorInfoBuff.toString());
		// 设置错误消息
		bae.setMsg(msg);
		bae.setTime(new Date());
		bae.setType(errorType);
		bae.setThrowable(t);

		throw bae;
	}

	/**
	 * 获取异常堆栈
	 * 
	 * @param t
	 * @return
	 */
	private static String getThrowableTrace(Throwable t) {
		StringBuffer sb = new StringBuffer();
		while (t != null) {
			sb.append("\r\nCause by: ");

			sb.append(t.toString());

			for (int i = 0; i < t.getStackTrace().length; i++) {
				sb.append("\r\n\tat ");
				sb.append(t.getStackTrace()[i]);
			}

		}
		return sb.toString();
	}

	/**
	 * 根据错误编码获取错误信息
	 * 
	 * @param errorCode
	 * @return
	 */
	private static String getMsgByCode(String errorCode,Object[] msgParm) {
//		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		ApplicationContext ctx = SpringContextHelper.getApplicationContext();
		//ctx.getMessage(errorCode, args, Locale.CHINA);
		String msg = ctx.getMessage(errorCode, msgParm,"Unknown Message!", Locale.CHINA);
		return msg;
	}

	/**
	 * 根据类型返回描述
	 * 
	 * @param type
	 * @return
	 */
	private static String getTypeMsgByTypeCode(int type) {
		String typeMsg = "";
		if (type == BUSI_ERROR_TYPE) {
			typeMsg = "[Buss Error]";
		} else {
			typeMsg = "[Sys Error]";
		}

		return typeMsg;
	}
}
