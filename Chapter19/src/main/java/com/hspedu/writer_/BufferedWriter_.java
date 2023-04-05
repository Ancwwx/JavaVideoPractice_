package com.hspedu.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
	public static void main(String[] args) throws IOException {
		String filePath = "../Resource/note.txt";
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
		bufferedWriter.write("hello,北京");
		bufferedWriter.newLine();
		bufferedWriter.write("2hello,北京");
		bufferedWriter.newLine();
		bufferedWriter.write("3hello,北京");
		bufferedWriter.newLine();

		bufferedWriter.close();

	}

}
