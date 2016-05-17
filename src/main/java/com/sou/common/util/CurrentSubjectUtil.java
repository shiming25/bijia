package com.sou.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sou.common.util.cookie.CookieUtil;

/**
 * 用于获得当前登录的用户信息
 * @author wangxin4
 */
public class CurrentSubjectUtil {

	/**
	 * 返回cookie中的所有信息
	 * @param request
	 * @return
	 */
    public static Map<String,Object> getAll(HttpServletRequest request) {
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("subject", getSubject(request));
        result.put("subjectName", getSubjectName(request));
        result.put("displayName", getDisplayName(request));
        result.put("subjectType", getSubjectType(request));
        result.put("subjectRole", getSubjectRole(request));
        return result;
    }
    
    /**
     * @param request
     * @return String 若未登录，则返回null
     */
    public static String getSubject(HttpServletRequest request) {
    	return CookieUtil.getCookieValueByKey(request, "subject");
    }
    
    /**
     * @param request
     * @return String 若未登录，则返回null
     */
    public static String getSubjectName(HttpServletRequest request) {
    	return CookieUtil.getCookieValueByKey(request, "subjectName");
    }
    
    /**
     * @param request
     * @return String 若未登录，则返回null
     */
    public static String getDisplayName(HttpServletRequest request) {
    	String displayName = CookieUtil.getCookieValueByKey(request, "displayName");
    	if(displayName == null) {
    		return null;
    	}
    	try {
			if (displayName.equals(new String(displayName.getBytes("UTF-8"), "UTF-8"))) {
				return URLDecoder.decode(displayName, "UTF-8");
			}
			return displayName;
		} catch (UnsupportedEncodingException e) {
			return displayName;
		}
    }

    /**
     * @param request
     * @return String 若未登录或当前用户类型不为供应商，则返回null
     */
    public static String getCompanyName(HttpServletRequest request) {
    	String companyName = CookieUtil.getCookieValueByKey(request, "companyName");
    	if(companyName == null) {
    		return null;
    	}
    	try {
			if (companyName.equals(new String(companyName.getBytes("UTF-8"), "UTF-8"))) {
				return URLDecoder.decode(companyName, "UTF-8");
			}
			return companyName;
		} catch (UnsupportedEncodingException e) {
			return companyName;
		}
    }
    
    /**
     * 返回当前用户类型
     * @param request
     * @return byte 若未登录，则返回0
     */
	public static byte getSubjectType(HttpServletRequest request) {
		String subjectTypeCookieStr = CookieUtil.getCookieValueByKey(request, "subjectType");
		byte subjectTypeCookie = 0;
		if(subjectTypeCookieStr != null) {
			subjectTypeCookie = Byte.parseByte(subjectTypeCookieStr);
		}
		return subjectTypeCookie;
	}
	
	/**
	 * 返回当前用户角色编号
	 * @param request
	 * @return int 若未登录，则返回0
	 */
	public static int getSubjectRole(HttpServletRequest request) {
		String subjectRoleStr = CookieUtil.getCookieValueByKey(request, "subjectRole");
		int subjectRole = 0;
		if(subjectRoleStr != null) {
			subjectRole = Integer.parseInt(subjectRoleStr);
		}
		return subjectRole;
	}
	
}
