package com.sou.common.rest;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public class RestClient {
	private String serverUrl;
	private String httpMethod;
	private String clientData;
	private final int DEFAULT_TIMEOUT = 2;
	private int connectTimeout;
	private int socketTimeout;

	public RestClient(String url, String method, String data) {
		this.serverUrl = url;
		this.httpMethod = method;
		this.clientData = data;
		this.connectTimeout = 2;
		this.socketTimeout = 2;
	}

	public RestClient(String url) {
		this.serverUrl = url;
		this.httpMethod = "GET";
		this.clientData = null;
		this.connectTimeout = 2;
		this.socketTimeout = 2;
	}

	public RestClient(String url, String data) {
		this.serverUrl = url;
		this.httpMethod = "GET";
		this.clientData = data;
		this.connectTimeout = 2;
		this.socketTimeout = 2;
	}

	public void setURL(String url) {
		this.serverUrl = url;
	}

	public void setMethod(String method) {
		this.httpMethod = method;
	}

	public void setData(String data) {
		this.clientData = data;
	}

	public void setConnectTimeout(int connectTimeout) {
		if (0 < connectTimeout)
			this.connectTimeout = connectTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		if (0 < socketTimeout)
			this.socketTimeout = socketTimeout;
	}

	public String execute() throws RestException {
		if (null == this.serverUrl) {
			return null;
		}

		this.clientData = RestCodec.encodeData(this.clientData);
		String ret = httpExecute();
		if (null != ret) {
			ret = RestCodec.decodeData(ret);
		}

		return ret;
	}

	private DefaultHttpClient getHttpClient() {
		DefaultHttpClient httpClient = new DefaultHttpClient();

		httpClient.getParams().setParameter("http.protocol.content-charset",
				"utf-8");
		if (0 < this.connectTimeout) {
			httpClient.getParams().setParameter("http.connection.timeout",
					Integer.valueOf(this.connectTimeout * 1000));
		}

		if (0 < this.socketTimeout) {
			httpClient.getParams().setParameter("http.socket.timeout",
					Integer.valueOf(this.socketTimeout * 1000));
		}

		return httpClient;
	}

	private String getURLWithData() {
		if (this.clientData != null) {
			if (this.serverUrl.endsWith("?")) {
				return this.serverUrl + this.clientData;
			}
			return this.serverUrl + "?" + this.clientData;
		}

		return this.serverUrl;
	}

	private String httpExecute() throws RestException {
		String ret = null;
		DefaultHttpClient httpclient = getHttpClient();
		try {
			ResponseHandler responseHandler = new BasicResponseHandler();
			if (this.httpMethod.equalsIgnoreCase("GET")) {
				HttpGet req = new HttpGet(getURLWithData());
				ret = (String) httpclient.execute(req, responseHandler);
			} else if (this.httpMethod.equalsIgnoreCase("POST")) {
				HttpPost req = new HttpPost(this.serverUrl);
				if (null != this.clientData) {
					req.setEntity(new StringEntity(this.clientData));
				}

				ret = (String) httpclient.execute(req, responseHandler);
			} else if (this.httpMethod.equalsIgnoreCase("PUT")) {
				HttpPut req = new HttpPut(this.serverUrl);
				if (null != this.clientData) {
					req.setEntity(new StringEntity(this.clientData));
				}

				ret = (String) httpclient.execute(req, responseHandler);
			} else if (this.httpMethod.equalsIgnoreCase("DELETE")) {
				HttpDelete req = new HttpDelete(getURLWithData());
				ret = (String) httpclient.execute(req, responseHandler);
			}
		} catch (ClientProtocolException e) {
			throw new RestException(e.getMessage(), e.getCause());
		} catch (IOException e) {
			throw new RestException(e.getMessage(), e.getCause());
		} catch (Exception e) {
			throw new RestException(e.getMessage(), e.getCause());
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return ret;
	}
}
