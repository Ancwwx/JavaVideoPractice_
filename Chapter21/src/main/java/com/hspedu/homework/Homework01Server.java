package com.hspedu.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class Homework01Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket= new ServerSocket(9999);
		System.out.println("服务端，在9999端口监听，等待连接..");
		Socket socket= serverSocket.accept();
		
		InputStream inputStream= socket.getInputStream();
		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
		String s= bufferedReader.readLine();
		String answer="";
		if("name".equals(s)) {
			answer="Anc";
			
		}else if("hobby".equals(s)) {
			answer="study java";
		}else {
			answer="what!";
		}
		
		OutputStream outputStream= socket.getOutputStream();
		BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write(answer);
		bufferedWriter.newLine();
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
		socket.close();
		serverSocket.close();
	}

}
