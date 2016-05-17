package com.sou.common.util;

/**
 * 响应格式参数模板类。<br>
 *
 * @author Weier Wang
 */
public class ResponseFormat<T> {

    /**
     * 是否成功标识
     */
    private boolean success = false;

    /**
     * 出错信息或是成功信息
     */
    private String msg;

    /**
     * 错误编码
     */
    private int errorCode;

    /**
     * 返回客户端的数据
     */
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
