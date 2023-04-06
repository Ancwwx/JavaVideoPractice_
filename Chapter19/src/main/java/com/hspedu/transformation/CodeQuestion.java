package com.hspedu.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodeQuestion {
	public static void main(String[] args) throws IOException {
		String filePath ="../Resource/story2.txt";
		BufferedReader bufferedReader= new BufferedReader(new FileReader(filePath));
		String s=bufferedReader.readLine();
		System.out.println("读取到的内容= "+s);
		bufferedReader.close();
	}
	

}
