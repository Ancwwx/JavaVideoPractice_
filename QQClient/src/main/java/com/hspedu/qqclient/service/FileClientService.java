package com.hspedu.qqclient.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

//该类完成文件的传输服务
public class FileClientService {
public void sendFileToOne(String src,String dest,String senderId,String getterId) {
	Message message= new Message();
	message.setMesType(MessageType.MESSAGE_FILE_MES);
	message.setSender(senderId);
	message.setGetter(getterId);
	message.setSrc(src);
	message.setDest(dest);
	FileInputStream fileInputStream=null;
	byte[] fileBytes=new byte[(int) new File(src).length()];
	try {
		fileInputStream = new FileInputStream(src);
		fileInputStream.read(fileBytes);//将src文件读入到程序的字节数组
		message.setFileBytes(fileBytes);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(fileInputStream!=null) {
			try {
				fileInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	System.out.println("\n"+senderId+" 给 "+getterId+" 发送文件 "+src+" 到对方电脑的目录 "+dest);
	try {
		ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
				.getClientConnectServerThread(senderId).getSocket().getOutputStream());
	   oos.writeObject(message);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
