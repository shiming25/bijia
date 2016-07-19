package com.bijia.weixin.service.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;

/**
 * <网页授权> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class OauthServiceImpl {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(OauthServiceImpl.class);

    /**
     * Description: 根据code获取token<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param code <br>
     */
    public OauthGetTokenResponse getTokenService(String code) {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);

        OauthAPI oauthAPI = new OauthAPI(config);
        OauthGetTokenResponse response = oauthAPI.getToken(code);
        LOG.debug("response:{}", response.toJsonString());
        return response;
    }

    /**
     * Description: 刷新token<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param refreshToken <br>
     */
    public void refreshTokenService(String refreshToken) {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);

        OauthAPI oauthAPI = new OauthAPI(config);
        OauthGetTokenResponse response = oauthAPI.refreshToken(refreshToken);
        LOG.debug("response:{}", response.toJsonString());
    }

    /**
     * Description: 获取用户信息<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param token
     * @param openid <br>
     */
    public void getUserInfoService(String token, String openid) {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);

        OauthAPI oauthAPI = new OauthAPI(config);
        GetUserInfoResponse response = oauthAPI.getUserInfo(token, openid);
        LOG.debug("response:{}", response.toJsonString());
    }

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        OauthServiceImpl serviceImpl = new OauthServiceImpl();

        // serviceImpl.getTokenService("021EksC01I32LL1d9NC01pJqC01EksCl");
        // serviceImpl
        // .refreshTokenService("GPrAw6DBydLdyaZMlQDWktrYFfDKXhKVe_tLkeL1EiJ5I0KizL0dQGYujhVQn0f9SpLjV6FaQyI_Z-Q6vsKiDl1nUVAyk8XUi-nhmIV4Vfo");
//        serviceImpl.getUserInfoService("sjr1vFL3CkkCxCAV6OthjfeZAbwC1Rjn9azvR8q6kAXphPnroup4g3zEMVXr5rOYCmWkMIwenak48zV9IeOukdz8_rw2Cz42kghLAz1Z-_w",
//                "o5cJLxMO--ve-tjLy6JbQBxam-ts");
    }
}
