package com.sou.common.util;

/**
 * @author 
 * 
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {

	private static Log LOG = LogFactory.getLog(DateUtil.class);

	/**
	 * Parses a string representing a date by trying a variety of different
	 * parser.
	 * 
	 * @param str
	 * @param parsePattern
	 * @return
	 */
	public static Date parseDate(String str, String parsePattern) {
		try {
			return DateUtils.parseDate(str, new String[] { parsePattern });
		} catch (ParseException e) {
			LOG.error("ParseDate error:str = " + str + ";parsePattern="
					+ parsePattern);
		}
		return null;
	}

	public static Date parseDate(String str) {
		return parseDate(str, "yyyy-MM-dd");
	}

	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		if (day == 1) {
			return 7;
		} else {
			return day - 1;
		}
	}

	public static Date parseDateByYear(String str) {
		return parseDate(str, "yyyy");
	}

	public static Date parseDateTime(String str) {
		return parseDate(str, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 精确到分钟的时间
	 * @param str
	 * @return
	 */
	public static Date parseDateMin(String str) {
		return parseDate(str, "yyyy-MM-dd HH:mm");
	}

	/**
	 * format data to my style
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat myFmt = new SimpleDateFormat(format);
		myFmt.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		if(null == date) {
			return "";
		}
		return myFmt.format(date);
	}

	public static String formatDate(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static String formatDateMin(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm");
	}


	/**
	 * 不需要考虑8小时时差
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate2(Date date, String format) {
		SimpleDateFormat myFmt = new SimpleDateFormat(format);
		return myFmt.format(date);
	}

	public static String formatDate2(Date date) {
		return formatDate2(date, "yyyy-MM-dd");
	}

	public static String formatDateTime2(Date date) {
		return formatDate2(date, "yyyy-MM-dd HH:mm");
	}

	public static boolean dateCompare(Date dat1, Date dat2) {
		boolean dateComPareFlag = true;
		if (dat2.compareTo(dat1) != 1) {
			dateComPareFlag = false; // 
		}
		return dateComPareFlag;
	}

	/**
	 * 获取距离date+days天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getSomeDay(Date date, int days) {
		return DateUtils.addDays(date, days);
	}

	@SuppressWarnings("static-access")
	public static Date setHour(Date date, int hour) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.HOUR_OF_DAY, hour);
		return c.getTime();
	}

	/**
	 * 让日期加1
	 * @param date
	 * @return
	 */
	public static Date addOne(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.get(Calendar.DAY_OF_MONTH) + 1);
		return calendar.getTime();
	}
	
	public static Date addDay(Date date,int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE,
				calendar.get(Calendar.DATE) + day);
		return calendar.getTime();
	}	
	
	/**
	 * 获取年份
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return year;
	}
	/**
	 * 获取月份
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.MONTH);
		return year;
	}
	/**
	 * 获取日
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.DAY_OF_MONTH);
		return year;
	}	
	
	/**
     * 获取两个日期之间的天数
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getBetweenDays(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        Long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }
    
    /**
	 * 返回两个时间相差几天，此天数是模糊的（例如：startDate：2013-06-27 15:00 ,endDate:2013-06-28 09:00
	 * 返回1）
	 */
    public static Long getAmbiguousBetweenDays(Date startDate, Date endDate){
    	Calendar startDateCalendar=Calendar.getInstance();
    	Calendar endDateCalendar=Calendar.getInstance();
    	startDateCalendar.setTime(startDate);
    	endDateCalendar.setTime(endDate);
    	startDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
    	startDateCalendar.set(Calendar.MINUTE, 0);
    	startDateCalendar.set(Calendar.SECOND, 0);
    	endDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
    	endDateCalendar.set(Calendar.MINUTE, 0);
    	endDateCalendar.set(Calendar.SECOND, 0);
    	return getBetweenDays(startDateCalendar.getTime(), endDateCalendar.getTime());
    }
	
	/**
	 * 日期减day
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date subDay(Date date,int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE,
				calendar.get(Calendar.DATE) - day);
		return calendar.getTime();
	}

}
