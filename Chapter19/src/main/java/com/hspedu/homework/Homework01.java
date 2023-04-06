package com.hspedu.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
	public static void main(String[] args) throws IOException {
		String directorPath = "../Resource/mytemp";
		File file = new File(directorPath);
		if (!file.exists()) {
			if (file.mkdirs()) {
				System.out.println("创建 " + directorPath + " 成功");
			} else {
				System.out.println("创建失败");
			}
			
		}
		String filePath = directorPath + "/hello.txt";
		file = new File(filePath);
		if (!file.exists()) {
			if (file.createNewFile()) {
				System.out.println(filePath + "创建成功");
				BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
				bufferedWriter.write("hello,world ; hello,北京");
				bufferedWriter.close();
			} else {
				System.out.println("创建失败");
			}
		} else {
			System.out.println(filePath + "已经存在");
		}
	}
}
