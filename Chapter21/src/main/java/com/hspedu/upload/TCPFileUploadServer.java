package com.hspedu.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//文件上传的服务端
public class TCPFileUploadServer {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket= new ServerSocket(8888);
		System.out.println("服务端在8888端口监听...");
		Socket socket=serverSocket.accept();
		BufferedInputStream bis= new BufferedInputStream(socket.getInputStream());
	    byte[] bytes= StreamUtils.streamToByteArray(bis);
	    String destFilePath="../Resource/Nahidaa.png";
	    BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(destFilePath));
	    bos.write(bytes);
	    bos.close();
	    
	    BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	    writer.write("收到图片");
	    writer.flush();
	    socket.shutdownOutput();
	    writer.close();
	    
	    
	    bis.close();
	    socket.close();
	    serverSocket.close();
	
	}

}
