package com.sou.servlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPatt {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^(var java).*; ");
		Matcher matcher = pattern.matcher("var java=test; var test=111;");
		System.out.println("eeee");
		if (matcher.find()) {
			System.out.println("dfdfd");
			System.out.println(matcher.group());
		}
	}

}
