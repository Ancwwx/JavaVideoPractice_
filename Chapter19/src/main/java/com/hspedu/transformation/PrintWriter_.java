package com.hspedu.transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
	public static void main(String[] args) throws IOException {
		//PrintWriter printWrite= new PrintWriter(System.out);
		PrintWriter printWrite= new PrintWriter(new FileWriter("../Resource/f2.txt"));
		
		printWrite.print("hi，天津你好~");
		printWrite.close();
		
	}

}
