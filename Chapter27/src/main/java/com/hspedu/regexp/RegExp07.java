package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp07 {
	public static void main(String[] args) {
		String content = "hanshunping s7789 nn1189han";
		//String regStr = "(\\d\\d)(\\d\\d)";
		String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";
		
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			System.out.println("找到: " + matcher.group(0));
//			System.out.println("找到第一个分组: " + matcher.group(1));
//			System.out.println("找到第二个分组: " + matcher.group(2));
			System.out.println("找到第一个分组: " + matcher.group("g1"));
			System.out.println("找到第二个分组: " + matcher.group("g2"));

		}
	}

}
