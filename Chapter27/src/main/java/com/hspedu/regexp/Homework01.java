package com.hspedu.regexp;

public class Homework01 {
	public static void main(String[] args) {
		String content="hsp@shu.com";
		//.写在[]里面表示点本身 写在（）里面表示匹配任意字符
		String regStr="^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
		if(content.matches(regStr)) {
			System.out.println("匹配成功");
		}else {
			System.out.println("匹配失败");
		}
	}

}
