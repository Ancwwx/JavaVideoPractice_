package com.hspedu.standard;

import java.util.Scanner;

public class InputAndOutput {
	public static void main(String[] args) {
		System.out.println(System.in.getClass());

		System.out.println(System.out.getClass());

		System.out.println("你好，北京");
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入内容");
		
		String next=scanner.next();
		System.out.println("next="+next);
		
	}

}
