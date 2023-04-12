package com.hspedu.qqclient.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

//该类完成用户登录验证和用户注册等功能
public class UserClientService {

	private User u = new User();
	private Socket socket;

	public boolean checkUser(String userId, String pwd) {
		u.setUserId(userId);
		u.setPasswd(pwd);
		boolean b = false;

		try {
			socket = new Socket(InetAddress.getByName("192.168.3.14"), 9999);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(u);
			
	
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		
			
			Message ms = (Message) ois.readObject();
			if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
				
				ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
				clientConnectServerThread.start();
				ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
				b = true;
			} else {
                socket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	//向服务器端请求在线用户列表
	public void onlineFriendList() {
		Message message= new Message();
		message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
		message.setSender(u.getUserId());
		try {
		ClientConnectServerThread clientConnectServerThread=ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
		Socket socket=clientConnectServerThread.getSocket();
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//编写方法 退出客户端 并发送退出系统的message给服务端
	public void logout() {
		Message message =new Message();
		message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
		message.setSender(u.getUserId());
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
			oos.writeObject(message);
			System.out.println(u.getUserId()+" 退出系统 ");
			System.exit(0);//结束进程
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
