package com.bijia.weixin.service.js;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.JsAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.response.GetSignatureResponse;

/**
 * <jssdk> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class JsApiServiceImpl {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(JsApiServiceImpl.class);

    /**
     * Description: Sign<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param code <br>
     */
    public GetSignatureResponse getJsApiSignService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);

        JsAPI jsAPI = new JsAPI(config);
        GetSignatureResponse response = jsAPI.getSignature("http://mp.weixin.qq.com");
        LOG.debug("response:{}", response.toJsonString());
        return response;
    }

    /**
     * Description: Sign<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param nonceStr
     * @param timestame
     * @param url
     * @return <br>
     */
    public GetSignatureResponse getJsApiSignService(String nonceStr, long timestame, String url) {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET, true);

        JsAPI jsAPI = new JsAPI(config);
        GetSignatureResponse response = jsAPI.getSignature(nonceStr, timestame, url);
        LOG.debug("response:{}", response.toJsonString());
        return response;
    }

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        JsApiServiceImpl serviceImpl = new JsApiServiceImpl();

        // serviceImpl.getJsApiSignService();
        serviceImpl.getJsApiSignService("a8fa276699ed4c3db5cb7cd886e099e6", 1469068295,
                "http://www.xuntj.com/test/jssdkdemo.html");

    }
}
