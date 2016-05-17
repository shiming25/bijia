package com.sou.common.exception;

import java.util.Date;

/**
 * 对异常进行封装的基本异常类
 * @author shiming
 *
 */
public class BaseAppException  extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1187516993124229948L;

	/** 异常标识 */
    private int id;

    /** 异常编码 */
    private String code;

    /** 异常描述.*/
    private String msg;

    /** 异常发生时间 */
    private Date time;

    /** 原始错误堆栈. */
    private Throwable throwable;

    /** 错误类型. 1--内部错误 0--业务错误*/
    private int type;

    /**
     * 默认构造器
     */
    public BaseAppException() {
    	super();
    }
    /**
     * 构造器
     * @param msg  错误消息
     */
    public BaseAppException(String msg) {
        super(msg);
    }
    
    /**
     * 构造器
     * @param code 错误编码
     * @param msg 错误消息
     */
    public BaseAppException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}



	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
    
    
    
}
