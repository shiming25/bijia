package com.sou.common.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

import com.sou.common.constants.NBookingError;
import com.sou.common.constants.OrderErrorCode;
import com.sou.common.exception.BaseAppException;
import com.sou.common.exception.ExceptionHandler;
import com.sou.common.rest.RestException;
import com.sou.common.util.ClientUtil;
import com.sou.common.util.CurrentSubjectUtil;
import com.sou.common.util.ResponseFormat;
import com.sou.common.util.ResponseFormatUtil;
import com.sou.common.util.RestUtil;
import com.sou.common.util.StringUtil;
import com.sou.common.util.jackson.JackJsonUtil;

/**
 * 控制器基类
 * 
 * @author
 * 
 */
public class BaseController {

	/**
	 * base64 编码输出数据
	 * 
	 * @param response
	 * @param object
	 * @throws IOException
	 */
	public void sendDataAsBase64(HttpServletResponse response, Object object) {
		RestUtil.writeAsBase64(response, object);
	}
	
	protected void write(HttpServletResponse response, Object object) {
		RestUtil.writeAsBase64(response, object);
	}
	/**
	 * 返回成功数据 返回list
	 * @param response
	 * @param listData
	 */
	public void sendSuccessDataAsBase64(HttpServletResponse response, List listData) {
		sendDataAsBase64(response, JackJsonUtil.toJson(getListSuccessReponseVo(listData)));
	}	
	
	/**
	 * 返回成功数据
	 * @param response
	 * @param listData
	 */
	public void sendSuccessDataGrid(HttpServletResponse response, List listData) {
		sendData(response, JackJsonUtil.toJson(getGridSuccessReponseVo(listData)));
	}
	
	/**
	 * 发送成功数据，返回对象
	 * @param response
	 * @param objData
	 */
	public void sendSuccessDataAsBase64(HttpServletResponse response, Object objData) {
		sendDataAsBase64(response, JackJsonUtil.toJson(getObjSuccessReponseVo(objData)));
	}	
	
	/**
	 * 获取成功数据 返回列表
	 * @param listData 列表数据
	 * @return ResponseFormat
	 */
	public ResponseFormat getListSuccessReponseVo(List listData) {
		ResponseFormat responseVo = new ResponseFormat();
		responseVo.setSuccess(true);
		responseVo.setErrorCode(0);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("count", listData.size());
		returnMap.put("rows", listData);
		responseVo.setData(returnMap);
		return responseVo;
	}
	
	/**
	 * 获取表格需要的数据格式
	 * @param listData
	 * @return
	 */
	public Map<String, Object> getGridSuccessReponseVo(List listData) {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("total", listData.size());
		returnMap.put("rows", listData);

		return returnMap;
	}	
	
	/**
	 * 获取成功数据，返回对象
	 * @param objData
	 * @return
	 */
	public ResponseFormat getObjSuccessReponseVo(Object objData) {
		ResponseFormat responseVo = new ResponseFormat();
		responseVo.setSuccess(true);
		responseVo.setErrorCode(0);
		responseVo.setData(objData);
		
		return responseVo;
	}
	
	/**
	 * 输出原始数据
	 * 
	 * @param response
	 * @param object
	 * @throws IOException
	 */
	public void sendData(HttpServletResponse response, Object object) {
		RestUtil.write(response, object);
	}

	/**
	 * base64 解码获取数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public JSONObject getJsonData(HttpServletRequest request,
			HttpServletResponse response) throws RestException {
		String result = this.getData(request, response);
		JSONObject jsonObject = JSONObject.fromObject(result);
		return jsonObject;
	}
	
	/**
	 * base64 解码获取数据
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseAppException
	 */
	public JSONObject getJsonDataObj(HttpServletRequest request,
			HttpServletResponse response) throws BaseAppException {
		String result = "";
		try {
			result = this.getData(request, response);
		} catch (RestException e) {
			ExceptionHandler.publish(OrderErrorCode.REST_GETDATA_ERROR,ExceptionHandler.SYS_ERROR_TYPE,e);
		}
		JSONObject jsonObject = JSONObject.fromObject(result);
		return jsonObject;
	}

	/**
	 * base64 解码获取数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public String getData(HttpServletRequest request,
			HttpServletResponse response) throws RestException {
		String ret =  RestUtil.getData(request, response);
//		ret = cleanXSS(ret);
		return ret;
	}


	//对请求的参数过滤一些关键字，替换成安全的，例如：< > ' " \ /  # &
	private String cleanXSS(String value) {
		// You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		//value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
	}


	/**
	 * base64 解码获取数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public <T> T toBean(HttpServletRequest request,
			HttpServletResponse response, Class<T> beanClass)
			throws RestException {
		return (T) JackJsonUtil.toBean(this.getData(request, response),
				beanClass);
	}
	
	/**
	 * base64 解码获取数据，设置jackjson 配置，比如日期格式
	 * @param request
	 * @param response
	 * @param beanClass
	 * @param configObj
	 * @return
	 * @throws RestException
	 */
	public <T> T toBean(HttpServletRequest request,
			HttpServletResponse response, Class<T> beanClass,Object... configObj)
			throws RestException {
		return (T) JackJsonUtil.toBean(this.getData(request, response),
				beanClass,configObj);
	}
	
	/**
	 * base64 解码获取数据，设置jackjson 配置，比如日期格式 抛出BaseAppException
	 * @param request
	 * @param response
	 * @param beanClass
	 * @param configObj
	 * @return BaseAppException
	 * @throws BaseAppException
	 */
	public <T> T toBeanObj(HttpServletRequest request,
			HttpServletResponse response, Class<T> beanClass,Object... configObj)
			throws BaseAppException {
		T obj = null;
		try {
			obj = (T) JackJsonUtil.toBean(this.getData(request, response),
					beanClass,configObj);
		} catch (RestException e) {
			ExceptionHandler.publish(OrderErrorCode.REST_GETDATA_ERROR,ExceptionHandler.SYS_ERROR_TYPE,e);
		}
		return obj;
	}	

	/**
	 * 获取原始数据
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String getData(HttpServletRequest request) throws RestException {
		String ret =  RestUtil.getData(request);
		ret = cleanXSS(ret);
		return ret;

	}
	

	/**
	 * 获取原始数据
	 * 
	 * @param request
	 * @return
	 * @throws BaseAppException 
	 * @throws IOException
	 */
	public String getDataObj(HttpServletRequest request) throws BaseAppException  {
		String retStr = "";
		try {
			retStr = RestUtil.getData(request);
			retStr = cleanXSS(retStr);
		} catch (RestException e) {
			ExceptionHandler.publish(OrderErrorCode.REST_GETDATA_ERROR,ExceptionHandler.SYS_ERROR_TYPE,e);
		}
		return retStr;
	}	

	/**
	 * 获取原始数据
	 * 
	 * @param request
	 * @param beanClass
	 * @return
	 * @throws IOException
	 */
	public <T> T toBean(HttpServletRequest request, Class<T> beanClass)
			throws RestException {
		return (T) JackJsonUtil.toBean(this.getData(request), beanClass);
	}

	/**
	 * 从request中获取JSON格式的参数
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public JSONObject getJsonFromParams(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return JSONObject.fromObject(request.getParameterMap());
	}

	public String getClientIpWithProxy(HttpServletRequest request) {
		String ipAddress = "";

		ipAddress = request.getHeader("X-Real-IP");

		if ((!StringUtils.hasText(ipAddress))
				|| ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("x-forwarded-for");
		}

		if ((!StringUtils.hasText(ipAddress))
				|| ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if ((!StringUtils.hasText(ipAddress))
				|| ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((!StringUtils.hasText(ipAddress))
				|| ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getRemoteAddr();
		}

		if ((ipAddress != null) && (ipAddress.length() > 15)
				&& (ipAddress.indexOf(",") > 0)) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}

		return ipAddress;
	}

	/**
	 * 将json对象转换成Map
	 * 
	 * @param jsonObject
	 *            json对象
	 * @return Map对象
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> toMap(JSONObject jsonObject) {
		Map<String, Object> result = new HashMap<String, Object>();
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		Object value = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = jsonObject.get(key);
			result.put(key, value);
		}
		return result;
	}
	public Map<String, Object> getMapFromParams(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		@SuppressWarnings("rawtypes")
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = (String) names.nextElement();
			result.put(name, request.getParameter(name));
		}
		return result;
	}
	

	@SuppressWarnings("unchecked")
	public <T> T mapToBean(Map<String, Object> param, Class<T> beanClass) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException, ParseException  {
		Object obj = beanClass.newInstance();
		Field[] fields = beanClass.getDeclaredFields();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			if (param.containsKey(name)) {
				Field field = obj.getClass().getDeclaredField(name);
				field.setAccessible(true);
				String type = field.getType().getSimpleName();
				if(type.toString().equals("Integer")){
					if(param.get(name) != null && !"".equals(param.get(name))){
						Integer value = Integer.valueOf((String) param.get(name));
						field.set(obj, value);
					}
				} else if(type.toString().equals("String")){
					if(param.get(name) != null && !"".equals(param.get(name))){
						String value = (String) param.get(name);
						field.set(obj, value);
					}
				} else if(type.toString().equals("Date")){
					if(param.get(name) != null && !"".equals(param.get(name))){
						Date value = format.parse((String) param.get(name));
						field.set(obj, value);
					}
				} else if(type.toString().equals("Timestamp")){
					if(param.get(name) != null && !"".equals(param.get(name))){
						Date value = format.parse((String) param.get(name));
						field.set(obj, new Timestamp(value.getTime()));
					}
				} else if(type.toString().equals("BigDecimal")){
					if(param.get(name) != null && !"".equals(param.get(name))){
						field.set(obj, new BigDecimal((String) param.get(name)));
					}
				}
			}
		}
		
		return (T) obj;
	}

	public LoginInfo getLoginInfo(HttpServletRequest request){
		Map<String,Object> result = CurrentSubjectUtil.getAll(request);
		String ip = ClientUtil.getClientIpWithProxy(request);
		 result.put("clientIp", ip);
		LoginInfo obj = JackJsonUtil.toBean(JSONObject.fromObject(result).toString(), LoginInfo.class);
		return obj;
	}
	
	/**
	 * 按标准格式输出数据
	 * @param response
	 * @param result
	 */
	protected void writeFinance(HttpServletResponse response, Object result) {
		PrintWriter out = null;
		try {
			if(null == result || JSONUtils.isNull(result)) {
				result = ResponseFormatUtil.getErrorInfo(NBookingError.SYSTEM_BLACK);
			}
			JSONObject json = JSONObject.fromObject(result);
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			if(json.containsKey("errorCode")) {
				map.put("errorCode", json.get("errorCode"));
			} else {
				map.put("errorCode", 0);
			}
			
			if(json.containsKey("data")) {
				map.put("data", json.get("data"));
			} else {
				json.put("data", new JSONObject());
			}
			
			if(json.containsKey("success")) {
				map.put("success", json.get("success"));
				if(!json.getBoolean("success")) {
					json.put("data", new JSONObject());
				}
			} else {
				map.put("success", true);
			}
			
			if(json.containsKey("msg")) {
				Object msgObj = json.get("msg");
				map.put("msg", msgObj);
				if(!JSONUtils.isNull(msgObj)) {
					String msg = json.getString("msg");
					//if(!StringUtil.isEmpty(msg) && msg.length() > 50){
					if(!StringUtil.isEmptyStr(msg) && msg.length() > 50) {
						map.put("msg", "操作失败!");
					}
				}
			}
			
			String resStr = Base64.encodeBase64String(JSONObject.fromObject(map).toString().getBytes("UTF-8"));
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Content-Type","application/json;charset=UTF-8");
			response.setHeader("Access-Control-Allow-Methods", "*");
			out = response.getWriter();
			out.write(resStr);
		} catch (Exception e) {
			//LogError.error(e);
		} finally {
			if(null != out) {
				out.flush();
				out.close();
			}
		}
	}		
	
	/**
	 * 财务结算异常操作
	 * @param response
	 * @param result
	 * @param ex
	 */
	protected void writeFinanceExeception(HttpServletResponse response, Object result,Exception ex) {
		PrintWriter out = null;
		try {
//			if(null == result || JSONUtils.isNull(result)) {
//				result = ResponseFormatUtil.getErrorInfo(NBookingError.SYSTEM_BLACK);
//			}			
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("errorCode", "500");
			map.put("data", ex.getMessage());
			map.put("success", false);
			map.put("msg", "操作失败!");
			
			String resStr = Base64.encodeBase64String(JSONObject.fromObject(map).toString().getBytes("UTF-8"));
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Content-Type","application/json;charset=UTF-8");
			response.setHeader("Access-Control-Allow-Methods", "*");
			out = response.getWriter();
			out.write(resStr);
		} catch (Exception e) {
			//LogError.error(e);
		} finally {
			if(null != out) {
				out.flush();
				out.close();
			}
		}
	}	
	
	/**
	 * 返回crm接口数据格式
	 * @param response
	 * @param object
	 */
	public void sendDataAsBase64ForCrm(HttpServletResponse response, Object object) {
		RestUtil.writeAsBase64ForCrm(response, object);
	}
	
}
