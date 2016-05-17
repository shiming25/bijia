package com.sou.common.util;

/**
 * 请求参数格式。<br>
 * 
 * @author 
 */
public class RequestFormat {

    /**
     * 接口名
     */
    private String func;

    /**
     * 参数
     */
    private Object params;

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

}
