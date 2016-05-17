package com.sou.tour.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sou.common.base.BaseController;
import com.sou.common.exception.BaseAppException;
import com.sou.tour.domain.vo.TestVo;

@Controller
@RequestMapping("/web/test")
public class TestController extends BaseController {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public void test(Model model, HttpServletRequest request,
			HttpServletResponse response) throws BaseAppException {
		TestVo test = new TestVo();
		test.setTest1("ttttt");
		test.setTest2("dddd");
		sendSuccessDataAsBase64(response, test);
	}

}
