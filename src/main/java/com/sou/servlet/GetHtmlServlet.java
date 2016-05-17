package com.sou.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * http://localhost:8080/tour/getImg?url=http://image.8264.com/ecmme/wan/xl/goods/20140909/201409090919128469_list.jpg
 * @author haier
 *
 */
public class GetHtmlServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetHtmlServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
			OutputStream os = response.getOutputStream();
			String picPath = request.getQueryString();

			picPath = picPath.substring(4, picPath.length());
			URLConnection u = new URL(picPath).openConnection();
			InputStream in = u.getInputStream();

			if (null != in) {
				int len;
				byte[] b = new byte[1024];
				while ((len = in.read(b)) != -1) { // 循环读取
					os.write(b, 0, len); // 写入到输出流
				}
				os.flush();
				in.close();
			}

			os.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
