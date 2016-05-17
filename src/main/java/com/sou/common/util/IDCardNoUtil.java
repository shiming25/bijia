package com.sou.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 身份证号工具类
 * @author 
 *
 */
public class IDCardNoUtil {
	
	private static Log LOG = LogFactory.getLog(DateUtil.class);
	
	public static boolean isAdult(String num){
		boolean result = true;
		if(!"".equals(num)){
			String subNum = null;
			if(num.length() == 18){
				subNum = num.substring(6,14);
			}else if(num.length() == 15){
				//15位是2位年（7－8位），前面加19就可以了
				subNum = "19" + num.substring(6,12);
			}else{
				return false;
			}
			DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			try {
				Calendar  birth = Calendar.getInstance();
				birth.setTime(sdf.parse(subNum));
				Calendar  now = Calendar.getInstance();
				now.setTime(new Date());
	            if ((now.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) < 18){
	                result = false;
	            }else  if ((now.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) == 18){
	            	if(now.get(Calendar.MONTH) > birth.get(Calendar.MONTH)){
	            		result = false;
	            	}else if(now.get(Calendar.MONTH) == birth.get(Calendar.MONTH)){
	            		if(now.get(Calendar.DATE) < birth.get(Calendar.DATE)){
	            			result = false;
	            		}
	            	}
	                
	            }
			    
			} catch (ParseException e) {
				LOG.error("ParseException str = " + subNum);
			}
		}
			
		return result;
	}

}
