package com.hspedu.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWrite_ {
	public static void main(String[] args) throws IOException {
		
		String filePath="../Resource/zl.txt";
		String charSet="utf-8";
		OutputStreamWriter osw =new OutputStreamWriter(new FileOutputStream(filePath),charSet);
		osw.write("hi北京");
		osw.close();
		System.out.println("按照 "+charSet+"保存文件成功");
		
	}

}
