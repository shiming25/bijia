/**
 * 
 */
package com.sou.match.service;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

/**
 * @author haier
 * 
 */
@Service
public interface ICrawTaobaoPage {

	public JSONObject crawPage(JSONObject paramObj);
}
