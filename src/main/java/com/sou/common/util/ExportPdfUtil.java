package com.sou.common.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pdfbox.pdmodel.PDDocument;

public class ExportPdfUtil {

	private static Log log = LogFactory.getLog(ExportPdfUtil.class);

	public static void download(HttpServletResponse response, String pdfUrl) {
		HttpURLConnection url_con = null;
		PDDocument document = null;
		OutputStream os = null;
		URL url = null;
		try {
			url = new URL(pdfUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("GET");
			url_con.setDoOutput(true);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			os = response.getOutputStream();
			document = PDDocument.load(url_con.getInputStream());

			String fileName = url.getFile();
			String[] fileNames = fileName.split("/");

			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileNames[fileNames.length - 1]);
			response.setContentType("application/pdf");
			document.save(os);
			response.flushBuffer();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
				}
			if (document != null)
				try {
					document.close();
				} catch (IOException e) {
				}
		}
	}

	/**
	 * 文件下载
	 *
	 * @param response
	 * @param fileUrl
	 */
	public static void fileDownload(HttpServletResponse response, String fileUrl) {
		HttpURLConnection urlConn = null;
		BufferedInputStream br = null;
		OutputStream os = null;
		URL url = null;
		try {
			url = new URL(fileUrl);
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setDoOutput(true);
			urlConn.getOutputStream().flush();
			urlConn.getOutputStream().close();

			String fileName = url.getFile();
			String[] fileNames = fileName.split("/");

			br = new BufferedInputStream(urlConn.getInputStream());
			byte[] buf = new byte[4096];
			int len = 0;

			response.reset();
             // 设定输出文件头
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileNames[fileNames.length - 1]);
			response.setContentType("application/octet-stream");

			os = response.getOutputStream();

			while ((len = br.read(buf)) > 0) {
				os.write(buf, 0, len);
			}
			br.close();
			os.close();

		} catch (Exception e) {
			log.error(e);
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
				}
		}
	}

	/**
	 * FMIS文件下载
	 *
	 * @param response
	 * @param fileUrl
	 */
	public static void fmisFileDownload(HttpServletResponse response, String fileUrl) {
		HttpURLConnection urlConn = null;
		BufferedInputStream br = null;
		OutputStream os = null;
		URL url = null;
		try {
			url = new URL(fileUrl);
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setDoOutput(true);
			urlConn.getOutputStream().flush();
			urlConn.getOutputStream().close();

			String fileName = url.getFile();
			String[] fileNames = fileName.split("/");

			br = new BufferedInputStream(urlConn.getInputStream());
			byte[] buf = new byte[4096];
			int len = 0;

			response.reset();
			String filename[] = fileNames[fileNames.length - 1].split("=");
			// 设定输出文件头
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(filename[1].getBytes("utf-8"),"iso-8859-1"));
			response.setContentType("application/octet-stream");

			os = response.getOutputStream();

			while ((len = br.read(buf)) > 0) {
				os.write(buf, 0, len);
			}
			br.close();
			os.close();

		} catch (Exception e) {
			log.error(e);
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
				}
		}
	}

	/**
	 * 下载html文件
	 *
	 * @param response
	 * @param fileUrl
	 */
	public static String htmlFileDownload(HttpServletResponse response,
			String fileUrl) {
		try {
			GetMethod filePost = new GetMethod(fileUrl);
			filePost.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler());
			HttpClient clients = new HttpClient();
			int status = clients.executeMethod(filePost);
			byte[] responseBody = filePost.getResponseBody();
			String temp = new String(responseBody, "utf-8");
			if (status == 200) {
				return temp;
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
		}
		return null;
	}
}
