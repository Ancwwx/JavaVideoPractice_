package com.hspedu.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
//客户端
public class Homework03Client {
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入下载文件名");
		String downloadFileName= scanner.next();
		Socket socket= new Socket(InetAddress.getLocalHost(),9999);
		OutputStream outputStream= socket.getOutputStream();
		outputStream.write(downloadFileName.getBytes());
		socket.shutdownOutput();
		
		BufferedInputStream bufferedInputStream= new BufferedInputStream(socket.getInputStream());
		byte[]  bytes=StreamUtils.streamToByteArray(bufferedInputStream);
		String filePath="../Resource/"+downloadFileName+".mp3";
		BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(new FileOutputStream(filePath));
	    bufferedOutputStream.write(bytes);
	    
	    bufferedOutputStream.close();
	    bufferedInputStream.close();
	    outputStream.close();
	    socket.close();
	    System.out.println("客户端下载完毕，正在退出..");
	
	}

}
