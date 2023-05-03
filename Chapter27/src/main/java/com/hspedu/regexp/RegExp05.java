package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp05 {
	public static void main(String[] args) {
		String content = "a1111111aaaaahello";
		// String regStr="a{3}";
		// String regStr="1{4}";
		// String regStr="\\d{2}";
		// String regStr="a{3,4}";
		// String regStr="1{4,5}";
		// String regStr="\\d{2,5}";
		// String regStr="1+";
		// String regStr="\\d+";
		String regStr = "1*";
		//String regStr="a1?";
		
		
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			System.out.println("找到: " + matcher.group(0));
		 }
	} 
}
