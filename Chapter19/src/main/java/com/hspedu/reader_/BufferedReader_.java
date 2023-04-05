package com.hspedu.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_ {
	public static void main(String[] args) throws Exception {
		String filePath = "../Resource/story1.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

		String line;
		line = bufferedReader.readLine();
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);

		}
		bufferedReader.close();

	}

}
