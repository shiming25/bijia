package com.bijia.weixin.service.qrcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.QrcodeAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.enums.QrcodeType;
import com.github.sd4324530.fastweixin.api.response.QrcodeResponse;

/**
 * 
 * <创建二维码> <br> 
 *  
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class QrCodeServiceImpl {
    
    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(QrCodeServiceImpl.class);
    
    /**
     * 
     * Description: 临时二维码<br> 
     *  
     * @author shi.ming<br>
     * @taskId <br> <br>
     */
    public void createQrCodeService() {
      //获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        //查询菜单
        QrcodeAPI api = new QrcodeAPI(config);
        QrcodeResponse response = api.createQrcode(QrcodeType.QR_SCENE, "100", 2592000);
        LOG.debug("临时二维码生成:{}", response.toJsonString());
    }
    
    /**
     * 
     * Description: 长久二维码<br> 
     *  
     * @author shi.ming<br>
     * @taskId <br> <br>
     */
    public void createLimitQrCodeService() {
        //获取accesssTocken
          ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
          //查询菜单
          QrcodeAPI api = new QrcodeAPI(config);
          QrcodeResponse response = api.createQrcode(QrcodeType.QR_LIMIT_SCENE, "200", 0);
          LOG.debug("长久二维码生成:{}", response.toJsonString());
      }    
    
    /**
     * 
     * Description: 长久字符串二维码<br> 
     *  
     * @author shi.ming<br>
     * @taskId <br> <br>
     */
    public void createLimitStrQrCodeService() {
        //获取accesssTocken
          ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
          //查询菜单
          QrcodeAPI api = new QrcodeAPI(config);
          QrcodeResponse response = api.createQrcode(QrcodeType.QR_LIMIT_STR_SCENE, "","bijia", 0);
          LOG.debug("长久字符串二维码生成:{}", response.toJsonString());
      }        
    
    /**
     * Description: main<br> 
     *  
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        QrCodeServiceImpl qrCodeServiceImpl = new QrCodeServiceImpl();
//        qrCodeServiceImpl.createQrCodeService();
//        qrCodeServiceImpl.createLimitQrCodeService();
        qrCodeServiceImpl.createLimitStrQrCodeService();
    }    
}
