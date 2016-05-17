package com.sou.common.base;

import com.sou.common.constants.OrderParam;



/**
 * 登录信息
 * @author 
 *
 */
public class LoginInfo {
	
	/**
	 * 对象标识（根据subject_type分成agency_id和途牛员工登录账号两种）
	 */
	private Integer subject;
	
	/**
	 * 对象类型 1供应商 2途牛员工 3供应商手机登录
	 */
	private Integer subjectType;
	
	/**
	 * 角色：1供应商 2途牛客服 3途牛管理员 4手机注册用户 0无
	 */
	private Integer subjectRole;
	
	/**
	 * 供应商名称
	 */
	private String subjectName;
	
	/**
	 * 登录人名称
	 */
	private String displayName;
	/**
	 * 客户端ip
	 */
	private String clientIp;

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public Integer getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Integer subjectType) {
		this.subjectType = subjectType;
	}

	public Integer getSubjectRole() {
		return subjectRole;
	}

	public void setSubjectRole(Integer subjectRole) {
		this.subjectRole = subjectRole;
	}

	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public boolean isAgency(){
		if(subjectType == OrderParam.SUBJECT_TYPE_AGENCY){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isStaff(){
		if(subjectType == OrderParam.SUBJECT_TYPE_STAFF){
			return true;
		}else{
			return false;
		}
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
