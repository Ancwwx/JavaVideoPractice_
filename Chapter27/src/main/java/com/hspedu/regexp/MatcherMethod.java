package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherMethod {
	public static void main(String[] args) {
		String content="hello edu jack tom hello smith hello hsp hspedu hspeduu";
		String regStr="hello.*";
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			System.out.println("=============");
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println("找到: "+content.substring(matcher.start(),matcher.end()));
			
			
			
		}
		System.out.println("整体匹配= "+matcher.matches());
		regStr="hspedu";
		pattern=Pattern.compile(regStr);
		matcher=pattern.matcher(content);
		String newContent=matcher.replaceAll("北京欢迎您");
		System.out.println("替换后= "+ newContent);
		
	}

}
