package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp12 {
	public static void main(String[] args) {
		String content="hello33333 j12321-333999111ack14 tom1331 jack2266 yyy12345 xxx";
		//String rgeStr="(\\d)\\1";
		//String rgeStr="(\\d)\\1{4}";
		//String rgeStr="(\\d)(\\d)\\2\\1";
		
		String rgeStr="\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
		
		
		
		Pattern pattern=Pattern.compile(rgeStr);
		Matcher matcher=pattern.matcher(content);
		while(matcher.find()) {
			System.out.println("找到: "+matcher.group(0));
		}
	}

}
