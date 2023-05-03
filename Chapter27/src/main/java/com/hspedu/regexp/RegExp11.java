package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp11 {
	public static void main(String[] args) {
		
		String content="https://www.bilibili.com/video/BV1fh411y7R8?p=894&spm_id_from=pageDriver&vd_source=1bc5827cddac0c30569bc96c469128b0";
		String regStr="^((http|https)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";
		Pattern pattern=Pattern.compile(regStr);
		Matcher matcher= pattern.matcher(content);
		if(matcher.find()) {
			System.out.println("满足格式");
		}else {
			System.out.println("不满足格式");
		}
		
	}

}
