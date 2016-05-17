package com.sou.tour.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sou.common.base.BaseController;
import com.sou.common.exception.BaseAppException;
import com.sou.tour.domain.vo.LoginInfoVo;
import com.sou.tour.domain.vo.TourInfoPageVo;
import com.sou.tour.domain.vo.TourInfoVo;
import com.sou.tour.service.ITourIkSearch;
import com.sou.tour.service.impl.MergeIndex;

@Controller
@RequestMapping("/web/tour")
public class TourQryController extends BaseController {

	@Autowired
	ITourIkSearch iTourIkSearch;
	@Autowired
	MergeIndex mergeIndex;
	
	@RequestMapping(value = "/query-top-one", method = RequestMethod.GET)
	@ResponseBody
	public void qryTopOne(Model model, HttpServletRequest request,
			HttpServletResponse response) throws BaseAppException {

		
		TourInfoVo tourInfoVo = this.toBeanObj(request, response, TourInfoVo.class);
		
		TourInfoPageVo tourInfoPageVo = iTourIkSearch.searchTop(tourInfoVo);
		
		sendSuccessDataAsBase64(response, tourInfoPageVo);
	}

	@RequestMapping(value = "/merge-index", method = RequestMethod.GET)
	@ResponseBody
	public void mergeIndex(Model model, HttpServletRequest request,
			HttpServletResponse response) throws BaseAppException {
//		Map ss = request.getParameterMap();
//		request.getp
//		
		LoginInfoVo loginInfoVo = this.toBeanObj(request, response, LoginInfoVo.class);
		
		String result = mergeIndex.mergeAllIndex();
		
		sendSuccessDataAsBase64(response, result);
	}	
	
}
