package com.hspedu.outputstream_;

import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileOutputStream_ {
	public static void main(String[] args) {
		
	}
	@Test
	public void writeFile() {
		String filePath="a.txt";
		FileOutputStream fileOutputStream =null;
		
		
		try {
			
			//覆盖
//			fileOutputStream = new FileOutputStream(filePath);
			
			//true追加
			fileOutputStream = new FileOutputStream(filePath,true);
			
			fileOutputStream.write('H');
			
			
			String str="hello,world!";
			fileOutputStream.write(str.getBytes());
			
			fileOutputStream.write(str.getBytes(),0,3);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

}
