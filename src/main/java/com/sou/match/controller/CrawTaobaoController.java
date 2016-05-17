package com.sou.match.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sou.common.base.BaseController;
import com.sou.common.exception.BaseAppException;
import com.sou.match.service.ICrawTaobaoPage;

@Controller
@RequestMapping("/test")
public class CrawTaobaoController  extends BaseController {
	@Autowired
	ICrawTaobaoPage iCrawTaobaoPage;
	static {System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");}
	@RequestMapping(value = "/taobao", method = RequestMethod.GET)
	@ResponseBody
	public void crawPage(Model model, HttpServletRequest request,
			HttpServletResponse response) throws BaseAppException {

		
		JSONObject paramObj = this.getJsonDataObj(request, response);
		
		
		JSONObject resultObj = iCrawTaobaoPage.crawPage(paramObj);
		
		sendSuccessDataAsBase64(response, resultObj);
	}
}
