package com.hspedu.printstream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
	public static void main(String[] args) throws IOException {
		PrintStream out =System.out;
		out.print("john,hello");
		out.write("北京，你好".getBytes());
		out.close();
		System.setOut(new PrintStream("../Resource/f1.txt"));
		System.out.println("hello,北京");
	}

}
