package com.hspedu.qqserver.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

//该类的一个对象和某个客户端保持通讯
public class ServerConnectClientThread extends Thread{
private Socket socket;
private String userId;//连接到服务端的用户id
public ServerConnectClientThread(Socket socket, String userId) {
	super();
	this.socket = socket;
	this.userId = userId;
}
public Socket getSocket() {
	return socket;
}
@Override
public void run() {
	while(true) {
		
		 try {
			 System.out.println("服务端和客户端"+userId+" 保持通信，读取数据....");
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Message message=(Message)ois.readObject();
			if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
				System.out.println(message.getSender()+" 要在线用户列表");
				String onlineUser= ManageClientThreads.getOnlineUser();
				
				//返回message
				//构建Message对象，返回给客户端
				Message message2 = new Message();
				message2.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
				message2.setContent(onlineUser);
				message2.setGetter(message.getSender());
				ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(message2);
				
			}else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
				ServerConnectClientThread serverConnectClientThread= ManageClientThreads.getServerConnectClientThread(message.getGetter());
			  ObjectOutputStream oos= new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
			oos.writeObject(message);
			
			
			}else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
				//遍历集合，得到所有socket，把message进行转发
				HashMap<String, ServerConnectClientThread> hm= ManageClientThreads.getHm();
				Iterator< String> iterator= hm.keySet().iterator();
				while(iterator.hasNext()) {
					String onLineUserId=iterator.next().toString();
					if(! onLineUserId.equals(message.getSender())) {
						ObjectOutputStream oos= new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
					oos.writeObject(message);
					}
				}
				
				
				
			}else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
				ServerConnectClientThread serverConnectClientThread= ManageClientThreads.getServerConnectClientThread(message.getGetter());
					ObjectOutputStream oos =new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
				oos.writeObject(message);
				
			}
			else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
				System.out.println(message.getSender() +"退出");
				ManageClientThreads.removeServerConnectClientThread(message.getSender());
				socket.close();
				break;
			}
			else {
				System.out.println("其他类型暂时不处理");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



}
