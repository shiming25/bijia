package com.sou.common.util.encrypt.base64;

import java.io.IOException;
import sun.misc.BASE64Decoder;

public class Base64Decoder {
	public static Base64Decoder getInstance() {
		return new Base64Decoder();
	}

	public static String decode(String str) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return new String(decoder.decodeBuffer(str));
	}
}
