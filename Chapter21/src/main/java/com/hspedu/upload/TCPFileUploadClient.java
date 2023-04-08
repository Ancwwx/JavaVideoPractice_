package com.hspedu.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

//文件上传的客户端
public class TCPFileUploadClient {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket(InetAddress.getLocalHost(),8888);
		String filePath="../Resource/Nahida.jpg";
		BufferedInputStream bis= new BufferedInputStream(new FileInputStream(filePath));
		
		byte[] bytes= StreamUtils.streamToByteArray(bis);
		BufferedOutputStream bos= new BufferedOutputStream(socket.getOutputStream());
	    bos.write(bytes);
	    bis.close();
	    socket.shutdownOutput();
	    InputStream inputStream= socket.getInputStream();
	    String s =StreamUtils.streamToString(inputStream);
	    System.out.println(s);
	   
	    inputStream.close();
	    bos.close();
	    socket.close();
	    
	    
	
	}

}
