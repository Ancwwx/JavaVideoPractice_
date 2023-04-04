package com.hspedu.file;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileCreate {
	public static void main(String[] args) {

	}
@Test
	public void create01() {
//		String filePath = "/Users/dreamtank117/news1.txt";
		String filePath = "../../news1.txt";
		
		File file = new File(filePath);
		try {
			file.createNewFile();
			System.out.println("文件创建成功");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void create02() {
		File parentFile = new File("src");
		String fileName = "news2.txt";
		File file = new File(parentFile, fileName);
		try {
			file.createNewFile();
			System.out.println("文件创建成功");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
@Test
	public void create03() {
		String parentPath = "src";
		String fileName = "news3.txt";
		File file = new File(parentPath, fileName);
		try {
			file.createNewFile();
			System.out.println("文件创建成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
