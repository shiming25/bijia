package com.sou.common.util.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	public static void addCookie(HttpServletResponse response, String name,
			String value) {
		Cookie cookie = new Cookie(name, value);
		response.addCookie(cookie);
	}

	public static String getCookieValueByKey(HttpServletRequest request,
			String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public static void deleteCookieByName(HttpServletRequest request,
			String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals(name))
					cookie.setMaxAge(0);
	}

	public static void setCookieAgeByName(HttpServletRequest request,
			String name, int age) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals(name))
					cookie.setMaxAge(age);
	}
}
