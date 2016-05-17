package com.sou.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * http://localhost:8080/tour/getImg?url=http://image.8264.com/ecmme/wan/xl/goods/20140909/201409090919128469_list.jpg
 * @author haier
 *
 */
public class GetHtmlServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetHtmlServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
//			String jsonStr = request.getParameter("param");
//	        System.out.println(jsonStr);
//	       JSONObject json = JSONObject.parseObject(jsonStr);
	       
//	        String address = json.getString("wxurl");
	        String picPath = request.getQueryString();

	        String address = picPath.substring(4, picPath.length());
			
	        if (null == address || "".equals(address)) {
	        }
		    URL url = new URL(address);
	        HttpURLConnection Connection = (HttpURLConnection) url.openConnection();
	        InputStreamReader is = new InputStreamReader(Connection.getInputStream());
	        BufferedReader br = new BufferedReader(is);
	        StringBuilder sb = new StringBuilder();
	        // new String 的参数byte,offset,len
	        String str = null;
	        while (null !=(str = br.readLine())) {
	            sb.append(str); // 最后一次的长度不一定为1024
	        }
	        is.close();
	        String strString = sb.toString();
	        strString = strString.replaceAll("data-src", "rel=\"mmbiz.qpic.cn\" src");
	        System.out.println(strString);
	        Pattern pattern = Pattern.compile("(var msg_source_url).*(var img_format =)");
			Matcher matcher = pattern.matcher(strString);
			System.out.println("eeee");
			if (matcher.find()) {
				System.out.println("dfdfd");
				System.out.println(matcher.group(0));
			}
			
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("textml");
			response.getWriter().append(strString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
