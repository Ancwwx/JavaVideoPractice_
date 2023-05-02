package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp03 {
	public static void main(String[] args) {
		String content = "a11c8 abc_\nABCy @";
		// String regStr="[a-z]";
		// String regStr="[A-Z]";
		// String regStr="abc";
		// String regStr="(?i)abc";
		// String regStr="[0-9]";
		// String regStr="[^a-z]";
		// String regStr="[^0-9]";
		// String regStr="[abcd]";
		// String regStr="\\d";
		// String regStr="\\D";
		// String regStr="\\w";
		// String regStr="\\W";
		// String regStr="\\s";
		// String regStr="\\S";
		String regStr = ".";

		Pattern pattern = Pattern.compile(regStr);
		// 不区分大小写
		// Pattern pattern= Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			System.out.println("找到: " + matcher.group(0));
		}

	}

}
