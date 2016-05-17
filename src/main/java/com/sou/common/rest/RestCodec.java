package com.sou.common.rest;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

class RestCodec {
	static String decodeData(String base64Data) throws RestException {
		try {
			String str = new String(Base64.decodeBase64(base64Data
					.getBytes("utf-8")), "utf-8");
			return str;
		} catch (UnsupportedEncodingException e) {
			throw new RestException(e.getMessage(), e.getCause());
		} finally {
		}

	}

	static String encodeData(String binaryData) throws RestException {
		try {
			String str = "";
			if (null == binaryData) {
				str = null;
				return str;
			}

			str = Base64.encodeBase64String(binaryData.getBytes("utf-8"));
			return str;
		} catch (UnsupportedEncodingException e) {
			throw new RestException(e.getMessage(), e.getCause());
		} finally {
		}
		
	}
}
