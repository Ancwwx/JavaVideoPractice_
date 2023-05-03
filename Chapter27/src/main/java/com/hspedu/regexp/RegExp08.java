package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp08 {
	public static void main(String[] args) {
		String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";
		// String regStr = "韩顺平教育|韩顺平老师|韩顺平同学";
		// String regStr = "韩顺平(?:教育|老师|同学)";
		// String regStr = "韩顺平(?=教育|老师)";
		String regStr = "韩顺平(?!教育|老师)";

		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			System.out.println("找到: " + matcher.group(0));
		}

	}

}
