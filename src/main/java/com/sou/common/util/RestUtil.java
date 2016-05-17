package com.sou.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sou.common.rest.RestException;
import com.sou.common.rest.RestMethod;
import com.sou.common.rest.RestServer;




public class RestUtil {
    private static final Logger LOG = LoggerFactory.getLogger(RestUtil.class);

    /**
     * 
     * 此方法描述的是：设置response head
     * 
     * @param response
     *            HttpServletResponse
     */
    private static void setHead(HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type","application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Methods", "*");
    }

    /**
     * rest 输出Base64
     * 
     * @param response
     * @param vo
     * @throws IOException
     */
    public static void writeAsBase64(HttpServletResponse response, Object object) {
    	setHead(response);

    	JSONObject json = JSONObject.fromObject(object);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("success", json.get("success"));
		map.put("msg", json.get("msg"));
		map.put("errorCode", json.get("errorCode"));
		map.put("data", json.get("data"));
    	
        try {
			response.getWriter().print(Base64.encodeBase64String(JSONObject.fromObject(map).toString().getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			LOG.error("UnsupportedEncodingException : ", e);
		} catch (IOException e) {
			LOG.error("IOException", e);
		}
    }
    
    /**
     * rest 输出原始数据
     * 
     * @param response
     * @param vo
     * @throws IOException
     */
    public static void write(HttpServletResponse response, Object object) {
    	setHead(response);

    	JSONObject json = JSONObject.fromObject(object);
//		Map<String, Object> map = new LinkedHashMap<String, Object>();
//		map.put("success", json.get("success"));
//		map.put("msg", json.get("msg"));
//		map.put("errorCode", json.get("errorCode"));
//		map.put("data", json.get("data"));
    	
        try {
			response.getWriter().print(json.toString());
		} catch (UnsupportedEncodingException e) {
			LOG.error("UnsupportedEncodingException", e);
		} catch (IOException e) {
			LOG.error("IOException", e);
		}
    }
    
    /**
     * 返回crm接口数据格式
     * @param response
     * @param object
     */
    public static void writeAsBase64ForCrm(HttpServletResponse response, Object object) {
    	setHead(response);
        try {
			response.getWriter().print(Base64.encodeBase64String(JSONObject.fromObject(object).toString().getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			LOG.error("UnsupportedEncodingException", e);
		} catch (IOException e) {
			LOG.error("IOException", e);
		}
    }

    /**
     * rest 输入
     * 
     * @param request
     * @param response
     * @return
     * @throws RestException 
     * @throws IOException
     */
    public static String getData(HttpServletRequest request, HttpServletResponse response) throws RestException {
        RestServer server = new RestServer(request, response);
        return server.getRestData();
    }

    public static String getData(HttpServletRequest request) throws RestException {
        String method = request.getMethod();
        String ret = null;
        if (method.equalsIgnoreCase(RestMethod.GET) || method.equalsIgnoreCase(RestMethod.DELETE)) {
            ret = request.getQueryString();
        } else {
            ret = getBodyData(request);
        }
        if (ret == null) {
            return null;
        }
        return ret;
    }

    private static String getBodyData(HttpServletRequest request) throws RestException {
        StringBuffer data = new StringBuffer();
        String line = null;
        BufferedReader reader;
        try {
            reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
        } catch (IOException e) {
            throw new RestException(e.getMessage(), e.getCause());
        }
        return data.toString();
    }

}
