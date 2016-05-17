/**
 * 项目名：attractionsTicket
 * 包名：com.tuniu.ticket.util	
 * 文件名：StringUtil.java *
 * 日期：2011-5-10 上午08:23:18
 * Copyright 途牛科技有限公司 2011
 * 版权所有
 */
package com.sou.common.util;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * 此类描述的是：
 * 
 * @author 
 */

public class StringUtil {
	// 过滤通过页面表单提交的字符 yanjun add 20111230
	private static String[][] FilterChars = { { "<", "&lt;" }, { ">", "&gt;" },
			{ " ", "&nbsp;" }, { "\"", "&quot;" }, { "&", "&amp;" },
			{ "/", "&#47;" }, { "\\\\", "&#92;" }, { "\n", "<br>" } };

	public static boolean cheackString(String str) {
		if (str != null && str.length() != 0)
			return true;
		return false;
	}

	public static boolean isNumberOrChar(String string) {
		if (cheackString(string)) {
			char[] chars = string.toCharArray();
			for (char c : chars) {
				if (c < 48 || c > 122 || (c > 57 && c < 65)
						|| (c > 90 && c < 97)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean containNumberAndChar(String name) {
		if(!StringUtils.hasText(name)) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("^\\w+$");
		return pattern.matcher(name).matches();
		
	}
	
	public static boolean isNumber(String string) {
		if (isEmptyStr(string)) {
			return false;
		}
		if (cheackString(string)) {
			char[] chars = string.toCharArray();
			for (char c : chars) {
				if (c < 48 || c > 57) {
					return false;
				}
			}
		}
		return true;
	}

	// yanjun add 20111230
	/**
	 * 替换字符串，能够在HTML页面上直接显示
	 * 
	 * @param str
	 *            String 原始字符串
	 * @return String 替换后的字符串
	 */
	public static String htmlEncode(String str) {
		if (str == null) {
			return null;
		}
		for (int j = 0; j < FilterChars.length; j++) {
			str = str.replaceAll(FilterChars[j][0], FilterChars[j][1]);
		}
		return str;
	}

	/**
	 * 替换字符串，将被编码的转换成原始码
	 * 
	 * @param str
	 *            String
	 * @return String
	 */
	public static String htmlDecode(String str) {
		if (str == null) {
			return null;
		}
		for (int j = 0; j < FilterChars.length; j++) {
			str = str.replaceAll(FilterChars[j][1], FilterChars[j][0]);
		}
		return str;

	}

	/**
	 * 判断是否为整数
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		if (isEmptyStr(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为浮点数，包括double和float
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}

	public static double formartDouble(double dou, String patten) {
		DecimalFormat df = new DecimalFormat(patten);
		return Double.valueOf(df.format(dou));
	}

	/**
	 * 判断输入的字符串是否符合Email样式.
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是Email样式返回true,否则返回false
	 */
	public static boolean isEmail(String str) {
		Pattern pattern = Pattern
				.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入的字符串是否为纯汉字
	 * 
	 * @param str
	 *            传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 是否为空白,包括null,为初始化和""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return str == null || str.isEmpty() || str.trim().length() == 0;
	}

	/**
	 * 数组转字符串
	 * 
	 * @param split
	 *            分割符
	 * @param arr
	 *            字符串数组
	 * @return String
	 */
	public static String implode(String split, String[] arr) {
		String newStr = "";
		int length = arr.length;
		if (length == 0) {
			return newStr;
		}
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				newStr = arr[i];
			} else {
				newStr += split + arr[i];
			}
		}
		return newStr;
	}

	/**
	 * 判断字符串是否为null或为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyStr(String str) {
		return str == null || "".equals(str.trim());
	}
	
	public static String convertXMLSpecialChar(String string) {
		return string.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
	}
}
