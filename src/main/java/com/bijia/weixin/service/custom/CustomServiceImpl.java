package com.bijia.weixin.service.custom;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.CustomAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.CustomAccount;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.GetCustomAccountsResponse;
import com.github.sd4324530.fastweixin.message.TextMsg;

/**
 * <客服接口> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class CustomServiceImpl {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustomServiceImpl.class);

    /**
     * Description: 添加客服信息<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void addCustomAccountService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        CustomAPI customAPI = new CustomAPI(config);

        CustomAccount customAccount = new CustomAccount();
        customAccount.setAccountName("peiyu@i-xiaoshuo");
        customAccount.setNickName("帅哥");
        customAccount.setPassword("666666");
        ResultType resultType = customAPI.addCustomAccount(customAccount);
        LOG.debug("添加结果:{}", resultType.toString());
    }

    /**
     * Description: 更新客服信息<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void updateCustomAccountService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        CustomAPI customAPI = new CustomAPI(config);

        CustomAccount customAccount = new CustomAccount();
        customAccount.setAccountName("peiyu@i-xiaoshuo");
        customAccount.setNickName("客服1");
        customAccount.setPassword("666666");
        ResultType resultType = customAPI.updateCustomAccount(customAccount);
        LOG.debug("添加结果:{}", resultType.toString());
    }

    /**
     * Description:删除客服 <br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void deleteCustomAccountService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        CustomAPI customAPI = new CustomAPI(config);

        ResultType resultType = customAPI.deleteCustomAccount("peiyu@i-xiaoshuo");
        LOG.debug("添加结果:{}", resultType.toString());
    }

    /**
     * Description:客服头像 <br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void uploadHeadImgService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        CustomAPI customAPI = new CustomAPI(config);

        File file = new File("e:/temp/test/p2.jpg");
        ResultType resultType = customAPI.uploadHeadImg("peiyu@i-xiaoshuo", file);
        LOG.debug("添加结果:{}", resultType.toString());
    }

    /**
     * Description: 客服列表<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void getCustomAccountListService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        CustomAPI customAPI = new CustomAPI(config);

        GetCustomAccountsResponse resultType = customAPI.getCustomAccountList();
        LOG.debug("添加结果:{}", resultType.toString());
    }

    /**
     * Description:发送客服信息 <br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void sendCustomMessageService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        CustomAPI customAPI = new CustomAPI(config);
        TextMsg msg = new TextMsg("custorm text msg2");
        ResultType resultType = customAPI.sendCustomMessage("o5cJLxMO--ve-tjLy6JbQBxam-ts", "", msg);
        LOG.debug("添加结果:{}", resultType.toString());
    }

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        CustomServiceImpl serviceImpl = new CustomServiceImpl();
        // serviceImpl.addCustomAccountService();
        // serviceImpl.updateCustomAccountService();
        // serviceImpl.deleteCustomAccountService();
        // serviceImpl.uploadHeadImgService();
        // serviceImpl.getCustomAccountListService();
        serviceImpl.sendCustomMessageService();
    }
}
