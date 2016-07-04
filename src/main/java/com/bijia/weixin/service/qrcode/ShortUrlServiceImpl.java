package com.bijia.weixin.service.qrcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.QrcodeAPI;
import com.github.sd4324530.fastweixin.api.SystemAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.enums.QrcodeType;
import com.github.sd4324530.fastweixin.api.response.QrcodeResponse;

/**
 * <长链接转短链接接口> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class ShortUrlServiceImpl {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(ShortUrlServiceImpl.class);

    /**
     * Description: 长链接转短链接接口<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void shortUrlService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 查询菜单
        SystemAPI api = new SystemAPI(config);
        String response = api.getShortUrl("http://wap.koudaitong.com/v2/showcase/goods?alias=128wi9shh&spm=h56083&redirect_count=1");
        LOG.debug("长链接转短链接接口:{}",response);
    }

    

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        ShortUrlServiceImpl serviceImpl = new ShortUrlServiceImpl();
        serviceImpl.shortUrlService();
    }
}
