package com.hspedu.reader_;

import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileReader_ {
	public static void main(String[] args) {

		String filePath = "../Resource/story1.txt";
		FileReader fileReader = null;
		int date = 0;

		try {
			fileReader = new FileReader(filePath);

			while ((date = fileReader.read()) != -1) {
				System.out.print((char) date);
			}
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}

	}
@Test
public void readFile02(){
		String filePath = "../Resource/story1.txt";
		FileReader fileReader = null;
		int readLen = 0;
		
		char[] buf=new char[8];

		try {
			fileReader = new FileReader(filePath);

			while ((readLen = fileReader.read(buf)) != -1) {
				System.out.print(new String(buf,0,readLen));
			}
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}
	}
}
