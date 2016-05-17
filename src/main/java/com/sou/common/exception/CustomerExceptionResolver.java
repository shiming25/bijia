package com.sou.common.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.sou.common.util.ResponseFormat;



/**
 * 自定义异常处理类
 * 
 * @author shiming
 * 
 */
public class CustomerExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	public ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		ResponseFormat responseVo = new ResponseFormat();
		responseVo.setSuccess(false);
		BaseAppException base = null;
		if (ex instanceof BaseAppException) {
			base = (BaseAppException) ex;
			responseVo.setErrorCode(Integer.parseInt(base.getCode()));
			responseVo.setMsg(base.getMsg());
		} else {
			responseVo.setErrorCode(500);
			responseVo.setMsg("unknow exception!");
		}
		write(response, responseVo);

		return null;
	}

	/**
	 * 按标准格式输出数据
	 * 
	 * @param response
	 * @param result
	 */
	protected void write(HttpServletResponse response, Object result) {
		PrintWriter out = null;
		try {
			JSONObject json = JSONObject.fromObject(result);
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("success", json.get("success"));
			map.put("msg", json.get("msg"));
			map.put("errorCode", json.get("errorCode"));
			//map.put("data", json.get("data"));

			String resStr = Base64.encodeBase64String(JSONObject.fromObject(map).toString().getBytes("UTF-8"));			
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Content-Type","application/json;charset=UTF-8");
			response.setHeader("Access-Control-Allow-Methods", "*");
			out = response.getWriter();
			out.write(resStr);
		} catch (UnsupportedEncodingException e) {
			// log.error("data encode error", e);
		} catch (IOException e) {
			// log.error("data out error", e);
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
	}
}
