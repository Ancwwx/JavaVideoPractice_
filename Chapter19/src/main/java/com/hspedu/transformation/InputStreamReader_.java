package com.hspedu.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_ {
	public static void main(String[] args) throws IOException {

		String filePath = "../Resource/story2.txt";
//		InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
//     BufferedReader br = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));

		String s = br.readLine();
		System.out.println("读取内容=" + s);
		br.close();
	}

}
