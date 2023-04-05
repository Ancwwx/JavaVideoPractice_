package com.hspedu.writer_;

import java.io.FileWriter;

public class FileWriter_ {
	public static void main(String[] args) {
		String filePath="../Resource/note.txt";
		FileWriter fileWriter=null;
		char[] chars= {'a','b','c'};
		
		try {
			fileWriter = new FileWriter(filePath);
			
			fileWriter.write('H');
			fileWriter.write(chars);
			fileWriter.write("北京欢迎您".toCharArray(),0,3);
			fileWriter.write("你好，北京");
			fileWriter.write("风雨之后，定见彩虹");
			fileWriter.write("上海天津",0,2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fileWriter.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
	}

}
