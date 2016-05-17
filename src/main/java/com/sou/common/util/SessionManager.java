package com.sou.common.util;

import java.util.Map;

import net.sf.json.JSONObject;

public class SessionManager {
	public static JSONObject getBySessionId(String sessionId) {
		return null;
	}
	
	/**
	 * 获取包含的JSONObject成员对象值
	 * 
	 * @param jsonObject
	 * @param str
	 * @return
	 */
	public static String getAttribute(JSONObject jsonObject, String str) {
		if (jsonObject != null && jsonObject.containsKey(str)) {
			return jsonObject.getString(str);
		} else {
			return "";
		}
	}
	
	public static void update(String sessionId, Integer agencyId, Map<String, String> map) {
		
	}
}
