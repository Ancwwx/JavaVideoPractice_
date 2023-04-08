package com.hspedu.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

//客户端
//字符流方式读写
public class SocketTCP03Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
		System.out.println("客户端 socket返回=" + socket.getClass());
		
		OutputStream outputStream = socket.getOutputStream();
		BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("hello!server");
		bufferedWriter.newLine();
		bufferedWriter.flush();
		
		InputStream inputStream = socket.getInputStream();
		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
		String s= bufferedReader.readLine();
		System.out.println(s);
		bufferedReader.close();
		bufferedWriter.close();
		socket.close();
		System.out.println("客户端退出");
	}

}
