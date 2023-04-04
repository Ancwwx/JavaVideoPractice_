package com.hspedu.inputstream_;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileInputStream_ {
	public static void main(String[] args) {

	}

	@Test
	public void readFile01() {
		String filePath = "news22";
//		File file= new File(filePath);
//		try {
//			file.createNewFile();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		int readDate = 0;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			while ((readDate = fileInputStream.read()) != -1) {
				System.out.print((char) readDate);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Test

	public void readFile02() {
		String filePath = "news23";

		int readDate = 0;
		byte[] buf = new byte[8];
		int readLen = 0;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			while ((readLen = fileInputStream.read(buf)) != -1) {
				System.out.print("\n" + new String(buf, 0, readLen));

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

}
