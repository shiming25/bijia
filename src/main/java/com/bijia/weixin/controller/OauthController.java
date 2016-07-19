package com.bijia.weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bijia.weixin.service.oauth.OauthServiceImpl;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;
import com.sou.common.base.BaseController;
import com.sou.common.exception.BaseAppException;
import com.sou.match.service.ICrawTaobaoPage;

@Controller
@RequestMapping("/oauth")
public class OauthController extends BaseController {
    @Autowired
    ICrawTaobaoPage iCrawTaobaoPage;
    static {
        System.out.println("bbbbbbbb");
    }

    /**
     * 
     * Description: 获取token<br> 
     *  
     * @author shi.ming<br>
     * @taskId <br>
     * @param model
     * @param request
     * @param response
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    @ResponseBody
    public void getToken(Model model, HttpServletRequest request,
            HttpServletResponse response) throws BaseAppException {

        JSONObject paramObj = this.getJsonDataObj(request, response);
        String code = paramObj.getString("code");

        OauthServiceImpl serviceImpl = new OauthServiceImpl();
        OauthGetTokenResponse resultObj = serviceImpl.getTokenService(code);

        sendSuccessDataAsBase64(response, resultObj);
    }
}
