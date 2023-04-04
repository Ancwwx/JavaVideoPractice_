package com.hspedu.file;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FileInformation {
	public static void main(String[] args) {
		
	}
	@Test
	public void info() {
		File file= new File("news1.txt");
		try {
			file.createNewFile();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("文件名字="+file.getName());
		System.out.println("文件绝对路径="+file.getAbsolutePath());
		System.out.println("文件父级目录="+file.getParent());
		System.out.println("文件大小（字节）="+file.length());
		System.out.println("文件是否存在="+file.exists());
		System.out.println("是不是一个文件="+file.isFile());
		System.out.println("是不是一个目录="+file.isDirectory());
	}

}
