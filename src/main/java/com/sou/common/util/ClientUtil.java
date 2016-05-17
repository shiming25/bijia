package com.sou.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class ClientUtil {

    public static String getClientIpWithProxy(HttpServletRequest request) {
        String ipAddress = "";
        
        ipAddress = request.getHeader("X-Real-IP");
        
        if ((!StringUtils.hasText(ipAddress)) || ("unknown".equalsIgnoreCase(ipAddress))) {
            ipAddress = request.getHeader("x-forwarded-for");
        }
        
        if ((!StringUtils.hasText(ipAddress)) || ("unknown".equalsIgnoreCase(ipAddress))) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if ((!StringUtils.hasText(ipAddress)) || ("unknown".equalsIgnoreCase(ipAddress))) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((!StringUtils.hasText(ipAddress)) || ("unknown".equalsIgnoreCase(ipAddress))) {
            ipAddress = request.getRemoteAddr();
        }
        
        if ((ipAddress != null) && (ipAddress.length() > 15) && (ipAddress.indexOf(",") > 0)) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }
        
        return ipAddress;
    }
    
    public static String getDomain(HttpServletRequest request) {
    	String domain = request.getServerName();
    	return domain;
    }
	
}
