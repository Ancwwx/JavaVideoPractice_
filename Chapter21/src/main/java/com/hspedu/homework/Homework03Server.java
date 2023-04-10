package com.hspedu.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端

public class Homework03Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket= new ServerSocket(9999);
		
		Socket socket =serverSocket.accept();
		InputStream inputStream= socket.getInputStream();
		byte[] b= new byte[1024];
		int len=0;
		String downLoadFileName="";
		while((len=inputStream.read(b))!=-1) {
			downLoadFileName +=new String(b,0,len);
		}
		System.out.println("客户端希望下载的文件名= "+downLoadFileName);
		String resFileName="";
		
		if("高山流水".equals(downLoadFileName)) {
			resFileName="/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter21/src/main/java/com/hspedu/homework/高山流水.mp3";
			
		}else {
			resFileName="/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter21/src/main/java/com/hspedu/homework/无名.mp3";
		}
		BufferedInputStream bufferedInputStream= new BufferedInputStream(new FileInputStream(resFileName));
		byte[]  bytes=StreamUtils.streamToByteArray(bufferedInputStream);
		
		BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(socket.getOutputStream());
		bufferedOutputStream.write(bytes);
		socket.shutdownOutput();
		bufferedOutputStream.close();
		inputStream.close();
		socket.close();
		serverSocket.close();
	}

}
