package com.bijia.weixin.servlet;

import com.bijia.weixin.service.WeixinSupportImpl;
import com.github.sd4324530.fastweixin.servlet.WeixinServletSupport;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;

public class WeixinServlet extends WeixinServletSupport {
    @Override
    protected WeixinSupport getWeixinSupport() {
            return new WeixinSupportImpl();
    }
}
