package com.hspedu.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Homework02 {
	public static void main(String[] args) throws IOException {
		String filePath = "../Resource/story1.txt";
		BufferedReader br = null;
		String line = "";
		int i = 1;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				System.out.println(i++ + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}

		}

	}

}
