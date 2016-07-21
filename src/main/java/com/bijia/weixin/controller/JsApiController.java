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

import com.bijia.weixin.service.js.JsApiServiceImpl;
import com.github.sd4324530.fastweixin.api.response.GetSignatureResponse;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.sou.common.base.BaseController;
import com.sou.common.exception.BaseAppException;
import com.sou.match.service.ICrawTaobaoPage;

@Controller
@RequestMapping("/jsapi")
public class JsApiController extends BaseController {
    @Autowired
    ICrawTaobaoPage iCrawTaobaoPage;
    static {
        System.out.println("bbbbbbbb");
    }

    /**
     * Description: 获取token<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param model
     * @param request
     * @param response
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    @ResponseBody
    public void getSign(Model model, HttpServletRequest request,
            HttpServletResponse response) throws BaseAppException {

        JSONObject paramObj = this.getJsonDataObj(request, response);
        String noncestr = paramObj.getString("noncestr");
        String timestampStr = paramObj.getString("timestamp");
        String url = paramObj.getString("url");
        long timestamp = Long.parseLong(timestampStr);

        JsApiServiceImpl serviceImpl = new JsApiServiceImpl();
        GetSignatureResponse resultObj = serviceImpl.getJsApiSignService(noncestr, timestamp, url);

        sendData(response, resultObj);
    }
}
