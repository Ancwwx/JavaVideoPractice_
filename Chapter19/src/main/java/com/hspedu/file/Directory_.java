package com.hspedu.file;

import java.io.File;

import org.junit.jupiter.api.Test;

public class Directory_ {
	public static void main(String[] args) {

	}

	@Test
	public void m1() {
		String filePath = "news1.txt";
		File file = new File(filePath);
		try {
			file.createNewFile();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} else {
			System.out.println("该文件不存在");
		}

	}

	@Test
	public void m2() {
		String filePath = "demo02";
		File file = new File(filePath);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} else {
			System.out.println("该目录不存在");
		}

	}

	@Test
	public void m3() {
		String directoryPath = "demo/demo03";
		File file = new File(directoryPath);
		if (file.exists()) {
			System.out.println(directoryPath + "存在");
		} else {
			if (file.mkdirs()) { //创建一级目录 mkdir方法 //多级目录mkdirs
				System.out.println("创建成功");
			} else {
				System.out.println("创建失败");
			}
		}

	}

}
