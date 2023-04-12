package com.hspedu.qqclient.service;

import java.io.ObjectOutputStream;
import java.util.Date;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

//提供和消息相关的服务方法
public class MessageClientService {
	
	public void sendMessageToAll(String content,String senderId) {
		Message message= new Message();
		message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
		message.setSender(senderId);
		message.setContent(content);
		message.setSendTime(new Date().toString());
		System.out.println(senderId +"对大家说"+content);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
					.getClientConnectServerThread(senderId).getSocket().getOutputStream());
		oos.writeObject(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendMessageToOne(String content,String senderId ,String getterId) {
		Message message= new Message();
		message.setMesType(MessageType.MESSAGE_COMM_MES);
		message.setSender(senderId);
		message.setGetter(getterId);
		message.setContent(content);
		message.setSendTime(new Date().toString());
		System.out.println(senderId +"对"+getterId+"说"+content);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
					.getClientConnectServerThread(senderId).getSocket().getOutputStream());
		oos.writeObject(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
