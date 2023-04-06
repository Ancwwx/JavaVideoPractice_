package com.hspedu.properties_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties= new Properties();
		properties.setProperty("charset", "utf8");
		properties.setProperty("user", "汤姆");
		properties.setProperty("pwd", "abc111");
		properties.store(new FileOutputStream("/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter19/src/main/java/mysql2.properties"), "hello world");
		
		System.out.println("保存配置文件成功");
		
	}

}
